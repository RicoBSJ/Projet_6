<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<body>
<h2>Détail du topo</h2>

<ul>
        <li>ID : <s:property value="id" /></li>
        <li>Nom : <s:property value="topo.nom_topo" /></li>
        <li>Roche : <s:property value="topo.roche" /></li>
        <li>Region : <s:property value="topo.region" /></li>
        <li>Lieu : <s:property value="topo.lieu" /></li>
        <li>Description : <s:property value = "topo.description" /></li>
</ul>
</body>
</html>