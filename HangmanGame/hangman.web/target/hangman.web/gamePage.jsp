
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"    isELIgnored="false"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

		<table>
			<tr>
				<td>You have lives</td>
				<td>${lives}</td>
			</tr>
			
			<tr>
				<td>Guessing word</td>
				<td>${game.guessWord}</td>
				 
			</tr>
			
			<tr>
				<p>Inputed letters: </p>
				<c:forEach var="l" items="${letters}">
					<c:out value="${l}"></c:out>
				</c:forEach>
				
			</tr>
		
		</table>

		<form method="post">
		<label for="letter">Enter a suggested letter:</label>
		<br>
		<input type="hidden" name="id" values="${game.id}">
  		<input type="text" name="letter" pattern="[a-z]{1}" required>
		<br>
		<input   type="submit" value="Guess!">
		</form>
</body>
</html>