<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <sec:authorize access="hasRole('ROLE_ADMIN')">
 
  <c:url var="firstUrl" value="/product/allproducts/1" />
<c:url var="lastUrl" value="/product/allproducts/${totalPages}" />
<c:url var="prevUrl" value="/product/allproducts/${currentPageNumber - 1}" />
<c:url var="nextUrl" value="/product/allproducts/${currentPageNumber + 1}" />
 
    <fmt:setLocale value="en_US" scope="session"/>
 <div class="container">   
    <div class="page-header"><h2 align="center">Список заказов</h2></div>
 
    
    
    <table class="table table-striped table-hover table-bordered">
        <tr>
            <th>Номер заказа</th>
            <th>Дата заказа</th>
            <th>Имя</th>
            <th>Адрес</th>
            <th>Email</th>
            <th>Сумма</th>
            <th>Детали заказа</th>
        </tr>
        <c:forEach items="${orders}" var="orderInfo">
            <tr>
                <td>${orderInfo.orderNum}</td>
                <td>
                   <fmt:formatDate value="${orderInfo.orderDate}" pattern="dd-MM-yyyy HH:mm"/>
                </td>
                <td>${orderInfo.customerName}</td>
                <td>${orderInfo.customerAddress}</td>
                <td>${orderInfo.customerEmail}</td>
                <td style="color:red;">
                   <fmt:formatNumber value="${orderInfo.amount}" type="currency"/>
                </td>
                <td><a href="${pageContext.request.contextPath}/admin/order/${orderInfo.orderNum}/${orderInfo.id}">
                   Просмотр</a></td>
            </tr>
        </c:forEach>
    </table>
   <div class="Page navigation text-center">
	    <ul class="pagination">
 <c:choose>
	            <c:when test="${currentPageNumber == 1}">
	                <li class="disabled"><a href="#">&lt;&lt;</a></li>
	                <li class="disabled"><a href="#">&lt;</a></li>
	            
	            
	            
	            </c:when>
	            <c:otherwise>
	                <li><a href="${firstUrl}">&lt;&lt;</a></li>
	                <li><a href="${prevUrl}">&lt;</a></li>
	            </c:otherwise>
	        </c:choose>
	        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
	            <c:url var="pageUrl" value="/product/allproducts/ ${i}" />
	            <c:choose>
	                <c:when test="${i == currentPageNumber}">
	                    <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
	                </c:when>
	                <c:otherwise>
	                    <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
	                </c:otherwise>
	            </c:choose>
	        </c:forEach>
	        <c:choose>
	            <c:when test="${currentPageNumber == totalPages}">
	                <li class="disabled"><a href="#">&gt;</a></li>
	                <li class="disabled"><a href="#">&gt;&gt;</a></li>
	            </c:when>
	            <c:otherwise>
	                <li><a href="${nextUrl}">&gt;</a></li>
	                <li><a href="${lastUrl}">&gt;&gt;</a></li>
	            </c:otherwise>
	        </c:choose>
	        </ul></div>
 
 
 
 </div>
   
 </sec:authorize>
</body>
</html>