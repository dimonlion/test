<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  
    <div class="container">
    
 <!-- Carousel
    ================================================== -->
   
    <div id="myCarousel" class="carousel slide" data-ride="carousel" style="height: 600px ;">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        
       
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active" style="height: 600px; width: auto;margin: auto;">
        
          <img class="first-slide" style="height: 600px; width: auto;margin: auto;" src="<c:url value="/resources/images/wall11.jpg"/>" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
             </div>
          </div>
        </div> 
        <div class="item "  style="height: 600px; width: auto;margin: auto;" >
          <img class="second-slide"  style="height: 600px; width: auto;margin: auto;" src="<c:url value="/resources/images/wall2.jpg"/>" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              </div>
          </div>
        </div>
        
         <div class="item" style="height: 600px; width: auto;margin: auto;">
          <img class="third-slide"  style="height: 600px; width: auto;margin: auto; " src="<c:url value="/resources/images/wall3.jpg"/>" alt="Fourth slide">
          <div class="container">
            <div class="carousel-caption">
            </div>
          </div>
        </div>
      </div>
       
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->
   
  
  <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
      <c:forEach var="category" items="${categories}">
        <div class="col-lg-3">
         
         <div class="product-single">
                <div class=" text-center productColumn"  style="height: 330px">
                 <div class=" img-responsive productImage">
         <img  style="width:240px ; height: 320px"  alt="image" src="data:image/jpeg;base64,${category.categoryPhotoString}" />
                    
                 </div>
                 
             </div>
             
             
             <div class="product-desc">
                <h3>${category.categoryName}</h3>
          
          <p><a class="btn btn-success btn-lg" href="<c:url  value="/product/findByCategory/${category.categoryName}/1"/>" role="button">Посмотреть</a></p>
             </div>
             </div>
        </div>
        </c:forEach>
        </div></div>
  
   
<h1 class="title-block" align="center" style="margin-bottom: 50px"><em>Молодежная женская одежда оптом</em></h1>
<p><img alt="Женская одежда оптом от производителя" src="<c:url value="/resources/images/photo-main.jpg"/>" style="margin-right: 30px; margin-bottom:30px; margin-top:4px; float: left; width: 360px; " />
Мы &ndash; молодая компания, которая выходит на украинский рынок с креативными идеями и лучшими ценовыми предложениями.
 Наши коллекции соответствуют самым актуальным трендам.
  Они обязательно понравятся молодым и прогрессивным клиенткам.
   Если вы желаете покупать женскую брендовую одежду по самой выгодной стоимости,
    воспользуйтесь услугами интернет магазина &laquo;Аржен&raquo;.</p>
    <p>Главный офис и производственные мощности нашей компании расположены в городе Хмельницкий.
     Мы активно работаем над созданием сети брендовых магазинов &laquo;Аржен&raquo;. 
     Но вам вовсе не обязательно ждать открытия магазина торговой марки в своем городе. 
     Все те, кого интересует возможность приобрести продукцию украинского производителя молодежной 
     женской одежды, получают возможность осуществить покупки на официальном&nbsp;сайте.</p>

<p>Мы приглашаем к сотрудничеству предпринимателей, которые специализируются на торговле женской одеждой. Вы получите максимально выгодные условия для оптовых закупок и сможете предложить своим покупательницам самые стильные и элегантные новинки, соответствующие актуальным модным трендам.</p>
    

   </div>
  
 
<%@ include file="/WEB-INF/views/templates/footer.jsp" %>