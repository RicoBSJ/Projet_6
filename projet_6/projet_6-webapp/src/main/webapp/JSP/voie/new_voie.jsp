<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp" %>
</head>

<body>

<h2>Création d'un topo</h2>

<s:form action="voie_new">
    <s:textfield name="voie.nomVoie" label="Nom de la voie" requiredLabel="true" />
    <s:textfield name="voie.cotation" label="Cotation du la voie" requiredLabel="true" />
    <s:textfield name="voie.hauteur" label="Hauteur de la voie" requiredLabel="true" />
    <s:textfield name="voie.description" label="Description" requiredLabel="true" />

    <s:submit value="OK"/>
</s:form>
</body>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>