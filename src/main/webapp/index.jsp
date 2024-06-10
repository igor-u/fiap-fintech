<%@ page import="java.util.*, com.fintech.model.conta.Movimentacao"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>X Bank</title>
<link rel="stylesheet" href="styles/bootstrap.min.css">
<link rel="stylesheet" href="styles/styles.css">
<link rel="stylesheet" href="styles/index-styles.css">
</head>

<body>
	<!-- Header -->

	<div class="logo-mobile">
		<a href="#"><img src="assets/logoMobile.svg" alt="Logo X Bank">
		</a>
	</div>

	<div class="header">
		<div class="logo">
			<a href="#"><img src="assets/logo.svg" alt="Logo X Bank"> </a>
		</div>

		<nav>
			<ul>
				<li><a href="#" class="underline">INÍCIO</a></li>
				<li><a href="#">INVESTIMENTOS</a></li>
				<li><a href="#">SOBRE</a></li>
				<li><a href="#">SUPORTE</a></li>
			</ul>

			<ul>

				<li><a href="#"><img src="assets/iconeInvestir.svg"
						alt="Ícone investir" class="icone-nav"></a></li>
				<li><a href="#"><img src="assets/iconeSobre.svg"
						alt="Ícone sobre" class="icone-nav"></a></li>
				<li><a href="#" class="underline-2"><img
						src="assets/home.svg" alt="Ícone início" class="icone-nav"></a></li>
				<li><a href="#"><img src="assets/iconeSuporte.svg"
						alt="Ícone suporte" class="icone-nav"></a></li>
				<li><a href="#"><img src="assets/user.svg"
						alt="Ícone usuário" class="icone-nav"></a></li>
			</ul>

		</nav>

		<div class="user">
			<p>
				<%=session.getAttribute("nome_usuario")%>
			</p>
			<a href="#"><img src="assets/usuarioFoto.svg"
				alt="Foto do usuário"></a>
		</div>

	</div>
	<!-- Fim Header -->

	<!-- Main -->
	<div class="main">
		<div class="divisao">
			<div class="retangulo">
				<h2>Ações rápidas</h2>
			</div>
			<div class="acoes">

				<div class="acao acao1">
					<a href="#">
						<div class="clicavel">
							<div class="borda">
								<img src="assets/pixIcon.svg" alt="Ícone de Pix" class="icone">
							</div>
							<p>Pix</p>
						</div>
					</a>
				</div>


				<div class="acao acao2">
					<a href="vincular_conta_bancaria.jsp">
						<div class="clicavel">
							<div class="borda">
								<img src="assets/vincularIcon.svg" alt="Ícone de vincular conta"
									class="icone">
							</div>
							<p>Vincular conta</p>
						</div>
					</a>
				</div>

				<div class="acao acao3">
					<a href="transferencia.jsp">
						<div class="clicavel">
							<div class="borda">
								<img src="assets/transferirIcon.svg"
									alt="Ícone de transferir conta" class="icone">
							</div>
							<p>Transferir</p>
						</div>
					</a>
				</div>

				<div class="acao acao4">
					<a href="#">
						<div class="clicavel">
							<div class="borda">
								<img src="assets/pagarIcon.svg" alt="Ícone de pagamento"
									class="icone">
							</div>
							<p>Pagar</p>
						</div>
					</a>
				</div>

				<div class="acao acao5">
					<a href="#">
						<div class="clicavel">
							<div class="borda">
								<img src="assets/cartaoIcon.svg" alt="Ícone de cartão"
									class="icone">
							</div>
							<p>Cartão</p>
						</div>
					</a>
				</div>

				<div class="acao acao6">
					<a href="#">
						<div class="clicavel">
							<div class="borda">
								<img src="assets/segurancaIcon.svg" alt="Ícone de cadeado"
									class="icone">
							</div>
							<p>Segurança</p>
						</div>
					</a>
				</div>

			</div>

			<div class="retangulo-2"></div>

		</div>

		<div class="divisao">
			<div class="retangulo">
				<h2>Movimentações</h2>
				<a href="movimentacoes.jsp"><img src="assets/iconeSeta.svg"
					alt="Ícone de seta para movimentações"></a>
			</div>

			<div class="movimentacoes">
				<table>

					<thead>
						<tr>
							<th class="coluna-informacoes"></th>
							<th class="coluna-data">Data</th>
							<th>Descrição</th>
							<th>Valor</th>
							<th>Conta</th>
						</tr>
					</thead>

					<tbody>
						<%
						List<Movimentacao> movimentacoes = (List<Movimentacao>) session.getAttribute("movimentacoes");

						if (movimentacoes != null) {
							for (Movimentacao movimentacao : movimentacoes) {
						%>
						<tr>
							<td class="coluna-informacoes"><img
								src="assets/iconeMaisInformacoes.svg"
								alt="Ícone de mais informações"></td>
							<td class="coluna-data"><%=movimentacao.getData()%></td>
							<td><%=movimentacao.getDescricao()%></td>
							<td><%=movimentacao.getValor()%></td>
							<td><%=movimentacao.getConta()%></td>
						</tr>
						<%
						}
						}
						%>
					</tbody>

				</table>
			</div>

			<div class="retangulo-2"></div>
		</div>

	</div>
	<!-- Fim Main -->

	<footer>
		<p>© 2024 X Bank, Inc. Todos os direitos reservados.</p>
		<p>© 2024 X Bank, Inc.</p>
	</footer>

</body>
</html>