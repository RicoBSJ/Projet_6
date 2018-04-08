<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="_include/header.jsp"%>
</head>

<body>
<h2>Liste Topo et Utilisateur</h2>
<br />

<nav>
    <s:a action="utilisateur_list">
        <h3>Liste des utilisateurs</h3>
    </s:a>

    <s:a action="topo_list">
        <h3>Liste des topo</h3>
    </s:a>

</nav>

</body>
</html>
