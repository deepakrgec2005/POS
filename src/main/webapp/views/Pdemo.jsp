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

			<div class="row"  >
				<div class="  col-md-12">

					<div class="panel panel-primary ">

						<div class="panel-heading text-center">

							<h4>Product Management</h4>

						</div>

						<div class="panel-body">
							<sf:form class="row g-3" modelAttribute="product"
								action="${contextRoot}/POS/mg" method="POST"
								enctype="multipart/form-data">
								<div class="col-md-3">
									<label class="form-label" for=mid>Select Category: </label>
								</div>
								<div class="col-md-6">
									<sf:select id="comboboxCountry" path="mid" class="form-control">
										<c:forEach var="country" items="${maingroup}">
											<sf:option value="${country.mid}" label="${country.mname}" />
										</c:forEach>
									</sf:select>
									<sf:errors path="mid" cssClass="help-block" element="em" />
								</div>
 							<div class="col-md-3">
									<input type="button"   data-toggle="modal" data-target="#newMaingroup" class="btn btn-warning btn-xs" value="Add Main Group"/>  
								</div>
								<div class="col-md-3">
									<label class="form-label" for="sg">Select Sub Category: </label>
								</div>
								<div class="col-md-6">
									<sf:select id="comboboxState" path="sg" class="form-control">

									</sf:select>
									<sf:errors path="sg" cssClass="help-block" element="em" />
								</div>
						<div class="col-md-3">
									<input type="button"   data-toggle="modal" data-target="#newSecondgroup" class="btn btn-warning btn-xs" value="Add Sub Group"/>  
								</div>

								<!-- Product Name -->

								<div class="col-md-3">
									<label class="form-label " for="PName">Enter Product
										Name <span class="style2">*</span>
									</label>
								</div>
								<div class="col-md-9">
									<sf:input type="text" path="PName" id="name"
										placeholder="Product Name" class="form-control" />
									<sf:errors path="PName" cssClass="help-block" element="em" />
								</div>


								<!-- Product Shoet Name -->

								<div class="col-md-3">
									<label class="control-label" for="PSName">Product Short
										Name on Bill Print: <span class="style2">*</span>
									</label>
								</div>
								<div class="col-md-9">
									<sf:input type="text" path="PSName" id="sname"
										placeholder="Product Name" class="form-control" />
									<sf:errors path="PSName" cssClass="help-block" element="em" />
								</div>


								<!-- Product Type -->

								<div class="col-md-3">
									<label class="control-label " for="PType">Select
										Product Type (Countable/Measureable)<span class="style2">*</span>
									</label>
								</div>
								<div class="col-md-9">
									<sf:select id="count" path="PType" class="form-control">
										<option value="" selected>-Select Quantity Unit-</option>
										<sf:option value="0">Meters (Measurable)</sf:option>
										<sf:option value="1">Pcs / Nos (Countable)</sf:option>
									</sf:select>
									<sf:errors path="PType" cssClass="help-block" element="em" />
								</div>



								<!-- HSN CODE -->
								<div class="col-md-3">
									<label class="control-label " for="HSNCODE">HSN CODE <span
										class="style2">*</span>
									</label>
								</div>
								<div class="col-md-6">
									<sf:input type="text" path="HSNCODE" id="HSN"
										placeholder="HSN CODE" class="form-control" />
									<sf:errors path="HSNCODE" cssClass="help-block" element="em" />
								</div>
								<div class="col-md-3">
									<a href="https://cbec-gst.gov.in/gst-goods-services-rates.html" target="_blank"  class="btn btn-primary">Seach HSN Code</a>
									 
								</div>



								<!-- GST -->

								<div class="col-md-3">
									<label class="control-label " for="GSTP">Goods and
										Service Tax (GST) :</span>
									</label>
								</div>
								<div class="col-md-9">
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


								<!-- GST ON VALUE -->

								<div class="col-md-3">
									<label class="control-label " for="GSTonSale">GST on
										Sales Value Amount </label>
								</div>
								<div class="col-md-9">
									<sf:input type="text" path="GSTonSale" id="GSTonSale"
										placeholder="" class="form-control" />
									<sf:errors path="GSTonSale" cssClass="help-block" element="em" />
								</div>


								<!-- GST ON MAX -->

								<div class="col-md-3">
									<label class="control-label " for="GSTP">Goods and
										Service Tax (GST) :</span>
									</label>
								</div>
								<div class="col-md-9">
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


								<!-- ACtive -->


								<div class="col-md-3">
									<label class="control-label " for="active">Active
										Status :</label>
								</div>
								<div class="col-md-9">
									<sf:select id="active" path="active" class="form-control">
										<option value="" selected>-Select Quantity Unit-</option>


										<sf:option value="0">De-Active</sf:option>


										<sf:option value="1">Active</sf:option>





									</sf:select>
									<sf:errors path="active" cssClass="help-block" element="em" />
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








								<div class="col-md-offset-4 col-md-8 text-center">

									<input type="submit" name="submit" value="Submitt"
										class="btn btn-primary" />

								</div>


							</sf:form>
						</div>
					</div>

				</div>

			</div>
		</div>
		<div class="row wrapper">
			<div class="col-lg-12 table-responsive">
				<table id="deepak"
					class="table table-striped table-borderd table-responsive">
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
<div class="modal fade" id="newMaingroup" role="dialog"
		tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Add New Main Category</h4>
				</div>
				<div class="modal-body">
					<sf:form id="categoryForm" modelAttribute="category"
						action="${contextRoot}/POS/category" method="POST"
						class="form-horizontal">
						<div class="form-group">
							<label for="Mname" class="control-label col-md-4">Category
								Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="Mname" id="Mname"
									class="form-control" />
							</div>
						</div>
 						<div class="form-group">

							<div class="col-md-offset-4 col-md-8">
								<input type="submit" value="Add Category"
									class="btn btn-primary" />
							</div>
						</div>


					</sf:form>
				</div>
			</div>
		</div>
	</div>
<div class="modal fade" id="newSecondgroup" role="dialog"
		tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Add New Main Category</h4>
				</div>
				<div class="modal-body">
					<sf:form id="subcategoryForm" modelAttribute="subcategory"
						action="${contextRoot}/POS/subcategory" method="POST"
						class="form-horizontal">
						<div class="form-group">
							<label for="mg" id="mg" class="control-label col-md-4" />Main Group</label>
							 <div class="col-md-8">
								<sf:input type="text" path="mg" id="subcatg" readonly="true"
									class="form-control" />
							</div>
							 
						</div>
						<div class="form-group">
							<label for="sname" class="control-label col-md-4">Sub Category
								Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="sname" id="sname"
									class="form-control" />
							</div>
						</div>
 						<div class="form-group">

							<div class="col-md-offset-4 col-md-8">
								<input type="submit" value="Add Category"
									class="btn btn-primary" />
							</div>
						</div>


					</sf:form>
				</div>
			</div>
		</div>
	</div>

</div>

 

