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
            <s:a action="utilisateur_detail">
            <span>Vous etes connecté <s:property value="#session.user.prenom"/> </span>
                <s:param name="id" value="#session.user.id" />
                <br />
            </s:a>
            <s:a action="logout">
                <span> Deconnection </span>
            </s:a>
        </h4>
    </s:if>
    <s:else>
        <s:form action="login">
            <s:textfield name="login" label="Identifiant" requiredLabel="true" />
            <s:password name="password" label="Mot de passe" requiredLabel="true" />

            <s:submit value="Connexion"/>
        </s:form>
        <s:a action="utilisateur_new">
            <span> Creer un compte</span>
        </s:a>
    </s:else>

</header>

<br />
