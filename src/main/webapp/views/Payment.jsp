<div class="container ">
	<div class="row">
		 		<div class="col-lg-12">
			<div class="row">

				<sf:form class="row g-3 myformR" modelAttribute="paydetail" 
					action=" " method="POST"
					enctype="multipart/form-data" border="1" id="paydt">
					<div class="col-md-12">
					 
								<sf:hidden id="paydate" path="paydate" />
							<sf:errors path="paydate" cssClass="help-block" element="em" />
					</div>
					<div class="col-md-6">
					
					<label class="form-label"  > Bill Number  </label>
							<sf:input type="text"   id="billno" path="billno"
							placeholder="Customer Name." class="form-control" readonly="true" />
						 <sf:errors path="billno" cssClass="help-block" element="em" />
					</div>
					<div class="col-md-6"> 
						 
				 
					 
						<label class="form-label" > Customer Name 
						</label>
						<sf:input type="text"   id="csname" path="csname"
							placeholder="Customer Name." class="form-control"  />
						<sf:errors path="csname" cssClass="help-block" element="em" />
					</div>

					<div class="col-md-12">

						<label class="form-label" >Pay Mode <span
							class="style2">*</span>
						</label>
						<sf:radiobutton path="pymd" value="4" id="4" checked="checked"/>
						 
	Cash
	<sf:radiobutton path="pymd"  value="5" id="5"/>Cheque
	<sf:radiobutton path="pymd"  value="6" id="6"/>Demand Draft
	<sf:radiobutton path="pymd"  value="7" id="7"/>Credit card
	<sf:radiobutton path="pymd"  value="8" id="8"/>Debt card
	<sf:radiobutton path="pymd"  value="9" id="9"/>Credit bill	
	<sf:radiobutton path="pymd"  value="10" id="10"/>
	PayTM / UPI
	 
	  
	<sf:radiobutton path="pymd"  name="pymd" value="11" id="11" />Other Mode

					</div>
					<div class="col-md-6">
					<label class="form-label"  > Net Payable amount  </label>
						<input type="text"  id="ntpay" placeholder="Supplier Invoice No." value="${billpay.outstanding}" class="form-control" readonly="true" />
						 
					</div>
					<div class="col-md-6"> 
						 
				 
					 
						<label class="form-label"  > Collected Amount: 
						</label>
						<sf:input type="text"   id="collectedamt" path="amountpaid"
							placeholder="Supplier Invoice No." class="form-control"  value="${billpay.outstanding-billpay.payamt}" onblur="clexch();"/>
						 <input type="hidden" id="depositamt" value="${billpay.payamt}"/>
					</div>
<div class="col-md-6">
					<label class="form-label"  > Remarks (if any)  </label>
						<sf:input type="text"   id="remarks" path="remarks"
							placeholder="Remarks." class="form-control"   />
						 
					</div>
					<div class="col-md-6"> 
						 
				 
					 
						<label class="form-label"  > Exchange cash (Return): 
						</label>
						<input type="text"   id="exchg"
							placeholder="0" class="form-control" value="0.0"  readonly="true"/> 
						
					 
						 <sf:hidden  id="user" path="user"/>
						 <sf:hidden  id="bid" path="bid"/>
						  
						 
					</div>
					<div class="col-md-12 text-center"> 
					<input type="button" id="pay" name="pay" value="pay" ${billpay.outstanding-billpay.payamt==0.0?'hidden="true"' : ''}class="btn btn-primary" onclick="cashcollected();"/>
					<input type="submit" id="print"name="print" value="print"class="btn btn-primary" ${billpay.outstanding-billpay.payamt!=0.0?'hidden="true"' : ''}  /> 
					</div>
					</sf:form>
					<br>
 
 
 
			</div>
		</div >
		</div>
		<div class="row">
		 
		<div class="col-lg-12">
		<table id="paydttb" class="table table-responsive table-striped table-borderd" style="width:100%"   >
		<thead>
		
		
							<tr>
								<th class="thcl">Transaction Id</th>
								<th class="thcl">Collected Amt</th>
								<th class="thcl">Pay mode</th>
								<th class="thcl">Received Date</th>
								<th class="thcl">Remarks</th>
								 
							</tr>
							<tr>
		<td colspan="2" class="text-center"><b>Total Amount Rs :-</b></td>
		 <td></td>
		 <td><b>Outstanding Amount Rs:-</b></td>
		 <td></td>
		</tr>
							</thead>
							</table>
		</div>
	</div>
</div>