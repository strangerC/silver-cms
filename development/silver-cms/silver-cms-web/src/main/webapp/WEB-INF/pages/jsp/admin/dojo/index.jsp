<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>        
        <link rel="stylesheet" href="http://${dojoPath}/dojo/1.9.0/dijit/themes/claro/document.css" />
        <link rel="stylesheet" href="http://${dojoPath}/dojo/1.9.0/dijit/themes/claro/claro.css" />
              
        <script type="text/javascript" src="http://${dojoPath}/dojo/1.9.0/dojo/dojo.js.uncompressed.js"></script>
        <script>
			dojo.addOnLoad(function() {
			    dojo.create(
			        "div",
			        {
			            "innerHTML": "Hello, World!"
			        },
			        dojo.body()
			    );
			});
			</script>
    </head>
    <body class="claro">     
    	<script>
            dojo.require("dijit.layout.BorderContainer");
            dojo.require("dijit.layout.ContentPane");
            dojo.require("dijit._Calendar");
        </script>
        <div dojoType="dijit._Calendar"></div>
    	<div style="width: 535px; height: 290px">
    <div dojoType="dijit.layout.BorderContainer" style="width: 100%; 
height: 100%;">
        <div dojoType="dijit.layout.ContentPane" region="top" splitter="true">
            This is the content in the top section.
        </div>
        <div dojoType="dijit.layout.ContentPane" region="left" style="width: 100px;" 
splitter="true">
            This is the content in the left section.
        </div>
        <div dojoType="dijit.layout.ContentPane" region="center" splitter="true">
            This is the content in the center section.
        </div>
        <div dojoType="dijit.layout.ContentPane" region="right" style="width: 100px;" 
splitter="true">
            This is the content in the right section.
        </div>
        <div dojoType="dijit.layout.ContentPane" region="bottom" splitter="true">
             This is the content in the bottom section.
         </div>
     </div>
</div>   
    </body>
</html>
