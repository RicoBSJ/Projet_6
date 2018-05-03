<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
</head>

<body>

<h2>Connexion <br />
    <s:actionerror/>
    <s:actionmessage/>
</h2>

<s:form action="login">
    <s:textfield name="login" label="Identifiant" requiredLabel="true" />
    <s:password name="password" label="Mot de passe" requiredLabel="true" />

    <s:submit value="Connexion"/>
</s:form>

</body>
</html>