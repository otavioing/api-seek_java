<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html lang="pt-br">

	<head>
		<title>Projeto API</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<script>
			function ativarMenu() {
				const menu = document.querySelector('.inicio');
				menu.classList.toggle('ativo');
			}

			function fecharMenu() {
				const menu = document.querySelector('.inicio');
				menu.classList.remove('ativo'); // garante que feche sempre
			}
		</script>
	</head>

	<body>


		<header class="inicio">
			<button id="btnFecharMenuMobile" class="close" onclick="fecharMenu()"
				style="border: none;outline: none;background: none;">
				<img src="/img/close.svg" alt="">
			</button>
			<div class="logosite">
				<a href="/index" class="logosite"><img src="/img/Logo.svg" alt="Logo Seek"></a>

			</div>

			<nav class="navsite">

				<div id="headerxplorar">
					<a href="/index">Página Principal</a>
				</div>

				<div id="headercadastro">
					<a href="/cadastrartipo">Cadastrar Tipo de Usuário</a>
				</div>

				<div id="headerlistar">
					<a href="/listartipo">Listar Tipos de Usuários</a>
				</div>

				<div id="headerintegrante">
					<a href="/integrante">Integrantes</a>
				</div>

			</nav>

			<div id="pesquisar">

				<form class="formSearch" method="GET" action="/pesquisartipo">
					<input type="search" name="tipo" placeholder="Pesquisar Tipo de Usuário">
					<button style="border: none;background: none;"><img src="/img/search2.svg" alt="Lupa"></button>
				</form>

			</div>

		</header>
		<header class="inicioIndex">
			<div class="logosite">
				<a href="/index" class="logosite"><img src="/img/Logo.svg" alt="Logo Seek"></a>
			</div>
			<button id="btnMenuMobile" onclick="ativarMenu()"
				style="display: flex;border: none;outline: none;background: none;">
				<img src="/img/hamburguerMenu.svg" alt="">
			</button>
		</header>

		<main>