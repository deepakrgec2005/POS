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
											document.getElementById('subcatg').value=countryId;
											 
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
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/POS/home">Home</a>
				</div>
			</div>
		</nav>


		<div class="content">

			<div class="container">

				<div class="row">

					<div class="col-xs-12">


						<div class="jumbotron">

							<h1>${errorTitle}</h1>
							<hr />

							<blockquote style="word-wrap: break-word">

								${errorDescription}</blockquote>

						</div>


					</div>

				</div>

			</div>

		</div>
          <%@include file="./shared/footer1.jsp"%>
        
	</div>
</body>

</html>
