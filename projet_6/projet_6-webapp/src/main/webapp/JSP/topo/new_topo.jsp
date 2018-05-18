<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp" %>
</head>

<body>

<h2>Création d'un topo</h2>

<s:form action="topo_new" class="col-lg-6" theme="simple">

    <legend> Votre Topo : </legend>

    <label for="topo.nomTopo">Nom du topo : </label>
    <s:textfield name="topo.nomTopo" requiredLabel="true" class="form-control" theme="simple"/>
    </br>
    <label for="topo.region">Region : </label>
    <s:textfield name="topo.region" requiredLabel="true" class="form-control" theme="simple"/>
    </br>
    <label for="topo.lieu">Lieu : </label>
    <s:textfield name="topo.lieu" requiredLabel="true" class="form-control" theme="simple"/>
    </br>
    <label for="topo.roche">Type de roche : </label>
    <s:textfield name="topo.roche" requiredLabel="true" class="form-control" theme="simple"/>
    </br>
    <label for="topo.ancrage">Ancrage : </label>
    <s:textfield name="topo.ancrage" requiredLabel="true" class="form-control" theme="simple"/>
    </br>
    <label for="topo.relai">Relai : </label>
    <s:textfield name="topo.relai" requiredLabel="true" class="form-control" theme="simple"/>
    </br>
    <label for="topo.profil">Profil : </label>
    <s:textfield name="topo.profil" requiredLabel="true" class="form-control" theme="simple"/>
    </br>
    <label for="topo.description">Description : </label>
    <s:textfield name="topo.description" requiredLabel="true" class="form-control" theme="simple"/>
    </br>
    <label for="topo.etat">Etat du topo : </label>
    <s:checkbox name="topo.etat" class="form-control" theme="simple"/>

    <s:submit value="OK" theme="simple"/>
</s:form>

</body>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>