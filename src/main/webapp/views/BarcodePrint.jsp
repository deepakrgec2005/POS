 <div class="row">
<div class="col-lg-12">
 
<form name="frm-example" id="frm-example">
<table width="100%" class="table table-responsive table-striped table-borderd" id="barcodeprinttable">
<thead>
 <tr>
      <td colspan="7" style="font-size:16px;color:#0000FF">Purchase ID : ${prid}
      <input type="hidden" id="priddet" value="${prid}"/>
      <input type="hidden" id="ptopre" value="${oppur}"/>
      </td>
    </tr>
    <tr>
      <td colspan="7">
         
         <span style="padding-left:20%"> <span style="font-size:16px"><b>Print type: </b></span>
        <input name="GSTRATE" type="radio" id="GSTRATE"  value="W" checked/>
        <span>Rate after GST (MRP)</span> 
        <input type="radio" name="GSTRATE" id="GSTRATE"   value="O"/> 
        <span>Rate before GST</span></span></td>
      </tr>
<tr>
  <th><input type="checkbox" name="select_all" value="1" id="select-all" /></th>
      <th>Barcode </th>
      <th>Product Name </th>
      
      <th>No of Barcode </th>
      <th>Rate before GST</th>
      <th>GST</th>
      <th>Rate after GST (MRP)</th>
</tr>
</thead>
 <tfoot>
    <tr>
      <td colspan="7">
	  
	         	  	<div id="formsubmitbutton" align="center">
        <input name="submit" type="button" value="Print" id="btnClick" disabled="disabled" style="font-size:16px;font-weight:800 "  />
</div>
<div id="buttonreplacement" style="margin-left:30px; display:none;">
<img src="../images/preload.gif" alt="loading..." >
</div>
</td>
      </tr>
  </tfoot>
</table>
 <!-- <inpurt type="hidden" id="barcodevalue" value=""/>
 <inpurt type="hidden" id="textvalue" value=""/>  -->
 
 <input type ="hidden" id="prhiddenvalue" value="${prid}"/>
</form>
</div>
</div>