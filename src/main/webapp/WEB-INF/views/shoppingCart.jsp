<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <div class="container">
    
    <fmt:setLocale value="en_US" scope="session"/>
 <div style="margin-bottom: 100px">
   <h1 align="center"> <div class="page-title">Моя корзина</div></h1>
 </div>
    <c:if test="${empty cartForm or empty cartForm.cartLines}">
        <h2>Нет товаров в корзине.</h2>
        <a href="<c:url value="/product/allproducts/1"/>">перейти в каталог</a>
    </c:if>
 

 
  <c:if test="${not empty cartForm and not empty cartForm.cartLines   }">
        <form:form method="POST" modelAttribute="cartForm"
            action="${pageContext.request.contextPath}/shoppingCart">
 
 <table class="table table-striped table-hover table-bordered">
<tr class="info">
<th rowspan="1">Код товара</th>
<th rowspan="1">Название</th>
<th rowspan="1">Цена за единицу</th>
<th rowspan="1">Колличество</th>

<th rowspan="1">Сумма</th>
<th colspan="1">Удалить из корзины</th>
 

 <c:forEach items="${cartForm.cartLines}" var="cartLineInfo"
                varStatus="varStatus">
<tr>
 
<td class="success">${cartLineInfo.productInfo.code} <form:hidden
                                path="cartLines[${varStatus.index}].productInfo.code" /></td>
 
 <td class="success">${cartLineInfo.productInfo.name}</td>
<td class="danger"> <fmt:formatNumber value="${cartLineInfo.productInfo.price}" type="currency"/></td>
<td class="success"><form:input path="cartLines[${varStatus.index}].quantity" /> 
</br>
 <input class="button-update-sc" type="submit" value="подтвердить" /> 
 </td>
<td class="success"><span class="subtotal">
                          
                             <fmt:formatNumber value="${cartLineInfo.amount}" type="currency"/>
                        
                          </span></td>

		              <td class="info">
		              <a style = "color:red" href=" <c:url value="/shoppingCartRemoveProduct?code=${cartLineInfo.productInfo.code}"/>"><span class="glyphicon glyphicon-remove"></span></a>
		              </td>
		              
</tr></c:forEach>
</table>
<a href = "<c:url value = "/product/allproducts/1"/>"  class="btn btn-primary">Продолжить покупки</a>
<a href = "<c:url value = "/shoppingCartCustomer"/>"  class="btn btn-primary">Оформить заказ</a>

    </form:form></c:if>
 </div>
</body>
</html>