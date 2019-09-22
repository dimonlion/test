<%@ include file="/WEB-INF/views/templates/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-wrapper">


	<div class="page-header"><h1 align="center">Оставьте ваши персональные данные</h1></div>

	<c:url var="addActions"
		value="/shoppingCartCustomer?${_csrf.parameterName}=${_csrf.token}"></c:url>

	<form:form action="${addActions}" method="post"
		modelAttribute="customerForm" class="form-horizontal">

		<div class="form-group has-success">

			<label class="col-xs-3 control-label" for="name">Имя :</label>
			<div class="col-xs-6">
				<form:input path="name" />
				<form:errors path="name" class="error-message" />
			</div>
		</div>

		<div class="form-group has-success">

			<label class="col-xs-3 control-label" for="productName">email</label>
			<div class="col-xs-6">
				<form:input path="email" />
				<form:errors path="email" class="error-message" />
			</div>
		</div>

		<div class="form-group has-success">

			<label class="col-xs-3 control-label" for="phone">номер телефона</label>
			<div class="col-xs-6">
			<form:input path="phone" />
			<form:errors path="phone" class="error-message" />
		</div></div>

			<div class="form-group has-success">

			<label class="col-xs-3 control-label" for="phone">Адрес</label>
			<div class="col-xs-6">
			<form:input path="address" />
			<form:errors path="address" class="error-message" />
		</div></div>

		<div class="col-xs-3 control-label ">
<button type="submit" class="btn btn-success btn-lg">Далее</button>
</div>
		

	</form:form>



</div>

</body>
</html>