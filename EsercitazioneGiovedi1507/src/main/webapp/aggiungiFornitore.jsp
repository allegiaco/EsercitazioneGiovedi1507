<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form method="POST" action="inserisciFornitore.doi">
  <label for="id">Inserisci ID Fornitore</label>
  <input type="text" name="id" id="id">
  <br>

  <label for="nome">Inserisci Nome Fornitore</label>
  <input type="text" name="nome" id="nome">
  <br>

  <label for="indirizzo">Inserisci indirizzo fornitore</label>
  <input type="text" name="indirizzo" id="indirizzo">
  <br>

  <label for="citta">Inserisci citta fornitore</label>
  <input type="text" name="citta" id="citta">
  <input type="submit" value="Inserisci">
</form>
</body>
</html>