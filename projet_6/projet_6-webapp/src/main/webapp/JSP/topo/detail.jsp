<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<body>
<br />

<section class="col-sm-8 table-responsive">
        <table class="table table-bordered table-striped table-condensed">
                <caption>
                        <h4>Detail du topo</h4>
                </caption>
                <thead>
                <tr>
                        <th>Nom</th>
                        <th>Roche</th>
                        <th>Region</th>
                        <th>Lieu</th>
                        <th>Description</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                        <td><s:property value="topo.nom_topo" /></td>
                        <td><s:property value="topo.roche" /></td>
                        <td><s:property value="topo.region" /></td>
                        <td><s:property value="topo.lieu" /></td>
                        <td><s:property value = "topo.description" /></td>
                </tr>
                </tbody>
        </table>
</section>
<form class="well">
        <legend>Laisser un commentaire</legend>
        <h4>Que penser vous du topo</h4>
        <fieldset>
                <label for="textarea">Votre message :</label>
                <textarea id="textarea" class="form-control" rows="4"></textarea>
                <p class="help-block">Vous pouvez agrandir la fenêtre</p>
                <button class="btn btn-primary" type="submit">Envoyer</button>
        </fieldset>
</form>
</body>
</html>