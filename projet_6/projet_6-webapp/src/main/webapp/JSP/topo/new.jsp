<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp" %>
</head>

<body>
<s:actionerror/>
<s:actionmessage/>

<h2>Création d'un projet</h2>

<s:form action="topo_new">
    <s:textfield name="topo.nom" label="Nom" requiredLabel="true" />
    <s:select name="topo.createur.id" label="Responsable"
              list="listTopo" listKey="id" listValue="prenom"
              emptyOption="true"
              requiredLabel="true"/>

    <s:checkbox name="topo.cloture" label="Cloturé"/>

    <s:submit value="OK"/>
</s:form>
</body>
</html>