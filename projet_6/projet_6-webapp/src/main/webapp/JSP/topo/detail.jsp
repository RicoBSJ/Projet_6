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
    <s:iterator value="listTopo">
        <li>ID : <s:property value="id" /></li>
        <li>Nom : <s:property value="nom" /></li>
        <li>Roche : <s:property value="roche" /></li>
        <li>Region : <s:property value="region" /></li>
        <li>Lieu : <s:property value="lieu" /></li>
        <li>Description : <s:property value = "description" /></li>
    </s:iterator>
</ul>
</body>
</html>