<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<body>
<br />

<s:actionerror/>

<s:actionmessage/>

<h2> Information Topo </h2>

<section class="col-sm-8 table-responsive">
        <table class="table table-bordered table-striped table-condensed">
                <thead>
                <tr>
                        <th>Nom</th>
                        <th>Roche</th>
                        <th>Region</th>
                        <th>Lieu</th>
                        <th>Description</th>
                        <th>Créateur</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                        <td><s:property value ="topo.nomTopo" /></td>
                        <td><s:property value ="topo.roche" /></td>
                        <td><s:property value ="topo.region" /></td>
                        <td><s:property value ="topo.lieu" /></td>
                        <td><s:property value ="topo.description" /></td>
                        <td><s:property value ="utilisateur.pseudonyme"/> </td>
                </tr>
                </tbody>
        </table>
</section>

<h2> Information Site </h2>

<s:a action="list_site">
    <s:param name="idTopoSite" value="topo.id" />
    <h3>Liste des site</h3>
</s:a>

<s:a action="site_new">
    <s:param name="idTopoSite" value="topo.id" />
    <h3>Creation d'un nouveau site</h3>
</s:a>

        <legend>Laisser un commentaire</legend>
        <h6>Que penser vous du topo</h6>

    <s:form action="com_new">
        <s:textarea name="commentaire.text" label="commentaire"/>
        <s:submit value="OK"/>
    </s:form>

<br />
<s:a action="topo_com">
    <h2>Espace discussion sur le topo</h2>
    <s:param name="idTopo" value="topo.id"/>
</s:a>
</body>
</html>