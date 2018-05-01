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
                        <td><s:property value ="topo.nom_topo" /></td>
                        <td><s:property value ="topo.roche" /></td>
                        <td><s:property value ="topo.region" /></td>
                        <td><s:property value ="topo.lieu" /></td>
                        <td><s:property value ="topo.description" /></td>
                        <td><s:property value ="utilisateur.pseudonyme"/> </td>
                </tr>
                </tbody>
        </table>
</section>
        <legend>Laisser un commentaire</legend>
        <h6>Que penser vous du topo</h6>

    <s:form action="com_new">
        <s:textarea name="commentaire.text" label="commentaire"/>
        <s:submit value="OK"/>
    </s:form>

<br />
<s:a action="topo_com">
    <h2>Espace discussion sur le topo</h2>
    <s:param name="id" value="id"/>
</s:a>
</body>
</html>