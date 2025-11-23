<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:include page="layouttopo.jsp"></jsp:include>
    <c:set var="nome" value="Maria"></c:set>
    <div class="row">
        <div class="card">
            <h1>Integrantes</h1>
            <ul>
                <c:forEach items="${integrantes}" var="integrante">
                    <li>${integrante}</li>
                </c:forEach>
            </ul>
        </div>
    </div>
<jsp:include page="layoutrodape.jsp"></jsp:include>