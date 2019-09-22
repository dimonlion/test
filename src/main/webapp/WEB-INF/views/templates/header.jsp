<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
       <%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
       <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

       <meta   name="viewport" content="width=device-width, initial-scale=1 ,  charset=UTF-8">
         <link rel="icon" href="<c:url value="/resources/images/brand.jpg"/>">
   
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
   
    <!-- normalize css -->
    <link href="<c:url value="/resources/css/normalize.css"/>" rel="stylesheet">
    
     <!-- Angular.JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    
     <!-- main css -->
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
     <link href="<c:url value="/resources/css/mycss.css"/>" rel="stylesheet">
    
    <link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/dropdown.css"/>" rel="stylesheet">
     <link href="<c:url value="/resources/css/forimage.css"/>" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="styles.css">
 
<title>Магазин одежды</title>

<style type="text/css">
 footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
    
    * {
    box-sizing: border-box;
}



/* Center website */
.main {
    max-width: 1000px;
    margin: auto;
}



.row {
    margin: 10px -16px;
}

/* Add padding BETWEEN each column */
.row,
.row > .column {
    padding: 8px;
}

/* Create three equal columns that floats next to each other */
.column {
    float: left;
    width: 33.33%;
    display: none; /* Hide all elements by default */
}

/* Clear floats after rows */ 
.row:after {
    content: "";
    display: table;
    clear: both;
}

/* Content */
.content {
    background-color: white;
    padding: 10px;
}

/* The "show" class is added to the filtered elements */
.show {
  display: block;
}

/* Style the buttons */





    
</style>

</head>
<body>
<nav class="navbarMy navbar-inverse navbar-fixed-top" >
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar" >
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">
       <img  src="<c:url value="/resources/images/brand.jpg"/>" alt="Generic placeholder image" 
       width="20" height="20">
      </a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
     
    <ul class="nav navbar-nav">
        <li > <a style="color: white;" class="btn" href="<c:url value="/"/>">Главная</a></li>
       <li><div style="color: white" class="dropdown">
  <a href="<c:url  value="/product/allproducts/1"/>" >
    <button class="dropbtn"> Каталог</button>
    </a>
    <div class="dropdown-content">
      <c:forEach var="category" items="${categories}">
      <a href="<c:url  value="/product/findByCategory/${category.categoryName}/1"/>">${category.categoryName}</a>
     </c:forEach>
    </div>
  </div> </li>
       
      
       
      </ul>
      
       
     
       <ul class="nav navbar-nav pull-right">
					 <!-- <li><a href="?lang=en">English</a></li> 
					     <li><a href="?lang=bn">Bangla</a></li> -->
					   <c:if test="${pageContext.request.userPrincipal.name!=null}">
					      
					     <li> <a>Добро пожаловать:${pageContext.request.userPrincipal.name} </a>  </li>
					     
					     <c:if test="${pageContext.request.userPrincipal.name!='admin'}">
					     
					       
					     
					     </c:if>
					     <li> <a style="color: white;" class="btn" href="<c:url value="/logout" />" >Выйти</a> </li>
					     
					      
					     
					      
					      <c:if test="${pageContext.request.userPrincipal.name =='admin'}">
					          <li> <a style="color: white;" class="btn" href="<c:url value="/admin"/>">Администратор</a>  </li>
					      </c:if>
					      
					   </c:if>
					   
					    <c:if test="${pageContext.request.userPrincipal.name == null}">
					          
					           <li> <a style="color: white;" class="btn" href="<c:url  value="/login"/>">Войти</a>   </li>
					           <li> <a style="color: white;" class="btn" href="<c:url  value="/register"/>">Зарегистрироваться</a>   </li>
					      </c:if>
					   
		 <li> <a style="color: white;" class="btn" href="${pageContext.request.contextPath}/shoppingCart">
		 <span class="glyphicon glyphicon-shopping-cart"></span> Моя корзина<span class="badge">${cartSize}</span>
		 </a>   </li>			    
					</ul>
    </div>
  </div>
  
</nav>
 <div class="container-wrapper">
<div class="page-header title">
	              <h1   align = "center" style = "color:DeepPink">${title}</h1>
	             
	    </div>
</div>


