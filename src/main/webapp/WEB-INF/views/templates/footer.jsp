<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
  <c:url var = "addActions" value = "/mail/sendMail"></c:url> 

<footer class="container-fluid text-center">
  <p>Оставьте вашу почту для рассылки новостей</p>  
  <form:form action="${addActions}" class="form-inline"  commandName="mail"   method = "post">
      <form:input path="mailPerson" class="form-control" placeholder="email для рассылки" size="50"   id="mailPerson" />
    <button type="submit" class="btn btn-danger">отправить</button>
</form:form>
</footer>

<section class="address">
           
           <div class="col-md-2">
                     
                      
                  </div>
           
             <diV class="container">
                
                <div class="row">
                  
                 
                   
                   <div class="col-md-8">
                       <div class="showroom" >
                             <div class="row">
                                    <div class="col-md-5 contact1" >
                                      <p class="contactNum" ><i class="fa fa-phone " style="font-size:40px;color:blue"></i><span  style="color:black">38-098-392-93-34</span></p>
                                       <p class="contactNum2"><i class="fa fa-envelope-o " style="font-size:30px;color:blue"></i>
                                       <span style="color:black">dmitryjava88@gmail.com</span></p>
                                       
                                    </div>

 
                                  
                              </div>
                       </div>
                    
                   </div>
                   
                   
                   
                  
                </div>
                
             </diV>
           
        </section>
        
        
        <footer class="foootersection text-center">
           
           <p>&copy; Copyright Online Shop 2018</p>
        </footer>

    </div>
 <script>
		window.jQuery
				|| document
						.write('<script src="<c:url value="/resources/js/jquery-1.12.4.min.js"/>"><\/script>')
	</script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>