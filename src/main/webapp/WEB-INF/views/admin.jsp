<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <sec:authorize access="hasRole('ROLE_ADMIN')">
 <div class="container-wrapper">

		<div class="container">

           <div class="page-header">
              <h1>Страница Администратора</h1>
              
              <p class="lead">Привет Админ!</p>
           </div>
         
         <c:if test="${pageContext.request.userPrincipal.name!=null}">
           Добро пожаловать:${pageContext.request.userPrincipal.name} | <a href="<c:url value="/logout"/>">Logout</a>
         </c:if>
         <h1>
<a href = "<c:url value = "/admin/showOrders/1"/>">Просмотреть заказы</a>
</h1>
 <h3> <p>Здесь можно просматривать заказы</p> </h3>        
          <h1>
<a href = "<c:url value = "/admin/allproducts/1"/>">Управление товарами</a>
</h1>
 <h3> <p>Здесь можно просматривать и редактировать товарные позиции</p> </h3>
 <h1>
<a href = "<c:url value = "/admin/allcategories/1"/>">Управление категориями</a>
</h1>
 <h3> <p>Здесь можно просматривать и редактировать категории</p> </h3>
 <h1>
<a href = "<c:url value = "/mail/showMails/1"/>">Управление email</a>
</h1>
 <h3> <p>email для рассылки</p> </h3>
</div></div>

</sec:authorize>

 </body>