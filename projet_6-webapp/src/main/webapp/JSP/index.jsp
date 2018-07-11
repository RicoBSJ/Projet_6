<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="_include/header.jsp"%>
</head>

<body>
    <br />
    <br />
    <br />
    <br />

    <!--
    <div class="title">
        <h1>
            Bienvenue sur Bubule <br />
            Site communautaire de reference de topo
        </h1>
    </div>
    -->

    <div class="inner cover">
        <h1 class="cover-heading">Site de Topo</h1>
        <p class="lead">Bienvenue sur notre site de référencement de topo, vous pouvez voir, reserver et faire des remarques sur les topo que vous avez essayés</p>
    </div>

    <br/>
    <br/>

    <!--
    <div class="row">
        <div class="col-lg-3">
        </div>
        <div class="col-lg-6">
            <div class="btn-group btn-group-justified">
                <a class="btn btn-danger" href="utilisateur_new.action">Creer un compte</a>
                <a class="btn btn-info" href="topo_list.action">Liste de topo</a>
                <a class="btn btn-warning" href="#">Rechercher un topo</a>
            </div>
        </div>
        <div class="col-lg-3">
        </div>
    </div>
    -->

</body>


<script src="${pageContext.request.contextPath}/JS/main.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>
