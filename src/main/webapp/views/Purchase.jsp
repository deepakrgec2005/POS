<div class="container ">
	<div class="row">
		<div class="col-lg-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<div class="col-lg-9">
			<div class="row">

				<sf:form class="row g-3" modelAttribute="purchase"
					action="${contextRoot}/purchase" method="POST"
					enctype="multipart/form-data">
					<div class="col-md-4">
						<label class="form-label" for="splinv">Party Inv <span
							class="style2">*</span>
						</label>
						<sf:input type="text" path="splinv" id="splinv"
							placeholder="Supplier Invoice No." class="form-control" />
						<sf:errors path="splinv" cssClass="help-block" element="em" />
					</div>

					<div class="col-md-4">

						<label class="form-label" for="spldt">Party Inv Date <span
							class="style2">*</span>
						</label>
						<sf:input type="text" path="spldt" id="spldt"
							placeholder="Supplier Invoice Date" class="form-control" />
						<sf:errors path="spldt" cssClass="help-block" element="em" />
						<img src="./assets/images/cal.gif"
							onClick="javascript:NewCssCal('spldt','ddMMyyyy')" />
						(dd-mm-yyyy)

					</div>
					<div class="col-md-4">
						<label class="form-label" for="splid">Select Supplier <span
							class="style2">*</span>
						</label> <input type="text" id="Text2" onFocus="showSupplier();" />
						<sf:hidden path="splid" id="splid" />
						<!-- <sf:input type="text" path="splid" id="splid"
						placeholder="Supplier IName" class="form-control" />
					 <sf:errors path="splid" cssClass="help-block" element="em" /> -->

					</div>
					<div class="col-md-8">
						Enter Product Code or Product Name:<input type="text" align="center" id="Text3"
							onFocus="showProduct();" />
					</div>
					<div class="col-md-4">
						<input type="button" name="submit" value="Product List" class="btn btn-primary" >
					</div>
					 
					<div class="col-md-4">
					<label class="form-label" for="pcs">Pcs  
						</label>
						<sf:input type="text" path="pcs" id="pcs"
							placeholder="Pcs" class="form-control" />
						<sf:errors path="pcs" cssClass="help-block" element="em" />
					
					</div>
					<div class="col-md-4">
					<label class="form-label" for="qty">Qty
						</label>
						<sf:input type="text" path="qty" id="qty"
							placeholder="qty" class="form-control" />
						<sf:errors path="qty" cssClass="help-block" element="em" />
					
					</div>
					<div class="col-md-4">
					<label class="form-label" for="bvalue">Base Price </span>
						</label>
						<sf:input type="text" path="bvalue" id="splinv"
							placeholder="Base Price" class="form-control" />
						<sf:errors path="bvalue" cssClass="help-block" element="em" />
					
					</div>
				</sf:form>

			</div>
		</div>
	</div>
</div>