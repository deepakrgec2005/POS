<div class="container ">
	<div class="row">
		<div class="col-lg-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<div class="col-lg-9">
			<div class="row">
				<sf:form class="row g-3" modelAttribute="stockOpeningdet"
					action="${contextRoot}/POS/stockOpeningdet" method="POST"
					enctype="multipart/form-data" border="1" id="form5">
					<div class="col-md-12 text-center">
						<label class="form-label">Opening Batch Id </span>
						</label> <input type="text" value="${purid}" id="var" readonly="true"
							disabled="true" />
					</div>


					<div class="col-md-8">
						Enter Product Code or Product Name:<input type="text"
							align="center" id="Text3" onFocus="showProduct();" />
						<sf:hidden id="pl" path="pl" />
					</div>

					<div class="col-md-4">
						<input type="button" name="s2" id="plbut" value="Product List"
							class="btn btn-primary" onclick="detailProduct();">
					</div>
					<div class="col-md-12">
						<table border="1">
							<tr>
								<td colspan="3"></td>
								<td colspan="3" align="center"><input type="radio"
									name="checkRadio" id="checkRadio" value="M"
									onclick="readonlyRate();">Rate<input type="radio"
									id="Rad" name="checkRadio" value="R" onclick="readonlyRate();"
									checked="checked">MRP</td>
								<td colspan="3"></td>
							</tr>
							<tr>
								<th>Product Code</th>
								<th>Product Name</th>
								<th>Pcs</th>
								<th>Qty</th>
								<th>BAse Rate</th>
								<th>MRP</th>
								<th>Amount</th>
								<th>Supplier</th>
								<th></th>
							</tr>
							<tr>
								<td><span id="ta-id"></span></td>
								<td><span id="ta-txt"></span></td>
								<td><sf:input type="text" id="pcs" path="pcs"
										placeholder="Pcs" class="form-control" /></td>
								<td><sf:input type="text" id="qty" path="qty"
										placeholder="qty" class="form-control" /></td>
								<td><sf:input type="text" path="bvalue" id="bvalue"
										placeholder="Base Price" class="form-control" readonly="true" /></td>
								<td><sf:input type="text" path="mrp" id="mrp"
										placeholder="MRP " class="form-control" /></td>
								<td>Amount</td>
								<td><label class="form-label" for="supid">Select
										Supplier <span class="style2">*</span>
								</label> <input type="text" id="Text2" onFocus="showSupplier();" /> <sf:input
										type="text" path="supid" id="splid" disable="true" /></td>
								<td><input type="button" name="op1" value="Add" id="addop1"
									class="btn btn-primary" onclick="openingsave();" /></td>
								<!-- openingsave() -->
							</tr>

						</table>

					</div>

					<!-- <div class="col-md-2">
					<label class="form-label" for="pcs">Pcs  
						</label>
						<sf:input type="text"  id="pcs" path="pcs"
							placeholder="Pcs" class="form-control" />
						 
					
					</div>
					<div class="col-md-2">
					<label class="form-label" for="qty">Qty
						</label>
						<sf:input type="text"  id="qty" path="qty"
							placeholder="qty" class="form-control" />
						
					
					</div>
					<div class="col-md-2">
					<label class="form-label" for="bvalue">Base Price </span>
						</label>
						<sf:input type="text" path="bvalue" id="bvalue"  placeholder="Base Price" class="form-control" />
						 
					
					</div>
					<div class="col-md-3">
						<label class="form-label" for="supid">Select Supplier <span
							class="style2">*</span>
						</label> <input type="text" id="Text2" onFocus="showSupplier();" />
						<sf:input type="text" path="supid" id="splid"  disable="true" />
						 

					</div> -->
					<div class="col-md-12">


						<sf:hidden id="inid" path="stkid" />
						<sf:hidden id="barcode" path="barcode" />
						<input type="text" disabled="disabled" id="splinv" value="opening">
						<input type="text" disabled="disabled" id="spldt"
							value="01-04-2021">

					</div>
				</sf:form>
			</div>

			<br>
			<div class="col-md-12">
				<table id="openingtab"
					class="table table-responsive table-striped table-borderd"
					style="width: 100%">
					<thead>
						<tr>
							<th>Stock Id</th>
							<th>Product Code</th>
							<th>Product Name</th>
							<th>Barcode</th>
							<th>Pc</th>
							<th>Qty</th>
							<th>Total Qty</th>
							<th>Base Rate</th>
							<th>MRP</th>
							<th>Total Amount</th> 
							<th><input type="button" id="openingBatch" name="openingBatch"
								value="Print Batch" class="btn btn-primary" onclick="getallprno('${purid}');"
								 disabled="disabled"> <input
								type="button" name="Barcode" value="Barcode" id="barcodeprint"
								class="btn btn-lg btn-primary" onclick="printbarcode('${purid}','Print-All-Barcode');"
								  /></th>
 
						</tr>
					</thead>

				</table>
			</div>


		</div>
	</div>
</div>