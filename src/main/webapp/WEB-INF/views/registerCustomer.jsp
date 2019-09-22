<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container-wrapper">
    
    <div class="container">
   
  

	   <div class="page-header title">
	              <h1>Регистрация</h1>
	              
	              <p class="lead">Заполните поля для создания аккаунта</p>
	    </div>
	    
	    
	   
	     
		<div class="form-layout" >
		  
		  
		 
	       <form:form   action="${pageContext.request.contextPath}/register?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data"  method="post" commandName="customer"     class="form-horizontal" >
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" ></label>
					<div class="col-xs-9">
						
					   <c:if test="${not empty emailMsg }">
					     <label class="label-danger">${emailMsg}</label>
					   </c:if>
					   
					   
					   <c:if test="${not empty usernameMsg }">
					     <label class="label-danger">${usernameMsg}</label>
					   </c:if>
					   
					   
					   <c:if test="${not empty update }">
					     <input name="update" hidden="true" value="update">
					     <input name="oldUserId" hidden="true" value="${customer.customerId}">
					   </c:if>
					   
					</div>
				</div>
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" ></label>
					<div class="col-xs-9">
						
					   <h1>Основная информация :</h1>
					</div>
				</div>
						
			  
			    <div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="customerName" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
			    
				<div class="form-group has-success">
				
					<label class="col-xs-3 control-label" for="customerName">Имя :</label>
					<div class="col-xs-9">
						
					   <form:input path="customerName" class="form-control" placeholder="Введите полное имя" id="customerName" />
					</div>
					
				</div>
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="customerEmailAddress" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
			    
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="customerEmailAddress">Почтовый адрес :</label>
					<div class="col-xs-9">
						
					   <form:input path="customerEmailAddress" class="form-control" placeholder="Введите ваш почтовый адрес" id="customerEmailAddress" />
					</div>
				</div>
				
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="custometPhoneNumber" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="custometPhoneNumber">Номер телефона:</label>
					<div class="col-xs-9">
						
					   <form:input path="custometPhoneNumber" class="form-control" placeholder="Введите номер телефона" id="custometPhoneNumber" />
					</div>
				</div>
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="username" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="username">Логин:</label>
					<div class="col-xs-9">
						
					   <form:input path="username" class="form-control" placeholder="Введите логин" id="username" />
					</div>
				</div>
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="password" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="password">Пароль:</label>
					<div class="col-xs-9">
						
					   <form:password path="password" class="form-control" placeholder="Введите пароль" id="password" />
					</div>
				</div>
				
				
				
				
				
			
				<div class="form-group has-success">
					<label class="col-xs-3 control-label"></label>
					<div class="col-xs-9">
						 <input type="submit" value="Submit" class="btn btn-default">
             <a href="<c:url value="/" />"  class="btn btn-default">Cancel</a>
					</div>
				</div>
			
			 
			</form:form>
		    
		</div>
    
    </div>

</div>


</body>