<div class="row">
<div class="col-lg-12">
 

<sf:form class="row g-3" modelAttribute="rsbilll" action=" " method="POST" enctype="multipart/form-data" border="1" id="formrsup"> 
					<div class="col-md-6">
						 <label class="form-label" >Product Name :  
						</label>
             		<input type="text" readonly="true" id="rsprname" value="${rsbilll.prname.PName}"/>
					</div>
					 
					<div class="col-md-6">
						<label class="form-label" for="barcode">Barcode</label>
						<sf:input type="text" readonly="true" id="rsbarcode" path="barcode"/>
					 
					</div>
					 <div class="col-md-12">
						<label class="form-label">Balance</label>
						<input type="text" readonly="true" id="rsbalance" value="${stkdt.tqty}"/>
					 
					</div>
					 
					<div class="col-md-6">
						<label class="form-label" for="bprice">Base Price</label>
						<sf:input type="text" readonly="true" id="rsprice" path="bprice"/>
					 
					</div>
					 
					 <div class="col-md-6">
						<label class="form-label">MRP</label>
						<input type="text" readonly="true" id="rsmrp" value="${stkdt1.mrp}"/>
						
					 </div>
				 
					
						 <div class="col-md-6">
						<label class="form-label" for="pcs">Pcs  
						</label>
						<sf:input type="text" id="rspcs" path="pcs" onblur="pcsqty()" placeholder="Pcs"/>
					 <input type="hidden" id="ppcs" value="${rsbilll.pcs}"/>
					</div>
					<div class="col-md-6">
					<label class="form-label" for="qty">Qty
						</label>
						 
 <c:choose>
    <c:when test="${rsbilll.prname.PType=='1'}">
       <sf:input type="text" id="rsqty" readonly="true" path="qty" placeholder="qty"/> 
        </c:when>    
    <c:otherwise>
        <sf:input type="text" id="rsqty" path="qty" onblur="pcsqty1()" placeholder="qty" />
    </c:otherwise>
</c:choose>
<input type="hidden" id="pqty" value="${rsbilll.qty}"/>
    		</div>
					 
				 <div class="col-md-6">
						<label class="form-label" for="net">Net  
						</label>
						<sf:input type="text" id="rsnet" path="net"   placeholder="Pcs"/>
					 
					</div>
					 <div class="col-md-6">
						<label class="form-label" for="payable">Payable  
						</label>
						<sf:input type="text" id="payable" path="payable"   placeholder="Pcs"/>
					 
					</div>	
					<div class="col-md-12">
					<sf:input type="hidden" id="rsid" path="billdid"/>
					<sf:input type="hidden" id="prname" path="prname"/>
					<sf:input type="hidden" id="discount" path="discount"/>
					<sf:input type="hidden" id="gst" path="gst"/>
					<sf:input type="hidden" id="bill" path="bill"/>
					 
					<input type="button" id="rsbt" value="Update Value" onclick="rsbillupdfr()"/>
					</div>
					 
				 	
				 
</sf:form>
</div>
</div>