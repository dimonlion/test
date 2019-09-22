<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<sec:authorize access="hasRole('ROLE_ADMIN')">


<c:forEach var="photo" items="${photos}">
 <div class="col-md-4">
             
                    <img id="myimage" src = "data:image/jpeg;base64,${photo.photoDataString}"  alt="image" style="width: 100%" />
             
</div>
</c:forEach>

</sec:authorize>
</body>
</html>