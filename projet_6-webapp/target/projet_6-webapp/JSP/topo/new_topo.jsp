<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp" %>
</head>

<body>

<h2>Création d'un topo</h2>

<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-3">
        </div>
    <s:form action="topo_new" class="col-lg-6" theme="simple">

        <legend> Votre Topo : </legend>

        <div class="form-row">
            <div class="form-group col-lg-6">
                <label for="topo.nomTopo">Nom du topo : </label>
                <s:textfield name="topo.nomTopo" requiredLabel="true" class="form-control" theme="simple"/>
                </br>
            </div>
            <div class="form-group col-lg-6">
                <label for="topo.region">Region : </label>
                <s:textfield name="topo.region" requiredLabel="true" class="form-control" theme="simple"/>
                </br>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-lg-6">
                <label for="topo.lieu">Lieu : </label>
                <s:textfield name="topo.lieu" requiredLabel="true" class="form-control" theme="simple"/>
                </br>
            </div>

            <div class="form-group col-lg-6">
                <label for="topo.roche">Type de roche : </label>
                <s:textfield name="topo.roche" requiredLabel="true" class="form-control" theme="simple"/>
                </br>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-lg-6">
                <label for="topo.ancrage">Ancrage : </label>
                <s:textfield name="topo.ancrage" requiredLabel="true" class="form-control" theme="simple"/>
                </br>
            </div>

            <div class="form-group col-lg-6">
                <label for="topo.relai">Relai : </label>
                <s:textfield name="topo.relai" requiredLabel="true" class="form-control" theme="simple"/>
                </br>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-lg-6">
                <label for="topo.profil">Profil : </label>
                <s:textfield name="topo.profil" requiredLabel="true" class="form-control" theme="simple"/>
                </br>
            </div>
            <div class="form-group col-lg-6">
                <label for="topo.disponible">Voulez vous rendre votre topo disponible aux prets ? </label>
                <s:checkbox name="topo.disponible" class="form-control" theme="simple"/>
            </div>
        </div>

        <div class="form-group col-lg-12">
            <label for="topo.description">Description : </label>
            <s:textfield name="topo.description" requiredLabel="true" class="form-control" theme="simple"/>
            </br>
        </div>

        <s:submit value="OK" theme="simple" class="btn btn-primary btn-sm"/>
    </s:form>
        <div class="col-lg-3">
        </div>
    </div>
</div>

</body>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>