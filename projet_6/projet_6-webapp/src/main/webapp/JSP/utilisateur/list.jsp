<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<body>
<h2>Liste des projets</h2>

<ul>
    <s:iterator value="listUtilisateur">
        <li>
            <s:a action="utilisateur_detail">
                <s:param name="id" value="responsable.id" />
                <s:property value="utilisateur.prenom"/> <s:property value="utilisateur.nom"/>
            </s:a>

        </li>
    </s:iterator>
</ul>
</body>
</html>
