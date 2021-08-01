

<html>
<head>
<title>::KIMIS ::PURCHASE</title>
<link rel="stylesheet" type="text/css"
	href="../stylesheets/pmegpNew.css" />
<script language="javascript" src="../js/jquery-1.12.4.js"></script>
<script language="javascript" src="../js/ModalPopupWindow.js"></script>

<script type="text/javascript" src="../js/inlinemsg.js"></script>
<script type="text/javascript" src="../js/datetimepicker_css.js"></script>
<link rel="stylesheet" type="text/css" href="../js/tautocomplete.css" />

<script src="tautocomplete.js" type="text/javascript"></script>
<style>
.tooltip {
	position: relative;
	display: inline-block;
}

.tooltip .tooltiptext {
	visibility: hidden;
	width: 300%;
	background-color: #CCCCCC;
	color: #000000;
	text-align: center;
	border-radius: 6px;
	padding: 10px 5px;
	position: absolute;
	z-index: 1;
	top: -5px;
	left: 110%;
}

.tooltip .tooltiptext::after {
	content: " ";
	position: absolute;
	top: 50%;
	right: 100%; /* To the left of the tooltip */
	margin-top: -5px;
	border-width: 5px;
	border-style: solid;
	border-color: transparent #CCCCCC transparent transparent;
}

.tooltip:hover .tooltiptext {
	visibility: visible;
}

.tooltip_left {
	position: relative;
	display: inline-block;
}

.tooltip_left .tooltiptext_left {
	visibility: hidden;
	width: 450%;
	background-color: #CCCCCC;
	color: #000000;
	text-align: center;
	border-radius: 6px;
	padding: 5px 0;
	position: absolute;
	z-index: 1;
	top: -5px;
	right: 110%;
}

.tooltip_left .tooltiptext_left::after {
	content: "";
	position: absolute;
	top: 50%;
	left: 100%;
	margin-top: -5px;
	border-width: 5px;
	border-style: solid;
	border-color: transparent transparent transparent #CCCCCC;
}

.tooltip_left:hover .tooltiptext_left {
	visibility: visible;
}
</style>

<script language="javascript">
 
 
  
document.onkeypress = function (event) {

    event = (event || window.event);
    if ( event.which == 13 ) { 
   save();
    }
}
 

 
 
 function sup_list() {
                var text2 = $("#Text3").tautocomplete({
                    width: "600px",
                    columns: ['Supplier Name','Supplier ID'],
                    ajax: {
                        url: "supplier_nmlist.jsp",
                        type: "GET",
                        data: function () {
                            return [{ test: text2.searchdata() }];
                        },
                        success: function (data) {
                            
                            var filterData = [];

                            var searchData = eval("/" + text2.searchdata() + "/gi");

                            $.each(data, function (i, v) {
                                if ((v.id.search(new RegExp(searchData)) != -1)   ||  (v.NAME.search(new RegExp(searchData)) != -1)   ) {
                                    filterData.push(v);
                                }
                            });
                            return filterData;
                        }
                    },
                    onchange: function () {
                        $("#ta-txt").html(text2.text());
                        $("#taid").html(text2.id());
						$('#CUSTCODE_SUPP').val(text2.id());
						showProdtwo();
					//showProduct();
					 //document.getElementById("EXPDATE").focus();
                    }
                });
				}//end of suplistfunction
           // });

		
		
		
		

     function   showProductList(){
                var text2 = $("#Text2").tautocomplete({
                    width: "500px",
                    columns: ['Product Name','Code','Group','Discount','GST %','Count/Meas'],
                    ajax: {
                        url: "jsontest.jsp",
                        type: "GET",
                        data: function () {
                            return [{ test: text2.searchdata() }];
                        },
                        success: function (data) {
                            
                            var filterData = [];

                            var searchData = eval("/" + text2.searchdata() + "/gi");

                            $.each(data, function (i, v) {
                                if ((v.ID3.search(new RegExp(searchData)) != -1)   ||  (v.NAME.search(new RegExp(searchData)) != -1)   ) {
                                    filterData.push(v);
                                }
                            });
                            return filterData;
                        }
                    },
                    onchange: function () {
                        $("#ta-txt").html(text2.text());
                        $("#taid").html(text2.id());
						$('#ID3S').val(text2.id());
				//	showProduct();
				showProdtwo();
                    }
                });
           }
			</script>

