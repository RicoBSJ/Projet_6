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

<s:a action="topo_new">
    Creation d'un nouveau topo
</s:a>


<s:actionmessage />
<br />
<br />
<div class="row">
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

<div class="row">
    <ul class="pager">
        <li><a href="#">Précédent</a></li>
        <li><a href="#">Suivant</a></li>
    </ul>
</div>

</body>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>