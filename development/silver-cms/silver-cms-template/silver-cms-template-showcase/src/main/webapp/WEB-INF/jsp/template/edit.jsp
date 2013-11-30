<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <c:set var="ctx" value="${pageContext.servletContext.contextPath}" scope="request"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Template</title>
        <link rel="stylesheet" href="${ctx}/style/bootstrap-3.0.2-dist/css/bootstrap.css">
        <link rel="stylesheet" href="${ctx}/style/showcase.css">
        <script type="text/javascript" src="${ctx}/scripts/ueditor1_2_6_2/ueditor.config.js"></script>
        <script type="text/javascript" src="${ctx}/scripts/ueditor1_2_6_2/ueditor.all.js"></script>
        <script type="text/javascript" src="${ctx}/scripts/jquery/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="${ctx}/scripts/template.js"></script>
    </head>
    <body>
        <div class="navbar navbar-inverse" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Project name</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>
        <div id="actions" class="navbar navbar-default" style="position: relative;" role="navigation"><button type="submit" class="btn btn-lg btn-primary btn-block">保存</button></div>
        <div id="msg" class="navbar navbar-default" style="height: 50 px;"></div>
        <div class="container">
            <h1>标题：</h1>
            <input type="text" class="form-control" id="title" name="title"/>
            <hr>
            <h1>内容：</h1>
            <br>
            <textarea id="templateEditor" name="templateEditor"></textarea>
            <script type="text/javascript">
                UE.getEditor('templateEditor');
            </script>    
        </div>    
    </body>
</html>
