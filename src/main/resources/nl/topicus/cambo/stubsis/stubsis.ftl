<html>
<head>
	<title>StubSIS</title>
	<style>
textarea, input {
	width: 100rem;
	display: block;
}
textarea {
	min-height: 10rem;
}
label {
	font-weight: bold;
	display: block;
	margin-top: 1rem;
}
input[type=submit] {
	margin-top: 1rem;
}
input.query {
	width: 15rem;
	margin-top: 0;
}
	</style>
</head>
<body>
	<h1>Welcome to StubSIS</h1>
	<p>The only SIS you'll ever need</p>
	<form action="./ui" method="post">
		<label>Access Token</label>
		<textarea name="accesstoken">${accesstoken}</textarea>

		<div style="width: 100rem; display: flex">
			<input name="action" type="submit" value="SIS" id="test1">
			<input name="action" type="submit" value="Koppelpunten" id="test2">
			<input name="action" type="submit" value="Nieuwe aanmeldingen" id="test3">
			<input name="action" type="submit" value="Aanmeldingen" id="test4">
		</div>
		<label>Koppelpunt</label>
		<input type="text" name="endpoint" value="99XX">
		
		<label>Output</label>
		<div style="width: 100rem; display: flex">
			<input type="text" name="uri" value="${uri}">
			<input name="action" type="submit" value="Query" id="query" class="query">
		</div>
		<textarea rows="40">${test}</textarea>
	</form>
</body>
</html>