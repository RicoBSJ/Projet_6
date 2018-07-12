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

            <legend> Votre voie : </legend>

            <span id="spanIdTopo" style="display: none;"><s:property value ="#session.topo.idTopo" /></span>
            <div class="form-group col-lg-12">
                <label for="voie.nomVoie">Nom de la voie : </label>
                <s:textfield name="voie.nomVoie" label="Nom du site" requiredLabel="true" class="form-control" theme="simple" />
                <br />
            </div>
            <div class="form-group col-lg-12">
                <label for="voie.hauteur">Hauteur de la voie : </label>
                <s:textfield name="voie.hauteur" label="Altitude de la voie (Pied)" requiredLabel="true" class="form-control" theme="simple"/>
                <br />
            </div>
            <div class="form-group col-lg-12">
                <label for="voie.cotation">Cotation de la voie : </label>
                <s:textfield name="voie.cotation" label="Altitude de la voie (Pied)" requiredLabel="true" class="form-control" theme="simple"/>
                <br />
            </div>
            <div class="form-group col-lg-12">
                <label for="voie.description">Description : </label>
                <s:textfield name="voie.description" label="Description" requiredLabel="true" class="form-control" theme="simple"/>
                <br />
            </div>
            <div class="form-group col-lg-12">
                <label for="selectSite"> Choisissez le site de votre voie </label>
                <s:select class="form-control"
                          id="selectSite" name="voie.idSite" label="Site"
                          list="{}" listKey="idSite" listValue="nomSite"
                          requiredLabel="true" theme="simple"
                          onchange="getListSecteur()"/>
                <br />
            </div>
            <div class="form-group col-lg-12">
                <label for="selectSecteur"> Choisissez le secteur de votre voie </label>
                <s:select class="form-control"
                          id="selectSecteur" name="voie.idSecteur" label="Secteur"
                          list="{}" listKey="idSecteur" listValue="nomSecteur"
                          requiredLabel="true" theme="simple" />
                <br />
            </div>

            <s:submit value="Creer la voie" class="btn btn-primary btn-sm"/>
        </s:form>

        <div class="col-lg-3">
        </div>
    </div>
</div>
</body>

<script>
    $(document).ready(function() {
        getListSite();
    });
</script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>