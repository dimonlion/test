<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <sec:authorize access="hasRole('ROLE_ADMIN')">
    
<c:url var="firstUrl" value="/admin/allcategories/1" />
<c:url var="lastUrl" value="/admin/allcategories/${totalPages}" />
<c:url var="prevUrl" value="/admin/allcategories/${currentPageNumber - 1}" />
<c:url var="nextUrl" value="/admin/allcategories/${currentPageNumber + 1}" />
<div class = "container">
<div style="margin-bottom: 100px">
<a href = "<c:url value = "/admin/formcreatecategory"/>"  class="btn btn-primary">СОЗДАТЬ НОВУЮ КАТЕГОРИЮ</a>
</div>

<table class="table table-striped table-hover table-bordered">
<tr class="info">
<th rowspan="2">Фото</th>
<th rowspan="2">Название категории</th>

<th colspan="3">Операции</th>
 <tr class="bg-success">
                 <th>Инфо</th>
                 <th>Удалить</th>
                 <th>Редактировать</th>
                 </tr>
</tr>
<c:forEach var="category" items="${categories}">
<tr>
 <td><a  href="<c:url value="/"/>">
 <img  style="width:150px ; height: 120px"  alt="image" src="data:image/jpeg;base64,${category.categoryPhotoString}" />
 </a>
 </td>

<td class="success">${category.categoryName}</td>

<td class="info"> 
		              <a style = "color:lime;" href=" <c:url value="/product/viewProduct/${product.productId}"/>"><span class="glyphicon glyphicon-info-sign"></span></a>
		              </td>
		              <td class="info">
		              <a style = "color:red" href=" <c:url value="/admin/product/deleteProduct/${product.productId}"/>"><span class="glyphicon glyphicon-remove"></span></a>
		              </td>
		              <td class="info">
		              <a href=" <c:url value="/admin/product/updateProduct/${product.productId}"/>"><span class="glyphicon glyphicon-pencil"></span></a>
		                
		              </td>
</tr></c:forEach>
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
	            <c:url var="pageUrl" value="/admin/allcategories/ ${i}" />
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