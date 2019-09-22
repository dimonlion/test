<%@ include file="/WEB-INF/views/templates/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container-wrapper">
	<div class="container">

<div class="main">

		<div class="row">
			<div class="col-md-4">
				<div class="img-zoom-container">
					<img id="myimage"
						src="data:image/jpeg;base64,${product.productPhotoString}"
						alt="image" style="width: 100%" />
					<div id="myresult" class="img-zoom-result"></div>
				</div>
			</div>

			<div class="page-header">
					<h3 style="text-align: center;">Наличие цветов</h3>
				</div>


<!-- Trigger the modal with a button -->
<c:forEach var="color" items="${colors}">
					<button type="button" class="btn btn-info btn-lg"
						data-toggle="modal" data-target="#myModalphoto${color.colourId}">${color.colourName}</button>

					<!-- Modal -->
					<div class="modal fade" id="myModalphoto${color.colourId}" role="dialog">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h2 align="center" class="modal-title">${color.colourName}</h2>
								</div>
								<div class="modal-body">
<c:forEach var="photos" items="${color.colourPhotos}">

					<div class="column ${color.colourId}">
						<div class="content">
							<img src="data:image/jpeg;base64,${photos.photoDataString}"
								alt="image" style="width: auto; height: 220px; margin: auto;">
						</div>
					</div>
				</c:forEach>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
					<!-- Modal -->
</c:forEach>

<div class="col-md-5 product-details" style="background: #FFA07A">
					<p>
						<strong class="desc-title col-md-4">Название </strong>:
						${product.productName}
					</p>
					<p>
						<strong class="desc-title col-md-4">Категория </strong>:
						${product.productCategory}
					</p>
					<p>
						<strong class="desc-title col-md-4">Материал </strong>:
						${product.productMaterial}
					</p>
					<p>
						<strong class="desc-title col-md-4">Размер</strong>:
						${product.productSize}
					</p>
					<p>
						<strong class="desc-title col-md-4">Параметры</strong>:
						${product.productParameters}
					</p>
					<p>
						<strong class="desc-title col-md-4">Цена</strong>:
						${product.productPrice}
					</p>

					<!-- Trigger the modal with a button -->
					<button type="button" class="btn btn-info btn-lg"
						data-toggle="modal" data-target="#myModal">Просмотреть
						характеристики</button>

					<!-- Modal -->
					<div class="modal fade" id="myModal" role="dialog">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">${product.productName}</h4>
								</div>
								<div class="modal-body">

									<h4>${product.productDescription}</h4>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
					<!-- Modal -->


					<a
						href="${pageContext.request.contextPath}/buyProduct?code=${product.productId}"
						class="btn btn-warning btn-large"><span
						class="glyphicon glyphicon-shopping-cart"></span> Заказать</a>

				</div>
			

		

	

</div>
			
				




</div>

</div>

		


<script>
	filterSelection("all")
	function filterSelection(c) {
		var x, i;
		x = document.getElementsByClassName("column");
		if (c == "all")
			c = "";
		for (i = 0; i < x.length; i++) {
			w3RemoveClass(x[i], "show");
			if (x[i].className.indexOf(c) > -1)
				w3AddClass(x[i], "show");
		}
	}

	function w3AddClass(element, name) {
		var i, arr1, arr2;
		arr1 = element.className.split(" ");
		arr2 = name.split(" ");
		for (i = 0; i < arr2.length; i++) {
			if (arr1.indexOf(arr2[i]) == -1) {
				element.className += " " + arr2[i];
			}
		}
	}

	function w3RemoveClass(element, name) {
		var i, arr1, arr2;
		arr1 = element.className.split(" ");
		arr2 = name.split(" ");
		for (i = 0; i < arr2.length; i++) {
			while (arr1.indexOf(arr2[i]) > -1) {
				arr1.splice(arr1.indexOf(arr2[i]), 1);
			}
		}
		element.className = arr1.join(" ");
	}

	// Add active class to the current button (highlight it)
	var btnContainer = document.getElementById("myBtnContainer");
	var btns = btnContainer.getElementsByClassName("btn");
	for (var i = 0; i < btns.length; i++) {
		btns[i].addEventListener("click", function() {
			var current = document.getElementsByClassName("active");
			current[0].className = current[0].className.replace(" active", "");
			this.className += " active";
		});
	}

	function imageZoom(imgID, resultID) {
		var img, lens, result, cx, cy;
		img = document.getElementById(imgID);
		result = document.getElementById(resultID);
		/*create lens:*/
		lens = document.createElement("DIV");
		lens.setAttribute("class", "img-zoom-lens");
		/*insert lens:*/
		img.parentElement.insertBefore(lens, img);
		/*calculate the ratio between result DIV and lens:*/
		cx = result.offsetWidth / lens.offsetWidth;
		cy = result.offsetHeight / lens.offsetHeight;
		/*set background properties for the result DIV:*/
		result.style.backgroundImage = "url('" + img.src + "')";
		result.style.backgroundSize = (img.width * cx) + "px "
				+ (img.height * cy) + "px";
		/*execute a function when someone moves the cursor over the image, or the lens:*/
		lens.addEventListener("mousemove", moveLens);
		img.addEventListener("mousemove", moveLens);
		/*and also for touch screens:*/
		lens.addEventListener("touchmove", moveLens);
		img.addEventListener("touchmove", moveLens);
		function moveLens(e) {
			var pos, x, y;
			/*prevent any other actions that may occur when moving over the image:*/
			e.preventDefault();
			/*get the cursor's x and y positions:*/
			pos = getCursorPos(e);
			/*calculate the position of the lens:*/
			x = pos.x - (lens.offsetWidth / 2);
			y = pos.y - (lens.offsetHeight / 2);
			/*prevent the lens from being positioned outside the image:*/
			if (x > img.width - lens.offsetWidth) {
				x = img.width - lens.offsetWidth;
			}
			if (x < 0) {
				x = 0;
			}
			if (y > img.height - lens.offsetHeight) {
				y = img.height - lens.offsetHeight;
			}
			if (y < 0) {
				y = 0;
			}
			/*set the position of the lens:*/
			lens.style.left = x + "px";
			lens.style.top = y + "px";
			/*display what the lens "sees":*/
			result.style.backgroundPosition = "-" + (x * cx) + "px -"
					+ (y * cy) + "px";
		}
		function getCursorPos(e) {
			var a, x = 0, y = 0;
			e = e || window.event;
			/*get the x and y positions of the image:*/
			a = img.getBoundingClientRect();
			/*calculate the cursor's x and y coordinates, relative to the image:*/
			x = e.pageX - a.left;
			y = e.pageY - a.top;
			/*consider any page scrolling:*/
			x = x - window.pageXOffset;
			y = y - window.pageYOffset;
			return {
				x : x,
				y : y
			};
		}
	}
</script>
<script>
	// Initiate zoom effect:
	imageZoom("myimage", "myresult");
</script>
</div>
<%@include file="/WEB-INF/views/templates/footer.jsp"%>