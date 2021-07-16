<%@page import="it.alessandro.mvc.model.Fornitore"%>
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
    
    <c:forEach items="${ALL_FORNITORI}" var="fornitore">
    <tr>
    	<td>${fornitore.codiceFornitore}</td>
    	<td>${fornitore.nome}</td>
    	<td>${fornitore.indirizzo}</td>
    	<td>${fornitore.citta}</td>
    	<td><a href="mostraFormUpdateFornitore.doi?id=${fornitore.codiceFornitore}">EDIT</a></td>
    </tr>
	</c:forEach>

    </tbody>
   
  </table>
  <br>
  <br>
  <a href="mostraFormAggiungiFornitore.doi">INSERISCI NUOVO FORNITORE</a>
</body>
</html>