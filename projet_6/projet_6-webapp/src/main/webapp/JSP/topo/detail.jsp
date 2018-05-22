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

<div class="tab_topo">
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
</div>

<h1> Le topo a été emprunté par : <s:property value="emprunteur.pseudonyme"/> </h1>

<div class="button_site">
    <button class="btn btn-primary btn-sm" type="submit" onclick="getListSiteAjax()"> Voir les sites du topo</button>
        <ul id="listSite">
            <li><em> A charger . . .</em> </li>
        </ul>
    <div style="color: green; font-size: 25px;"></div>
</div>


<s:a action="site_new">
    <h3>Creation d'un nouveau site</h3>
</s:a>


<legend>Laisser un commentaire</legend>
<h6>Que penser vous du topo</h6>

<s:form action="com_new">
    <s:textarea name="commentaire.text" label="commentaire"/>
    <s:submit value="OK"/>
</s:form>

<br />


<div class="commentaire" >
    <div class="col-lg-12">
        <button class="btn btn-primary btn-sm" type="submit" onclick="getListComAjax()"> Voir les commentaires</button>
        <ul class="list-group" id="listCom">
            <em> Cliquez pour charger les commentaires.</em>
            <li class="list-group-item">
            </li>
        </ul>
    </div>
</div>


</body>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>