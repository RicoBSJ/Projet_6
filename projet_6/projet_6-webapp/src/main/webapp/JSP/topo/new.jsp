<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp" %>
</head>

<body>

<h2>Création d'un topo</h2>

<s:form action="topo_new">
    <s:param name="topo.id_utilisateur_createur" value="#session.user.id"/>
    <s:textfield name="topo.nom_topo" label="Nom" requiredLabel="true" />
    <s:textfield name="topo.region" label="Region" requiredLabel="true" />
    <s:textfield name="topo.lieu" label="Lieu" requiredLabel="true" />
    <s:textfield name="topo.roche" label="Roche" requiredLabel="true" />
    <s:textfield name="topo.ancrage" label="Ancrage" requiredLabel="true" />
    <s:textfield name="topo.relai" label="Relai" requiredLabel="true" />
    <s:textfield name="topo.profil" label="Profil" requiredLabel="true" />
    <s:textfield name="topo.description" label="Description" requiredLabel="true" />

    <s:checkbox name="topo.etat" label="Disponible"/>

    <s:submit value="OK"/>
</s:form>
</body>
</html>