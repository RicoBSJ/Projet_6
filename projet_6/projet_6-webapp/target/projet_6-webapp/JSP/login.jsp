<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>

<head>
    <%@ include file="_include/header.jsp"%>
</head>

<body>
<s:actionerror/>
<s:actionmessage/>


</body>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>

<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-4">
        </div>

        <s:form action="login" class="col-lg-4" theme="simple">
            <div class="form-group col-lg-12">
                <label for="login">Pseudonyme : </label>
                <s:textfield name="login" label="Identifiant" requiredLabel="true" class="form-control" theme="simple" />
                </br>
            </div>
            <div class="form-group col-lg-12">
                <label for="password">Mot de passe : </label>
                <s:textfield name="password" label="Password" requiredLabel="true" class="form-control" theme="simple"/>
                </br>
            </div>
            <s:submit value="Connexion" class="btn btn-primary btn-sm"/>
            <br/>
            <br/>
        </s:form>
        <div class="col-lg-4">
        </div>
    </div>
</div>
<div class="row">
    <div class="col-lg-5">
    </div>
    <div class="col-lg-2">
        <div class="btn-group btn-group-justified">
            <a class="btn btn-danger" href="utilisateur_new.action">Creer un compte</a>
        </div>
    </div>
    <div class="col-lg-5">
    </div>
</div>