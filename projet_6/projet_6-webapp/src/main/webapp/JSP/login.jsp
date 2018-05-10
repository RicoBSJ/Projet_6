<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>

<head>
    <h2> Page de Connexion <br />
        <s:actionerror/>
        <s:actionmessage/>
    </h2>
</head>

<body>


<s:form action="login">
    <s:textfield name="login" label="Identifiant" requiredLabel="true" />
    <s:password name="password" label="Mot de passe" requiredLabel="true" />

    <s:submit value="Connexion" class="button"/>
</s:form>

<s:a action="utilisateur_new">
    <span class="button"> Creer un compte </span>
</s:a>

</body>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>