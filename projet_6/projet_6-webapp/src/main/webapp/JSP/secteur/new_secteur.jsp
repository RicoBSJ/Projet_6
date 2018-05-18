<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp" %>
</head>

<body>

<h2>Création d'un topo</h2>

<s:form action="secteur_new">
    <s:textfield name="secteur.nomSecteur" label="Nom du secteur" requiredLabel="true" />
    <s:textfield name="secteur.difficulte" label="Difficulté du secteur" requiredLabel="true" />
    <s:textfield name="secteur.orientation" label="orientation du secteur" requiredLabel="true" />
    <s:textfield name="secteur.description" label="Description" requiredLabel="true" />

    <s:submit value="OK"/>
</s:form>
</body>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>