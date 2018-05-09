<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="_include/header.jsp"%>
</head>

<body>
    <h2>Liste Topo</h2>
    <br />

    <nav>
        <s:a action="topo_list">
            <h3>Liste des topo</h3>
        </s:a>

        <s:a action="login">
            <h4>
                Page de connection
            </h4>
        </s:a>
    </nav>

</body>
</html>
