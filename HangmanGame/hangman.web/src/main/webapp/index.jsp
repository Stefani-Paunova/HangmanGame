
<%@page import="org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   isELIgnored="false"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
</head>
<body>

	<h1>Welcome to Hangman</h1>
	<br>
	<c:if test="${!empty originalWord}">
	
		<p>Sorry, you lose the game.</p>
		<br>
		<p>The word to guess was ${originalWord}</p>	
	
	</c:if>
	<c:if test="${!empty win }">
	
		<p>You win!</p>
		<br>
		
	</c:if>
	<h2>
	<form method="post" action="/games">
		<input   type="submit" value="Start game!">
	</form>
		
	</h2>

</body>
</html>