<%-- 
    Document   : list
    Created on : Nov 16, 2012, 11:47:36 PM
    Author     : CN085910
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>web resource</title>
        <jsp:include page="/WEB-INF/pages/jsp/common/common-resource.jsp"/>        
        <script>
            $(function(){
                $("#uploadFormDiv").dialog({
                    autoOpen: false,
                    width: 400,
                    modal:true,
                    buttons:{
                        "上传":function() {
                            $("#uploadForm").submit();
                            $(this).dialog("close");
                        },
                        "取消":
                            function() {
                            $(this).dialog("close");
                        }
                    }
                }); 
                
                $("#addResource").click(function (event){
                    $("#uploadFormDiv").dialog("open"); 
                    event.preventDefault();
                });
            });            
        </script>
        <style>
            #uploadFormDiv input[type="file"]{size: 100px;}
        </style>
    </head>
    <body>
        <div>           
            <button class="btn" type="button" id="addResource">新增</button>
            <button class="btn" type="button" id="deleteResource">删除</button>            
        </div>
        <div>
            <table class="table">
                <thead>
                <th>#</th>
                <th>名称</th>
                <th>类型</th>
                <th>大小</th>
                <th>上传时间</th>
                </thead>
                <c:if test="${webResourceList != null}">
                </c:if>
            </table>    
        </div>        
        <div id="uploadFormDiv" style="display: none" title="上传资源">
            <form id="uploadForm" method="POST" action="${ctx}/webresource/uploadResource" enctype="multipart/form-data">
                <fieldset>
                    <label for="filePath">上传资源本地路径：</label>
                    <input type="file" id="uploadFilePath" name="uploadFilePath" size="30"/>  
                    <label for="filePath">资源名：</label>
                    <input type="text" id="fileName" name="fileName" size="30"/>  
                </fieldset>
            </form>
        </div>
    </div>
</body>
</html>
