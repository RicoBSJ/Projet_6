<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

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
            <s:if test="topo.disponible == false ">
                Le topo est indisponible, il a été emprunté par : <s:property value="emprunteur.pseudonyme"/>
            </s:if>
            <s:elseif test="topo.idEmprunteur == null && topo.disponible == true">
                <h3> Voulez vous emprunter ce topo ? </h3>
                <s:a action="reserver">
                    <button class="btn btn-primary btn-sm" type="submit"> Reserver </button>
                </s:a>
            </s:elseif>
            <s:if test="#session.idUtilisateur == topo.idEmprunteur">
                <h3> Voulez vous rendre ce topo ?</h3>
                <s:a action="rendre">
                    <button class="btn btn-primary btn-sm" type="submit"> Rendre le topo </button>
                </s:a>
            </s:if>
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
            <div class="cadre">
                <div class="form-group">
                    <span id="spanIdTopo" style="display: none;"><s:property value ="topo.IdTopo" /></span>
                    <s:form>
                        <s:select class="form-control"
                                  id="selectSite" name="site" label="Site"
                                  list="{}" listKey="idSite" listValue="nomSite"
                                  onchange="getListSecteur(), getSiteDetail()"/>
                    </s:form>
                    information du site :
                    <ul id="infoSite">
                        <li> Info Site </li>
                    </ul>
                    <s:a action="site_new">
                        <button class="btn btn-primary btn-sm" type="submit">Creer un site </button>
                    </s:a>
                </div>
            </div>
        </div>

        <div class="col-lg-2">
            <div class="cadre">
                <div class="form-group">
                    <s:form>
                        <s:select class="form-control"
                                  id="selectSecteur" name="secteur" label="Secteur"
                                  list="{}" listKey="idSecteur" listValue="nomSecteur"
                                  onchange="getListVoie(), getSecteurDetail()"/>
                    </s:form>
                    information du secteur :
                    <ul id="infoSecteur">
                        <li><em> Info secteur </em></li>
                    </ul>
                    <s:a action="secteur_new">
                        <button class="btn btn-primary btn-sm" type="submit"> Creer un secteur </button>
                    </s:a>
                </div>
            </div>
        </div>

        <div class="col-lg-2">
            <div class="cadre">
                <div class="form-group">
                    <s:form>
                        <s:select class="form-control"
                                  id="selectVoie" name="voie" label="Voie"
                                  list="{}" listKey="idVoie" listValue="nomVoie"
                                  onchange="getVoieDetail()"/>
                    </s:form>
                    information de la voie :
                    <ul id="infoVoie">
                        <li> Info voie </li>
                    </ul>
                    <s:a action="voie_new">
                        <button class="btn btn-primary btn-sm" type="submit"> Creer une voie </button>
                    </s:a>
                </div>
            </div>
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
            <div class="form-group">
                <s:form action="com_new" class="col-lg-6">
                    <label> Dites nous ce que vous pensez du topo : </label>
                    <s:textarea name="commentaire.text" class="form-control" rows="5" />
                    <s:submit value="Envoyer" class="btn btn-primary btn-sm" theme="simple" onclick="getListComAjax"/>
                </s:form>
            </div>
        </div>
        <div class="col-lg-3">
        </div>
    </div>
</div>

<br />

<div class="row">
    <div class="commentaire">
        <div class="col-lg-12">
            <div class="col-lg-2">
            </div>
                <div class="col-lg-8">
                    <div class="cadre">
                    <label> Commentaire du topo </label>
                    <br />
                    <br/>
                    <ul  id="listCom">
                        <li>
                            <em>commentaires.</em>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="col-lg-2">
            </div>
        </div>
    </div>
</div>

<script>
    $( document ).ready(function() {
        getListComAjax();
    });
    $( document ).ready(function() {
        getListSite();
    })
</script>
</body>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>