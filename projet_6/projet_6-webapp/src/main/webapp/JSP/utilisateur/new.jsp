<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<body>
<s:actionerror/>
<s:actionmessage/>

<h2>Création d'un nouveau compte</h2>

<div class="col-lg-12">
    <div class="col-lg-3">
    </div>
    <s:form action="utilisateur_new" class="col-lg-6" theme="simple">
        <div class="form-row">
            <div class="form-group col-lg-6">
                <label for="utilisateur.nom">Nom</label>
                <s:textfield name="utilisateur.nom" label="Nom" requiredLabel="true" />
                <br />
            </div>
            <div class="form-group col-lg-6">
                <label for="utilisateur.prenom">Prénom</label>
                <s:textfield name="utilisateur.prenom" label="Prenom" requiredLabel="true" />
                <br />
            </div>
        </div>
        <div class="form-group col-lg-12">
            <label for="utilisateur.pseudonyme">Pseudonyme</label>
            <s:textfield name="utilisateur.pseudonyme" label="Pseudonyme" requiredLabel="true" />
            <br />
        </div>
        <div class="form-group col-lg-12">
            <label for="utilisateur.mail">Adresse mail</label>
            <s:textfield name="utilisateur.mail" label="Mail" requiredLabel="true" />
            <br />
        </div>
        <div class="form-row">
            <div class="form-group col-lg-6">
                <label for="utilisateur.tel">Numero de telephone</label>
                <s:textfield name="utilisateur.tel" label="Telephone" requiredLabel="true" />
                <br />
            </div>
            <div class="form-group col-lg-6">
                <label for="utilisateur.motDePasse">Mot de passe</label>
                <s:textfield name="utilisateur.motDePasse" label="Mot de Passe" requiredLabel="true" />
                <br />
            </div>
        </div>
        <div class="form-row">
            <s:submit value="Creer votre compte" class="btn btn-primary"/>
        </div>
    </s:form>

    <div class="col-lg-3">
    </div>

</div>


</body>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>