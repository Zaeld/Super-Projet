<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des articles</title>
</head>

<body>
	<h1>Liste des clients</h1>
	<c:forEach items="${clients}" var="client">
		<div title="${client.idClient }">
			<div>
				<h2>${client.nom }</h2>
			</div>
			<p>${client.prenom }</p>
		</div>
	</c:forEach>
	

	    <a href="/api/client">Jersey resource</a>
	
</body>

</html>