<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>

</head>

<body>
<s:actionerror/>
<s:actionmessage/>

<h2>Création d'un nouveau compte</h2>
<div class="form">

    <s:form action="utilisateur_new">
        <s:textfield name="utilisateur.nom" label="Nom" requiredLabel="true" />
        <s:textfield name="utilisateur.prenom" label="Prenom" requiredLabel="true" />
        <s:textfield name="utilisateur.pseudonyme" label="Pseudonyme" requiredLabel="true" />
        <s:textfield name="utilisateur.mail" label="Mail" requiredLabel="true" />
        <s:textfield name="utilisateur.tel" label="Telephone" requiredLabel="true" />
        <s:textfield name="utilisateur.motDePasse" label="Mot de Passe" requiredLabel="true" />

        <s:submit value="OK"/>
    </s:form>
</div>

</body>
</html>