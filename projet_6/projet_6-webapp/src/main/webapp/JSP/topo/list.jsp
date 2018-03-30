<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<body>
<h2>Liste des Topo</h2>

<ul>
    <s:iterator value="listTopo">

        <li>
            <s:a action="topo_detail">
                Nom topo : <s:property value="nom"/>
                Id : <s:property value="id"/>
            </s:a>
        </li>
    </s:iterator>
</ul>
</body>
</html>