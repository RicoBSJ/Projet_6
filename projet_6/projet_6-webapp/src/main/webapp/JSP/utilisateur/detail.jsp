<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<body>
<h2>Détail de l'utilisateur</h2>

<ul>

    <li>Nom : <s:property value="session.user.nom" /></li>
    <li>Prénom : <s:property value="session.user.prenom" /></li>
    <li>Mail : <s:property value="session.user.mail" /></li>
    <li>Mot de passe : <s:property value = "session.user.MotDePasse" /></li>
    <li>Pseudonyme : <s:property value = "session.user.pseudonyme" /></li>
    <li>Telephone : <s:property value = "session.user.tel" /></li>

</ul>
</body>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>