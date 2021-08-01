<div class="row">
<div class="col-lg-12">
 

<sf:form class="row g-3" modelAttribute="purrege"
					action=" " method="POST"
					enctype="multipart/form-data" border="1" id="formstkup"> 
					<div class="col-md-12 text-center">
						 <label class="form-label" for="barcode">Barcode  
						</label>
             		<sf:input type="text"    id="barcode" path="barcode" readonly="true"/>
					</div>
					 
					<div class="col-md-6">
						<label class="form-label" for="pl">Product ID</label>
						<sf:input type="text" readonly="true" id="pl" path="pl"/>
					 
					</div>
					 <div class="col-md-6">
						<label class="form-label" >Product Name</label>
						<input type="text"  readonly="true" id="plname" value="${purrege.pl.PName}"/>
					 
					</div>
					
					<div class="col-md-6">
						<label class="form-label" for="supid">Supplier ID</label>
						<sf:input type="text" readonly="true" id="supid" path="supid"/>
					 
					</div>
					 <div class="col-md-6">
						<label class="form-label" >Supplier Name</label>
						<input type="text"  readonly="true" id="spname" value="${purrege.supid.sname}"/>
					 
					</div>
					
					
					<div class="col-md-6">
						<label class="form-label" for="inid">Opening Stock Id</label>
						<sf:input type="text"  readonly="true" id="iniddetailid" path="stkid"/>
					 
					</div>
					 
					 
					<div class="col-md-6">
					<label class="form-label"  >Product Type</label>
						<input type="text"  disabled="true" id="pupptype" value="${purrege.pl.PType=='1'?'Countable':'Measurable'}"/>
					
					</div>
					<div class="col-md-6">
					<label class="form-label"  >GST On Sale</label>
						<input type="text"  disabled="true" id="pupgstons" value="${purrege.pl.GSTonSale }"/>
					
					</div>
					<div class="col-md-6">
					<label class="form-label"  >GST Percentage</label>
						<input type="text"  disabled="true" id="pupgstp" value="${purrege.pl.GSTP }"/>
					
					</div>
					<div class="col-md-6">
					<label class="form-label"  >Max GST Percentage</label>
						<input type="text"  disabled="true" id="pupgstpm" value="${purrege.pl.GSTPM }"/>
					
					</div>
					
					<!-- End -->
					
					
						 <div class="col-md-6">
						<label class="form-label" for="pcs">Pcs  
						</label>
						<sf:input type="text"  id="pcs" path="pcs"  placeholder="Pcs"  />
					 
					</div>
					<div class="col-md-6">
					<label class="form-label" for="qty">Qty
						</label>
						 
 <c:choose>
    <c:when test="${purrege.pl.PType=='1'}">
       <sf:input type="text" id="qty" readonly="true" path="qty"    placeholder="qty" /> 
        </c:when>    
    <c:otherwise>
        <sf:input type="text" id="qty"  path="qty"   placeholder="qty"   />
    </c:otherwise>
</c:choose>
    		</div>
					<div class="col-md-6">
					<label class="form-label" for="bvalue">Base Price </span>
						</label>
						<sf:input type="text" path="bvalue" id="bvalue" onblur="basemrpcalc()"  placeholder="Base Price"   />
						 
					
					</div>
					<div class="col-md-6">
					<label class="form-label" for="mrp">MRP </span>
						</label>
						<sf:input type="text" path="mrp" id="pupmrp" onblur="mrpbasecalc()" placeholder="MRP"   />
				 	</div>
				 	 
					 
					
					<div class="col-md-12">
					<input type="button" value="Update Value" onclick="formupdatesub('opening');">
					</div >
					 
				 	
				 
</sf:form>
</div>
</div>