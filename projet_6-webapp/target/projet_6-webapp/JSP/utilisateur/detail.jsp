<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<body>

<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-2">
        </div>
        <div class="col-lg-8">
            <legend> Detail de l'utilisateur : </legend>
            <br />
            <br />
            <div class="description">
                <ul>
                    <li>Nom : <s:property value="#session.user.nom" /></li>
                    <br />
                    <li>Prénom : <s:property value="#session.user.prenom" /></li>
                    <br />
                    <li>Mail : <s:property value="#session.user.mail" /></li>
                    <br />
                    <li>Mot de passe : <s:property value = "#session.user.motDePasse" /></li>
                    <br />
                    <li>Pseudonyme : <s:property value = "#session.user.pseudonyme" /></li>
                    <br />
                    <li>Telephone : <s:property value = "#session.user.tel" /></li>
                </ul>
            </div>
        </div>
        <div class="col-lg-2">
        </div>
    </div>
</div>


</body>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>