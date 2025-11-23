<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<title>Projeto - Framework Spring MVC</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="css/login.css">
	</head>
	<body id="todo">
    <main class="mainlogin">

      <div class="logologin">
        <img src="/img/Logo.svg" alt="Logo Seek">
        <div>
          <h1>
            Mais informações sobre o <span class="spanSeekLogin">Seek</span>
          </h1>
        </div>
      </div>
  

      <!-- Login -->
      <div class="cardlogin">

        <div class="form-container">

          <img class="logoMobile" src="/img/Group 776.svg" alt="Logo Seek">
          <h2 class="title">Entrar</h2>
          <form action="/login" method="post" id="loginForm" class="formLogin">

            <input
              type="email"
              name="email"
              class="modalInput"
              id="logInEmail"
              placeholder="Email"
              required
              autofocus />

            <input
              type="password"
              name="password"
              class="modalInput"
              id="logInPsw"
              placeholder="Senha"
              required />

            <button class="form-btn" id="logInBtn" type="submit">Entrar</button>
          </form>

          <div class="sign-up-label">
            <button
              onclick="document.getElementById('sign-up-modal').style.display='flex'"
              class="sign-up-link">Cadastrar</button>
          </div>

        </div>

      </div>
      <!-- Fim do Login -->

      <!-- Modal Cadastro -->
      <div id="sign-up-modal" class="sign-up-modal" style="display: none;">

        <div class="sign-up-content">

          <img class="logoMobile" src="/img/Group 776.svg" alt="Logo Seek">

          <h2 class="title">Cadastrar</h2>

          <span 
            onclick="document.getElementById('sign-up-modal').style.display='none'"
            class="close"
            title="Fechar">&times;</span>

          <form action="/cadastrarusuario" class="sign-up-container" method="post">

              <!-- Email -->
					    <input
                type="email"
                name="email"
                id="cadastroEmail"
                class="modalInput"
                placeholder="Email"
                required>

              <!-- Nome -->
              <input
                type="text"
                name="nome"
                id="cadastroNome"
                class="modalInput"
                placeholder="Nome"
                required>

              <!-- Senha -->
					    <input
                type="password"
                name="password"
                id="password"
                class="modalInput"
                placeholder="Senha"
                required>

              <!-- Confirmar Senha-->
					    <input               
                type="password"
                name="confirmPassword"
                id="confirmarSenha"
                class="modalInput"
                placeholder="Repitir Senha"
                required>

					    <button id="signInBtn" class="form-btn" type="submit">Cadastrar</button>

			    </form>

        </div>

      </div>
      <!-- Fim do Modal Cadastro -->

    </main>
	</body>
</html>