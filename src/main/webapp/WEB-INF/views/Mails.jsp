<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <sec:authorize access="hasRole('ROLE_ADMIN')">

<c:url var="firstUrl" value="/mail/showMails/1" />
<c:url var="lastUrl" value="/mail/showMails/${totalPages}" />
<c:url var="prevUrl" value="/mail/showMails/${currentPageNumber - 1}" />
<c:url var="nextUrl" value="/mail/showMails/${currentPageNumber + 1}" />

<section class="productsection">
 
       <div class="container">

        <c:forEach var="mail" items="${mails}">
         
        
            <div class="row message">
                
               
		              <p class="info"> ${mail.mailPerson}</p>
		               <br/>
		              
		                 <div class="row" style=" margin-bottom: 20px; margin-left: -3px;color: Crimson ;">
		                   
		                   
		                <br/>
		                <div class="col-md-6">
		                   Дата : ${mail.date}
		                
		               </div></div>
		                                                                                     
            </div>                                                                    
          </c:forEach>    
          
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
	            <c:url var="pageUrl" value="/mail/showMails/ ${i}" />
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
   
   
   
</section>	         

</sec:authorize>

 </body>
</html>