<script language="javascript">
			
 var xmlHttp   
      var xmlHttp 
      function showProdtwo(){ 
	  try
    {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
    }
  catch (e)
    {
    // Internet Explorer
    try
      {
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
      }
    catch (e)
      {
      try
        {
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
      catch (e)
        {
        alert("Your Browser Don't Support AJAX!");
        return false;
        }
      }
    }
	 
	 
      vID1=document.form.CUSTCODE_SUPP.value;
	  str=document.form.ID3S.value;
   // alert(vID1);
	//alert(str);
	
      var url="sup_state_list.jsp"; 
      url +="?count=" +vID1+"&ID3="+str;
	  
      xmlHttp.onreadystatechange = ProductTwoChange; 
      xmlHttp.open("post", url, true); 
      xmlHttp.send(null); 
      } 
	  
      function ProductTwoChange(){    
      if (xmlHttp.readyState==4 || .readyState=="complete"){   
	  var x=document.getElementById('ID3_COUNT');
	  x.innerHTML=xmlHttp.responseText;
	  
	 str=document.form.ID3S.value;
	 
	 if( !( str=="" || str=="0" ) ){
	  	  
	  var CCOUNT_MESUR=document.getElementById("CCOUNT_MESUR").value;

	  if( CCOUNT_MESUR == "1"){
	  document.getElementById("QUANTITY").disabled =false;
	  }else{
	  document.getElementById("QUANTITY").disabled =true;
	  document.getElementById("QUANTITY").value ="";
	  }
	  document.getElementById("PIECES").focus();


 var VGSTONAMT = document.getElementById("GST_ON_AMT_P").value; //GST_ON_AMT_P ;// Number(document.getElementById("taxid").rows[0].cells.namedItem("GSTONAMT").innerHTML);
 var VGSTMAX = document.getElementById("GST_PER_MAX_P").value; //GST_PER_MAX_P;// Number(document.getElementById("taxid").rows[0].cells.namedItem("GSTMAX").innerHTML);
 var VGSTMIN = document.getElementById("GST_PER_P").value; //GST_PER_P;// Number(document.getElementById("taxid").rows[0].cells.namedItem("GSTMIN").innerHTML);
 var VHSN = document.getElementById("HSNCODE_P").value; // Number(document.getElementById("taxid").rows[0].cells.namedItem("HSNCODE").innerHTML);

document.getElementById('GSTMAX').innerHTML=VGSTMAX;
document.getElementById('GSTONAMT').innerHTML=VGSTONAMT;
document.getElementById('GSTMIN').innerHTML=VGSTMIN;
document.getElementById('HSNCODE').innerHTML=VHSN;


}


	// alert (xmlHttp.responseText);
      } //statechane1 function end   
      }//main function end.

	 
 
</script>


<script language="javascript">


function getTaxValue(net){

 var pcs= document.getElementById("PIECES").value;
 var branch_st= document.getElementById("BR_STATE").value;
 var current_st= document.getElementById("SUP_STATE").value;
 var net_per_pcs = document.getElementById("RATE").value;
 document.getElementById("HSNCODE_P").value=VHSN;
 var num=Number(branch_st) -Number(current_st);
 var cess_per=0;
  var VCESS = document.getElementById("CESS_P").value; 
 var VCESSMAX = document.getElementById("CESS_MAX_P").value; 
 var VCESSONAMT = document.getElementById("CESS_ON_AMT_P").value; 

 var VGSTONAMT = document.getElementById("GST_ON_AMT_P").value; 
 var VGSTMAX = document.getElementById("GST_PER_MAX_P").value; 
 var VGSTMIN = document.getElementById("GST_PER_P").value; 
 var VHSN = document.getElementById("HSNCODE_P").value; 

document.getElementById('GSTMAX').innerHTML=VGSTMAX;
document.getElementById('GSTONAMT').innerHTML=VGSTONAMT;
document.getElementById('GSTMIN').innerHTML=VGSTMIN;
document.getElementById('HSNCODE').innerHTML=VHSN;
/*
var vtax = Number(VCESS) * Number(net) / 100;
 document.getElementById("ORG_RATE").value =Number(vtax).toFixed(2);

*/

if( Number(VCESSONAMT) > 0) { 

if( Number(net) > Number(VCESSONAMT)){
cess_per = Number(VCESSMAX) ;

}else{
cess_per = Number(VCESS) ;

}

}else{
cess_per = Number(VCESS);

}

var vtax = Number(cess_per) * Number(net) / 100;
 document.getElementById("ORG_RATE").value =Number(vtax).toFixed(2);



var GST;

if(VGSTONAMT > 0) { 

if(net > VGSTONAMT){
GST = VGSTMAX ;
}else{
GST = VGSTMIN ;
}

}else{
GST = VGSTMIN;
}

var VGST = Number(GST)   * Number(net) / 100;


 if( num == 0 || num == '0'){ 
 
 document.getElementById("CGST_PER").value = GST / 2;
 document.getElementById("SGST_PER").value = GST / 2;
 
 document.getElementById("CGST_AMT").value = (VGST /2).toFixed(2);
document.getElementById("SGST_AMT").value = (VGST/2).toFixed(2);
}else{

//alert(net);



 document.getElementById("IGST_PER").value = GST;
document.getElementById("IGST_AMT").value =((VGST/2) +(VGST/2)).toFixed(2);   //(VGST).toFixed(2);

}
document.getElementById("TAXABLENET").value = net_per_pcs;
document.getElementById("PAYABLENET").value =Math.round( Number(net) + Number(VGST) + Number(vtax));

}


</script>

<script language="javascript">
function cal_com_radio(){
var val=document.getElementById("checkRadio").checked;
if(val==true){
          
  document.getElementById("COMM_AMT").readOnly = true;
  document.getElementById("MANG_AMT").readOnly = true;
  document.getElementById("MDA_COMMAMT").readOnly = true;
  
   document.getElementById("COMM").readOnly = false;
   document.getElementById("MANG_CHR").readOnly = false;
   document.getElementById("MDA_COMM").readOnly = false;
  }else{
  document.getElementById("COMM_AMT").readOnly = false;
  document.getElementById("MANG_AMT").readOnly = false;
  document.getElementById("MDA_COMMAMT").readOnly = false;
  
   document.getElementById("COMM").readOnly = true;
   document.getElementById("MANG_CHR").readOnly = true;
   document.getElementById("MDA_COMM").readOnly = true;
	}
}


function calMastGST(){
var ICGST_AMT= document.getElementById("ICGST_AMT").value;
var ISGST_AMT=document.getElementById("ISGST_AMT").value;
var IIGST_AMT= document.getElementById("IIGST_AMT").value;

var caltot=Number(ICGST_AMT) + Number(ISGST_AMT)+ Number(IIGST_AMT);

document.getElementById('TOT_GST').value=caltot.toFixed(2);


}


function calOthersCharges() {

var packchr= document.getElementById("PACK_CHR").value;
var postchr=document.getElementById("POST_CHR").value;
var miscchr= document.getElementById("MISC_CHR").value;
var insurchr=document.getElementById("INSUR_CHR").value;
//var stax=document.getElementById("STAX").value;


var tot_charges=Number(packchr)+Number(postchr)+Number(miscchr)+Number(insurchr);

document.getElementById('TOT_CHARGES_AMT').value=tot_charges.toFixed(2);
//calCommP(tot_charges);
}

function calCommP() {
var ICGST_AMT= document.getElementById("ICGST_AMT").value;
var ISGST_AMT=document.getElementById("ISGST_AMT").value;
var IIGST_AMT= document.getElementById("IIGST_AMT").value;



var commp= document.getElementById("COMM").value;
var invt=document.getElementById("INVOICE_TOT").value;
var mangchr= document.getElementById("MANG_CHR").value;
var mdacomm=document.getElementById("MDA_COMM").value;

 var c_amt= document.getElementById("COMM_AMT").value ;
 var mang_amt= document.getElementById("MANG_AMT").value ;
 var mda_amt= document.getElementById("MDA_COMMAMT").value ;

var packchr= document.getElementById("PACK_CHR").value;
var postchr=document.getElementById("POST_CHR").value;
var miscchr= document.getElementById("MISC_CHR").value;
var insurchr=document.getElementById("INSUR_CHR").value;
var val=document.getElementById("checkRadio").checked;

if(val==true){
//alert("%");
var commamt=Number(commp)*Number(invt)/100;
var mangamt=Number(mangchr)*Number(invt)/100;
var mdaamt=Number(mdacomm)*Number(invt)/100;
var calc_com=commamt+mdaamt+mangamt;
document.getElementById('COMM_AMT').value=commamt.toFixed(2);
document.getElementById('MANG_AMT').value=mangamt.toFixed(2);
document.getElementById('MDA_COMMAMT').value=mdaamt.toFixed(2);

}else{
//alert("Rs.");
var comm_per=Number(c_amt)*100/Number(invt);
var mang_per=Number(mang_amt)*100/Number(invt);
var mda_per=Number(mda_amt)*100/Number(invt);
var calc_com=Number(c_amt)+Number(mang_amt)+Number(mda_amt);
document.getElementById('COMM').value=comm_per.toFixed(8);
document.getElementById('MANG_CHR').value=mang_per.toFixed(8);
document.getElementById('MDA_COMM').value=mda_per.toFixed(8);
}
var tot_comm=calc_com;


var tot_charges=Number(packchr)+Number(postchr)+Number(miscchr)+Number(insurchr);
var caltot=Number(ICGST_AMT) + Number(ISGST_AMT)+ Number(IIGST_AMT);
//document.getElementById("COMM_AMT").innerHTML=calcc;
document.getElementById('COMM_AMT').value=commamt.toFixed(2);
document.getElementById('MANG_AMT').value=mangamt.toFixed(2);
document.getElementById('MDA_COMMAMT').value=mdaamt.toFixed(2);
document.getElementById('TOT_COMM_AMT').value=Math.round(tot_comm);

var grand_tot= Number(invt)  + Number(tot_charges) + Number( caltot)  - Number(tot_comm);

document.getElementById('GRAND_TOT').value=Math.round(grand_tot);
document.getElementById('GRAND_TOTS').innerHTML=Math.round(grand_tot).toFixed(2);

var gamt=document.getElementById("GAMOUNT").value;
var less=document.getElementById("LESS").value;
var amt_less=Number(invt) * Number(less) /100;

var mgross_amt=Number(gamt) - Number(amt_less);
var net_earned=Number(mgross_amt) - Number(invt) ;

document.getElementById('AMT_LESS').innerHTML=amt_less.toFixed(2);
document.getElementById('MGROSS').innerHTML=mgross_amt.toFixed(2);
document.getElementById('NET_EARNED').innerHTML=net_earned.toFixed(2);
document.getElementById('TOT_AMT1').innerHTML=Number(invt).toFixed(2);
document.getElementById('TOT_AMT2').innerHTML=Number(gamt).toFixed(2);
}




    function ShowHideDiv(chkPassport) {
            var dvPassport = document.getElementById("dvPassport");
            dvPassport.style.display = chkPassport.checked ? "block" : "none";
			
        }
		
function mattressCheck(){
		
		  var rate =document.getElementById("RATE").value;
		  var pcs= document.getElementById("PIECES").value;
		  var qty= document.getElementById("QUANTITY").value;
		  var count=document.getElementById("CCOUNT_MESUR").value;

var mamount =0;


      if(count == "1"){
	
		 mamount=Number(pcs)*Number(rate)*Number(qty);
		document.getElementById("MATAMT").innerHTML=mamount.toFixed(2);
		}
		else{
		 mamount=Number(pcs)*Number(rate);
			document.getElementById("MATAMT").innerHTML=mamount.toFixed(2);
		}
			
			getMarginDoc();
		}
		
		
	function getMarginDoc(){
	//alert();
		 var rate =document.getElementById("RATE").value;
		 var margin =document.getElementById("MARGIN").value;
		 var margin_lpc =document.getElementById("MARGIN_LPC").value;
		 var rfc =document.getElementById("RFC").value;
		var margin_insur =document.getElementById("MARGIN_INSUR").value;
		 var margin_strec =document.getElementById("MARGIN_STREC").value;
		  var margin_excess =document.getElementById("MARGIN_EXCESS").value;
		  var count=document.getElementById("CCOUNT_MESUR").value;
		  var pcs= document.getElementById("PIECES").value;
		  var qty= document.getElementById("QUANTITY").value;
		 
		 var m_rate=Number(rate)*Number(margin)/100;
		  var m_rfc=Number(rate)*Number(rfc)/100;
		  var i_rate=Number(rate)*Number(margin_insur)/100;
		   var m_othr=Number(margin_excess);
		    var st_rate=Number(rate)*Number(margin_strec)/100;
			
			var cal_rate=Number(m_rate)+Number(rate)+Number(i_rate)+Number(m_rfc)+Number(m_othr)+Number(st_rate);
			//alert(cal_rate);
			//(I15*2/5000)*50
			 if(count == "1"){
			// var m_lpc=(Number(cal_rate)*Number(margin_lpc)/(Number(pcs)*Number(qty)))*Number(pcs);
			  var m_lpc=(((Number(cal_rate)*Number(margin_lpc)/(Number(pcs)*Number(qty)))*Number(pcs))/100);
			 }
			else{
			var m_lpc=(((Number(cal_rate)*Number(margin_lpc)/(Number(pcs)))*Number(pcs))/100);
			}
			 var marg_rate=Number(cal_rate) + m_lpc;
			 
			 getTaxValue(marg_rate);
			 
		 document.getElementById("M_RATE").value=m_rate.toFixed(2);
		  document.getElementById("P_RECV").value=m_rfc.toFixed(2);
		   document.getElementById("I_RATE").value=i_rate.toFixed(2);
		    document.getElementById("OTH_RATE").value=m_othr.toFixed(2);
			 document.getElementById("ST_RATE").value=st_rate.toFixed(2);
			  document.getElementById("LPCS_COM").value=m_lpc.toFixed(2);
			  document.getElementById("MARG_RATE").value=marg_rate.toFixed(2);
			  //alert(m_rate);
		}





//MARG_RATE
		
		
		
		
		
		
function getPercentagetoAmount(rname,fname) {
	 var rate =document.getElementById("RATE").value;
	 fnmval=0;   // get list of radio buttons with specified name
    var radios = form.elements[rname];
    var i=0;
    // loop through list of radio buttons
    for ( len=radios.length; i<len; i++) {
        if ( radios[i].checked ) { // radio checked?
           var val = radios[i].value; // if so, hold its value in val
		  break; // and break out of for loop
        }
		
    }
	
	if (val == 'P'){
	document.getElementById(""+fname+"").value= Math.round((Number(rate)* Number(document.getElementById(""+fname+"").value))/100,0);
	}
	net();
}

function upload(){




 var autoo =document.getElementById("AutoO");
 var autof =document.getElementById("AutoF");
 str3 =document.getElementById("POnOff").value;   //

		 if(str3=="RW"){
		document.getElementById("AutoF").checked=true;
		document.getElementById("AutoO").checked=false;
		 }else  if(str3=="PC"){
		
		 document.getElementById("AutoF").checked=false;
		document.getElementById("AutoO").checked=true;
		 }else {
		 document.getElementById("POnOff").value='PC';
		document.getElementById("AutoF").checked=false;
		document.getElementById("AutoO").checked=true;
		 }

}


/*

 var xmlHttp   			//RECEIVED
      var xmlHttp 
      function showProduct(){ 
	  try
    {
    xmlHttp=new XMLHttpRequest();
    }
  catch (e)
    {
    try
      {
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
      }
    catch (e)
      {
      try
        {
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
      catch (e)
        {
        alert("Your Browser Don't Support AJAX!");
        return false;
        }
      }
    }
	 

	  str1= document.getElementById("ID3S").value;
	  str = document.getElementById("ID3S").value;
	  	var autoo =document.getElementById("AutoO");
 		var autof =document.getElementById("AutoF");

		 str5 =document.getElementById("AutoO").value;
 		 str3 =document.getElementById("AutoF").value;
		 
		 if(autoo.checked == true){
		 
		 str4=str5;
		
		 }else{
		 
		 str4=str3;
		  
		 }
		 
      var url="getProduct.jsp"; 
      url +="?ID3=" +str+"&AUTOOF="+str4+"&PID3="+str1;
	 
      xmlHttp.onreadystatechange = stateChange55; 
      xmlHttp.open("post", url, true); 
      xmlHttp.send(null); 
      } 
	  
      function stateChange55(){    
      if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
	   var x=document.getElementById('GETPRODUCTLIST');
	   x.innerHTML=xmlHttp.responseText;
	   
      } //statechane1 function end   

      }//main function end.


*/


function funct_calc(){


 		var autoo =document.getElementById("AutoO");
 		var autof =document.getElementById("AutoF");

		  str5 =document.getElementById("AutoO").value;
 		 str3 =document.getElementById("AutoF").value;
		 
		 if(autoo.checked == true){
		 str4=str5;
		
		 }else{
		  str4=str3;
		 }
		  document.getElementById("POnOff").value=str4; 

}

 

function check(){

var A =document.getElementById("APPLYA");
var B =document.getElementById("APPLYB");

if(A.checked )
{
document.getElementById('APPLY').value="A";
}else{
document.getElementById('APPLY').value="B";
}
//alert(document.getElementById('APPLY').value);
}



      function showbarcode(){ 
	  try
    {
    xmlHttp=new XMLHttpRequest();
    }
  catch (e)
    {
    try
      {
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
      }
    catch (e)
      {
      try
        {
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
      catch (e)
        {
        alert("Your Browser Don't Support AJAX!");
        return false;
        }
      }
    }
	 
	 str1 = document.getElementById("COMPUTERID").value;
	  
      var u="verifybarcode.jsp"; 
      u +="?COMPUTERID=" +str1;
	  
      xmlHttp.onreadystatechange = stateChange1; 
      xmlHttp.open("post", u, true); 
      xmlHttp.send(null); 
	  
      } 
	  
      function stateChange1(){    
      if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
	   var y=document.getElementById('SHOWBARCODEERROR');
	   y.innerHTML=xmlHttp.responseText;
      } //statechane1 function end   
      }//main function end.



</script>
<script>
function save(){
  var nameRegex = /^[a-zA-Z]+(([\'\,\.\- ][a-zA-Z ])?[a-zA-Z]*)*$/; 
  var numberOnly=/^[0-9 \.-]+$/;
  
  
  
  
  var COUNTERID =document.getElementById("COUNTERID").value;
  
 if(COUNTERID == "") {
    inlineMsg('COUNTERID','Enter Counter',2);
    return false;
	}

var CUSTCODE_SUPP =document.getElementById("CUSTCODE_SUPP").value;
var PR_NO =document.getElementById("PR_NO").value;
var INVDATE =document.getElementById("INVDATE").value;
var COMM =document.getElementById("COMM").value;
var COMM_AMT =document.getElementById("COMM_AMT").value;

var MARGIN=document.getElementById("MARGIN").value;
var MARGIN_INSUR =document.getElementById("MARGIN_INSUR").value;
var RFC =document.getElementById("RFC").value;
var MARGIN_STREC=document.getElementById("MARGIN_STREC").value;
var MARGIN_LPC =document.getElementById("MARGIN_LPC").value;

var MANG_CHR =document.getElementById("MANG_CHR").value;
var MANG_AMT =document.getElementById("MANG_AMT").value;
var MDA_COMM =document.getElementById("MDA_COMM").value;
var MDA_COMMAMT =document.getElementById("MDA_COMMAMT").value;

var PACK_CHR =document.getElementById("PACK_CHR").value;
var POST_CHR=document.getElementById("POST_CHR").value;
var MISC_CHR =document.getElementById("MISC_CHR").value;
var INSUR_CHR =document.getElementById("INSUR_CHR").value;
var MARGIN_EXCESS=document.getElementById("MARGIN_EXCESS").value;




if((!numberOnly.test(COMM)&& COMM !="") ) {
    inlineMsg('COMM','Numbers only',2);
    return false;
    }
	
	
	 if(!numberOnly.test(COMM_AMT) && COMM_AMT !="") {
    inlineMsg('COMM_AMT',' Numbers only ',2);
    return false;
}
 if(!numberOnly.test(MARGIN) && MARGIN !="") {
    inlineMsg('MARGIN',' Numbers only ',2);
    return false;
}
 if(!numberOnly.test(MARGIN_INSUR)  && MARGIN_INSUR !="") {
    inlineMsg('MARGIN_INSUR',' Numbers only ',2);
    return false;
}
 if(!numberOnly.test(RFC)  && RFC !="") {
    inlineMsg('RFC',' Numbers only ',2);
    return false;
}
 if(!numberOnly.test(MARGIN_STREC)  && MARGIN_STREC !="") {
    inlineMsg('MARGIN_STREC',' Numbers only ',2);
    return false;
}
 if(!numberOnly.test(MARGIN_LPC)  && MARGIN_LPC !="") {
    inlineMsg('MARGIN_LPC',' Numbers only ',2);
    return false;
}
 
 if(!numberOnly.test(MANG_CHR)  && MANG_CHR !="") {
        inlineMsg('MANG_CHR',' Numbers only ',2);
    return false;
}

if(!numberOnly.test(MANG_AMT)  && MANG_AMT !="" ) {
    inlineMsg('MANG_AMT','Numbers only',2);
    return false;
    }
	 if(!numberOnly.test(MDA_COMM)  && MDA_COMM !="") {
    inlineMsg('MDA_COMM',' Numbers only ',2);
    return false;
}
 if(!numberOnly.test(MDA_COMMAMT)  && MDA_COMMAMT !="") {
    inlineMsg('MDA_COMMAMT',' Numbers only ',2);
    return false;
}
 
 if(!numberOnly.test(PACK_CHR)  && PACK_CHR !="") {
    inlineMsg('PACK_CHR',' Numbers only ',2);
    return false;
}
 if(!numberOnly.test(POST_CHR)  && POST_CHR !="") {
    inlineMsg('POST_CHR',' Numbers only ',2);
    return false;
}
 if(!numberOnly.test(MISC_CHR)  && MISC_CHR !="") {
    inlineMsg('MISC_CHR',' Numbers only ',2);
    return false;
}
  if(!numberOnly.test(INSUR_CHR)  && INSUR_CHR !="") {

        inlineMsg('INSUR_CHR',' Numbers only ',2);

    return false;
}
 
 if(!numberOnly.test(MARGIN_EXCESS)  && MARGIN_EXCESS !="") {
        inlineMsg('MARGIN_EXCESS',' Numbers only ',2);
    return false;
}


 
 if(PR_NO == "") {
    inlineMsg('PR_NO','Enter Invoice No',2);
    return false;
	}
	
 
 if(INVDATE == "") {
    inlineMsg('INVDATE','Enter Invoice Date',2);
    return false;
    }	
	//INVDATE
 	 function ValidateINVDATE() {
  var dtValue = $('#INVDATE').val();
  var dtRegex = new RegExp("^([0]?[1-9]|[1-2]\\d|3[0-1])-(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)-[1-2]\\d{3}$", 'i');
  return dtRegex.test(dtValue);
}

  if (ValidateINVDATE() == false) {
    inlineMsg('INVDATE','WRONG DATE OR DATE FORMAT SHOULD BE (DD-MON-YYYY)',2);
    return false;
  }

  
try {

var ID3S=document.getElementById("ID3S").value;

 if(ID3S == "" || ID3S == "0") {
    inlineMsg('ID3_COUNT','Select Product',2);
    return false;
    }

var PIECES=document.getElementById("PIECES").value;
var QUANTITY =document.getElementById("QUANTITY").value;
var RATE =document.getElementById("RATE").value;
var REB_CLOTH_VALUE= document.form.REB_CLOTH_VALUE.value;

 if(PIECES == "" || PIECES == "0") {
    inlineMsg('PIECES','Enter Pieces',2);
    return false;
    }
	if(!numberOnly.test(PIECES)) {
    inlineMsg('PIECES','Numbers only',2);
    return false;
    }
	
	var count=document.getElementById("CCOUNT_MESUR").value;

	
	if(count == "1"){
	//if(MATTRESS == "N"){
	 if(QUANTITY == "" || QUANTITY == "0") {
    inlineMsg('QUANTITY','Enter kgs/mts',2);
    return false;
    }
	if(!numberOnly.test(QUANTITY)) {
    inlineMsg('QUANTITY','Numbers only',2);
    return false;
   // }
	}
	}


 if(RATE == "" || RATE == "0") {
    inlineMsg('RATE','Enter RATE',2);
    return false;
    }
	
	if(!numberOnly.test(RATE)) {
    inlineMsg('RATE','Numbers only',2);
    return false;
    }
	
		if( !numberOnly.test(REB_CLOTH_VALUE ) && REB_CLOTH_VALUE != "" ) {
    inlineMsg('REB_CLOTH_VALUE','Numbers only',2);
    return false;
    }
	
	
	}catch (m) {}
	
	///////////////////////////////////
 try
    {
	
	if(document.form.EXISTYN.value == "Y") {
    inlineMsg('COMPUTERID','Barcode Already Exist...',2);
    return false;
    }
}catch(e){}
////////////////////////////////////////////////////////
if(CUSTCODE_SUPP == ""){
alert("Please Select Received From ");
}else{



try{
getMarginDoc();

var VMRATE =document.getElementById("MARG_RATE").value;

if ( VMRATE==""|| Number(VMRATE) ==0) {
 inlineMsg('RATE','Margin Rate Couldnot calculated Properly, Please verify Data',2);
    return false;
}
}catch(e){}





	document.form.ins.value='I'; 
	document.form.submit();
	document.form.refresh();
   }

}


function savemast(){
  var nameRegex = /^[a-zA-Z]+(([\'\,\.\- ][a-zA-Z ])?[a-zA-Z]*)*$/; 
  var numberOnly=/^[0-9 \.-]+$/;
  
  
  
  
  var COUNTERID =document.getElementById("COUNTERID").value;
  
 if(COUNTERID == "") {
    inlineMsg('COUNTERID','Enter Counter',2);
    return false;
	}

var CUSTCODE_SUPP =document.getElementById("CUSTCODE_SUPP").value;
var PR_NO =document.getElementById("PR_NO").value;
var INVDATE =document.getElementById("INVDATE").value;
var COMM =document.getElementById("COMM").value;
var COMM_AMT =document.getElementById("COMM_AMT").value;

var MARGIN=document.getElementById("MARGIN").value;
var MARGIN_INSUR =document.getElementById("MARGIN_INSUR").value;
var RFC =document.getElementById("RFC").value;
var MARGIN_STREC=document.getElementById("MARGIN_STREC").value;
var MARGIN_LPC =document.getElementById("MARGIN_LPC").value;

var MANG_CHR =document.getElementById("MANG_CHR").value;
var MANG_AMT =document.getElementById("MANG_AMT").value;
var MDA_COMM =document.getElementById("MDA_COMM").value;
var MDA_COMMAMT =document.getElementById("MDA_COMMAMT").value;

var PACK_CHR =document.getElementById("PACK_CHR").value;
var POST_CHR=document.getElementById("POST_CHR").value;
var MISC_CHR =document.getElementById("MISC_CHR").value;
var INSUR_CHR =document.getElementById("INSUR_CHR").value;
var MARGIN_EXCESS=document.getElementById("MARGIN_EXCESS").value;




if((!numberOnly.test(COMM)&& COMM !="") ) {
    inlineMsg('COMM','Numbers only',2);
    return false;
    }
	
	
	 if(!numberOnly.test(COMM_AMT) && COMM_AMT !="") {
    inlineMsg('COMM_AMT',' Numbers only ',2);
    return false;
}
 if(!numberOnly.test(MARGIN) && MARGIN !="") {
    inlineMsg('MARGIN',' Numbers only ',2);
    return false;
}
 if(!numberOnly.test(MARGIN_INSUR)  && MARGIN_INSUR !="") {
    inlineMsg('MARGIN_INSUR',' Numbers only ',2);
    return false;
}
 if(!numberOnly.test(RFC)  && RFC !="") {
    inlineMsg('RFC',' Numbers only ',2);
    return false;
}
 if(!numberOnly.test(MARGIN_STREC)  && MARGIN_STREC !="") {
    inlineMsg('MARGIN_STREC',' Numbers only ',2);
    return false;
}
 if(!numberOnly.test(MARGIN_LPC)  && MARGIN_LPC !="") {
    inlineMsg('MARGIN_LPC',' Numbers only ',2);
    return false;
}
 
 if(!numberOnly.test(MANG_CHR)  && MANG_CHR !="") {
        inlineMsg('MANG_CHR',' Numbers only ',2);
    return false;
}

if(!numberOnly.test(MANG_AMT)  && MANG_AMT !="" ) {
    inlineMsg('MANG_AMT','Numbers only',2);
    return false;
    }
	 if(!numberOnly.test(MDA_COMM)  && MDA_COMM !="") {
    inlineMsg('MDA_COMM',' Numbers only ',2);
    return false;
}
 if(!numberOnly.test(MDA_COMMAMT)  && MDA_COMMAMT !="") {
    inlineMsg('MDA_COMMAMT',' Numbers only ',2);
    return false;
}
 
 if(!numberOnly.test(PACK_CHR)  && PACK_CHR !="") {
    inlineMsg('PACK_CHR',' Numbers only ',2);
    return false;
}
 if(!numberOnly.test(POST_CHR)  && POST_CHR !="") {
    inlineMsg('POST_CHR',' Numbers only ',2);
    return false;
}
 if(!numberOnly.test(MISC_CHR)  && MISC_CHR !="") {
    inlineMsg('MISC_CHR',' Numbers only ',2);
    return false;
}
  if(!numberOnly.test(INSUR_CHR)  && INSUR_CHR !="") {

        inlineMsg('INSUR_CHR',' Numbers only ',2);

    return false;
}
 
 if(!numberOnly.test(MARGIN_EXCESS)  && MARGIN_EXCESS !="") {
        inlineMsg('MARGIN_EXCESS',' Numbers only ',2);
    return false;
}


 
 if(PR_NO == "") {
    inlineMsg('PR_NO','Enter Invoice No',2);
    return false;
	}
	
 
 if(INVDATE == "") {
    inlineMsg('INVDATE','Enter Invoice Date',2);
    return false;
    }	
	//INVDATE
 	 function ValidateINVDATE() {
  var dtValue = $('#INVDATE').val();
  var dtRegex = new RegExp("^([0]?[1-9]|[1-2]\\d|3[0-1])-(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)-[1-2]\\d{3}$", 'i');
  return dtRegex.test(dtValue);
}

  if (ValidateINVDATE() == false) {
    inlineMsg('INVDATE','WRONG DATE OR DATE FORMAT SHOULD BE (DD-MON-YYYY)',2);
    return false;
  }

  
////////////////////////////////////////////////////////
if(CUSTCODE_SUPP == ""){
alert("Please Select Received From ");
}else{


/*
try{
getMarginDoc();

var VMRATE =document.getElementById("MARG_RATE").value;

if ( VMRATE==""|| Number(VMRATE) ==0) {
 inlineMsg('RATE','Margin Rate Couldnot calculated Properly, Please verify Data',2);
    return false;
}
}catch(e){}

*/



	document.form.ins.value='I'; 
	document.form.submit();
	document.form.refresh();
   }

}




</script>

<style type="text/css">
<!--
.style2 {
	color: #000000
}

.style5 {
	color: #000000
}

.style6 {
	color: #006600
}

.style8 {
	color: #990033
}

.style9 {
	color: #000099
}

.style10 {
	color: #9900CC
}

.style11 {
	color: #663399
}

.style12 {
	font-size: 12px
}

.style13 {
	font-size: 14px
}

.style14 {
	color: #000000;
	font-size: 14px;
}

.style15 {
	color: #990033;
	font-size: 14px;
}

.style17 {
	font-size: 18px;
	color: #003333;
}

.style18 {
	color: #990000
}

#table_down tr:hover {
	background-color: #8EFDFD;
}

.style19 {
	font-size: 16px
}
-->
</style>
</head>
<body
	onLoad="showProdtwo();upload();calMastGST();calCommP();calOthersCharges();check();showProdtwo();cal_com_radio();">
	<form method="post" name="form" id="form">
		<style>
/* Style The Dropdown a */
.dropbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px;
	font-size: 10px;
	border: none;
	cursor: pointer;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
	position: relative;
	display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 200px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	border: 1px #006633 solid;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {
	background-color: #f1f1f1
}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
	display: block;
}

/* Change the background color of the dropdown a when the dropdown content is shown */
.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}

.style5 {
	color: #000000;
	font-weight: bold;
}
</style>


		<table align="center" width="100%">
			<thead>
				<tr>
					<td colspan="10"><img src="../images/0014.jpg" width="100%"></td>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor="#F7FECD">
					<td><span class="style5"> Branch Code:</span></td>
					<td style="border-right: 2px solid black"><span class="style5">1010011407
					</span></td>
					<td><strong>Branch Name: </strong></td>
					<td style="border-right: 2px solid black"><strong>KHADI
							INDIA ONLINE SALES</strong></td>
					<td><strong>Today's Date and Time </strong></td>
					<td style="border-right: 2px solid black"><strong>
							27-Apr-2021 </strong></td>
					<td><strong>Financial Year : </strong></td>
					<td style="border-right: 2px solid black"><strong>2020-21</strong></td>
					<td><strong>Operator Name: </strong></td>
					<td><strong>0-Inst. Branch Admin</strong></td>
				</tr>
			</tbody>
		</table>



		<blockquote>
			<table border="0" align="center">
				<tr>
					<td><a href="../br_admin/dashboard_br_admin.jsp"
						class="buttongrey">Home</a>
					</div></td>

					<td><div class="dropdown">
							<a class="buttongrey">Master</a>
							<div class="dropdown-content">
								<a href="../br_admin/viewCounter.jsp">Counter</a> <a
									href="../rebateMastProduct/rebateMaster_prod.jsp">(1)Product
									Wise Rebate Master</a> <a
									href="../rebateMastCounter/rebateMaster_counter.jsp">(2)Counter
									Wise Rebate Master</a> <a
									href="../rebateMastSupplier/rebateMaster_supp.jsp">(3)Supplier
									Wise Rebate Master</a> <a href="../rebateMast/rebateMaster.jsp">(4)Maingroup
									Wise Rebate Master</a> <a href="../newuser/create_user.jsp">
									User / Operator</a> <a href="../ReRating/reRatingView.jsp"> Re
									-Rating Products</a> <a
									href="../stockentryphy/openingStockViewBatch.jsp">Physical
									Stock Entry</a> <a href="../PhyStockExcelUpload/Action_file.jsp">Physical
									Stock Excel Upload</a>
								<!-- <a href="../ReRating_Batch/reRatingView.jsp">Batchwise Re -Rating</a>	-->
							</div>
						</div></td>
					<td><a href="../openingBalance/openingStockViewBatch.jsp"
						class="buttongrey">Stock entry</a>
					</div></td>


					<td><a
						href="../openingBalance_online/openingStockViewBatch.jsp"
						class="buttongrey">Online Stock entry</a>
					</div></td>

					<td>
						<div class="dropdown">
							<a class="buttongrey">Purchase</a>
							<div class="dropdown-content">

								<a href="../purchase_dl_onl/viewPurchase.jsp">Online
									Purchase DL</a> <a href="../purchase_dl/viewPurchase.jsp">Purchase
									DL</a> <a href="../purchase/viewPurchase.jsp">Purchase</a> <a
									href="../purchase_cspgs/viewPurchase.jsp">Purchase CSP/GS</a>
								<a href="../purchase_return/viewPurRet.jsp">Purchase Return</a>
								<a href="../OldStock_purchase_return/viewPurRet.jsp">Old
									Purchase Return</a>
								<!--	<a href="../raw_material/viewRawmaterial.jsp">Raw Material Purchase</a>	 </div>   -->
							</div>
					</td>
					<td><div class="dropdown">
							<a class="buttongrey">Production</a>
							<div class="dropdown-content">
								<!--<a href="../artisan_details/ArtisanViewPage.jsp">Artisans Profile</a>  -->
								<a href="../AllProd_processing/wdp_ProcessView.jsp">All
									Processing</a> <a href="../silkReeling/ProcessView.jsp">Silk
									Reeling Process</a> <a href="../PreSpinning/SPProcessView.jsp">Pre-Spinning
									Process (OWN)</a> <a href="../Spinning_Process_OHP/ProcessView.jsp">Spinning
									Process (OWN)</a> <a href="../PreWeaving_OPH/WPProcessView.jsp">Pre-Weaving
									Process (OWN)</a> <a href="../Weaving_Process_OHP/ProcessView.jsp">Weaving
									Process (OWN)</a> <a
									href="../csp_processing/tailoringProcessView.jsp"> CSP Own
									House Production </a> <a
									href="../tailoring_own_house/tailoringProcessView.jsp">Tailoring
									/ Other Process (OWN)</a>

								<!-- <a href="../costchart/costchartviewpage.jsp">Cost Chart</a>
		  <a href="../spinner_weaver_issues/sw_issue_viewpage.jsp">Raw Material issues</a>
	<a href="../spinner_receive/spinner_receive_viewform.jsp">Spinner Receive</a>
		<a href="../weaver_receive/weaver_receive_viewform.jsp">Weaver Receive</a>
	<a href="../preweaving_process/preweaving_viewform.jsp">Pre-Weaving Process</a>-->

								<a href="../wash_dye_print_dl/wdp_ProcessView.jsp">Washing /
									Dyeing / Printing DL</a>

								<!--<a href="../tailoring/tailoringProcessView.jsp">Tailoring </a>-->
								<a href="../tailoring_dl/tailoringProcessView.jsp">Tailoring
								</a> <a href="../tailoring_dl_multi_prod/tailoringProcessView.jsp">Tailoring
									Multi Product</a> <a
									href="../OutSourcingProduction/wdp_ProcessView.jsp">Job
									Work</a> <a href="../wages/wageView.jsp">Wages Payment</a>
							</div>
						</div></td>
					<td>

						<div class="dropdown">
							<a class="buttongrey">Sales</a>
							<div class="dropdown-content">
								<a href="../csp_sales/viewWholesale.jsp">CSP Sales</a> <a
									href="../SalesCashier/salesCashierView.jsp">Sales Cashier
									ER</a> <a href="../sales_dl_auto_lh/viewSales.jsp">Retail Sale
								</a> <a href="../ManualSales_dl/viewSales.jsp">Manual Billing
									(Sale) </a> <a href="../salesCoupon_lh/viewSales.jsp">Coupon
									Sale </a> <a href="../RetRetailSale_dl_lh/viewRetailSDetail.jsp">Retail
									Sale Return </a> <a href="../wholesale_dl/viewWholesale.jsp">WholeSale
								</a> <a href="../RetWholeSale/viewWholeSDetail.jsp">WholeSale
									Return</a> <a href="../Wholesale_challan_dl/viewbr_godown.jsp">Branch
									WholeSale Issue</a> <a
									href="../Wholesale_challan_dl/viewbr_godownRec.jsp">Branch
									Purchase Receive</a> <a
									href="../GovernmantSupply_dl_auto/viewGovernmentSupDetail.jsp">Government
									Supply </a> <a
									href="../ReturnGovSupply/viewGovernmentSupDetail.jsp">Government
									Supply Return</a> <a href="../branch_godown_dl/viewbr_godown.jsp">Branch
									Challan issue</a> <a href="../branch_godown/viewbr_godown.jsp">Branch
									Challan issue WB</a> <a
									href="../branch_godown/viewbr_godownRec.jsp">Branch
									Challan Receive</a>
							</div>
						</div>
					</td>


					<td>
						<div class="dropdown">
							<a class="buttongrey">Accounts</a>
							<div class="dropdown-content">
								<a href="../accountsBR/openingbalance.jsp">Opening Balance</a>
								<a href="../accountsBR/VourcherDetailView.jsp">Voucher
									Entry</a> <a href="../SalesVoucher/SalesVoucherView.jsp">Sales
									Voucher</a> <a href="../SalesVoucher_WB/SalesVoucherView.jsp">Sales
									Voucher WB</a> <a href="../ProductionVoucher/SalesVoucherView.jsp">Production
									Voucher</a> <a href="../accountsBR/kimis_acc_reports.jsp">Accounting
									Statements</a>
							</div>
						</div>
					</td>



					<td>
						<div class="dropdown">
							<a class="buttongrey">Barcode Trace</a>
							<div class="dropdown-content">
								<a href="../Barcode_trace_dl/BarcodeTraceView.jsp">Barcode
									Trace</a>
							</div>
						</div>
					<td><a href="../br_admin/kimis_br_reports.jsp"
						class="buttongrey">Reports</a></td>
					<td><a href="../branch_usermanual_02.pdf" class="buttongrey">User
							manual</a>
					</div></td>
					<td><div align="center">
							<a href="../br_admin/change_password_br.jsp" class="buttongrey">Change
								Password </a>
						</div></td>
					<td><a href="../logout.jsp" class="buttongrey">Logout</a>
					</div></td>
				</tr>
			</table>
			<br>








			<table width="100%" align="center">
				<tr>
					<td colspan="7"><div align="center">
							<span class="style17">Non-Raw Matrial Purchase Details DL</span><span
								class="style18"><span style="float: right">(*)Marked
									fields are Mandatory</span></span>
						</div></td>
				</tr>
				<tr>
					<td colspan="7" bgcolor="#C0DDDF"><div align="center"
							class="style2">Received Specifications</div></td>
				</tr>
				<tr>
					<th><div align="center">Purchase ID</div></th>
					<th><div align="center">
							Party Invoice No.<span style="color: #990000">*</span> / Date <span
								style="color: #990000">*</span>
						</div></th>
					<th><div align="center">
							Received from <span style="color: #990000">*</span>
						</div></th>
					<th><div align="center">Transport / Remarks</div></th>
					<th><div align="center">Weight</div></th>
					<th><div align="center">
							Counter<span style="color: #990000">*</span>
						</div></th>
					<th><div align="center">
							<a href="viewPurchase.jsp" class="buttonBlue">Back</a>
						</div></th>
				</tr>
				<tr>
					<td><div align="center">
							<input name="PUR_ID" type="hidden" id="PUR_ID" value="2201964011">
							2201964011
						</div></td>
					<td><div align="center">
							<input name="ins" type="hidden" id="ins"> <input
								name="BR_STATE" type="hidden" id="BR_STATE" value="1">
							<input name="PR_NO" type="text" id="PR_NO" value="11" size="10"
								maxlength="15" placeholder="Invoice No"> / <input
								name="INVDATE" type="text" id="INVDATE"
								placeholder="Invoice Date" value="27-apr-2021" size="11"
								maxlength="11"> <img src="../js/img/cal.gif"
								onClick="javascript:NewCssCal('INVDATE','ddMMMyyyy')"
								style="cursor: pointer" /> (dd-mon-yyyy)
						</div></td>
					<td><div align="center">
							<input name="text2" type="text" id="Text3"
								style="width: 400px; font-size: 1.0em;" onFocus="sup_list();"
								placeholder="Search Here by Name" value="Kgb Prossesingh">
							<input name="CUSTCODE_SUPP" type="hidden" id="CUSTCODE_SUPP"
								value="1010072372" />
							<DIV id="SUP_ST_NM"></DIV>
						</div></td>
					<td><div align="center">
							<input name="TRANSPORT" type="text" id="TRANSPORT" value=""
								size="10" maxlength="10"> <input name="CUSTCODE"
								type="hidden" id="CUSTCODE" value="1010011407">
						</div></td>
					<td><div align="center">
							<input name="WEIGHT" type="text" id="WEIGHT" value="" size="10"
								maxlength="10">
						</div></td>
					<td><div align="center">
							<select name="COUNTERID" id="COUNTERID">

								<option value="2028938" selected>2028938-M3-SHIRTING
									COTTON KHADI</option>

								<option value="2028927">2028927-F1-HAND MADE PAPER</option>

								<option value="2028928">2028928-F2-Leather</option>

								<option value="2028929">2028929-F3-DHOTIES AND TOWELS
								</option>

								<option value="2028930">2028930-F4-WOLLEN KHADI</option>

								<option value="2028931">2028931-G1-White/silk
									Material/pasmina</option>

								<option value="2028932">2028932-G2-V.I. PRODUCTS</option>

								<option value="2028933">2028933-G3-READYMADE</option>

								<option value="2028934">2028934-G4-READYMADE</option>

								<option value="2028935">2028935-G5-READYMADE</option>

								<option value="2028937">2028937-G7-NATIONAL FLAG</option>

								<option value="2030884">2030884-M1-SILK SARIES /
									COTTON SARIES</option>

								<option value="2028867">
									2028867-G6-READYMADE(DESIGNER)</option>

								<option value="2028912">2028912-M8-CONSIGNMENT</option>

								<option value="2029115">2029115-M5-PRINT COTTON KHADI
								</option>

								<option value="2029116">2029116-M6-POLYVASTRA</option>

								<option value="2131865">2131865-M4-COLOURED KHADI</option>

								<option value="2029906">2029906-M7-SOLAR VASTRA</option>

								<option value="2029907">2029907-M11-HANDICRAFTS</option>

							</select>
						</div></td>
					<td>&nbsp;</td>
				</tr>




				<tr>
					<td colspan="7">
						<table width="100%" align="center">
							<tr>
								<td colspan="8" bgcolor="#FFFF99"><div align="center">
										<span class="style17">Consignee Invoice Yes </span> <input
											name="CONSIGNEE_YN" id="radio" type="radio" value="Y">
										<span class="style17">No</span> <input name="CONSIGNEE_YN"
											type="radio" id="radio" value="N" checked>
									</div></td>
							</tr>
							<tr>
								<th colspan="8" class="style8"><div align="center"
										class="style9">Margin Docket</div></th>
							</tr>
							<tr>
								<td width="16%" class="style8"><span class="style9">Margin
								</span></td>
								<td width="25%" colspan="3" class="style8"><input
									name="MARGIN" type="text" id="MARGIN" value="" size="10"
									maxlength="10"> <span class="style9">%</span></td>
								<td width="18%"><span class="style9">Insurance </span></td>
								<td width="10%"><input name="MARGIN_INSUR" type="text"
									id="MARGIN_INSUR" value="" size="10" maxlength="10">
									<span class="style8"><span class="style9">%</span></span></td>
								<td width="31%" colspan="2">Applied to all product: <input
									name="APPLY_MARG" type="radio" id="APPLYA" onChange="check();"
									value="A"> (YES) <input name="APPLY_MARG"
									type="radio" id="APPLYB" onChange="check();" value="B" checked>
									(NO)
								</td>
							</tr>
							<tr>
								<td class="style8"><span class="style9">Pcs.
										Recovery / RFC </span></td>
								<td colspan="3" class="style8"><input name="RFC"
									type="text" id="RFC" value="" size="10" maxlength="10">
									<span class="style9">%</span></td>
								<td><span class="style9">S. T. Refund </span></td>
								<td><input name="MARGIN_STREC" type="text"
									id="MARGIN_STREC" value="" size="10" maxlength="10">
									<span class="style8"><span class="style9">%</span></span></td>
								<td width="31%" colspan="2">&nbsp;</td>
							</tr>
							<tr>
								<td class="style8"><span class="style9">Last Piece
										Discount </span></td>
								<td colspan="3" class="style8"><input name="MARGIN_LPC"
									type="text" id="MARGIN_LPC" value="" size="10" maxlength="10">
									<span class="style9">%</span></td>
								<td><span class="style9">Others </span></td>
								<td>Rs. <input name="MARGIN_EXCESS" type="text"
									id="MARGIN_EXCESS" value="" size="10" maxlength="10">
									<input name="M_RATE" type="hidden" id="M_RATE" value="">
									<input name="P_RECV" type="hidden" id="P_RECV" value="">
									<input name="I_RATE" type="hidden" id="I_RATE" value="">
									<input name="OTH_RATE" type="hidden" id="OTH_RATE" value="">
									<input name="ST_RATE" type="hidden" id="ST_RATE" value="">
									<input name="LPCS_COM" type="hidden" id="LPCS_COM" value="">
									<input name="MARG_RATE" type="hidden" id="MARG_RATE" value="">
									<input name="APPLY" type="hidden" id="APPLY" value="">
								</td>
								<td colspan="2"><div align="center">
										<input name="Button22" type="button" class="buttongrey"
											onClick="calculation();" value="Show calculation">
									</div></td>
							</tr>
							<tr>
								<td class="style8">&nbsp;</td>
								<td colspan="3" class="style8">&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td colspan="2">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="8" bgcolor="#FFFFCC" class="style8"><div
										align="center">
										<span class="style17">Non-Raw Material</span> <input
											name="AutoOF" id="AutoO" type="radio" value="PC"
											onClick="funct_calc();"> <span class="style17">OR
											Raw Material</span> <input name="AutoOF" type="radio" id="AutoF"
											onClick="funct_calc();" value="RW"> <input
											name="POnOff" type="hidden" id="POnOff" value="PC">

									</div></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

			</td>
			</tr>
			<tr>
				<th colspan="3"><input type="hidden" name="MATTRESS_YN"
					value="Y" id="MATTRESS_YN">

					<div align="center">
						Enter Product Code or Product Name: <input name="text" type="text"
							id="Text2" style="width: 300px; font-size: 1.2em;"
							placeholder="Search here by Product Name or Id"
							onFocus="showProductList();" /> <input name="ID3S" type="hidden"
							id="ID3S" value="101007210100257749"> &nbsp;&nbsp;&nbsp;
						<input name="btnMasterAddnew2" type="button" class="buttongrey"
							id="btnMasterAddnew2" onClick="Showproductlist('1010072101');"
							value="Product List" /> <input name="Button222" type="button"
							class="buttongrey" onClick="print_barcode('2201964011');"
							value="Print Barcode">

						<div id="ID3_COUNT" align="center" style="width: 20%"></div>
			</tr>
			</table>



			<table width="100%" align="center">
				<tr>
					<th><div align="center">Pcs</div></th>
					<th><div align="center">Mts / Kgs</div></th>
					<th><div align="center">Rate</div></th>
					<th><div align="center">Amount</div></th>
					<th><div align="center">Cloth value For Rebate</div></th>
					<th>Size / width</th>
					<th><div align="center">Exp date</div></th>
					<th><div align="center"></div></th>
				</tr>
				<tr>
					<td><div align="center">
							<input name="CESS" type="hidden" id="CESS" value="" /> <input
								name="PIECES" type="text" id="PIECES" value=""
								onblur="mattressCheck();"> <input name="COUNT_MESUR"
								type="hidden" id="COUNT_MESUR" value="" /> <input
								name="CGST_PER" type="hidden" id="CGST_PER" value="" /> <input
								name="SGST_PER" type="hidden" id="SGST_PER" value="" /> <input
								name="IGST_PER" type="hidden" id="IGST_PER" value="" /> <input
								name="HSNCODE" type="hidden" id="HSNCODE" value="" /> <input
								name="getPOnOff" type="hidden" id="getPOnOff" value="" /> <input
								name="PID3" type="hidden" id="PID3" value="101007210100257749" />
							<input name="CGST_AMT" type="hidden" id="CGST_AMT" value="" /> <input
								name="SGST_AMT" type="hidden" id="SGST_AMT" value="" /> <input
								name="IGST_AMT" type="hidden" id="IGST_AMT" value="" /> <input
								name="TAXABLENET" type="hidden" id="TAXABLENET" value="" /> <input
								name="PAYABLENET" type="hidden" id="PAYABLENET" value="" /> <input
								name="ORG_RATE" type="hidden" id="ORG_RATE" value="" />

						</div></td>
					<td><div align="center">
							<input name="QUANTITY" type="text" id="QUANTITY" value=""
								onBlur="mattressCheck();">
						</div></td>
					<td><div align="center">
							<input name="RATE" type="text" id="RATE" value=""
								onBlur="mattressCheck();" />
						</div></td>
					<td><DIV id="MATAMT"></DIV></td>
					<td><div align="center">
							<input name="REB_CLOTH_VALUE" type="TEXT" id="REB_CLOTH_VALUE"
								value="" size="7" maxlength="12" />
						</div></td>
					<td><div align="center">
							<input name="SIZE_UNIT" type="text" id="SIZE_UNIT" value=""
								size="10" maxlength="10">
						</div></td>
					<td><div align="center">
							<input name="EXPDATE" type="text" id="EXPDATE" tabindex="7"
								onClick="javascript:NewCssCal('EXPDATE','ddMMMyyyy')">
						</div></td>
					<td><input name="Button" type="button" class="button"
						value="Add" onClick="save();" /></td>
				</tr>
			</table>

			<table align="right" id="taxid">
				<tr bgcolor="#FFFF99">
					<td>HSN CODE:</td>
					<td id=""><span id="HSNCODE"></span></td>
					<td>GST</td>
					<td id=""><span id="GSTMIN"></span></td>
					<td>% < Rs.</td>

					<td id=""><span id="GSTONAMT"></span></td>
					<td>></td>
					<td id=""><span id="GSTMAX"></span></td>

					<td>%</td>

				</tr>


			</table>



			</p>

			<table width="100%" align="center" cellpadding="2" cellspacing="2"
				style="font-size: 10px;" id="table_down">
				<tr>
					<td colspan="28" bgcolor="#C0DDDF"><div align="center"
							class="style2"></div></td>
				</tr>
				<tr>
					<td colspan="9"><div align="center" class="style13">
							<span class="style5">Purchase Details </span>
						</div></td>
					<td colspan="8" bgcolor="#C4F8FB" class="style9"><div
							align="center" class="style14">
							<div align="center" class="style9">Margin Docket</div>
						</div></td>
					<td colspan="10" bgcolor="#DDDDFF"><div align="center"
							class="style15">Tax Docket</div></td>
					<td rowspan="2"><a
						href="../kimisreports/GenerateBill.jsp?REPNAME=PURCHASE_IDWISE&PUR_ID=2201964011"
						target="_blank" class="buttongrey">Print Bill</a><a
						href="../kimisreports/GenerateBill.jsp?REPNAME=PURCHASE_TAXINVOICE&PUR_ID=2201964011"
						target="_blank" class="buttongrey">Tax Invoice</a></td>
				</tr>
				<tr>
					<td class="table_inner_border"><div align="center"
							class="style12">TRID</div></td>
					<td class="table_inner_border"><div align="center"
							class="style12">Product Name</div></td>
					<td class="table_inner_border"><div align="center"
							class="style12">Barcode</div></td>
					<td class="table_inner_border"><div align="center">Size
							/ width</div></td>
					<td class="table_inner_border"><div align="center"
							class="style12">Pcs.</div></td>
					<td class="table_inner_border"><div align="center"
							class="style12">Mts./kgs</div></td>
					<td class="table_inner_border"><div align="center">Tot
							Qty</div></td>
					<td class="table_inner_border"><div align="center"
							class="style12">Rate</div></td>
					<td class="table_inner_border"><div align="center"
							class="style12">Amount</div></td>
					<td bgcolor="#C4F8FB" class="table_inner_border"><div
							align="center" class="style12">M.Rate</div></td>
					<td bgcolor="#C4F8FB" class="table_inner_border"><div
							align="center" class="style12">P.Recv</div></td>
					<td bgcolor="#C4F8FB" class="table_inner_border"><div
							align="center" class="style12">I.Rate</div></td>
					<td bgcolor="#C4F8FB" class="table_inner_border"><div
							align="center" class="style12">Oth.Rate</div></td>
					<td bgcolor="#C4F8FB" class="table_inner_border"><div
							align="center" class="style12">S.T Rate</div></td>
					<td bgcolor="#C4F8FB" class="table_inner_border"><div
							align="center" class="style12">LPcs.Com</div></td>
					<td bgcolor="#C4F8FB" class="table_inner_border">Excess Short
					</td>
					<td bgcolor="#C4F8FB" class="table_inner_border"><div
							align="center" class="style12">Amount</div></td>
					<td bgcolor="#DDDDFF" class="table_inner_border"><div
							align="center" class="style12">Marg. Rate</div></td>
					<td bgcolor="#DDDDFF" class="table_inner_border"><div
							align="center" class="style12">CGST %</div></td>
					<td bgcolor="#DDDDFF" class="table_inner_border"><div
							align="center" class="style12">SGST %</div></td>
					<td bgcolor="#DDDDFF" class="table_inner_border"><div
							align="center" class="style12">IGST %</div></td>
					<td bgcolor="#DDDDFF" class="table_inner_border"><div
							align="center" class="style12">CGST Rs.</div></td>
					<td bgcolor="#DDDDFF" class="table_inner_border"><div
							align="center" class="style12">SGST Rs.</div></td>
					<td bgcolor="#DDDDFF" class="table_inner_border"><div
							align="center" class="style12">IGST Rs.</div></td>
					<td bgcolor="#DDDDFF" class="table_inner_border"><div
							align="center">CESS</div></td>
					<td bgcolor="#DDDDFF" class="table_inner_border"><div
							align="center" class="style12">R.RATE/ MRP</div></td>
					<td bgcolor="#DDDDFF" class="table_inner_border"><div
							align="center" class="style12">Amount</div></td>
				</tr>







				<tr>
					<td colspan="3" bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center">TOTAL</div>
						<div align="left"></div>
						<div align="left"></div>
						<div align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center">
							<input type="hidden" name="GAMOUNT" id="GAMOUNT" VALUE="">
						</div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border">&nbsp;</td>
					<td bgcolor="#EBEBEB" class="table_inner_border">&nbsp;</td>
					<td bgcolor="#EBEBEB" class="table_inner_border">&nbsp;</td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td bgcolor="#EBEBEB" class="table_inner_border"><div
							align="center"></div></td>
					<td></td>
				</tr>


			</table>
			<table width="100%">
				<tr>
					<th colspan="4" class="table_border"><div align="center"
							class="style10">Particulars</div></th>
					<th colspan="2"><div align="center" class="style11">Charges
							Specification</div></th>
					<th>&nbsp;</th>
					<th>
						<div align="center">(%)</div>
					</th>
					<th><div align="center">(Rs.)</div></th>
				</tr>
				<tr>
					<td colspan="2"><div align="right">
							<input type="radio" name="checkRadio" id="checkRadio" value="P"
								onClick="cal_com_radio();" checked="checked"> in (%)
						</div></td>
					<td colspan="2"><input type="radio" name="checkRadio"
						id="checkRadio" value="V" onClick="cal_com_radio();"> in
						(Rs.)</td>
					<td width="18%"><span class="style11">(+) Packaging
							Charges (Rs.)</span></td>
					<td width="10%"><input name="PACK_CHR" type="text"
						id="PACK_CHR" onChange="calOthersCharges();" value="" size="15"
						maxlength="10"></td>
					<td width="21%"><span class="style11">(+) CGST On
							Purchase </span></td>
					<td width="10%"><div align="center">
							<input name="ICGST_PER" type="text" id="ICGST_PER" value=""
								size="6" maxlength="6">
						</div></td>
					<td width="10%"><div align="center">
							<input name="ICGST_AMT" type="text" id="ICGST_AMT"
								onChange="calMastGST();" value="" size="15" maxlength="10">
						</div></td>
				</tr>
				<tr>
					<td width="16%"><span class="style10">Discount</span></td>
					<td width="12%"><input name="COMM" type="text" id="COMM"
						onBlur="calCommP();" value="" size="10" maxlength="10"> <span
						class="style10">% </span></td>
					<td width="3%">Rs.</td>
					<td width="10%"><input name="COMM_AMT" type="text"
						id="COMM_AMT" onBlur="calCommP();" value="0" size="18"
						maxlength="18"></td>
					<td><span class="style11">(+) Misc. Charges (Rs.)</span></td>
					<td><input name="MISC_CHR" type="text" id="MISC_CHR"
						onBlur="calOthersCharges();" value="" size="15" maxlength="10"></td>
					<td><span class="style11">(+) SGST</span> <span
						class="style11">On Purchase </span></td>
					<td><div align="center">
							<input name="ISGST_PER" type="text" id="ISGST_PER" onChange=""
								value="" size="6" maxlength="6">
						</div></td>
					<td><div align="center">
							<input name="ISGST_AMT" type="text" id="ISGST_AMT"
								onChange="calMastGST();" value="" size="15" maxlength="10">
						</div></td>
				</tr>
				<tr>
					<td><span class="style10">Special Discount </span></td>
					<td><input name="MANG_CHR" type="text" id="MANG_CHR"
						onBlur="calCommP();" value="" size="10" maxlength="10"> <span
						class="style10">% </span></td>
					<td>Rs.</td>
					<td><input name="MANG_AMT" type="text" id="MANG_AMT"
						onBlur="calCommP();" value="0" size="18" maxlength="18"></td>
					<td><span class="style11"></span><span class="style11">(+)
							Freight / Postal Charges (Rs.)</span></td>
					<td><input name="POST_CHR" type="text" id="POST_CHR"
						onChange="calOthersCharges();" value="" size="15" maxlength="10"></td>
					<td><span class="style11">(+) IGST On Purchase </span></td>
					<td><div align="center">
							<input name="IIGST_PER" type="text" id="IIGST_PER" onChange=""
								value="" size="6" maxlength="6">
						</div></td>
					<td><div align="center">
							<input name="IIGST_AMT" type="text" id="IIGST_AMT"
								onChange="calMastGST();" value="" size="15" maxlength="10">
						</div></td>
				</tr>
				<tr>
					<td><span class="style10">MDA </span></td>
					<td><input name="MDA_COMM" type="text" id="MDA_COMM"
						onBlur="calCommP();" value="" size="10" maxlength="10"> <span
						class="style10">% </span></td>
					<td>Rs.</td>
					<td><input name="MDA_COMMAMT" type="text" id="MDA_COMMAMT"
						onBlur="calCommP();" value="0" size="18" maxlength="18"></td>
					<td><span class="style11">(+) Insurance Charges (Rs.)</span></td>
					<td><input name="INSUR_CHR" type="text" id="INSUR_CHR"
						onBlur="calOthersCharges();" value="" size="15" maxlength="10"></td>
					<td><span class="style11"> Total GST </span></td>
					<td>&nbsp;</td>
					<td><input name="TOT_GST" type="text" id="TOT_GST" value=""
						size="15" readonly></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><div align="right">
							<span class="style10">Total Comission</span>:
						</div></td>
					<td>Rs.</td>
					<td><input name="Input" type="text" id="TOT_COMM_AMT" value=""
						size="18" readonly></td>
					<td><span class="style11">Total Charges</span></td>
					<td><input name="Input" type="text" id="TOT_CHARGES_AMT"
						value="" size="15" readonly></td>
					<td><div align="right"
							style="font-family: 'Courier New', Courier, mono; font-size: 20px; color: #990000">Invoice
							Total &#8377;</div></td>
					<td colspan="2"
						style="font-family: 'Courier New', Courier, mono; font-size: 20px; color: #990000"><input
						type="HIDDEN" value="" name="Input2" id="INVOICE_TOT" readonly>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td><div align="right"
							style="font-family: 'Courier New', Courier, mono; font-size: 20px; color: #0000FF">Grand
							Total &#8377;</div></td>
					<td colspan="2"><input type="HIDDEN" value=""
						name="GRAND_TOT" id="GRAND_TOT" readonly> <SPAN
						id="GRAND_TOTS"
						style="font-family: 'Courier New', Courier, mono; font-size: 20px; color: #0000FF"></SPAN></td>
				</tr>
				<tr>
					<td colspan="9"><table align="center" width="70%">
							<tr>
								<th><div align="right">Net Commission Earned :</div></th>
								<td bgcolor="#FBD7E1"><div class="tooltip">
										Rs.<span id="NET_EARNED"></span><span class="tooltiptext">
											Gross Amount - Invoice Total</span>
									</div></td>
								<th><div align="right">Totals :</div></th>
								<td><div class="tooltip">
										<span id="TOT_AMT1"></span><span class="tooltiptext">
											Invoice Total </span>
									</div></td>
								<td>&#8377;
									<div class="tooltip">
										<span id="TOT_AMT2"></span><span class="tooltiptext">
											Margin Docket Amount </span>
									</div>
								</td>
								<td bgcolor="#FFFFFF">&nbsp;</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<th><div align="right">Less % :</div></th>
								<td><input name="LESS" type="text" id="LESS"
									onBlur="calCommP();" value="" maxlength="5"></td>
								<td><div class="tooltip">
										&#8377; <SPAN id="AMT_LESS"></SPAN><span class="tooltiptext">
											Invoice Total * / 100</span>
									</div></td>
								<td bgcolor="#FFFFFF">&nbsp;</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<th>Gross Amount :</th>
								<td bgcolor="#FBD7E1" style="font-size: 18px;"><div
										class="tooltip">
										<SPAN id="MGROSS"></SPAN><span class="tooltiptext">
											Margin Docket Amount - Less Amount</span>
									</div></td>
								<td bgcolor="#FFFFFF">&nbsp;</td>
							</tr>
						</table></td>
				</tr>
			</table>
			<input type="button" class="buttonBlue" value="SUBMIT"
				onClick="savemast();" />



			<script>



 var modalWin = new CreateModalPopUpObject();
 modalWin.SetLoadingImagePath("../images/loading.gif");
 modalWin.SetCloseButtonImagePath("../images/remove.gif");
//autoinsert


 function autoinsert(PUR_ID){
// var callbackFunctionArray = new Array(EnrollNow, EnrollLater);
 modalWin.ShowURL("BulkEntry.jsp?PUR_ID="+PUR_ID,800,1400,'Bulk Product',null,null);
 }//end of bank
 


 function DeleteProd(PPUR_TRID){
// var callbackFunctionArray = new Array(EnrollNow, EnrollLater);
 modalWin.ShowURL("deletePurProduct.jsp?PPUR_TRID="+PPUR_TRID,300,600,'Delete Product',null,null);
 }//end of bank
 
 //UpdateProd
 
  function UpdateProd(PPUR_TRID){
// var callbackFunctionArray = new Array(EnrollNow, EnrollLater);
 modalWin.ShowURL("updatePurProduct.jsp?PPUR_TRID="+PPUR_TRID,600,1100,'Update Sale Rate',null,null);
 }//end of bank
 
 
  function calculation(){
// var callbackFunctionArray = new Array(EnrollNow, EnrollLater);
 modalWin.ShowURL("purCalculation.jsp",400,1300,'CALCULATION',null,null);
 }//end of bank
 
  function Showproductlist(BASEID){
var callbackFunctionArray = new Array(refreshpage,getProductDetail);
 modalWin.ShowURL("ShowProdList.jsp?BASEID="+BASEID,800,1400,'PRODUCT DETAILS',null,callbackFunctionArray);
 }//end of bank

  function print_barcode(PUR_ID){
 modalWin.ShowURL("print_barcode_purchase.jsp?PUR_ID="+PUR_ID,800,1400,'Print Barcode',null,null);
 }//end of bank


function getProductDetail(ID3,ID3_NAME){

form.ID3S.value=ID3;

 //form.BRANCH_NAME.value=BRNAME;
}
 
 function HideModalWindow() {
    modalWin.HideModalPopUp();
}
function refreshpage() {
   form.submit(); 
}



 $(document).ready(function() {
 
//todaydt();
            //option A
            $("form").submit(function(e){
			if (document.form.ins !='I'){
               e.preventDefault(e);
			   
			  
			   save();
			   //showProduct();
			  // submit_update();
			   }
            });
        });





	</script>
	</form>

</body>
</html>