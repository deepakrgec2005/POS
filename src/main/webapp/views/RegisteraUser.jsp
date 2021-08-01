<div class="container">
	<div class="row">
		<div class="col-sm-6"  >
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Sign Up -Personal</h4>
				</div>
				<div class="panel-body">
				 
				<sf:form action="/POS/register" method="POST" class="raw g-3" enctype="multipart/form-data" border="1" id="regform" modelAttribute="userd">
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <sf:input name="" class="form-control" placeholder="First name" type="text" path="firstName" />
        <sf:errors path="firstName" cssClass="help-block" element="em" />
    </div> <!-- form-group// -->
    
    <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <sf:input name="" class="form-control" placeholder="Last name" type="text" path="lastName"/>
         <sf:errors path="lastName" cssClass="help-block" element="em" />
    </div> <!-- form-group// -->
    
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <sf:input name="" class="form-control" placeholder="Email address" type="email" path="email"/>
         <sf:errors path="email" cssClass="help-block" element="em" />
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
		</div>
		<select class="custom-select" style="max-width: 120px;">
		    <option selected="">+91</option>
		     
		</select>
    	<sf:input name="" class="form-control" placeholder="Phone number" type="text" path="contactNumber"/>
          
    </div> <!-- form-group// -->
 
 <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fas fa-laptop"></i> </span>
		</div>
        <sf:input class="form-control" placeholder="User Id" type="username" path="username" />
         <sf:errors path="username" cssClass="help-block" element="em" />
    </div> <!-- form-group// -->
 
 
 
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <sf:input class="form-control" placeholder="Create password" type="password" path="password" id="pass" />
         <sf:errors path="password" cssClass="help-block" element="em" />
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input class="form-control" placeholder="Repeat password" type="password" id="repass" onblur="passwordcheck();">
    </div> <!-- form-group// -->                                      
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block" id="regformsub"> Create Account  </button>
    </div> <!-- form-group// -->      
     <div class="form-group">
     <sf:hidden id="orgdetail" path="orgdetail"/>
     <sf:hidden id="role" path="role" value="ROLE_USER"/> 
     </div>                                                                
</sf:form>
				 
				</div>
			</div>


		</div>

	</div>
	<div class="row">
	<div class="col-lg-12">
	<table id="userdtdata" class="table table-responsive table-striped table-borderd">
						<thead>
							<tr>
								<th>UserId</th>
								<th>Operator Name</th>
								<th>User Type</th>
								<th>Mobile</th>

								<th>Active?(Y/N)</th>
								 <th> Act/Dect</th>
								 <th>Change Password</th>
							</tr>
						</thead>
					</table>
	
	
	</div> 
	</div>
	 <div class="modal fade" id="changepass" role="dialog"
		tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Change Password</h4>
				</div>
				<div class="modal-body">
					<sf:form id="changePasswordForm" modelAttribute="changepass"
						action="${contextRoot}/POS/changepass" method="POST"
						class="form-horizontal">
						<div class="form-group">
							<label for="password" id="password" class="control-label col-md-4" />New Password</label>
							 <div class="col-md-8">
								<sf:input type="text" path="password" id="newpass" 
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