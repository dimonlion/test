<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <sec:authorize access="hasRole('ROLE_ADMIN')">

<c:url var = "addActions" value = "/admin/addCategory?${_csrf.parameterName}=${_csrf.token}"></c:url>


<form:form class="form-horizontal" action = "${addActions}" commandName="category" method="post" enctype="multipart/form-data">




<div class="form-group has-success">
<label class="col-xs-3 control-label" for="categoryName">Название категории :</label>
<div class="col-xs-6">					
<form:input path="categoryName"   id="categoryName" class="form-control"/>
</div></div>

<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="productPhoto">Download :</label>
					
					<div class="col-xs-9">
				<input type="file" name="fileUpload" size="50" >
				</div></div>

<div class="col-xs-3 control-label ">
<button type="submit" class="btn btn-success btn-lg">Сохранить</button>
</div>
</form:form>

</sec:authorize>
</body>
</html>