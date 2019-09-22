<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:url var="firstUrl" value="/product/allproducts/1" />
<c:url var="lastUrl" value="/product/allproducts/${totalPages}" />
<c:url var="prevUrl" value="/product/allproducts/${currentPageNumber - 1}" />
<c:url var="nextUrl" value="/product/allproducts/${currentPageNumber + 1}" />

<div class="container">


<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h3 style = "color :white; background-color: DarkBlue ;text-align: center">К А Т Е Г О Р И И</h3>
      <ul class="nav nav-pills nav-stacked">
       
        <c:forEach var="resCat" items="${categories}">
        <li class="active" style="text-align: center"><a href = "<c:url value = "/product/findByCategory/${resCat.categoryName}/1"/>">${resCat.categoryName}</a></li>
        </c:forEach>
    
      </ul>
    </div>
    
   <c:if test="${category == null}">
<h5 style="margin-bottom: 30px">

<a style="margin-left: 40px " href="<c:url value = "/product/findByPrice/up/1"/>">ПО ВОЗРАСТАНИЮ ЦЕН</a>
 <a style="margin-left: 40px " href="<c:url value = "/product/findByPrice/down/1"/>">ПО УБЫВАНИЮ ЦЕН</a>
 </h5>
</c:if>
<c:if test="${category != null}">
<h5 style="margin-bottom: 30px">

<a style="margin-left: 40px " href="<c:url value = "/product/findByCategoryPrice/up/${category}/1"/>">ПО ВОЗРАСТАНИЮ ЦЕН</a>
 <a style="margin-left: 40px " href="<c:url value = "/product/findByCategoryPrice/down/${category}/1"/>">ПО УБЫВАНИЮ ЦЕН</a>
 </h5>
</c:if>

 <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
 <c:forEach var="productRes" items="${products}">
        
         <div class="col-lg-3">
         
         <div class="product-single">
                <div class=" text-center productColumn"  style="height: 330px">
                 <div class=" img-responsive productImage">
                 
            <a href="<c:url  value="/product/showProductDetails/${productRes.productId}"/>">
            <img title="ПРОСМОТРЕТЬ" src="data:image/jpeg;base64,${productRes.productPhotoString}" style="width:240px ; height: 320px"  alt="image">
            </a> 
            
             </div></div>
             
              <div class=" product-desc" >
             <h4>${productRes.productName}</h4>
                <h3>${productRes.productPrice} грн</h3>
               </div>
                     
          </div></div>
                    
                
          </c:forEach> </div></div>       
</div>
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
	        </ul></div></div></div>
<%@ include file="/WEB-INF/views/templates/footer.jsp" %>