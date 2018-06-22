<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<body>

<s:debug />

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
            <s:if test="topo.etat == false ">
                Le topo est indisponible
            </s:if>
            <s:elseif test="topo.idEmprunteur != null" >
                <h3> Le topo a été emprunté par : <s:property value="emprunteur.pseudonyme"/> </h3>
            </s:elseif>
            <s:elseif test="topo.idEmprunteur == null && topo.etat == true">
                <h3> Voulez vous emprunter ce topo ? </h3>
                <s:a action="reserver">
                    <button class="btn btn-primary btn-sm" type="submit"> Reserver </button>
                </s:a>
            </s:elseif>
        </div>
        <div class="col-lg-3">
        </div>
    </div>
</div>

<br/>
<br/>

<div class="row">
    <div class="col-lg-12">

        <div class="col-lg-3">
        </div>

        <div class="col-lg-2">
            <div class="form-group">
                <span id="spanIdTopo" style="display: none;"><s:property value ="topo.IdTopo" /></span>
                <s:form>
                    <s:select class="form-control"
                              id="selectSite" name="site" label="Site"
                              list="listSite" listKey="idSite" listValue="nomSite"
                              onchange="getListSecteur(), getSecteurDetail()"/>
                </s:form>
                <s:a action="site_new">
                    <button class="btn btn-primary btn-sm" type="submit"> Creer un site </button>
                </s:a>
            </div>
        </div>

        <div class="col-lg-2">
            <s:form>
                <s:select class="form-control"
                          id="selectSecteur" name="secteur" label="Secteur"
                          list="{}" listKey="idSecteur" listValue="nomSecteur"
                          onchange="getListVoie()"/>
            </s:form>
            <s:a action="secteur_new">
                <button class="btn btn-primary btn-sm" type="submit"> Creer un secteur </button>
            </s:a>
        </div>

        <div class="col-lg-2">
            <s:form>
                <s:select class="form-control"
                          id="selectVoie" label="Voie" list="{}"/>
            </s:form>
            <s:a action="voie_new">
                <button class="btn btn-primary btn-sm" type="submit"> Creer une voie </button>
            </s:a>
        </div>

        <div class="col-lg-3">
        </div>

    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-3">
        </div>

        <div class="col-lg-2">
            information du site :
            <ul id="infoSite">
                <li> Info Site </li>
            </ul>
        </div>

        <div class="col-lg-2">
            information du secteur :
            <ul id="infoSecteur">
                <li><em> Info secteur </em></li>
            </ul>
        </div>

        <div class="col-lg-2">
            information de la voie :
            <ul id="infoVoie">
                <li> Info voie</li>
            </ul>
        </div>

        <div class="col-lg-3">
        </div>
    </div>
</div>

<br />

<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-3">
        </div>
        <div class="col-lg-6">
            <s:form action="com_new" class="col-lg-6">
                <s:textarea name="commentaire.text" label="commentaire" class="form-control"/>
                <s:submit value="Envoyer" class="btn btn-primary btn-sm" theme="simple"/>
            </s:form>
        </div>
        <div class="col-lg-3">
        </div>
    </div>
</div>

<h6>Dite nous ce que vous pensez du topo</h6>

<br />

<div class="commentaire">
    <div class="col-lg-12">
        <div class="col-lg-2">
        </div>
        <div class="col-lg-8">
            <!--<button class="btn btn-primary btn-sm" type="submit" onclick="getListComAjax()"> Voir les commentaires</button>-->
            <br />
            <br/>
            <ul  id="listCom">
                <li>
                    <em> Cliquez pour charger les commentaires.</em>
                </li>
            </ul>
        </div>
        <div class="col-lg-2">
        </div>
    </div>
</div>

<script>
    $( document ).ready(function() {
        getListComAjax();
    });
</script>
</body>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>