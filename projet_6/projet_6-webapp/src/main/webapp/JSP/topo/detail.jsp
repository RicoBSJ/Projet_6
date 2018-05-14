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
        <s:param name="idTopo" value="topo.id"/>
        <s:textarea name="commentaire.text" label="commentaire"/>
        <s:submit value="OK"/>
    </s:form>

<br />
<ul>
    <s:iterator value="listCom">
        <s:param name="idTopo" value="topo.id"/>
        <li>
            Commentaire : <s:property value="text"/>
        </li>
        <br />
    </s:iterator>
</ul>


<div class="commentaire" >
    <div class="col-lg-12">
        <ul class="list-group">
            <s:a action="listComAjax">
                <s:iterator value="listCom">
                    <li class="list-group-item">
                        <s:property value="text"/>
                    </li>
                </s:iterator>
            </s:a>
        </ul>
    </div>
</div>





</body>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>