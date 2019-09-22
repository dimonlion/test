<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <sec:authorize access="hasRole('ROLE_ADMIN')">
    
<c:url var = "addActions" value = "/admin/addProduct?${_csrf.parameterName}=${_csrf.token}"></c:url>
<form:form class="form-horizontal" action = "${addActions}" commandName="product" method="post" enctype="multipart/form-data">


<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="productCategory">Категория :</label>
			<div class="col-xs-9">
						
					  
				     <form:select path="productCategory" style = "color:black" >
				     <div class="styled-select blue semi-square">
					   <form:option value="Поле не выбрано" label="--- Выбрать ---" class="styled-select blue semi-square"/>
					   <form:options items="${categories2}" class="styled-select blue semi-square"/>
					   </div>
					</form:select>
					  </div>
					     	</div>

<div class="form-group has-success">
				
					<label class="col-xs-3 control-label" for="productName">Название :</label>
<div class="col-xs-6">					
<form:input path="productName"   id="productName" class="form-control"/>
</div></div>

<div class="form-group has-success">
				
					<label class="col-xs-3 control-label" for="productMaterial">Материал :</label>
<div class="col-xs-6">					
<form:input path="productMaterial"   id="productMaterial" class="form-control"/>
</div></div>


<div class="form-group has-success">
				
					<label class="col-xs-3 control-label" for="productSize">Размер изделия :</label>
<div class="col-xs-6">					
<form:input path="productSize"   id="productSize" class="form-control"/>
</div></div>

<div class="form-group has-success">
				
					<label class="col-xs-3 control-label" for="productParameters">Параметры изделия :</label>
<div class="col-xs-6">					
<form:input path="productParameters"   id="productParameters" class="form-control"/>
</div></div>

<div class="form-group has-success">
				
					<label class="col-xs-3 control-label" for="productPrice">Цена :</label>
<div class="col-xs-6">					
<form:input path="productPrice"   id="productPrice" class="form-control"/>
</div></div>

<div class="form-group has-success">
<label class="col-xs-3 control-label" for="productDescription">Описание :</label>
<div class="col-xs-6">					
<form:input path="productDescription"   id="productDescription" class="form-control"/>
</div></div>

	

<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="productPhoto">Загрузить :</label>
					
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