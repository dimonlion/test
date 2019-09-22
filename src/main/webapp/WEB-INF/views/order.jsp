<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <sec:authorize access="hasRole('ROLE_ADMIN')">
 
<div class="container">
 
  
     
    <fmt:setLocale value="en_US" scope="session"/>
 
  
 
    <div class="customer-info-container">
        <h3>Информация о заказчике:</h3>
        <ul>
            <li>Имя: ${order.customerName}</li>
            <li>Email: ${order.customerEmail}</li>
            <li>Телефон: ${order.customerPhone}</li>
            <li>Адрес: ${order.customerAddress}</li>
        </ul>
        <h3>Сумма:</h3>
        <ul>
            <li>Всего:
            <span class="total">
            <fmt:formatNumber value="${order.amount}" type="currency"/>
            </span></li>
        </ul>
    </div>
     
    <br/>
     
    <table class="table table-striped table-hover table-bordered">
        <tr class="success">
            <th>Код товара</th>
           
            <th>Колличество</th>
            <th>Цена за единицу</th>
            <th>Сумма</th>
        </tr>
        <c:forEach items="${listProducts}" var="orderDetailInfo">
            <tr class="info">
                <td>${orderDetailInfo.productCode}</td>
              
                <td>${orderDetailInfo.quanity}</td>
                <td>
                 <fmt:formatNumber value="${orderDetailInfo.price}" type="currency"/>
                </td>
                <td>
                 <fmt:formatNumber value="${orderDetailInfo.amount}" type="currency"/>
                </td>  
            </tr>
        </c:forEach>
    </table>
   
</div> 
</sec:authorize>
 

</body>
</html>