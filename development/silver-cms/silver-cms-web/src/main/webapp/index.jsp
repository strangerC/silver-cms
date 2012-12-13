<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="/WEB-INF/pages/jsp/common/common-resource.jsp"/>
    </head>
    <body>              
        <div class="navbar">
            <div class="navbar-inner">
                <a class="brand" href="#">Title</a>
                <ul class="nav">
                    <li><a href="#">Home</a></li>
                    <li><a href="ArticleServlet">edit article</a></li>
                    <li><a href="#">Link</a></li>
                </ul>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="span2">span2</div>
                <div class="span2 offset4">span2</div>
            </div>
        </div>
    </body>
</html>





