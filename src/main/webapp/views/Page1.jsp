<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Kaushik Soft-${title}</title>
<!-- Bootstrap core CSS -->

<link href="/assets/css/bootstrap.min.css" rel="stylesheet">
<link href="/assets/css/bootstrap-redable-theme.css" rel="stylesheet">
<link href="/assets/css/dataTables.bootstrap.css" rel="stylesheet">

<link href="/assets/css/myapp.css" rel="stylesheet">

<link href="/assets/css/shop-item.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="/assets/css/tautocomplete.css" />
	

<link href="/assets/css/jquery.dataTables.min.css" rel="stylesheet">
 

<script src="/assets/js/jquery-1.12.4.js"></script>

<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>
<script src="/assets/js/tautocomplete.js" type="text/javascript"></script>
<script src="/assets/js/datetimepicker_css.js"></script>
<script src="/assets/js/ModalPopupWindow.js"></script>

<script src="/assets/js/inlinemsg.js"></script>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						/* $('#example').DataTable(); */

						$('#comboboxCountry')
								.on(
										'change',
										function() {
											var countryId = $(this).val();
											console.log(countryId);
											$
													.ajax({
														type : 'GET',
														url : '${pageContext.request.contextPath }/loadSubgroupByMainGroup/'
																+ countryId,
														success : function(
																result) {
															var result = JSON
																	.parse(result);
															var s = '';
															for (var i = 0; i < result.length; i++) {
																s += '<option value="' + result[i].sid + '">'
																		+ result[i].sname
																		+ '</option>';
																console.log(s);
															}
															$('#comboboxState')
																	.html(s);
														}
													});
										});

					});
</script>

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->

<c:choose>
       <c:when test="${userClickPurchaselist ==true}">
              
       </c:when>
         <c:when test="${userClickPurchaselistupdate==true}">
              
       </c:when>
         <c:when test="${userClickBarcodePrint==true}">
              
       </c:when>
       
       <c:otherwise>
          <%@ include file="./shared/navbar1.jsp"%>   
       </c:otherwise>
  </c:choose>
  <!-- Page Content -->
<div class="content">
		<c:if test="${userClickHome ==true}">
		 
				<%@include file="Home1.jsp"%>
		</c:if>
		<c:if test="${userClickProduct ==true}">
			 
				<%@include file="Pdemo.jsp"%>
		</c:if>
		<c:if test="${userClickSupplier ==true}">
			 
				<%@include file="Supplier.jsp"%>
		</c:if>
		<c:if test="${userClickPurchase ==true}">
			 
				<%@include file="Purchase.jsp"%>
		</c:if>
		<c:if test="${userClickPurchaselist ==true}">
			  
				<%@include file="prlist.jsp"%>
		</c:if>
		<c:if test="${userClickPurchasedetails ==true}">
			  
				<%@include file="Purchasedetail.jsp"%>
		</c:if>
				<c:if test="${userClickPurchaselistupdate==true}">
			  
				<%@include file="productupdate.jsp"%>
		</c:if>
				<c:if test="${userClickBarcodePrint==true}">
			  
				<%@include file="BarcodePrint.jsp"%>
		</c:if>
		
		<c:choose>
       <c:when test="${userClickPurchaselist ==true}">
               
       </c:when>
        <c:when test="${userClickPurchaselistupdate==true}">
               
       </c:when>
        <c:when test="${userClickBarcodePrint==true}">
               
       </c:when>
       <c:otherwise>
          <%@include file="./shared/footer1.jsp"%>
       </c:otherwise>
  </c:choose>
		
		
	</div>
	<!-- Footer -->

	<!-- Bootstrap core JavaScript -->
	<!-- <script src="/assets/js/jquery.js"></script> -->

	<script src="/assets/js/bootstrap.min.js"></script>
	<script src="/assets/js/jquery.dataTables.js"></script>
	<script src="/assets/js/dataTables.bootstrap.js"></script>
	<!-- if error remove below two -->
	<!-- <script src="/assets/js/jquery.min.js"></script>
	<script src="/assets/js/jquery.dataTables.min.js"></script> -->
	<!-- if error remove below two END -->
	<script src="/assets/js/bootbox.min.js"></script>
	<script src="/assets/js/myapp.js"></script>


	</div>
</body>

</html>
