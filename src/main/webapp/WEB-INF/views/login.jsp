<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container-wrapper">
    
    <div class="container">
   
  

	   <div class="page-header title">
	              <h1>Страница авторизации</h1>
	              
	              <p class="lead">Введите Ваш логин и пароль</p>
	    </div>
	    
	    
	   
	     
		<div class="form-layout">
	       <form name="loginForm"  action="<c:url value="/j_spring_security_check" />"   method="post"  class="form-horizontal"  >
						
				 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" ></label>
					<div class="col-xs-9">
                           <c:if test="${not empty error}">
                
				                  <div class="error" style="color:#ff0000">
				                    ${error}
				                  </div>
			                </c:if>					
					</div>
				</div>		
			  
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" ></label>
					<div class="col-xs-9">
                           <c:if test="${not empty msg}">
                               <div class="msg">${msg}</div>
                            </c:if>						
					</div>
				</div>
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="username">Логин :</label>
					<div class="col-xs-9">
						
					   
					   <input type="text" class="form-control" placeholder="Введите Логин" name="username" id="username"/>
					</div>
				</div>
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="password">Пароль :</label>
					<div class="col-xs-9">
						
					   
					   <input type="password" class="form-control"  name="password" placeholder="Введите Пароль" id="password"/>
					</div>
				</div>
				
	            
	            
	      
	           		   
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label"></label>
					<div class="col-xs-9">
						 <input type="submit" value="Войти" class="btn btn-default">
                        
					</div>
				</div>
			
			 
			</form>
		</div>
    
    </div>

</div>


</body>
