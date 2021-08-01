<div class="container">
<div class="row">
<div class="col-lg-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
<div class="col-lg-9">
 
<form name="frm-stock" id="frm-stock">
<table width="100%" class="table table-responsive table-striped table-borderd" id="stocktable" border="1">
<thead>
   
    <tr>
      <td colspan="9">
         <div class="text-center"> 
         <input type="button" name="submit" class="btn btn-primary" id="btnClickstock" value="Print-All-Barcode" disabled="disabled" style="font-size:16px;font-weight:800 "  />
         
      </div>
      </tr>
<tr>
  <th> <input type="checkbox" name="select_allOp" value="1" id="select-allOp" /></th>
      <th>Opening Id </th>
      <th>Type </th>
      
      <th>Stock On</th>
      <th>Total Amount</th>
      <th>No. of Record</th>
      <th> </th>
      <th>Stock Report </th>
      <th><a href="${contextRoot}/POS/stockOpening?opn_id=0" class="btn btn-xs btn-primary " role="button">Add New Batch</a> </th>
</tr>
</thead>
  
</table>
 <!-- <inpurt type="hidden" id="barcodevalue" value=""/>
 <inpurt type="hidden" id="textvalue" value=""/>  -->
 
  
</form>
</div>
</div>
</div>