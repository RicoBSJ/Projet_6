<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp" %>
</head>

<body>

<h2>Création d'un topo</h2>

<s:form action="topo_new" class="col-lg-6">

    <div class="form-group">
        <label>Nom du topo : </label>
        <s:textfield name="topo.nomTopo" label="Nom du topo" requiredLabel="true" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Region : </label>
        <s:textfield name="topo.region" label="Region" requiredLabel="true" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Lieu : </label>
        <s:textfield name="topo.lieu" label="Lieu" requiredLabel="true" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Type de roche : </label>
        <s:textfield name="topo.roche" label="Roche" requiredLabel="true" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Ancrage : </label>
        <s:textfield name="topo.ancrage" label="Ancrage" requiredLabel="true" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Relai : </label>
        <s:textfield name="topo.relai" label="Relai" requiredLabel="true" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Profil : </label>
        <s:textfield name="topo.profil" label="Profil" requiredLabel="true" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Description : </label>
        <s:textfield name="topo.description" label="Description" requiredLabel="true" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Etat du topo : </label>
        <s:checkbox name="topo.etat" label="Disponible" class="form-control"/>
    </div>

    <s:submit value="OK"/>
</s:form>

</body>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>