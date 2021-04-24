<div class="container">

	<div class="row">

		
		<div class="col-lg-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<div class="col-lg-9">
		<c:if test="${not empty message}">
		
		<div class="row">
		<div class="col-mg-12">
			 
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			 
			</div>
		</div>
		</c:if>
		
			<div class="row">
				<div class="col-md-offset-2 col-md-8">

					<div class="panel panel-primary">

						<div class="panel-heading">

							<h4>Product Management</h4>

						</div>

						<div class="panel-body">
							<sf:form class="form-horizontal" modelAttribute="product"
								action="${contextRoot}/mg" method="POST"
								enctype="multipart/form-data">
								<div class="form-group">
									<label class="control-label col-md-4" for=mid>Select
										Category: </label>
									<div class="col-md-8">
										<sf:select id="comboboxCountry" path="mid"
											class="form-control">
											<c:forEach var="country" items="${maingroup}">
												<sf:option value="${country.mid}" label="${country.mname}" />
											</c:forEach>
										</sf:select>
										<sf:errors path="mid" cssClass="help-block" element="em" />
									</div>

								</div>



								<div class="form-group">
									<label class="control-label col-md-4" for="sg">Select
										Sub Category: </label>
									<div class="col-md-8">
										<sf:select id="comboboxState" path="sg" class="form-control">

										</sf:select>
										<sf:errors path="sg" cssClass="help-block" element="em" />
									</div>

								</div>
								<!-- Product Name -->

								<div class="form-group">
									<label class="control-label col-md-4" for="PName">Enter
										Product Name <span class="style2">*</span>
									</label>
									<div class="col-md-8">
										<sf:input type="text" path="PName" id="name"
											placeholder="Product Name" class="form-control" />
										<sf:errors path="PName" cssClass="help-block" element="em" />
									</div>

								</div>
								<!-- Product Shoet Name -->

								<div class="form-group">
									<label class="control-label col-md-4" for="PSName">Product
										Short Name on Bill Print: <span class="style2">*</span>
									</label>
									<div class="col-md-8">
										<sf:input type="text" path="PSName" id="sname"
											placeholder="Product Name" class="form-control" />
										<sf:errors path="PSName" cssClass="help-block" element="em" />
									</div>

								</div>
								<!-- Product Type -->

								<div class="form-group">
									<label class="control-label col-md-4" for="PType">Select
										Product Type (Countable/Measureable)<span class="style2">*</span>
									</label>
									<div class="col-md-8">
										<sf:select id="count" path="PType" class="form-control">
											<option value="" selected>-Select Quantity Unit-</option>
											<sf:option value="0">Meters (Measurable)</sf:option>
 											<sf:option value="1">Pcs / Nos (Countable)</sf:option>
 										</sf:select>
										<sf:errors path="PType" cssClass="help-block" element="em" />
									</div>

								</div>

								<!-- HSN CODE -->
								<div class="form-group">
									<label class="control-label col-md-4" for="HSNCODE">HSN
										CODE <span class="style2">*</span>
									</label>
									<div class="col-md-8">
										<sf:input type="text" path="HSNCODE" id="HSN"
											placeholder="HSN CODE" class="form-control" />
										<sf:errors path="HSNCODE" cssClass="help-block" element="em" />
									</div>

								</div>

								<!-- GST -->

								<div class="form-group">
									<label class="control-label col-md-4" for="GSTP">Goods
										and Service Tax (GST) :</span>
									</label>
									<div class="col-md-8">
										<sf:select id="GSTP" path="GSTP" class="form-control">
											<option value="" selected>-Select Quantity Unit-</option>


											<sf:option value="0">0%</sf:option>


											<sf:option value="3">3% GST</sf:option>


											<sf:option value="5">5% GST</sf:option>


											<sf:option value="12">12% GST</sf:option>


											<sf:option value="18">18% GST</sf:option>


											<sf:option value="28">28% GST</sf:option>


										</sf:select>
										<sf:errors path="GSTP" cssClass="help-block" element="em" />
									</div>

								</div>
								<!-- GST ON VALUE -->

								<div class="form-group">
									<label class="control-label col-md-4" for="GSTonSale">GST
										on Sales Value Amount </label>
									<div class="col-md-8">
										<sf:input type="text" path="GSTonSale" id="GSTonSale"
											placeholder="" class="form-control" />
										<sf:errors path="GSTonSale" cssClass="help-block" element="em" />
									</div>

								</div>
								<!-- GST ON MAX -->

								<div class="form-group">
									<label class="control-label col-md-4" for="GSTP">Goods
										and Service Tax (GST) :</span>
									</label>
									<div class="col-md-8">
										<sf:select id="GSTPM" path="GSTPM" class="form-control">
											<option value="" selected>-Select Quantity Unit-</option>


											<sf:option value="0">0%</sf:option>


											<sf:option value="3">3% GST</sf:option>


											<sf:option value="5">5% GST</sf:option>


											<sf:option value="12">12% GST</sf:option>


											<sf:option value="18">18% GST</sf:option>


											<sf:option value="28">28% GST</sf:option>


										</sf:select>
										<sf:errors path="GSTPM" cssClass="help-block" element="em" />
									</div>

								</div>
								<!-- ACtive -->


								<div class="form-group">
									<label class="control-label col-md-4" for="active">Active
										Status :</label>
									<div class="col-md-8">
										<sf:select id="active" path="active" class="form-control">
											<option value="" selected>-Select Quantity Unit-</option>


											<sf:option value="0">De-Active</sf:option>


											<sf:option value="1">Active</sf:option>





										</sf:select>
										<sf:errors path="active" cssClass="help-block" element="em" />
									</div>

								</div>
								<!-- 

		  
 
			<tr>
				<th>Rebate MDA/Discount Applicable:</th>
				<th colspan="2"><select name="REB_MDISC" id="REB_MDISC">
						<option value="N">No</option>
						<option value="Y">Yes</option>
				</select></th>
			</tr>
 -->






								<div class="form-group">

									<div class="col-md-offset-4 col-md-8">

										<input type="submit" name="submit" value="Submitt"
											class="btn btn-primary" />

									</div>
								</div>

							</sf:form>
						</div>

					</div>

				</div>
				 






			</div>
			<div class="row wrapper">
				<div class="col-lg-12 table-responsive">
					<table id="deepak" class="table table-striped table-borderd table-responsive">
						<thead>
							<tr>
								<th>Product Code</th>
								<th>Main Product</th>
								<th>Sub Product</th>
								<th>Product Name</th>

								<th>Unit Quantity</th>
								<th>HSN Code</th>
								<th>GST (%)</th>
								<th>GST on sales Amount</th>
								<th>GST (%) MAX</th>



								<!-- <th>&nbsp;</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th> -->
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>

</div>

