$(function() {
	switch (menu) {
	case 'About Us':
		$('about').addClass('active');
		break;
	case 'Product Master':
		$('pmaster').addClass('active');
		break;
	case 'Contact Us':
		$('contact').addClass('active');
		break;
	default:
		$('home').addClass('active');
		break;
	}

	const queryString = window.location.search;
	//console.log(queryString);
	const urlParams = new URLSearchParams(queryString);
	const product = urlParams.get('pur_id');
	//console.log("value of product"+product);
	
	
	if(product!=0)
	{

		pridfa=product;
 
			getall();
			  $('#inid').val(product);
	
	}
	
	
	var $table = $('#deepak');
	if ($table.length) {
		var jsonUrl = window.contextRoot + '/json/data';
		$table.DataTable({
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [ {
				data : 'prId'
			}, {
				data : 'sg',
				mRender : function(data, type, row) {
					return data.mg.mname;
				}

			}, {
				data : 'sg',
				mRender : function(data, type, row) {
					return data.sname;
				}

			}, 
			{
				data : 'pname'
			}, 	
			{
				data : 'ptype'
			},
			{
				data : 'hsncode'
			},

			{
				data : 'gstp'
			},

			{
				data : 'gstonSale'
			},

			{
				data : 'gstpm'
			}

			]

		});

	}
 
/*	Barcode Table*/
	var $table = $('#barcodeprinttable');
	if ($table.length) {
	var paravalue=document.getElementById("prhiddenvalue").value;
		
	//	var paravalue=window.parent.geturlpa();
		 
		var jsonUrl = window.contextRoot + '/json/purdetail/'+paravalue;
		 alert('value of jsonUrl'+jsonUrl);
		var table=$table.DataTable({
			initComplete:function(){
				 $('#select-all').on('click', function(){
					 if ($('#select-all').is(":checked")) {
						 
		                    $('#btnClick').removeAttr('disabled');
		                }
		                else {
		                	 $('#btnClick').attr('disabled', 'disabled');
		                }
				      // Get all rows with search applied
				      var rows = table.rows({ 'search': 'applied' }).nodes();
				      // Check/uncheck checkboxes for all rows in the table
				      $('input[type="checkbox"]', rows).prop('checked', this.checked);
				   });
				
				$('.chk1').change(function () {
					 
	                if ($(this).is(":checked")) {
	                    $('#btnClick').removeAttr('disabled');
	                }
	                else {
	                    var isChecked = false;
	                    $('.chk1').each(function () {
	                        if ($(this).is(":checked")) {
	                            $('#btnClick').removeAttr('disabled');
	                            isChecked = true;
	                        }
	                    });
	                    if (!isChecked) {
	                        $('#btnClick').attr('disabled', 'disabled');
	                    }
	                }
	 
	 
	            });
				 $('#btnClick').on('click', function(e){
				      var textarray =[];
				      var array = [];
				      var selectedvalue=document.querySelector('input[name="GSTRATE"]:checked').value;
					 $( "input[type=checkbox]" ).each(function(){
				            if($(this).is(':checked'))
				            {
				                var vtext = $(this).closest('tr').find($( "input[type=text]" )).val();
				                var vcheck= $(this).val();
				                array.push(vcheck);
				                textarray.push(vtext);
				                //alert(value);
				            }
				        });
					 alert('array value'+array);
					 alert('array textarray'+textarray);
					 alert('array selectedvalue'+selectedvalue);
				 
					 location.replace(window.contextRoot+"/prbarcodeprint?barcoded="+array+"&textv="+textarray+"&rad="+selectedvalue);

				      
				 
				 
				 });
			},
			columnDefs: [
			    { orderable: false, targets: 0 }
			  ],
			  order: [[1, 'asc']],
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
		 
			columns : [ 
			 	{
				data : 'barcode',
				mRender : function(data, type, row) {
					return '<input type="checkbox" name ="barc" class="chk1 "  value="'+data+'"/>';
				}
			}, 
			{
				data : 'barcode',
				mRender : function(data, type, row) {
					return  data;
				}
			}, 
			
			{data : 'pl',
				mRender : function(data, type, row) {
					return data.pname;
				}

			},  
			{
				data : 'pcs',	
				mRender : function(data, type, row) {
					return '<input type="text" value="'+data+'"/>';
				}
			}, 	
			{
				data : 'bvalue'
			},
			{
				data : 'pl',
				mRender : function(data, type, row) {
					return data.gstp+'% ----'+data.gstpm+'%';
					}
			
			},

			{
				data : 'mrp'
			} 			
			]
		});
	}
	
	/*	Barcode Table*/
	/*Product Summary need to update*/
	var $table = $('#purdata');
	if ($table.length) {
		var jsonUrl = window.contextRoot + 'json/purchaseall';
		$table.DataTable({
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [ {
				data : 'pid'
			}, {
				data : 'intype'
			},
			{
				data : 'splid',
				mRender : function(data, type, row) {
					return data.sname;
				}

			}, {
				data : 'splinv',
				 

			}, 
			{
				data : 'spldt'
			} ,
			{
				data:'transf'
					,
					mRender: function(data,type, row)
					{
						if(data)
							{

							return		'<a href="'
																							+ window.contextRoot
																							+ '/update/'
																							+ '/bar='+data+'" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open">Print Barcode</span></a> &#160;';
							
							
							}
							else{
								return '<span style="color:blue">Stock Not yet Transfered..</span>'; 
							}
					}
			},
			{
				data: {transf :"transf",pid :"pid"}
					,
					mRender: function(data, type, row)
					{
						//return data.transfer;
						if(data.transf)
							{

							return ' '; 
							
							
							}
							else{
								//alert('value of purid '+ data.purid);
								return		'<a href="'
								+ window.contextRoot
								+ '/purchase?'
								+ 'pur_id='+data.pid+'" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open">Update</span></a> &#160;';
							}
					}
			}
			,
			{
				data:'transf'
					,
					mRender: function(data,type, row)
					{
						if(data)
							{
							return '<span style="color:blue">Included in stock</span>'; 
							
							
							
							}
							else{
								return		'<a href="'
								+ window.contextRoot
								+ '/update/'
								+ '/bar='+data+'" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open">Transfer to Stock</span></a> &#160;';
								
							}
					}
			} ,
			{
				data:'pid'
					,
					mRender: function(data,type, row)
					{
						 

							
							return		'<a href="'
							+ window.contextRoot
							+ '/myreporttrial/'
							 +data+'" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open">Invoice</span></a> &#160;';
							
							 
					}
			},
			{
				data:'transf'
					,
					mRender: function(data,type, row)
					{
						if(data)
							{

							
							return		'';
							
							}
							else{
								; 
								return		'<a href="'
								+ window.contextRoot
								+ '/update/'
								+ '/bar='+data+'" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open">Delete</span></a> &#160;';
							}
					}
			}

			]

		});

	}
	
	/* ProductList */
	var $table = $('#pli');
	 if ($table.length) 
	 {
		$('#pli tfoot th').each( function()
		{
	        var title = $(this).text();
	        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
	    });
		
		var jsonUrl = window.contextRoot + '/json/da';
		var t1=	$table.DataTable({
			initComplete:function(){
				
				this.api().columns().every(function(){
					
					var that=this;
					$('input', this.footer()).on('keyup change clear', function(){
						
						if(that.search()!==this.value){
							that.search(this.value).draw();
						}
						
					});
					
					
				});
				
			},
		 
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [ {
				data : 'id'
			}, {
				data : 'pname',

			}, {
				data : 'gstp',

			}, {
				data : 'gstpm'
			},{
				data : 'sid',
				bSortable : false,
				mRender : function(data, type, row) {
					var str = '';
					str += '<button>Select!</button>';
					  
					return str;
				}
			}

			]
 		});
	$('#pli tbody').on( 'click', 'button', function () {
        var dt = t1.row( $(this).parents('tr') ).data();
        //data();
       
        window.parent.myvalsetup(dt.id,dt.pname);	
        window.parent. HideModalWindow();
    } );
	
	
	}
 /* Supplier Details */

	var $table = $('#supplierdata');
	if ($table.length) {
		var jsonUrl = window.contextRoot + '/json/supplier';
		$table.DataTable({

					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'sid'
							},
							{
								data : 'sname',

							},
							{
								data : 'gstno',

							},
							{
								data : 'add1'
							},
							{
								data : 'add2'
							},
							{
								data : 'city'
							},

							{
								data : 'distrcit'
							},

							{
								data : 'state'
							},

							{
								data : 'pincode'
							},

							{
								data : 'phoneno'
							},

							{
								data : 'mobile'
							},

							{
								data : 'email'
							},
							{
								data : 'sid',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/supplier/'
											+ data
											+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
									return str;
								}
							}

					]

				});

	}

	/* Supplier details End */

	var $alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000);
	}
	
