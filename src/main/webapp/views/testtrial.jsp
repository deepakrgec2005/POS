<html>
<head>
<title></title>

<style type="text/css">
body {
	
}
</style>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="/assets/js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="/assets/js/jquery-ui.js" type="text/javascript"></script>
<script src="/assets/js/jquery.scannerdetection.js" type="text/javascript"></script>
<script type="text/javascript">
        
    $(function() {		
    $("#Text2").autocomplete({
    
    source:function(request,response){
     $.ajax({
            url: "/POS/json/barcode",
            data: {
                brc: request.term
            }
        }).done(function (data) {
            response($.map(data,function(item){
            return{
            id:item.l2,
            value:item.l2,
            
            }
            
            }));
        }); 
   /*  $.ajax({
    type: "GET",
    url:'/POS/enddata',
    
				
				data:{brc: request.term},
				dataType:"json",
				sucess:function(data){
				return data.label;
				 
				
				}
    
    
    });  */
    
    },
    minLength: 3
    ,select: function(event, ui) {
					this.value = ui.item.label;
					$("#Text2").val(ui.item.value);
					return false;
					}
    
    });
    });
        </script>
        <script type="text/javascript">
	  $(document).scannerDetection({
		timeBeforeScanTest : 200, // wait for the next character for upto 200ms
		startChar : [ 120 ], // Prefix character for the cabled scanner (OPL6845R)
		endChar : [ 13 ], // be sure the scan is complete if key 13 (enter) is detected
		avgTimeByChar : 40, // it's not a barcode if a character takes longer than 40ms
		//preventDefault:true,
		//onKeyDetect: function(event){console.log(event.which); return false;}
		onComplete : function(barcode, qty) {
		alert('value of barcode called'+barcode);
		document.getElementById("Text4").value = barcode;
		 $("#ta-txt").html(barcode);
		  //$( "#Text4" ).value(barcode);
			
			  $("#Text4" ).html=barcode;
			// 
			//getbardet(barcode);
			//$("#Text4").focus();
			//scanbarcode();
		} // main callback function	
	});  
</script>
</head>
<body>
	<br />
	<br />
	<br />
	<br />
	<br />
	<div style="width: 100%; text-align: center;">
		<input type="text" id="Text2" style="width: 200px; font-size: 1.2em;" /><br />
		<br /> Text: <span id="ta-txt"></span><br /> ID: <span id="ta-id"></span><br />
	</div>
</body>
</html>