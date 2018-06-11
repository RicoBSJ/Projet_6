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

<!-- Recherche de topo -->
<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-3">
        </div>
        <div class="col-lg-6">
            <div class="input-group"> <span class="input-group-addon">Filter</span>
                <input id="filter" type="text" class="form-control" placeholder="Type here...">
            </div>
        </div>
        <div class="col-lg-3">
        </div>
    </div>
</div>
<!--
<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-2">
        </div>
        <div class="col-lg-8">
            <s:iterator value="listTopo">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Nom du topo</th>
                        <th>Type de roche</th>
                        <th>Region</th>
                        <th>Lieu</th>
                    </tr>
                    </thead>
                    <s:a action="topo_detail">
                        <tbody>
                        <tr>
                            <td><s:property value ="nomTopo" /></td>
                            <td><s:property value ="roche" /></td>
                            <td><s:property value ="region" /></td>
                            <td><s:property value ="lieu" /></td>
                            <s:param name="idTopo" value="idTopo" />
                        </tr>
                        </tbody>
                    </s:a>
                </table>
            </s:iterator>
        </div>
        <div class="col-lg-2">
        </div>
    </div>
</div>
-->

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
<div id="page_navigation"> </div>

<!-- Pagination -->
<script>
    var show_per_page = 3;
    var current_page = 0;

    function set_display(first, last) {
        $('#content').children().css('display', 'none');
        $('#content').children().slice(first, last).css('display', 'block');
    }

    function previous(){
        if($('.active').prev('.page_link').length) go_to_page(current_page - 1);
    }

    function next(){
        if($('.active').next('.page_link').length) go_to_page(current_page + 1);
    }

    function go_to_page(page_num){
        current_page = page_num;
        start_from = current_page * show_per_page;
        end_on = start_from + show_per_page;
        set_display(start_from, end_on);
        $('.active').removeClass('active');
        $('#id' + page_num).addClass('active');
    }

    $(document).ready(function() {

        var number_of_pages = Math.ceil($('#content').children().length / show_per_page);

        var nav = '<ul class="pagination"><li><a href="javascript:previous();">&laquo;</a>';

        var i = -1;
        while(number_of_pages > ++i){
            nav += '<li class="page_link'
            if(!i) nav += ' active';
            nav += '" id="id' + i +'">';
            nav += '<a href="javascript:go_to_page(' + i +')">'+ (i + 1) +'</a>';
        }
        nav += '<li><a href="javascript:next();">&raquo;</a></ul>';

        $('#page_navigation').html(nav);
        set_display(0, show_per_page);

    });
</script>

</body>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
</html>