<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<s:actionerror/>
<s:actionmessage/>

<body>

<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-3">
        </div>
        <div class="col-lg-6">
            <h1> Information Topo </h1>
        </div>
        <div class="col-lg-3">
        </div>
    </div>
</div>

<header class="row">
    <div class="row">
        <div class="col-lg-12">
            <div class="col-lg-2">
            </div>
            <section class="col-lg-8 table-responsive">
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
            <div class="col-lg-2">
            </div>
        </div>
    </div>
</header>

<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-3">
        </div>
        <div class="col-lg-6">
            <s:if test="topo.idEmprunteur != null " >
                <h3> Le topo a été emprunté par : <s:property value="emprunteur.pseudonyme"/> </h3>
            </s:if>
            <s:else>
                <h3> Voulez vous emprunter ce topo ? </h3>
                <s:a action="reserver">
                    <button class="btn btn-primary btn-sm" type="submit"> Reserver </button>
                </s:a>
            </s:else>
        </div>
        <div class="col-lg-3">
        </div>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-3">
            aside
        </div>
        <div class="class-lg-2">
            aside

            <div class="button_site">
                <button class="btn btn-primary btn-sm" type="submit" onclick="getListSiteAjax()"> Voir les sites du topo</button>
                <ul id="listSite">
                    <li><em> Afficher les sites </em> </li>
                </ul>
            </div>

        </div>
        <div class="class-lg-2">
            aside
            <!--
            <div class="button_secteur">
                <button class="btn btn-primary btn-sm" type = "submit" onclick="getListSecteur()"> Voir les secteurs du site</button>
                <ul id="listSecteur">
                    <li><em> Voir les secteurs du site </em> </li>
                </ul>
            </div>
            -->
        </div>
        <div class="class-lg-2">
            aside
        </div>
        <div class="col-lg-3">
            aside
        </div>
    </div>
</div>


<s:a action="site_new">
    <h3>Ajouter un site</h3>
</s:a>

<br />



<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-3">
        </div>
        <s:form action="com_new" class="col-lg-6">
            <s:textarea name="commentaire.text" label="commentaire" class="form-control"/>
            <s:submit value="Envoyer" class="btn btn-primary btn-sm" theme="simple"/>
        </s:form>
    </div>
</div>

<h6>Dite nous ce que vous pensez du topo</h6>

<br />


<div class="commentaire" >
    <div class="col-lg-12">
        <button class="btn btn-primary btn-sm" type="submit" onclick="getListComAjax()"> Voir les commentaires</button>
        <ul  id="listCom">
            <li><em> Cliquez pour charger les commentaires.</em></li>
        </ul>
    </div>
</div>


</body>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>