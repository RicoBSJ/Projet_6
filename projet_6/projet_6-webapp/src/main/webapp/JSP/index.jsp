<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="_include/header.jsp"%>
</head>

<body>
<h2>CoucouLou</h2>

<nav>
    <s:a action="utilisateur_list">
        <h1>Liste des utilisateurs</h1>
    </s:a>

    <s:a action="topo_list">
        <h1>Liste des topo</h1>
    </s:a>

</nav>

</body>
</html>
