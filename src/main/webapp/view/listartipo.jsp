<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:include page="layouttopo.jsp"></jsp:include>
     <h1>Usuários</h1>
     <div class="row">
        <div class="card">
           
            <div class="container">
                <c:forEach var="TypeUser" items="${listarTypeUser}">
                    <div class="card-usuario">
                        <p>id: ${TypeUser.id}</p>
                        <p>Tipo: ${TypeUser.tipo}</p>
                        <p>Descrição: ${TypeUser.descricao}</p>

                        <a href="/alterartipo?id=${TypeUser.getId()}">Editar</a>
                        <a href="/excluirtipo?id=${TypeUser.getId()}" >Excluir</a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
<jsp:include page="layoutrodape.jsp"></jsp:include>