/*	add product purchase*/
	
	/*product update start */

	/*trial code*/


	 /*trial code*/
	
	
});
function showSupplier() {
	var jsonUrl = window.contextRoot + '/json/supplier';
	var text2 = $("#Text2").tautocomplete({
		width : "500px",
		columns : [ 'Supplier Name', 'GST No' ],
		ajax : {
			url : "json/supplier",
			type : "GET",
			data : function() {
				return [ {
					test : text2.searchdata()
				} ];
			},
			success : function(data) {

				var filterData = [];

				var searchData = eval("/" + text2.searchdata() + "/gi");

				$.each(data, function(i, v) {
					if ((v.sname.search(new RegExp(searchData)) != -1)) {
						filterData.push(v);
					}
				});
				return filterData;
			}
		},
		onchange : function() {
			$("#splid").val(text2.id());

			// $("#ta-id").html(text2.id());
		}
	});
}
var text3;
var tidv;
var tidtext;
function showProduct() {
	
	
	var jsonUrl = window.contextRoot + '/json/da';
	text3 = $("#Text3").tautocomplete({
 
		width : "500px",
		columns : ['id','pname','gstp'],
		//hide : [ false ],

		ajax : {
			url : "json/da",
			type : "GET",
			data : function() {
				return [ {
					test : text3.searchdata()
				} ];
			},
			success : function(data) {

				var filterData = [];

				var searchData = eval("/" + text3.searchdata() + "/gi");

				$.each(data, function(i, v) {

					if ((v.pname.search(new RegExp(searchData)) != -1)) {
						filterData.push(v);
					}
				});
				// alert(filterData);
				return filterData;
			}
		},
		onchange : function() {
		 
			myvalsetup(text3.id(),text3.text());	
		 
		}
	});
}
function myvalsetup(sid,stext)
{
 
	$("#ta-txt").html(stext);
	$("#ta-id").html(sid);
	$("#pl").val(sid);
tidv=sid;
tidtext=stext;

 $('#pcs').val('0');
 $('#qty').val('1.0');
 $('#bvalue').val('0.0');
calldet();
	}
