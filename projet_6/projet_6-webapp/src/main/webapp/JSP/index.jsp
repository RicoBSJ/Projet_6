<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="_include/header.jsp"%>
</head>

<body>
<h2>Liste Topo et Utilisateur <br />
    <s:actionerror/>
    <s:actionmessage/>
</h2>
<br />

<nav>

    <s:a action="utilisateur_list">
        <h3>Liste des utilisateurs</h3>
    </s:a>

    <s:a action="login">
        Page de connection
    </s:a>

    <s:a action="topo_list">
        <h3>Liste des topo</h3>
    </s:a>

</nav>

<s:if test="#session.check == 'true'">
    <h3>
        <span>Vous etes bien connecté <s:property value="utilisateur.pseudonyme"/> </span>
    </h3>
</s:if>
<s:if test="#session.check == 'false'">
    <h3>
        <span>Vous n'etes pas connecté </span>
    </h3>
</s:if>


</body>
</html>
