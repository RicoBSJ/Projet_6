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
<div class="col-lg-5">
    <ul class="list-group">
        <s:iterator value="listTopo">

            <li class="list-group-item">
                <s:a action="topo_detail">
                    Nom topo : <s:property value="nomTopo"/>
                    <s:param name="idTopo" value="id" />
            </li>
        </s:a>
            <br />
        </s:iterator>
    </ul>
</div>

</body>
</html>