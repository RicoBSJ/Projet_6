<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<body>
<br />

<s:actionerror/>
<s:actionmessage/>

<ul>
    <s:iterator value="listCom">
        <li>
           Commentaire : <s:property value="text"/>
        </li>
        <br />
    </s:iterator>
</ul>

</body>
</html>