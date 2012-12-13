<%-- 
    Document   : common_resource
    Created on : Oct 21, 2012, 2:39:34 PM
    Author     : liaojian
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String contextPath = request.getContextPath();
request.setAttribute("ctx", contextPath);
%>
<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/smoothness/jquery-ui-1.9.1.custom.min.css" rel="stylesheet">
<script src="${ctx}/js/jquery.js"></script>
<script src="${ctx}/js/jquery-ui-1.9.1.custom.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>  