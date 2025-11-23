package com.projeto.report;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.*;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.*;

import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.pdf.event.*;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Relatorio {
    
    public static <T> ResponseEntity<byte[]> gerar(List<T> lista, String titulo, String descricao, boolean abrirInline) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);
            pdfDoc.addEventHandler(PdfDocumentEvent.END_PAGE, new RodapeHandler(document));

            var font = PdfFontFactory.createFont(StandardFonts.HELVETICA);

            document.add(new Paragraph(titulo)
                    .setFont(font)
                    .setFontSize(18)
                    .setTextAlignment(TextAlignment.CENTER));

            document.add(new Paragraph(descricao)
                    .setFont(font)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setMarginBottom(20));

            if (lista == null || lista.isEmpty()) {
                document.add(new Paragraph("Nenhum dado encontrado."));
            } else {
                Class<?> clazz = lista.get(0).getClass();
                Field[] campos = clazz.getDeclaredFields();

                float[] colWidths = {1, 3, 1, 1, 1};
                Table table = new Table(UnitValue.createPercentArray(colWidths))
                    .useAllAvailableWidth();

                for (Field campo : campos) {
                    table.addHeaderCell(new Cell()
                            .add(new Paragraph(campo.getName()))
                            .setBackgroundColor(com.itextpdf.kernel.colors.ColorConstants.LIGHT_GRAY));
                }

                for (T item : lista) {
                    for (Field campo : campos) {
                        campo.setAccessible(true);
                        Object valor = campo.get(item);
                        table.addCell(new Paragraph(valor != null ? valor.toString() : ""));
                    }
                }

                document.add(table);
            }

            document.add(new Paragraph("\nGerado em: " +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")))
                .setFontSize(9)
                .setTextAlignment(TextAlignment.RIGHT));

            document.close();

            if (abrirInline) {
                return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=relatorio.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(baos.toByteArray());
            } else {
                byte[] pdfBytes = baos.toByteArray();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_PDF);
                headers.setContentDispositionFormData("filename", "relatorio.pdf");
                return ResponseEntity.ok().headers(headers).body(pdfBytes);    
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    private static class RodapeHandler extends AbstractPdfDocumentEventHandler {
    
        public RodapeHandler(Document document) { }

        @Override
        protected void onAcceptedEvent(AbstractPdfDocumentEvent event) {
            var pdfDoc = event.getDocument();
            var page = pdfDoc.getPage(pdfDoc.getNumberOfPages());
            
            int pageNumber = pdfDoc.getPageNumber(page);
    
            PdfCanvas canvas = new PdfCanvas(page);
            canvas.beginText();
            try {
                var font = PdfFontFactory.createFont(StandardFonts.HELVETICA_OBLIQUE);
                canvas.setFontAndSize(font, 9);
                canvas.moveText(520, 20);
                canvas.showText("Página " + pageNumber);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                canvas.endText();
                canvas.release();
            }
        }
    }
}