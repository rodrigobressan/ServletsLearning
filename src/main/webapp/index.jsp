<html>
<body>
	<h2>Formulário simples de POST</h2>

	Search places:
	<br/>
	<form action="places" method="POST">
		<input type="text" name="message">
		<input type="submit" value="Enviar">
	</form>
	
	<br/>
	<br/>
	Login
	<br/>
	<form action="login" method="POST">
		<input type="text" name="user">
		<input type="password" name="password">
		<input type="submit" value="Enviar">
	</form>
	
	<br/>
	<br/>
	Logout
	<br/>
	<form action="logout" method="POST">
		<input type="submit" value="Enviar">
	</form>
</body>
</html>
