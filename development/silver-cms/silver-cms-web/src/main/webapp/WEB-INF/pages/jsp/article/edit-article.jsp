<%-- 
    Document   : edit-article.jsp
    Created on : Aug 25, 2012, 11:47:29 PM
    Author     : Liao Jian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${article.title}</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script type="text/javascript" src="scripts/ckeditor/ckeditor.js"></script>
        <script src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </head>
    <body>   
        <div class="container">
        <form method="post">
        <div>            
            <textarea id="editor1" name="editor1">&lt;p&gt;Initial value.&lt;/p&gt;</textarea>
            <script type="text/javascript">
                CKEDITOR.replace( 'editor1' );
            </script>
            <input type="submit" value="提交"/>
        </div>            
        </form>
        </div>
    </body>
</html>
