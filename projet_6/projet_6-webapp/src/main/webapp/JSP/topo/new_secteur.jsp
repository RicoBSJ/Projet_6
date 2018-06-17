<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp" %>
</head>

<body>

<h2>Création d'un secteur</h2>

<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-3">
        </div>

        <s:form action="secteur_new" class="col-lg-6" theme="simple">
            <div class="form-group col-lg-12">
                <label for="secteur.nomSecteur">Nom du secteur : </label>
                <s:textfield name="secteur.nomSecteur" label="Nom du secteur" requiredLabel="true" class="form-control" theme="simple"/>
                </br>
            </div>
            <div class="form-group col-lg-12">
                <label for="secteur.difficulte">Difficulté du secteur : </label>
                <s:textfield name="secteur.difficulte" label="Difficulté du secteur" requiredLabel="true" class="form-control" theme="simple"/>
                </br>
            </div>
            <div class="form-group col-lg-12">
                <label for="secteur.orientation">Orientation : </label>
                <s:textfield name="secteur.orientation" label="orientation du secteur" requiredLabel="true" class="form-control" theme="simple"/>
                </br>
            </div>
            <div class="form-group col-lg-12">
                <label for="secteur.description">Description : </label>
                <s:textfield name="secteur.description" label="Description" requiredLabel="true" class="form-control" theme="simple"/>
                </br>
            </div>
            <div class="form-group col-lg-12">
                <label for="selectSite"> Choisissez le site de votre secteur </label>
                <s:form>
                    <s:select class="form-control"
                              id="selectSite" name="site" label="Site"
                              list="{}" listKey="idSite" listValue="nomSite"
                              onchange="getListSite()"/>
                </s:form>
            </div>

            <s:submit value="OK"/>
        </s:form>

        <div class="col-lg-3">
        </div>
    </div>
</div>
</body>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>