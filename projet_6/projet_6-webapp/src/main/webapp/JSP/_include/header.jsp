<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</head>

<header>
    <s:actionerror/>
    <s:actionmessage/>

    <title>Site d'escalade</title>



    <div class="login">
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
            <s:textfield name="login" label="Identifiant" requiredLabel="true" class="username"/>
            <s:password name="password" label="Mot de passe" requiredLabel="true" type="password" />

            <s:submit value="Connexion" class="button" type="submit"/>
        </s:form>
        <s:a action="utilisateur_new">
            <span class="button"> Creer un compte </span>
        </s:a>
    </s:else>
    </div>

    <script src="${pageContext.request.contextPath}/JS/main.js"></script>

</header>

<br />

<!--

<div class='login-form'>
    <div class='container'>
        <form>
            <h4>Username</h4>
            <input class='username' />
            <h4>Password</h4>
            <input type='password' />
            <input class='sign-in-button' type='submit' value='Sign In' />
        </form>
    </div>
</div>

-->

<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
<script
        src="https://code.jquery.com/jquery-3.3.1.js"
        integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>