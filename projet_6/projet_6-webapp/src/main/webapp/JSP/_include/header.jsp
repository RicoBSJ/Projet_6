<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<head>
    <meta charset="utf-8" />
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>

<header>
    <s:actionerror/>
    <s:actionmessage/>


    <div class="navbar navbar-inverse">
        <ul class="nav navbar-nav">
            <li class="active"> <a href="index.action">Accueil</a> </li>
            <li> <a href="#">Rechercher un topo</a> </li>
            <li> <a href="topo_list.action">Liste de topo</a> </li>
        </ul>
        <s:if test="#session.check == 'true'">
            <s:a action="utilisateur_detail" theme="simple">
                <span>Vous etes connecté <s:property value="#session.user.prenom"/> </span>
                <s:param name="id" value="#session.user.id" />
                <br />
            </s:a>
            <s:a action="logout" theme="simple">
                <span> Deconnection </span>
            </s:a>
        </s:if>
        <s:else >
            <s:form action="login" class="navbar-form navbar-right inline-form" theme="simple">
                <s:textfield name="login" label="Identifiant" requiredLabel="true" class="input-sm form-control" theme="simple"/>
                <s:password name="password" label="Mot de passe" requiredLabel="true" type="password" class="input-sm form-control" theme="simple"/>
                <s:submit value="Connexion" class="btn btn-primary btn-sm" type="submit" theme="simple"/>
            </s:form>
        </s:else>
    </div>

</header>

<br />


<script src="${pageContext.request.contextPath}/JS/main.js"></script>
<script
        src="https://code.jquery.com/jquery-3.3.1.js"
        integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>