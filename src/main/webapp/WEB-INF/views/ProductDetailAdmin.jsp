<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<sec:authorize access="hasRole('ROLE_ADMIN')">

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Детальная информация</h1>
</div>

            <div class="container">
            <div class="row">
                <div class="col-md-5 image">
                    <img src = "data:image/jpeg;base64,${product.productPhotoString}"  alt="image" style="width:100%" />
                </div>
                <div class="col-md-5 product-details" style = " background: #FFA07A">
                  
                  <p ><strong class="desc-title col-md-4" >Название </strong>: ${product.productName}</p>
                    <p ><strong class="desc-title col-md-4" >Категория </strong>: ${product.productCategory}</p>
                    <p> <strong class="desc-title col-md-4">Материал </strong>: ${product.productMaterial}</p>
                    <p><strong class="desc-title col-md-4">Размер</strong>: ${product.productSize}</p>
                    <p><strong class="desc-title col-md-4">Параметры</strong>: ${product.productParameters}</p>
                    <p><strong class="desc-title col-md-4">Цена</strong>: ${product.productPrice}</p>
                    <p><strong class="desc-title col-md-4">Описание</strong>: ${product.productDescription}</p>
                   
                    <br/>


                </div>
            </div>
        </div>
<div class="page-header">
            <h1>Таблица цветов товара</h1>
</div>
<table class="table table-striped table-hover table-bordered">
<tr class="info">
<th rowspan="2">Фото</th>
<th rowspan="2">Название</th>
<th rowspan="2">Добавить фото</th>
<th rowspan="2">Просмотреть фото</th>

 <tr class="bg-success">
                 <th>Инфо</th>
                 <th>Удалить</th>
                 <th>Редактировать</th>
                 </tr>
</tr>
<c:forEach var="colorRes" items="${coloursList}">
<tr>
 <td><a  href="<c:url value="/"/>">
 <img  style="width:150px ; height: 120px"  alt="image" src="data:image/jpeg;base64,${colorRes.colourMainPhotoString}" />
 </a>
 </td>

<td class="success">${colorRes.colourName}</td>
<td class="success"><a style = "color:blue"  href = "<c:url value = "/admin/addphototocolor/${colorRes.colourId}"/>">Добавить</a></td>
<td class="success"><a style = "color:blue"  href = "<c:url value = "/admin/colorsphotos/${colorRes.colourId}"/>">Просмотреть</a></td>
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


</div></div>
</sec:authorize>
</body>
</html>