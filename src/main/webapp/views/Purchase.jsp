<div class="container ">
	<div class="row">
		<div class="col-lg-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<div class="col-lg-9">
			<div class="row">

				<sf:form class="row g-3" modelAttribute="purchase"
					action="${contextRoot}/purchase" method="POST"
					enctype="multipart/form-data" border="1" id="form1">
					<div class="col-md-3">
					<label class="form-label">Purchase Id </span>
						</label>
					 <input type="text"  value="${purid}" id="var" readonly="true" disabled="true"/>
					</div>
					<div class="col-md-3"> 
						<sf:hidden path="pid"/>
					<sf:hidden id="transf" path="transf"/>
					<sf:input type="hidden"  path="intype" value="purchase"/>
					 
						<label class="form-label" for="splinv">Party Inv <span
							class="style2">*</span>
						</label>
						<sf:input type="text" path="splinv" id="splinv"
							placeholder="Supplier Invoice No." class="form-control"   />
						<sf:errors path="splinv" cssClass="help-block" element="em" />
					</div>

					<div class="col-md-2">

						<label class="form-label" for="spldt" >Party Inv Date <span
							class="style2">*</span>
						</label>
						<sf:input type="text" path="spldt" id="spldt"
							placeholder="Supplier Invoice Date" class="form-control" readonly="true" />
						<sf:errors path="spldt" cssClass="help-block" element="em" />
						<img src="./assets/images/cal.gif"
							onClick="javascript:NewCssCal('spldt','ddMMyyyy')" />
						(dd-mm-yyyy)

					</div>
					<div class="col-md-2">
						<label class="form-label" for="splid">Select Supplier <span
							class="style2">*</span>
						</label> <input type="text" id="Text2" onFocus="showSupplier();" />
						<sf:input type="text" path="splid" id="splid"  rdisable="true" />
						<!-- <sf:input type="text" path="splid" id="splid"
						placeholder="Supplier IName" class="form-control" />
					 <sf:errors path="splid" cssClass="help-block" element="em" /> -->

					</div>
					<div class="col-md-2">
					<input type="button" name="s3" value="update bill detail" id="add3" ${transfdv==true?'disabled="disabled"' : ''} class="btn btn-primary" onclick="billdetailup()"/>
					</div>
					</sf:form>
					<br>
					<sf:form class="row g-3" modelAttribute="purrege"
					action="${contextRoot}/purrege" method="POST"
					enctype="multipart/form-data" border="1" id="form2">
					 
					
					<div class="col-md-8">
						Enter Product Code or Product Name:<input type="text" align="center" id="Text3" onFocus="showProduct();" />
							Text: <span id="ta-txt"></span><br />
            ID: <span id="ta-id"></span><br />
             <sf:hidden  id="pl" path="pl"/>
					</div>
					 
					<div class="col-md-4">
						<input type="button" name="s2" id="plbut" value="Product List" ${transfdv==true?'disabled="disabled"' : ''} class="btn btn-primary" onclick="detailProduct();">
					</div>
					 
					<div class="col-md-3">
					<label class="form-label" for="pcs">Pcs  
						</label>
						<sf:input type="text"  id="pcs" path="pcs"
							placeholder="Pcs" class="form-control" />
						 
					
					</div>
					<div class="col-md-3">
					<label class="form-label" for="qty">Qty
						</label>
						<sf:input type="text"  id="qty" path="qty"
							placeholder="qty" class="form-control" />
						
					
					</div>
					<div class="col-md-3">
					<label class="form-label" for="bvalue">Base Price </span>
						</label>
						<sf:input type="text" path="bvalue" id="bvalue"  placeholder="Base Price" class="form-control" />
						 
					
					</div>
					<div class="col-md-3">
					<input type="button" name="s1" value="Add" id="add1" ${transfdv==true?'disabled="disabled"' : ''} class="btn btn-primary" onclick="purdsave()" />
					<sf:hidden  id="mrp" path="mrp"/>
					<sf:hidden  id="inid" path="inid"  />
					<sf:hidden  id="barcode" path="barcode"/>
					</div>
				</sf:form>
 <br>
<div class="col-md-12">
<table id="productent" class="table table-responsive table-striped table-borderd" style="width:100%"  >
        <thead>
            <tr>
            	<th>Product Name</th>
                <th>Barcode</th>
                <th>Pcs</th>
                <th>Qty</th>
                <th>Total Qty</th>
                <th>Base Rate</th>
                <th>MRP</th>
                <th>Supplier Discount</th>
                <th>Tax on bill</th>
                <th><input type="button" id="printbill" name="Print Bill" value="Print Bill" class="btn btn-primary" onclick="getprno('${purid}');" disabled="disabled"> <input type="button" name="Barcode" value="Barcode" id="barcodeprint" class="btn btn-lg btn-primary" onclick="printbarcode();" /></th>
                 
            </tr>
        </thead>
         
    </table>
</div>
 
			</div>
		</div>
	</div>
</div>