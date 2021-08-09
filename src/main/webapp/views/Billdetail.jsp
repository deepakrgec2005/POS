<script type="text/javascript">
	  $(document).scannerDetection({
		timeBeforeScanTest : 200, // wait for the next character for upto 200ms
		startChar : [ 120 ], // Prefix character for the cabled scanner (OPL6845R)
		endChar : [ 13 ], // be sure the scan is complete if key 13 (enter) is detected
		avgTimeByChar : 40, // it's not a barcode if a character takes longer than 40ms
		//preventDefault:true,
		//onKeyDetect: function(event){console.log(event.which); return false;}
		onComplete : function(barcode, qty) {
		alert('value of barcode called'+barcode);
		document.getElementById("Text4").value = barcode;
		 $("#ta-txt").html(barcode);
		  //$( "#Text4" ).value(barcode);
			
			  $("#Text4").html=barcode;
			// 
			getbardet(barcode);
			//$("#Text4").focus();
			//scanbarcode();
		} // main callback function	
	});
		
    
</script>
 
<div class="container">
	<div class="row">
		<div class="col-lg-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<div class="col-lg-9">
			<div class="row ">
				<sf:form class="row g-2   myformR" modelAttribute="billd"
					action="${contextRoot}/bill" method="POST"
					enctype="multipart/form-data" border="1" id="invform1">
					<div class="form-row myformRow">
						<div class="col-md-3 ">
							<label><span>Bill Id (Auto) </span> </label> <i
								class="fas fa-money-bill"></i><input type="text" class="form-control" value="${billid}" id="varbill" readonly="true" disabled="true" />
							<sf:hidden path="billInvId" />
						</div>
						<div class="col-md-3 offset-md-6">



							<label for="date">Bill Date <span class="style2">*</span>
							</label> <i class="fas fa-calendar-week"></i>
							<input type="text"  id="dateinv"
								placeholder="Bill Date" class="form-control" readonly="true"
								disabled="true" />
								<sf:hidden id="indate" path="date" />
							<sf:errors path="date" cssClass="help-block" element="em" />
							 <input type="hidden" id="outamt" value="${outstanding}"/> 
						</div>
					</div>

				</sf:form>

			</div>
			<br> <br>
			<div class="row ">

				<sf:form class="row g-2 myformR" modelAttribute="customer"
					action="${contextRoot}/customer" method="POST"
					enctype="multipart/form-data" id="custform1">
					<div class="form-row myformRow">
						<div class="col-md-4">
							<label for="cname">Customer Name </span>
							</label> <i class="far fa-user"></i>
							<sf:input type="text" id="cname" path="cname"
								class="form-control" />

						</div>
						<div class="col-md-4">
							<label for="caddress">Customer Address </span>
							</label> <i class="fas fa-map-marked"></i>
							<sf:input type="text" id="caddress" path="caddress"
								class="form-control" />
						</div>

						<div class="col-md-4">
							<label for="isut">Customer State </span>
							</label>
							<sf:select id="State" path="isut" class="form-control">
								<c:forEach var="country" items="${State}">
									<sf:option value="${country.stid}" label="${country.statename}"
										class="form-control" />
								</c:forEach>
							</sf:select>
							<sf:errors path="isut" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="form-row myformRow">
						<div class="col-md-4">
							<label for="cnumber">Customer Number </span>
							</label> <i class="fas fa-phone"></i>
							<sf:input type="text" id="cnumber" path="cnumber"
								class="form-control" />

						</div>
						<div class="col-md-4">
							<label for="gstno">G.S.T. Number </span>
							</label>
							<sf:input type="text" id="gstno" path="gstno"
								class="form-control" />

						</div>
						<div class="col-md-4 text-center">
							<br> <input type="button" name="sbut" value="Save" id="add3"
								class="btn btn-primary" onclick=" "
								style="width: 91px; height: 45px" />
						</div>

					</div>
				</sf:form>
			</div>
			<div class="row">
				<sf:form class="row g-3" modelAttribute="billdt"
					action="${contextRoot}/billdet" method="POST"
					enctype="multipart/form-data" border="1" id="billdtform">
					<div class="form-row myformRow">
						<div class="col-md-12 " align="center" style="background-color: Lime; ">
						Auto Insert On <input  type="radio" name="AutoOF" id="AutoO" value="O" onclick="">
						OR OFF<input  type="radio" name="AutoOF" id="AutoF" value="F" onclick="" checked>
						</div>
						</div>
					<div class="form-row myformRow">
						<div class="col-md-12">
							Search by last 6 digit Barcode or Scan Your Barcode Here :<input type="text"  align="center" id="Text4"  autofocus 	/>
						 <!-- onchange="scanbarcode();" -->
							Text: <span id="ta-txt"></span><br /> ID: <span id="ta-id"></span><br />
							<sf:hidden id="barc" path="barcode" />
							<br />
						</div>
					</div>
				 
					<div class="form-row myformRow">
					<div class="col-md-12">
						<table class="table  table-responsive"  >
							<tr>
								<th class="thcl">Barcode</th>
								<th class="thcl">Product Name</th>
								<th class="thcl">Pcs</th>
								<th class="thcl">Qty</th>
								<th class="thcl">Rate</th>
								<th class="thcl">Gross</th>
								<th class="thcl">Discount</th>
								<th class="thcl">Net</th>
								<th  >Add</th>
							</tr>
							<tr>
								<td class="thcl" ><sf:input type="text" id="barcode" path="barcode" readonly="true"/></td>
								<td class="thcl" ><input type="text" id="pr1" path="pr1" readonly="true"/> <sf:hidden id="prname" path="prname"/></td>
								<td class="thcl" ><sf:input type="text" id="pcs1" path="pcs" onblur="uppcs1();"/></td>
								<td class="thcl" ><sf:input type="text" id="qty1" path="qty"  onblur="uppcs1();"/></td>
								<td class="thcl" ><sf:input type="text" readonly="true" id="bprice1" path="bprice"/></td>
								<td class="thcl" ><input type="text" readonly="true" id="gross" /></td>
								<td class="thcl" ><sf:input type="text" id="discount" path="discount" onblur="uppcs1();" /></td>
								<td  class="thcl"><sf:input type="text" id="net" path="net"/><sf:hidden id="billdetailbill" path="bill"/></td>
								<td class=" text-center"><input type="Button" value="Add" name="add" id="add" onclick="billdsave();"  ${outstanding!=0.0?'disabled="disabled"' : ''}><input type="hidden" id="blck"/></td>
						</table>
						</div>
						<div class="col-md-12">
						<table id="salebp" class="table table-responsive table-striped table-borderd" style="width:100%"  >
        <thead>
            <tr>
            	<th>Sr. No</th>
                <th>Barcode</th>
                <th>Product Name</th>
                <th>Pcs</th>
                <th>Qty</th>
                <th>Rate</th>
                <th>Gross</th>
                <th>Discount</th>
                <th>Net</th>
                <th>GST</th>
                <th>Paybale Net</th>
                <th></th>
                 
            </tr>
            <tr>
            <td colspan="3" class="text-center"><b>Grand Total</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><input type="button" id="upbspay" name="Uppay" value="Pay" class="btn btn-primary" onclick="paymentdetailcap();" disabled="disabled"/></td>
            </tr>
        </thead>
         
    </table>
						</div>
					</div>
				</sf:form>

			</div>
		</div>
	</div>
</div>