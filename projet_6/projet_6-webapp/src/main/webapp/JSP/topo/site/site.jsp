<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>

<body>
<h2>Liste des Site</h2>
<br />

<s:actionmessage />
<br />
<br />

<ul>
    <s:iterator value="listSite">

        <li>
            Nom site : <s:property value="nomSite"/>
            Altitude de la voie (en pied) : <s:property value="altitudePiedVoie"/>
            Description : <s:property value="altitudePiedVoie"/>
            </li>
        <br />
    </s:iterator>
</ul>

</body>
</html>