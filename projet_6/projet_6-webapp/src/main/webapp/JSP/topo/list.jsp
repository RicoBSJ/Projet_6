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

<s:a action="topo_new">Creation d'un nouveau topo </s:a>


<s:actionmessage />
<br />
<br />

<ul>
    <s:iterator value="listTopo">

        <li>
            <s:a action="topo_detail">
                Nom topo : <s:property value="nom_topo"/>
                <s:param name="id" value="id" />
        </li>
    </s:a>
        <br />
    </s:iterator>
</ul>

</body>
</html>