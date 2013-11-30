<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            
            function submitForm() {
                $("#list").submit();
            }
        </script>
        <style>
            #uploadFormDiv input[type="file"]{size: 100px;}
        </style>
    </head>
    <body>
        <div>           
            <button class="btn" type="button" id="addResource">新增</button>
            <button class="btn" type="button" id="deleteResource" onclick="submitForm();">删除</button>            
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
                    <form id="list" action="${ctx}/webresource/delete" method="POST">
                    <c:forEach items="${webResourceList}" var="webResource" varStatus="status">
                    <tr>
                        <td><input type="checkbox" name="idSelected" value="${webResource.id}"/>${status.count}</td>
                        <td>${webResource.name}</td>
                        <td>${webResource.type}</td>
                        <td>${webResource.resourceSize}</td>
                        <td>${webResource.uploadTimestamp}</td>
                    </tr>        
                    </c:forEach>
                    </form>
                </c:if>
            </table>    
        </div>        
        <div id="uploadFormDiv" style="display: none" title="上传资源">
            <form id="uploadForm" method="POST" action="${ctx}/webresource/create" enctype="multipart/form-data">
                <fieldset>
                    <label for="filePath">上传资源本地路径：</label>
                    <input type="file" id="uploadFilePath" name="uploadFilePath" size="30"/>  
                    <label for="filePath">备注：</label>
                    <input type="text" id="remark" name="remark" size="30"/>  
                </fieldset>
            </form>
        </div>
    </div>
</body>
</html>
