<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<body>
<h2>Liste des Topo</h2>
<br />

<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-2">
        </div>
        <div class="col-lg-8">
            <table id="listTopo" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Nom du topo</th>
                    <th>Type de roche</th>
                    <th>Region</th>
                    <th>Lieu</th>
                    <th>Etat</th>
                    <th>Detail</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="listTopo">
                    <tr>
                        <td><s:property value ="nomTopo" /></td>
                        <td><s:property value ="roche" /></td>
                        <td><s:property value ="region" /></td>
                        <td><s:property value ="lieu" /></td>
                        <td><s:if test="disponible == true">Disponible</s:if>
                            <s:else> Indisponibile </s:else></td>
                        <td><a href="<s:url namespace="/" action="topo_detail"><s:param name="idTopo" value="%{idTopo}" /></s:url>">
                            <button type="button" class="btn btn-info"> <span class="glyphicon glyphicon-eye-open"></span></button>
                        </a> </td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
        <div class="col-lg-2">
        </div>
    </div>
</div>

</body>

<script>
    $(document).ready(function() {
        $('#listTopo').DataTable();
    });
</script>
<script src="${pageContext.request.contextPath}/JS/main.js"></script>
<script src=" https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
<link href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css" rel="stylesheet" />
</html>