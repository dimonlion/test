<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <sec:authorize access="hasRole('ROLE_ADMIN')">

<c:url var="addActions" value="/admin/addcolour/${productId}?${_csrf.parameterName}=${_csrf.token}" ></c:url>
<form:form action="${addActions}" commandName="colour" class="form-horizontal" method = "post" enctype="multipart/form-data">

					
					
					<div class="form-group has-success">
				
					<label class="col-xs-3 control-label" for="colourName">Название цвета :</label>
					<div class="col-xs-9">
						
					   <form:input path="colourName" class="form-control" placeholder="Добавьте цвет" id="colourName" />
					</div>
					
				</div>
			
			<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="colourMainPhoto">Загрузить :</label>
					
					<div class="col-xs-9">
				<input type="file" name="fileUpload" size="50" >
				</div></div>
			
				<div class="form-group has-success">
					<label class="col-xs-3 control-label"></label>
					<div class="col-xs-9">
						 <input type="submit" value="Добавить" class="btn btn-success">
						 </div>
						 </div>
			

</form:form>

</sec:authorize>
</body>
</html>