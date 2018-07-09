<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp" %>
</head>

<s:debug />

<body>

<h2>Création d'un Site</h2>
<br/>

<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-3">
        </div>
        <s:form action="site_new" class="col-lg-6" theme="simple">
            <div class="form-group col-lg-12">
                <label for="site.nomSite">Nom du Site : </label>
                <s:textfield name="site.nomSite" label="Nom du site" requiredLabel="true" class="form-control" theme="simple" />
                </br>
            </div>
            <div class="form-group col-lg-12">
                <label for="site.altitudePiedVoie">Altiude du site (en pied) : </label>
                <s:textfield name="site.altitudePiedVoie" label="Altitude de la voie (Pied)" requiredLabel="true" class="form-control" theme="simple"/>
                </br>
            </div>
            <div class="form-group col-lg-12">
                <label for="site.description">Description : </label>
                <s:textfield name="site.description" label="Description" requiredLabel="true" class="form-control" theme="simple"/>
                </br>
            </div>

            <s:submit value="Creer le site" class="btn btn-primary btn-sm"/>
        </s:form>

        <div class="col-lg-3">
        </div>
    </div>
</div>


</body>


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>