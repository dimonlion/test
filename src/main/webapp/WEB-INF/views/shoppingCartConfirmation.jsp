<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container-wrapper">
  
  
 <fmt:setLocale value="en_US" scope="session"/>
 
  <div class="container">
 
 
  
  
  
   <div class="customer-info-container">
       <h3>Ваши данные:</h3>
       <ul>
           <li>Имя: ${myCart.customerInfo.name}</li>
           <li>Email: ${myCart.customerInfo.email}</li>
           <li>Телефон: ${myCart.customerInfo.phone}</li>
           <li>Адрес: ${myCart.customerInfo.address}</li>
       </ul>
        </br> 
        <form method="POST"
       action="${pageContext.request.contextPath}/shoppingCartConfirmation?${_csrf.parameterName}=${_csrf.token}">
        <a 
           href="${pageContext.request.contextPath}/shoppingCartCustomer" class="btn btn-primary">Редактировать ваши данные</a>
           </form>
            </br> 
       <h3>Суммарно:</h3>
       <ul>
           <li>Колличество: ${myCart.quantityTotal}</li>
           <li>Сумма:
           <span class="total">
             <fmt:formatNumber value="${myCart.amountTotal}" type="currency"/>
           </span></li>
       </ul>
   </div>
 
    </br> 
 
   <table class="table table-striped table-hover table-bordered">
        <tr>
            <th>Код товара</th>
            <th>Название</th>
            <th>Цена</th>
            <th>Колличество</th>
           
            <th>Сумма</th>
          
        </tr>
      
        <c:forEach items="${myCart.cartLines}" var="cartLineInfo">
            <tr>
                <td> ${cartLineInfo.productInfo.code} <input
                       type="hidden" name="code" value="${cartLineInfo.productInfo.code}" /></td>
               
                <td>${cartLineInfo.productInfo.name}</td>
                <td><span class="price">
                      <fmt:formatNumber value="${cartLineInfo.productInfo.price}" type="currency"/>
                   </span></td>
                <td>${cartLineInfo.quantity}</td>
                <td style="color:red;">
                  <span class="subtotal">
                        <fmt:formatNumber value="${cartLineInfo.amount}" type="currency"/>
                     </span>
                </td>
               
            </tr>
        </c:forEach>
    </table>
 </br>
   <form method="POST"
       action="${pageContext.request.contextPath}/shoppingCartConfirmation?${_csrf.parameterName}=${_csrf.token}">
 
      
 
 <a href = "<c:url value = "${pageContext.request.contextPath}/shoppingCart"/>"  class="btn btn-primary">Редактировать корзиу</a>
   
       <!-- Send/Save -->
       <input type="submit" value="Заказать" class="btn btn-primary" />
   </form>
 
   </div>
 
   </div>
 
</body>
</html>