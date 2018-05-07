<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp" %>
</head>

<body>

<h2>Création d'un topo</h2>

<s:form action="site_new">
    <s:textfield name="site.nomSite" label="Nom du site" requiredLabel="true" />
    <s:textfield name="site.altitudePiedVoie" label="Altitude de la voie (Pied)" requiredLabel="true" />
    <s:textfield name="site.description" label="Description" requiredLabel="true" />

    <s:submit value="OK"/>
</s:form>
</body>
</html>