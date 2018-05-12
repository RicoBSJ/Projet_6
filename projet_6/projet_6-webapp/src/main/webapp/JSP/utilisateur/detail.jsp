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

    <li>Nom : <s:property value="utilisateur.nom" /></li>
    <li>Prénom : <s:property value="utilisateur.prenom" /></li>
    <li>Mail : <s:property value="utilisateur.mail" /></li>
    <li>Mot de passe : <s:property value = "utilisateur.MotDePasse" /></li>
    <li>Pseudonyme : <s:property value = "utilisateur.pseudonyme" /></li>
    <li>Telephone : <s:property value = "utilisateur.tel" /></li>

</ul>
</body>
</html>