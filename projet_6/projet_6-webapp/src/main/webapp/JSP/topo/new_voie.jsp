<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp" %>
</head>

<body>

<h2>Création d'une nouvelle voie</h2>
<br/>

<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-3">
        </div>

        <s:form action="voie_new" class="col-lg-6" theme="simple">
            <div class="form-group col-lg-12">
                <label for="voie.nom">Nom de la voie : </label>
                <s:textfield name="voie.nom" label="Nom du site" requiredLabel="true" class="form-control" theme="simple" />
                </br>
            </div>
            <div class="form-group col-lg-12">
                <label for="voie.hauteur">Hauteur de la voie : </label>
                <s:textfield name="voie.hauteur" label="Altitude de la voie (Pied)" requiredLabel="true" class="form-control" theme="simple"/>
                </br>
            </div>
            <div class="form-group col-lg-12">
                <label for="voie.cotation">Cotation de la voie : </label>
                <s:textfield name="voie.cotation" label="Altitude de la voie (Pied)" requiredLabel="true" class="form-control" theme="simple"/>
                </br>
            </div>
            <div class="form-group col-lg-12">
                <label for="voie.description">Description : </label>
                <s:textfield name="voie.description" label="Description" requiredLabel="true" class="form-control" theme="simple"/>
                </br>
            </div>

            <s:submit value="OK"/>
        </s:form>

        <div class="col-lg-3">
        </div>
    </div>
</div>
</body>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>