<div class="container">

	<div class="row">

		<div class="col-lg-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<div class="col-lg-9">

			<c:if test="${not empty message}">
				<div class="row">
					<div class="col-mg-12">
						<div class="col-lg-12">
							<div class="alert alert-success alert-dismissible">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								${message}
							</div>
						</div>
					</div>
			</c:if>
			<div class="row">

				<sf:form class="form-horizontal" modelAttribute="supplier"
					action="${contextRoot}/POS/supplier" method="POST"
					enctype="multipart/form-data">
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label class="control-label col-md-4" for="sname">Enter
									Supplier Name <span class="style2">*</span>
								</label>
								<div class="col-md-8">
									<sf:input type="text" path="sname" id="sname"
										placeholder="Supplier Name" class="form-control" />
									<sf:errors path="sname" cssClass="help-block" element="em" />
								</div>

							</div>

						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label class="control-label col-md-4" for="gstno">Enter
									GST Number <span class="style2">*</span>
								</label>
								<div class="col-md-8">
									<sf:input type="text" path="gstno" id="gstno"
										placeholder="Supplier Name" class="form-control" />
									<sf:errors path="gstno" cssClass="help-block" element="em" />
								</div>

							</div>

						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label class="control-label col-md-4" for="add1">Address
									LIne 1 <span class="style2">*</span>
								</label>
								<div class="col-md-8">
									<sf:input type="text" path="add1" id="add1"
										placeholder="Address Line 1" class="form-control" />
									<sf:errors path="add1" cssClass="help-block" element="em" />
								</div>

							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label class="control-label col-md-4" for="add1">Address
									LIne 2 <span class="style2">*</span>
								</label>
								<div class="col-md-8">
									<sf:input type="text" path="add2" id="add2"
										placeholder="Address Line 2" class="form-control" />
									<sf:errors path="add2" cssClass="help-block" element="em" />
								</div>

							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label class="control-label col-md-4" for="add1">City <span
									class="style2">*</span>
								</label>
								<div class="col-md-8">
									<sf:input type="text" path="city" id="city" placeholder="City"
										class="form-control" />
									<sf:errors path="city" cssClass="help-block" element="em" />
								</div>

							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label class="control-label col-md-4" for="distrcit">District
									: <span class="style2">*</span>
								</label>
								<div class="col-md-8">
									<sf:input type="text" path="distrcit" id="distrcit"
										placeholder="District" class="form-control" />
									<sf:errors path="distrcit" cssClass="help-block" element="em" />
								</div>

							</div>
						</div>
					</div>


					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label class="control-label col-md-4" for="State">State
									<span class="style2">*</span>
								</label>
								<div class="col-md-8">
									<sf:input type="text" path="State" id="State"
										placeholder="State" class="form-control" />
									<sf:errors path="State" cssClass="help-block" element="em" />
								</div>

							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label class="control-label col-md-4" for="pincode">Pincode</span>
								</label>
								<div class="col-md-8">
									<sf:input type="text" path="pincode" id="pincode"
										placeholder="pincode" class="form-control" />
									<sf:errors path="pincode" cssClass="help-block" element="em" />
								</div>

							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-4">
							<div class="form-group">
								<label class="control-label col-md-4" for="phoneno">phoneno
									<span class="style2">*</span>
								</label>
								<div class="col-md-8">
									<sf:input type="text" path="phoneno" id="phoneno"
										placeholder="phoneno" class="form-control" />
									<sf:errors path="phoneno" cssClass="help-block" element="em" />
								</div>

							</div>
						</div>
						<div class="col-lg-4">
							<div class="form-group">
								<label class="control-label col-md-4" for="mobile">Pincode</span>
								</label>
								<div class="col-md-8">
									<sf:input type="text" path="mobile" id="mobile"
										placeholder="mobile" class="form-control" />
									<sf:errors path="mobile" cssClass="help-block" element="em" />
								</div>

							</div>
						</div>

						<div class="col-lg-4">
							<div class="form-group">
								<label class="control-label col-md-4" for="email">email</span>
								</label>
								<div class="col-md-8">
									<sf:input type="text" path="email" id="email"
										placeholder="email" class="form-control" />
									<sf:errors path="email" cssClass="help-block" element="em" />
								</div>

							</div>
						</div>
					</div>



					<div class="row">
						<div class="col-lg-offset-8 col-lg-4">
							<div class="form-group">

								<div class="col-md-offset-4 col-md-8">

									<input type="submit" name="submit" value="Submitt"
										class="btn btn-primary" />
									<sf:hidden path="sid"></sf:hidden>
								</div>

							</div>
						</div>



					</div>


				</sf:form>
			</div>
			<div class="row">

				<div class="col-lg-12">
					<table id="supplierdata" class="table table-responsive table-striped table-borderd">
						<thead>
							<tr>
								<th>Id</th>
								<th>Supplier Name</th>
								<th>GST Number</th>
								<th>Address Line 1</th>

								<th>Address Line 2</th>
								<th>City</th>
								<th>District</th>
								<th>State</th>
								<th>Pin</th>
								<th>Phone No.</th>
								<th>Mobile No.</th>
								<th>e-mail</th>
								<th>edit</th>



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