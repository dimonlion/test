<%@  include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <sec:authorize access="hasRole('ROLE_ADMIN')">


<table class="table table-striped table-hover table-bordered">
<tr class="info">
<th rowspan="2">Фото</th>
<th rowspan="2">Название</th>

 <tr class="bg-success">
                 <th>Инфо</th>
                 <th>Удалить</th>
                 <th>Редактировать</th>
                 </tr>
</tr>
<c:forEach var="product" items="${products}">
<tr>
 <td><a  href="<c:url value="/"/>">
 <img  style="width:150px ; height: 120px"  alt="image" src="data:image/jpeg;base64,${product.productPhotoString}" />
 </a>
 </td>

<td class="success">${product.productPrice}</td>
<td class="info"> 
		              <a style = "color:lime;" href=" <c:url value="/admin/showProductDetail/${product.productId}"/>"><span class="glyphicon glyphicon-info-sign"></span></a>
		              </td>
		              <td class="info">
		              <a style = "color:red" href=" <c:url value="/admin/product/deleteProduct/${product.productId}"/>"><span class="glyphicon glyphicon-remove"></span></a>
		              </td>
		              <td class="info">
		              <a href=" <c:url value="/admin/product/updateProduct/${product.productId}"/>"><span class="glyphicon glyphicon-pencil"></span></a>
		                
		              </td>
</tr></c:forEach>
</table>

</sec:authorize>
</body>
</html>