var modalWin = new CreateModalPopUpObject();
modalWin.SetLoadingImagePath("./assets/images/loading.gif");
modalWin.SetCloseButtonImagePath("./assets/images/remove.gif");
function detailProduct(){
	var callbackFunctionArray = new Array(refreshpage,myvalsetup,HideModalWindow);
	var url1= window.contextRoot +"/tr";
	 modalWin.ShowURL(url1,800,1400,'PRODUCT DETAILS',null,callbackFunctionArray);
	 }//end of bank
function refreshpage() {
	   form.submit(); 
	}
var errmsg='';
var pridfa='';
function purdsave(){
	var prid=document.getElementById("var").value;
 
	 var x=savefun()
 
	 if(x)
		 {
		 //var myd=false;
		 
	if(prid==0)
		{
		billdetail();
		
		 
	//	document.getElementById("form1").submit();
		savepurchasedetail();
		
		getall();
		}
 
else{
	
	 //alert("I m inside else message");
	savepurchasedetail();
	getall();
	 
}
		 }
	 else{
		 alert("Kindly check following items : "+errmsg) ;
	 }
}
function billdetailup()
{
	if(prid!=0)
		{
			var prid=document.getElementById("var").value;
			var ouv=  myurldataup();
			
			if(ouv)
			{ 
		billdetail();
		}
		}
	 else
	 {
		 alert("Kindly check following items : "+errmsg) ;
	 }

	
}

 function billdetail()
 {
	 var url= window.contextRoot +'/purchase?pur_id=0';
		var postdata=$("#form1").serialize();
		
		method="POST";
		$.ajax({
			type:method,
			async: false,
			url : url,
			dataType: "JSON",
			data :postdata,
			success:function(data)
			{
				 
			 
				  $('#var').val(data.status)
				  $('#inid').val(data.status);
				  pridfa=data.status;
			 
		 
				 // getall();
			},
		 error: function (jqXhr, textStatus, errorMessage) { 
		    
		     var err = JSON.parse(jqXhr.responseText);
		     alert(err.message);
		    }
			
			
		});
		
		
		//console.log(postdata);
 }
 var xmlHttp   
      
  function calldet()
{ 
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
	var url = "/json/data/"+tidv;
	xmlHttp.onreadystatechange = callp;
	xmlHttp.open("GET", url, true);
	xmlHttp.send();
 	 
} 
	var prdetail;  
 function callp()
 {
	 if (this.readyState == 4 && this.status == 200)
	 { 
		    var myObj = JSON.parse(this.responseText);
		//    console.log(myObj);
		    prdetail=myObj;;
		    
		    if(myObj.ptype==1)
		    	{
		    	$('#qty').val('1.0');
				 
		    	document.getElementById("qty").disabled =true;
		    	document.getElementById("qty").value ="1";
		    	
		    	
		    	}else{
		    		  document.getElementById("qty").disabled =false;
		    		  
		    		  }
		    		  document.getElementById("pcs").focus();

 }
 }
 
 function myurldataup()
 {
	 var suppinv=document.getElementById("splinv").value ;
	 var suppdt=document.getElementById("spldt").value ;
	 var suppid=document.getElementById("splid").value;
	 if(suppinv=="")
	 {
	 errmsg+='Select Supplier Inv No  ; ';
	    
	    return false;
	 }
 if(suppdt=="")
 {
 errmsg+='Select Bill Date; ';
    
    return false;
 }
 if(suppid=="")
 { inlineMsg('splid','Select Supplier',2);
 errmsg+='Select Supplier; ';
    
    return false;
 }
 return true;
 }
 
 function savefun()
{ 
	 var prsltd = tidtext;
// alert('value of prsltd'+prsltd);
	 var pcsdata= document.getElementById("pcs").value;
	 var qtydata=document.getElementById("qty").value;
	 var bvaluedata=document.getElementById("bvalue").value;
	 var gsts =prdetail.gstonSale;
	 var gstmin=prdetail.gstp;
	 var gstmax=prdetail.gstpm;
	 var ouv=  myurldataup();
	
		 if(ouv==false)
			 {
			 return false;
			 }
 	
	 if(prsltd == "")
	 {
		 errmsg+='Select Product; ';
	    
	    return false;
		}
	 if(bvaluedata=="0.0" || bvaluedata=="")
	 {
		 errmsg+='KIndly enter base value.  ;';
		  return false;
	 } 
	 
	 if(prdetail.ptype==1)
		 {
		 if(pcsdata=="0" || pcsdata=="")
		 {
			 errmsg+='KIndly enter Pcs.  ;';
			  return false;
		 } 
		
		 }
	 if(prdetail.ptype==0){
		 if(pcsdata=="0" || pcsdata=="" ||qtydata=="0.0"||qtydata=="")
		 {
			 errmsg+='KIndly enter Pcs.  ;';
		  return false;
		 }
		  
		 }
	  if(gsts==0)
		  {
		  if(gstmin==0)
		  {
			  document.getElementById("mrp").value =bvaluedata;
		  }else
			  {
			  document.getElementById("mrp").value =Math.round(bvaluedata*(1+(gstmin/100)));
			  }
		  
		  }else{
			  if(bvaluedata>=gsts)
				  {
				  document.getElementById("mrp").value =Math.round(bvaluedata*(1+(gstmax/100)));
				  }
			  else
				  {
				  document.getElementById("mrp").value =Math.round(bvaluedata*(1+(gstmin/100)));
				  }
			  }
return true;
}
 
 function savepurchasedetail()
 {
	/* start update*/
	
 
		var url= window.contextRoot +'/purrege';
		var postdata=$("#form2").serialize();
		//adaasd postdata=postdata;
		//alert("form2 url"+url);
		// console.log("form2 postdata"+postdata);
		
		method="POST";
		$.ajax({
			type:method,
			async: false,
			url : url,
			dataType: "JSON",
			data :postdata,
			success:function(data)
			{
				//console.log("Inside");
			// alert("inside data"+data);
			// alert("postdata of form2"+data.status);
			 
				 
			},
		 error: function (jqXhr, textStatus, errorMessage) { 
		      
		     var err = JSON.parse(jqXhr.responseText);
		     alert(err.message);
		    }
			
			
		});
		
		
 
		  /* document.getElementById('pcs').innerhtml="0";
        	document.getElementById('qty').innerhtml="1.0";
        	document.getElementById('bvalue').innerhtml="0.0";
		*/
	 /*end update*/
 }
