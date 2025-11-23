<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="layouttopo.jsp"></jsp:include>
    <div class="row">
        <div class="card">

            <h1>Alterar Tipo de Usuário</h1>
            <div class="type-user-content">
                <form:form action="/alterartipo" modelAttribute="tipo">

                    <input type="number" class="modalInput" value="${tipo.getId()}" disabled>
                    <input type="hidden" id="id" name="id" class="modalInput" value="${tipo.getId()}">

                    <input
                    type="text"
                    id="descricao"
                    name="descricao"
                    class="modalInput"
                    placeholder="Descrição"
                    value="${tipo.getDescricao()}">

                    <select name="tipo" id="tipo">
                        <option value="padrao"
                            <c:if test="${tipo.tipo == 'padrao'}">selected</c:if>>Padrão</option>
                        <option value="professor"
                            <c:if test="${tipo.tipo == 'professor'}">selected</c:if>>Professor</option>
                        <option value="empresa"
                            <c:if test="${tipo.tipo == 'empresa'}">selected</c:if>>Empresa</option>
                    </select>
                    
                    <div id="divProf">

                        <input
                        type="text"
                        name="departamento"
                        id="departamento"
                        class="modalInput"
                        placeholder="Departamento"
                        value="${tipo.departamento}">

                        <input
                        type="text"
                        name="formAcad"
                        id="formAcad"
                        class="modalInput"
                        placeholder="Formação Acadêmica"
                        value="${tipo.formAcad}">

                    </div>
                            
                    <div id="divBusiness">

                        <input
                        type="text"
                        name="cnpj"
                        id="cnpj"
                        class="modalInput"
                        placeholder="CNPJ"
                        value="${tipo.cnpj}">

                        <input
                        type="text"
                        name="razaoSocial"
                        id="razaoSocial"
                        class="modalInput"
                        placeholder="Razão Social"
                        value="${tipo.razaoSocial}">

                    </div>

                    <button type="submit" class="form-btn">Alterar</button>
                
                </form:form>
            </div>

        </div>
    </div>
    <script src="js/cadastrartipo.js"></script>
<jsp:include page="layoutrodape.jsp"></jsp:include>