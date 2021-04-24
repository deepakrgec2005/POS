
<html>
<head>
<title>::Kaushik | INVENTORY MANAGEMENT SYSTEM</title>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<link rel="stylesheet" type="text/css" href="/assets/css/pmegpNew.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/jquery.dataTables.min.css" />
<script language="javascript" src="/assets/js/jquery-1.7.1.min.js"></script>
  
<script type="text/javascript">
	$(document).ready(function()
	{
	
		$('#categoryId').on('change',function()
		{
			var cga=$(this).val();
			console.log(cga);
			$.ajax({
						type:'GET',
						url:'${pageContext.request.contextPath }/loadSubgroupByMainGroup/'+cga,
						sucees:function(result)
						{
							var result=JSON.parse(result);
							console.log(result);
							var d='';
							for(var i=0;i<result.length;i++)
							{
								d +='<option value="'+result[i].sid+'">'+result[i].sname+'</option>';
								console.log(d);
	
							}
							$('#categoryId2').html(d);
						}



					});
 
		});
	
	
	

	 
});
</script>
  
 
</head>
<body>

	<form method="post" name="form" id="form">

		<style>

/* Style The Dropdown a  4CAF50*/
.dropbtn {
	background-color: #82ccc7;
	color: white;
	padding: 12px;
	font-size: 14px;
	border: none;
	cursor: pointer;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
	position: relative;
	display: inline-block;
}

/* Dropdown Content (Hidden by Default)  f9f9f9*/
.dropdown-content {
	display: none;
	position: absolute;
	background-color: #82ccc7;
	min-width: 180px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	border: 1px #006633 solid;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {
	background-color: #f1f1f1
}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
	display: block;
}

/* Change the background color of the dropdown a when the dropdown content is shown */
.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}

.header_wd {
	color: #990000;
	font-weight: bold;
	font-size: 12px;
}

.header_wd {
	font-size: 12px;
	font-weight: bold;
}
</style>
 		<table align="center" width="100%">
			<tr>
				<td>
					<%-- <%@ include  file="./shared/navbar.jsp" %> --%>
				</td>
			</tr>
		</table>
		<br />

		<table align="center" border="0">

		</table>
		</blockquote>

		<br /> <input name="ins" type="hidden" id="ins">
		<div class="HeaderLabel">PRODUCT MASTER</div>
		<br>
		<table align="center" class="shadow">

			<tr>
				<td colspan="3"><div align="center">
						<span class="style2">(*)Marked are Mandatory Fields </span>
					</div></td>
			</tr>
			<tr>
				<th>Select Main Product Group<span class="style2">*</span></th>






				<th colspan="2"><select id="comboboxCountry" style="width:200px">
						<c:forEach var="country" items="${maingroup}">
							<option value=${country.mid}>${country.mname}</option>
						</c:forEach>
					</select></th>
			</tr>

			<tr>
				<th>Select Second Sub Product Group <span class="style2">*</span></th>
				<th colspan="2" id="PRODUCTTWO"><select id="comboboxState" style="width:200px"/></th>
			</tr>

			<tr>
				<th>Enter Product Name <span class="style2">*</span></th>
				<th colspan="2"><input name="ID3_NAME" type="text"
					id="ID3_NAME" value="" size="40" maxlength="200"></th>
			</tr>
			<tr>
				<th>Product Short Name on Bill Print:</th>
				<th><input name="SHORT_DESC" type="text" id="SHORT_DESC"
					value="" size="40" maxlength="20"></th>
			</tr>
			<tr>
				<th>Select Product Type (Countable/Measureable)<span
					class="style2">*</span></th>
				<th colspan="2"><select name="UQC_ID" id="UQC_ID">
						<option value="" selected>-Select Quantity Unit-</option>


						<option value="DKS">Hanks (Countable)</option>


						<option value="KGS">Kg (Measurable)</option>


						<option value="LTR">Litres (Measurable)</option>


						<option value="MTR">Meters (Measurable)</option>


						<option value="QTL">Quintal (Measurable)</option>


						<option value="NOS">Pcs / Nos (Countable)</option>

				</select></th>
			</tr>

			<tr>
				<th>HSN CODE <span class="style2">*</span></th>
				<th colspan="2"><input name="HSNCODE" id="HSNCODE" type="text"
					size="10" maxlength="8"> <a
					href="https://cbec-gst.gov.in/gst-goods-services-rates.html"
					class="buttongrey" target="_blank">Search HSN Code</a></th>
			</tr>
			<tr>
				<th>Goods and Service Tax (GST) :</th>
				<th colspan="2"><select name="GST_PER" id="GST_PER">

						<option value="0">0%</option>
						<option value="3">3% GST</option>
						<option value="5">5% GST</option>
						<option value="12">12% GST</option>
						<option value="18">18 % GST</option>
						<option value="28">28 % GST</option>
				</select> (MINIMUM/NORMAL)</th>

			</tr>
			<tr>
				<th>GST on Sales Value Amount</th>
				<th colspan="2"><input name="GST_ON_AMT" id="GST_ON_AMT"
					type="text" size="10" maxlength="5"></th>


			</tr>
			<tr>
				<th>Goods and Service Tax (GST) :</th>
				<th colspan="2"><select name="GST_PER_MAX" id="GST_PER_MAX">
						<option value="0">0%</option>
						<option value="3">3% GST</option>
						<option value="5">5% GST</option>
						<option value="12">12% GST</option>
						<option value="18">18 % GST</option>
						<option value="28">28 % GST</option>
				</select> (MAX)</th>

			</tr>
			<tr>
				<th>Rebate MDA/Discount Applicable:</th>
				<th colspan="2"><select name="REB_MDISC" id="REB_MDISC">
						<option value="N">No</option>
						<option value="Y">Yes</option>
				</select></th>
			</tr>
			<tr>
				<td colspan="3"><div align="center">
						<input name="Button" type="button" class="buttongrey"
							value="Save Data" onClick="submit_update();">
					</div></td>
			</tr>
		</table>
		 
		<table width="100%" cellspacing="0" class="display" id="example">
			<thead>
				<tr>
					<th>Product Code</th>
					<th>Main Product</th>
					<th>Sub Product</th>
					<th>Product Name</th>
					<th>GS CODE</th>
					<th>Unit Quantity</th>
					<th>HSN Code</th>
					<th>GST (%)</th>
					<th>GST on sales Amount</th>
					<th>GST (%) MAX</th>
					<th>Rebate MDA/Discount</th>
					<th>Active</th>
					<th>CESS (%)</th>
					<th>CESS On Sales Value</th>
					<th>CESS(%) MAX</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
			<tfoot>
			<thead>
			<tfoot>
			<tbody>




			</tbody>
		</table>
		 
	</form>
</body>
</html>