function getall()
{$('#printbill').removeAttr('disabled');
	var $table = $('#productent');
	if ($table.length) {
		var jsonUrl = window.contextRoot + '/json/purdetail/'+pridfa;
		$table.DataTable({
			 destroy: true,
			ajax : {url : jsonUrl,
				dataSrc : ''
				},
				columns :[
					{
						data : 'pl',
						mRender : function(data, type, row) {
							return data.sg.sname;
						}
						
					},
					{
						data :'barcode'
							},
							{
								data :'pcs'
									},
									{
										data :'qty'
											},
											{
												data :{qty:'qty',pcs:'pcs'},
												mRender : function(data, type, row) {
													return data.qty*data.pcs;
												}
													},
													{
														data :'bvalue'
															},
															{
																data :'mrp'
																	},
																	{
																		data :'spldis'
																			},
																			{
																				data :'spltax'
																					},
																					{
																						data:{barcode:'barcode',inid:'inid'},
																						mRender : function(data, type, row) {
																							//alert("value of data.transf"+data.inid.transf);
																							if(data.inid.transf)
																								{
																								
																								return'';
																								}else{
																									return		'<input type="button" name="s3"  class="btn btn-primary " value="UPDATE"  onclick="updateProductdetail('+data.barcode+');"/> &#160;<br>'+'<a href="'
																									+ window.contextRoot
																									+ '/delete'
																									+ '?bar='+data.barcode+'" class="btn btn-primary delac"> DELETE </a> &#160;';
																								}
																					

																						}
																					}
				],
				initComplete : function() {
					var api = this.api();
					api.$('.delac')
					.on(
							'click',
							function(e) {
								e.preventDefault();
								href = $(this).attr('href');
							
								var dMsg ='Are you sure?';
							 
							 var product=href.substring(href.indexOf('=')+1,href.length);
							 
								 
								 bootbox.confirm({size : 'medium',
									title : 'Product Delete',
									message : dMsg,callback : function(result){
										  if (result) {
										 //   alert('value of bar value '+product);
										    var activationUrl = window.contextRoot+href;
									$.post(
													activationUrl,
													function(data) {
														bootbox.alert({
																	size : 'medium',
																	title : 'Information',
																	message : data
																	
																});

													});
										    }
									}
									
								});
										
								getall();		
							//	
								 
							});
				
				}
			});
		
	}
		 
}
function HideModalWindow() {
    modalWin.HideModalPopUp();
}
function updateProductdetail(barcode)
{
	var callbackFunctionArray = new Array(HideModalWindow );
	var url1= window.contextRoot +"/pliupdate?bar="+barcode;
	 
	 modalWin.ShowURL(url1,800,1400,'PRODUCT DETAILS',null,callbackFunctionArray);
	// getall();
//location.reload();
	}
