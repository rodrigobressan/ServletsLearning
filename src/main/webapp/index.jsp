<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<body>
	<h2>Formulário simples de POST</h2>

    Você está logado como ${usuarioLogado} <br />
	Search places:
	<br />
	<form action="places" method="POST">
		<input type="text" name="message"> <input type="submit"
			value="Enviar">
	</form>

	<br />
	<br /> Login
	<br />
	<form action="login" method="POST">
		<input type="text" name="user"> <input type="password"
			name="password"> <input type="submit" value="Enviar">
	</form>

	<br />
	<br /> Logout
	<br />
	<form action="logout" method="POST">
		<input type="submit" value="Enviar">
	</form>
</body>
</html>
