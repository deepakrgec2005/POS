<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
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
<link href="/assets/css/all.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/00a7c923a7.js" crossorigin="anonymous"></script>
<link href="/assets/css/myapp.css" rel="stylesheet">

<link href="/assets/css/shop-item.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="/assets/css/tautocomplete.css" />
	

<link href="/assets/css/jquery.dataTables.min.css" rel="stylesheet">
 


<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>
	<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="/assets/js/jquery-1.12.4.js"></script>
<script src="/assets/js/jquery-ui.js"></script>
<script src="/assets/js/datetimepicker_css.js"></script>
<script src="/assets/js/ModalPopupWindow.js"></script>

<script src="/assets/js/inlinemsg.js"></script>
<script src="/assets/js/tautocomplete.js" type="text/javascript"></script>
 
 
 
<script src="/assets/js/jquery.scannerdetection.js" type="text/javascript"></script>
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
											document.getElementById('subcatg').value=countryId;
											 
											$
													.ajax({
														type : 'GET',
														url : '${pageContext.request.contextPath }/POS/loadSubgroupByMainGroup/'
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
$("#Text4").autocomplete({
    
    source:function(request,response){
     $.ajax({
            url: "/POS/json/barcode",
            data: {
                brc: request.term
            }
        }).done(function (data) {
       // alert('value of data'+data);
            response($.map(data,function(item){
            return{
            id:item.l1,
            value:item.l2,
            
            }
            
            }));
        }); 
    
    
    },
    minLength: 3,
    width : "500px",
    autoFocous:true,  
    select: function(event, ui) {
    //alert('hi'+ui.item.l2);
					this.value = ui.item.id;
					$("#Text4").val(ui.item.value);
					$("#ta-txt").html(ui.item.value);
					$("#ta-id").html(ui.item.id);
					getbardet(ui.item.value);
					//scanbarcode();
					return ui.item.value;
					}
    
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
        <c:when test="${userClickRsBill==true}">
              
       </c:when>
        <c:when test="${userClickStockupdate==true}">
              
       </c:when>
         <c:when test="${userClickBarcodePrint==true}">
              
       </c:when>
         <c:when test="${userClickBillPaym==true}">
              
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
		<c:if test="${userClickRSale ==true}">
			  
				<%@include file="Rsaledetail.jsp"%>
		</c:if>
				<c:if test="${userClickPurchaselistupdate==true}">
			  
				<%@include file="productupdate.jsp"%>
		</c:if>
		<c:if test="${userClickRsBill==true}">
			  
				<%@include file="RsUB.jsp"%>
		</c:if>
		<c:if test="${userClickStockupdate==true}">
			  
				<%@include file="Stockupdate.jsp"%>
		</c:if>
				<c:if test="${userClickBarcodePrint==true}">
			  
				<%@include file="BarcodePrint.jsp"%>
		</c:if>
	 
				<c:if test="${userClickBillPaym==true}">
			  
				<%@include file="Payment.jsp"%>
		</c:if>
		 <c:if test="${userClicStock==true}">
			  
				<%@include file="stock.jsp"%>
		</c:if>
		
		 <c:if test="${userClicStockOpening==true}">
			  
				<%@include file="OpeningBatch.jsp"%>
		</c:if>
		<c:if test="${userClickUserMg==true}">
			  
				<%@include file="RegisteraUser.jsp"%>
		</c:if>
		<c:if test="${userClickBill==true}">
			  
				<%@include file="Billdetail.jsp"%>
		</c:if>
		<c:choose>
       <c:when test="${userClickPurchaselist ==true}">
               
       </c:when>
        <c:when test="${userClickPurchaselistupdate==true}">
              
       </c:when>
       <c:when test="${userClickRsBill==true}">
              
       </c:when>
       <c:when test="${userClickStockupdate==true}">
              
       </c:when>
        <c:when test="${userClickBarcodePrint==true}">
               
       </c:when>
          <c:when test="${userClickBillPaym==true}">
               
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
