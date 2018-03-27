<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<body>
<h2>Liste des Utilisateur</h2>

<ul>
    <s:iterator value="listUtilisateur">
        <li> Nom utilisateur : <s:property value="nom"/>
        </li>
    </s:iterator>
</ul>
</body>
</html>
