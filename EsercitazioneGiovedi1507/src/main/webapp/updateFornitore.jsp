<%@page import="it.alessandro.mvc.model.Fornitore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
    <thead>
      <tr>
        <th scope="col">CODICE FORNITORE</th>
        <th scope="col">NOME</th>
        <th scope="col">INDIRIZZO</th>
        <th scope="col">CITTA</th>
        <th scope="col"></th>
      </tr>
    </thead>
    <tbody>
    <tr>
    	<td>${fornToUpdate.codiceFornitore}</td>
    	<td>${fornToUpdate.nome}</td>
    	<td>${fornToUpdate.indirizzo}</td>
    	<td>${fornToUpdate.citta}</td>
    </tr>
    </tbody>
  </table>
<br>
  
<form method="POST" action="updateFornitore.doi?id=${fornToUpdate.codiceFornitore}">
  <label for="nome">Inserisci Nome Fornitore</label>
  <input type="text" name="nome" id="nome">
  <br>

  <label for="indirizzo">Inserisci indirizzo fornitore</label>
  <input type="text" name="indirizzo" id="indirizzo">
  <br>

  <label for="citta">Inserisci citta fornitore</label>
  <input type="text" name="citta" id="citta">
  <input type="submit" value="Modifica">
</form>
<br>
<hr>

<p>Per cancellare il Fornitore, premere il link sottostante</p>
  <a href="cancellaFornitore.doi?id=${fornToUpdate.codiceFornitore}&nome=${fornToUpdate.nome}&indirizzo=${fornToUpdate.indirizzo}&citta=${fornToUpdate.citta}">CANCELLA FORNITORE</a>
  <br>
</body>
</html>