<%@ page
	import="java.util.*,java.time.*,com.fintech.model.conta.Movimentacao"
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
<link rel="stylesheet" href="styles/movimentacoes-styles.css">
</head>

<body>
	<!-- Header -->

	<div class="logo-mobile">
		<a href="index.jsp"><img src="assets/logoMobile.svg"
			alt="Logo X Bank"> </a>
	</div>

	<div class="header">
		<div class="logo">
			<a href="index.jsp"><img src="assets/logo.svg" alt="Logo X Bank">
			</a>
		</div>

		<nav>
			<ul>
				<li><a href="index.jsp">INÍCIO</a></li>
				<li><a href="#">INVESTIMENTOS</a></li>
				<li><a href="#">SOBRE</a></li>
				<li><a href="#">SUPORTE</a></li>
				<li><a href="#" class="underline">MOVIMENTAÇÕES</a></li>
			</ul>

			<ul>

				<li><a href="#" class="underline-2"><img
						src="assets/iconeInvestir.svg" alt="Ícone investir"
						class="icone-nav"></a></li>
				<li><a href="#"><img src="assets/iconeSobre.svg"
						alt="Ícone sobre" class="icone-nav"></a></li>
				<li><a href="index.jsp"><img src="assets/home.svg"
						alt="Ícone início" class="icone-nav"></a></li>
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

			<h2>Movimentações</h2>

			<div class="movimentacoes">
				<table>

					<thead>
						<tr>
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
							<td class="coluna-data"><%= movimentacao.getData() %></td>
							<td><%= movimentacao.getDescricao() %></td>
							<td><%= movimentacao.getValor() %></td>
							<td><%= movimentacao.getConta() %></td>
						</tr>
						<%
            }
            }
            %>
					</tbody>

				</table>
			</div>
		</div>

	</div>
	<!-- Fim Main -->

</body>
</html>