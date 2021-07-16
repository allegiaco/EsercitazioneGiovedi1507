<%@page import="it.alessandro.mvc.model.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
	table, th, td {
	border: 1px solid black;
	}
	
	td {
	text-align: center;
	}
</style>
<title>Insert title here</title>
</head>
<body>

<h1>ELENCO DI TUTTI I PRODOTTI</h1>
<br>
<hr>
<br>
<table>
    <thead>
      <tr>
        <th scope="col">CODICE PRODOTTO</th>
        <th scope="col">NOME</th>
        <th scope="col">DESCRIZIONE</th>
        <th scope="col">MARCA</th>
        <th scope="col">PREZZO</th>
        <th scope="col">CODICE FORNITORE</th>
        <th scope="col"></th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach items="${ALL_PRODOTTI}" var="prodotto">
    <tr>
    	<td>${prodotto.codiceProdotto}</td>
    	<td>${prodotto.nome}</td>
    	<td>${prodotto.descrizione}</td>
    	<td>${prodotto.marca}</td>
    	<td>${prodotto.prezzo}</td>
    	<td>${prodotto.forn.getCodiceFornitore()}</td>
    	<td><a href="mostraFormUpdateProdotto.doi?id=${fornitore.codiceFornitore}">EDIT</a></td>
    </tr>
	</c:forEach>

    </tbody>
   
  </table>
  <br>
  <br>
  <a href="mostraFormAggiungiProdotto.doi">INSERISCI NUOVO PRODOTTO</a>
</body>
</html>