function formupdatesub()
{
	//alert('inside formup function'); 
		var url= window.contextRoot +'/pliupdate';
		var postdata=$("#form3").serialize();
	 
		method="POST";
		$.ajax({
			type:method,
			async: false,
			url : url,
			dataType: "JSON",
			data :postdata,
			success:function(data)
			{  window.parent.location.reload();   
				 window.parent. HideModalWindow();  			 
			},
		 error: function (jqXhr, textStatus, errorMessage) { 
		      
		     var err = JSON.parse(jqXhr.responseText);
		     alert(err.message);
		    }
			
			
		});
	
	 
	}
function basemrpcalc()
{
	 var gstonsvalue = document.getElementById("pupgstons").value;
	 var  gstpvalue=document.getElementById("pupgstp").value;
	 var gstpmvalue = document.getElementById("pupgstpm").value;
	 var basevalue=document.getElementById("bvalue").value;
	 console.log('value of following item GSTOnValue, GST Percentage, GSTPercentMax, BaseValue '+gstonsvalue+' '+gstpvalue+' '+gstpmvalue+' '+basevalue);
	var mrpfinal='';
	 if(gstonsvalue=='0')
		 {
		 mrpfinal=Math.round(basevalue*(1+(gstpvalue/100)));
		 console.log('value of mrpfinal '+mrpfinal);
		 }
	 else{
		 mrpfinal=Math.round(basevalue*(1+(gstpmvalue/100)));
		 console.log('value of mrpfinal '+mrpfinal);
	 }
	 document.getElementById('pupmrp').value=mrpfinal;
}
 function mrpbasecalc()
 {
	 var gstonsvalue = document.getElementById("pupgstons").value;
	 var  gstpvalue=document.getElementById("pupgstp").value;
	 var gstpmvalue = document.getElementById("pupgstpm").value;
	 var mrpvalue=document.getElementById("pupmrp").value;
	 console.log('value of following item GSTOnValue, GST Percentage, GSTPercentMax, BaseValue '+gstonsvalue+' '+gstpvalue+' '+gstpmvalue+' '+mrpvalue);
	var basefinal='';
	 if(gstonsvalue=='0')
		 {
		 basefinal=Math.round(mrpvalue/(1+(gstpvalue/100)));
		 console.log('value of basefinal '+basefinal);
		 }
	 else{
		 basefinal=Math.round(mrpvalue/(1+(gstpmvalue/100)));
		 console.log('value of basefinal '+basefinal);
	 }
	 document.getElementById('bvalue').value=basefinal;
 }
 function getprno(prdatainv)
 {
	 location.href ="/myreporttrial/"+prdatainv;
 }
 function printbarcode()
 {
	 
	 var callbackFunctionArray = new Array(HideModalWindow);
		var url1= window.contextRoot +"/barcodeprintp/"+pridfa;
		 
		/*window.contextRoot +*/
		 modalWin.ShowURL(url1,800,1400,'PRODUCT DETAILS',null,callbackFunctionArray);
 }
 
   