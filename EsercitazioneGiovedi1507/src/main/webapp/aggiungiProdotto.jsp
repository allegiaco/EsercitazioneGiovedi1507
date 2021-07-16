<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="inserisciProdotto.doi">
  <label for="id">Inserisci ID Prodotto</label>
  <input type="text" name="id" id="id">
  <br>

  <label for="nome">Inserisci Nome Prodotto</label>
  <input type="text" name="nome" id="nome">
  <br>

  <label for="descrizione">Inserisci descrizione prodotto</label>
  <input type="text" name="descrizione" id="descrizione">
  <br>

  <label for="marca">Inserisci marca prodotto</label>
  <input type="text" name="marca" id="marca">
  <input type="submit" value="Inserisci">
</form>

</body>
</html>