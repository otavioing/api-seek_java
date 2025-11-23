<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="layouttopo.jsp"></jsp:include>
    <div class="row">
        <div class="card">
            
            <h1>Cadastro de Tipo de Usuário</h1>
            <div class="type-user-content">
                <form:form action="/cadastrartipo" modelAttribute="typeUser" method="post" class="type-user-container">

                    <input
                    type="text"
                    id="descricao"
                    name="descricao"
                    class="modalInput"
                    placeholder="Descrição">
                    
                    <label for="tipo">Tipo:</label>
                    <select name="tipo" id="tipo" required>
                        <option value="" disabled selected hidden>Selecione um tipo</option>
                        <option value="padrao">Padrão</option>
                        <option value="professor">Professor</option>
                        <option value="empresa">Empresa</option>
                    </select>
                    
                    <div id="divProf">

                        <input
                        type="text"
                        name="departamento"
                        id="departamento"
                        class="modalInput"
                        placeholder="Departamento">

                        <input
                        type="text"
                        name="formAcad"
                        id="formAcad"
                        class="modalInput"
                        placeholder="Formação Acadêmica">

                    </div>
                            
                    <div id="divBusiness">

                        <input
                        type="text"
                        name="cnpj"
                        id="cnpj"
                        class="modalInput"
                        placeholder="CNPJ">

                        <input
                        type="text"
                        name="razaoSocial"
                        id="razaoSocial"
                        class="modalInput"
                        placeholder="Razão Social">

                    </div>
                            
                    <button type="submit" class="form-btn">Cadastrar</button>
                            
                </form:form>
            </div>

        </div>
    </div>
    <script src="js/cadastrartipo.js"></script>
<jsp:include page="layoutrodape.jsp"></jsp:include>