<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>

<header>
    <h1> Site d'escalade </h1>

    <s:actionerror/>
    <s:actionmessage/>

    <s:if test="#session.check == 'true'">
        <h4>
            <span>Vous etes connecté <s:property value="#session.user.prenom"/> </span>
        </h4>
    </s:if>
    <s:if test="#session.check == 'false'">
        <s:a action="login">
            <h4>
                Page de connection
            </h4>
        </s:a>
    </s:if>

</header>

<br />
