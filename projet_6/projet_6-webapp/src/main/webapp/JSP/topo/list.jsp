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
                    <table id="listTopo" class="table table-striped table-bordered" style="width:100%"
                           data-toggle="table"
                           data-filter-control="true"
                           data-filter-show-clear="true">
                        <thead>
                        <tr>
                            <th data-filter-control="input">Nom du topo</th>
                            <th data-filter-control="input">Type de roche</th>
                            <th data-filter-control="input">Region</th>
                            <th data-filter-control="input">Lieu</th>
                        </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="listTopo">
                        <tr>
                            <s:a action="topo_detail">
                            <td><s:property value ="nomTopo" /></td>
                            </s:a>
                            <td><s:property value ="roche" /></td>
                            <td><s:property value ="region" /></td>
                            <td><s:property value ="lieu" /></td>
                            <s:param name="idTopo" value="idTopo" />
                        </tr>
                            </s:iterator>
                        </tbody>
                    </table>
        </div>
        <div class="col-lg-2">
        </div>
    </div>
</div>

<div id="page_navigation"> </div>

<div id="content" class="row">
    <div class="col-lg-3">
    </div>
    <div class="col-lg-6">
        <ul class="list-group">
            <s:iterator value="listTopo">

                <li class="list-group-item">
                <s:a action="topo_detail">
                    Nom topo : <s:property value="nomTopo"/>
                    <s:param name="idTopo" value="idTopo" />
                    </li>
                </s:a>
                <br />
            </s:iterator>
        </ul>
    </div>
    <div class="col-lg-3">
    </div>
</div>

</body>

<script src="${pageContext.request.contextPath}/JS/main.js"></script>
<script src=" https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
<link href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css" rel="stylesheet" />
</html>