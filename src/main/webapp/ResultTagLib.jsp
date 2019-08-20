<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
	import="br.senai.sp.informatica.servlets.libs.Mensagem"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>Servlets</title>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<meta http-equiv="cache-control" content="no-cache, no-store, must-revalidate" />
	<meta http-equiv="expires" content="Mon, 17 jul 2000 10:10:00 GMT" />
	<title>Servlets</title>
	<link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
	<div id="wrapper">
		<header role="banner" class="group">
			<div id="logo"><a href="index.html">Utilizando Java Beans</a></div>
			<nav role="navigation">
				<ul id="mainNav">
					<li><a href="ThreeParamsForm.html">Argumentos</a></li>
					<li><a href="ApplesAndOranges.xls">Planilha</a></li>
					<li><a href="WrongDestination">Redirecionamento</a></li>
					<li><a href="ShadowedText.html">Texto</a></li>
					<li><a href="TelaDados.html">Entrada de dados</a></li>
					<li><a href="Cookie.html">Cookies</a></li>
					<li><a href="Bean.html">Java Beans</a></li>
				</ul>
			</nav>
		</header>

		<div id="content" role="main">
			<h2><c:out value="${msg.titulo}" /></h2>
			<p><c:out value="${msg.texto}" /></p>
		</div>

	</div>
</body>
</html>