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
	case 'PurchaseDetail':
		$('purchasedetail').addClass('active');
		break;
 	default:
		$('home').addClass('active');
		break;
	}

	const queryString = window.location.search;
	//console.log(queryString);
	const urlParams = new URLSearchParams(queryString);
	const product = urlParams.get('pur_id');
	const product1 = urlParams.get('opn_id');
	const rsaledsq1 =urlParams.get('bill_id');
	 if(document.getElementById('dateinv')!=null)
{
	var today = new Date();
var months=['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
 


var date1 = today.getDate()+'-'+months[(today.getMonth()+1)-1]+'-'+today.getFullYear();
	document.getElementById('dateinv').value =date1;
	document.getElementById('indate').value=date1;
}
	
	if(product!=0)
	{
//alert('inside product check'+product);
		pridfa=product;
 
			getall();
			  $('#inid').val(product);
			 // document.getElementById("inid").value =product;
	}
	
	if(rsaledsq1!=0)
	{
		pridfa=rsaledsq1;
		getrsaledt();
		$('#varbill').val(rsaledsq1);
	}
	
	if(product1!=0)
		{
		pridfa=product1;
		 
		getopeningdetl();
		  $('#inid').val(product1);
		   
		}
	
	
	var $table = $('#deepak');
	if ($table.length) {
		var jsonUrl = window.contextRoot + '/POS/json/data';
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
	var clastoselect=document.getElementById("ptopre").value;
	//	var paravalue=window.parent.geturlpa();
	var jsonUrl ;
		 if(clastoselect=='Print-All-Barcode')
			 {
			 jsonUrl = window.contextRoot + '/POS/json/opdetail/'+paravalue;
			 }else
				 {
				 jsonUrl = window.contextRoot + '/POS/json/purdetail/'+paravalue; 
				 }
		
		 //alert('value of jsonUrl'+jsonUrl);
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
					 
				 
					 location.replace(window.contextRoot+"/POS/prbarcodeprint?barcoded="+array+"&textv="+textarray+"&rad="+selectedvalue+"&ctos="+clastoselect);

				      
				 
				 
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
	
	/* RSale*/
	
	var $table = $('#saleddata');
	if ($table.length) {
		var jsonUrl = window.contextRoot + '/POS/json/rsaledetail';
	 	 //alert('value of jsonUrl'+jsonUrl);
	$table.DataTable({
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [ {
				data : 'billInvId'
			}, {
				data : 'date'
			},
			{
				data : 'pcs',
				 

			}, {
				data : 'qty',
				 

			}, 
			{
				data : 'gross'
			} ,
			{
				data: 'outstanding'
					 
			},
			{
				data:'outstanding'
			}
			,
			{
				data: 'user',
					mRender: function(data,type, row)
					{
						return data.username;
						} 
			} ,
			{
				data:{payment:'payamt',billInvId:'billInvId'}
					,
					mRender: function(data,type, row)
					{
						 if(data.payment!=0)
					{
						return'<a href="'
							+ window.contextRoot
							+ '/POS/bill?bill_id='
							 +data.billInvId+'" class="btn btn-primary">View</a>';
					}
					else{
						
						return'Bill Paid';
					}

						 	 
					}
			},
			{
				data:'outstanding'
					,
					mRender: function(data,type, row)
					{
						if(data!=0)
							{

							
							return		'<a href="'
								+ window.contextRoot
								+ '/POS/rsaledell/'
								+ '/bar='+data+'" class="btn btn-danger"><span class="glyphicon glyphicon-eye-open">Delete</span></a> &#160;';
							
							}
							else{
								; 
								return		'<a href="'
								+ window.contextRoot
								+ '/POS/Rsaleprint/'
								+ '/bar='+data+'" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open">Print Bill</span></a> &#160;';
							}
					}
			}

			]

		});
	}
	

	
	/* RSale*/
	
	
	/*	Stock Table*/
	var $table = $('#stocktable');
	if ($table.length) {
	 
		
	//	var paravalue=window.parent.geturlpa();
		 
		var jsonUrl = window.contextRoot + '/POS/json/st';
		// alert('value of jsonUrl'+jsonUrl);
		var table=$table.DataTable({
			initComplete:function(){
				 $('#select-allOp').on('click', function(){
					 if ($('#select-allOp').is(":checked")) {
						 
		                    $('#btnClickstock').removeAttr('disabled');
		                }
		                else {
		                	 $('#btnClickstock').attr('disabled', 'disabled');
		                }
				      // Get all rows with search applied
				      var rows = table.rows({ 'search': 'applied' }).nodes();
				      // Check/uncheck checkboxes for all rows in the table
				      $('input[type="checkbox"]', rows).prop('checked', this.checked);
				   });
				
				$('.chkop1').change(function () {
					 
	                if ($(this).is(":checked")) {
	                    $('#btnClickstock').removeAttr('disabled');
	                }
	                else {
	                    var isChecked = false;
	                    $('.chkop1').each(function () {
	                        if ($(this).is(":checked")) {
	                            $('#btnClickstock').removeAttr('disabled');
	                            isChecked = true;
	                        }
	                    });
	                    if (!isChecked) {
	                        $('#btnClickstock').attr('disabled', 'disabled');
	                    }
	                }
	 
	 
	            });
				 $('#btnClickstock').on('click', function(e){
				      var textarray =[];
				      var array = [];
				    //  var selectedvalue=document.querySelector('input[name="GSTRATE"]:checked').value;
					 $( "input[type=checkbox]" ).each(function(){
				            if($(this).is(':checked'))
				            {
				               
				                var vcheck= $(this).val();
				                if(vcheck==1)
				                	{
				                	
				                	}else{
				                		array.push(vcheck);
				                	}
				                
				               
				                //alert(value);
				            }
				        });
					 array=array+' ';
					 
				//	 alert('array value'+array);
					 
				 
					// location.replace(window.contextRoot+"/prbarcodeprint?barcoded="+array+"&textv="+textarray+"&rad="+selectedvalue);
var rptop=document.getElementById("btnClickstock").value;
//alert('value of selected report'+rptop);
					 printbarcode(array,rptop);   
				 
				 
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
					data:'stockid', 
					mRender : function(data, type, row) {
						return '<input type="checkbox" name ="barc" class="chkop1 "  value="'+data+'"/>';
					}
				 
				},
			 	{
				data : 'stockid',
				 
			}, 
			{
				data : 'stocktype',
				 
			}, 	
			{
				data : 'stockon'
			}, 
			
			{data : 'amount',
				 

			},  
			{
				data : 'nor',	
				 
			},
			{
				data:'stockid',
				mRender : function(data, type, row)
				{
					
						return'<input type="button" name="Barcodestock"  class="btn btn-primary " value="Barcode"  onclick="printbarcode('+"'"+data+"'"+",'Print-All-Barcode'"+');"/> &#160;<br>';
				  
					 
			
				}		
	 	
			},

			{
				
				data:{stockid:'stockid',stocktype:'stocktype'},
				mRender : function(data, type, row)
				{
					if(data.stocktype=='current-opening')
					{
						//return'<input type="button" name="Barcodestock"  class="btn btn-primary " value="Barcode"  onclick="printbarcode('+"'"+data.stockid+"'"+');"/> &#160;<br>';
						return ' <input type="button" name="Printstock"  class="btn btn-primary " value="Print Bill"  onclick="getallprno('+"'"+data.stockid+"'"+');"/> &#160;<br>';
					}else{
						var st=data.stocktype;
						st=st.substring(0,st.length-9);
					//alert('value of st'+st);
				//	return		'<input type="button" name="Barcodestock"  class="btn btn-primary " value="Barcode"  onclick="printbarcode('+"'"+st+"'"+');"/> &#160;<br>';
					return ' <input type="button" name="Printstock"  class="btn btn-primary " value="Print Bill"  onclick="getprno('+"'"+st+"'"+');"/> &#160;<br>';
				}
			
				}		
				
				
				 
				 
				 
			} 	,

			{
				data:{stockid:'stockid',stocktype:'stocktype'},
				 mRender : function(data, type, row)
				{
					 if(data.stocktype=='current-opening')
					 {
						 return '<a href="'+ window.contextRoot+ '/POS/stockOpening?opn_id='+data.stockid+'" class="btn btn-primary btn-xs">Update/Add</a>'
					 }
					 else
					{
					return'';
					}
				}
			} 	 		
			]
		});
	}
	
	/*	Stock Table*/
	
	
	/*Product Summary need to update*/
	var $table = $('#purdata');
	if ($table.length) {
		var jsonUrl = window.contextRoot + '/POS/json/purchaseall';
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
				data: {transf :"transf",pid :"pid"}
					,
					mRender: function(data,type, row)
					{
						if(data.transf)
							{

							return		'<input type="button"  name="s111" class="btn btn-primary btn-xs " value="Barcode p" onclick="printbarcode('+"'"+data.pid+"'"+');" />'
							/*'<input type="button" name="s3"  class="btn btn-primary " value="UPDATE"  onclick="updateProductdetail('+data.barcode+');"/> &#160;<br>'*/
							
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
								+ '/POS/purchase?'
								+ 'pur_id='+data.pid+'" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-eye-open">Update</span></a> &#160;';
							}
					}
			}
			,
			{
				data: {transf :"transf",pid :"pid"}
					,
					mRender: function(data,type, row)
					{
						if(data.transf)
							{
							return '<span style="color:blue">Included in stock</span>'; 
							
							
							
							}
							else{
								return		'<a href="'
								+ window.contextRoot
								+ '/POS/stocktransfer/'
								+data.pid+'" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open">Transfer to Stock</span></a> &#160;';
								
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
							+ '/POS/myreporttrial/'
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
								+ '/POS/update/'
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
		
		var jsonUrl = window.contextRoot + '/POS/json/da';
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
		var jsonUrl = window.contextRoot + '/POS/json/supplier';
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
											+ '/POS/supplier/'
											+ data
											+ '" class="btn btn-primary"><span class="fas fa-edit"></span></a> &#160;';
									return str;
								}
							}

					]

				});

	}

	/* Supplier details End */
	/*User Detail*/
	var $table = $('#userdtdata');
	if ($table.length) {
		var jsonUrl = window.contextRoot + '/POS/logidet';
		 
		$table.DataTable({

					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data :'usermid',
								 
							},
							{
								data : 'username',
								 

							},
							{
								data : 'role',
								 

							},
							{
								data : 'contactNumber',
								 
							},
							{
								data : 'enabled',
									mRender : function(data, type, row) {
										if(data==true)
											{
											return 'Yes';
											}
										else{
											return 'No'
										}
									}
							} 
							,
							{
								data:{usermid:'usermid',enabled:'enabled',role:'role'},
								
								mRender : function(data, type, row) {
									//alert("value of data.transf"+data.inid.transf);
									if(data.role=='ROLE_ADMIN')
									{
										return '';
									}else{
									var mydata;
									 if(data.enabled==true)
										 {
										 mydata=false;
										 }
									 else{
										
										 mydata=true;
									//alert('value of mydata'+mydata);
									 }
											return		'<a href="'
											+ window.contextRoot
											+ '/POS/userup'
											+ '?bar='+mydata+'&userid='+data.usermid+'" class="btn btn-primary delac"> UPDATE </a> &#160;';
											
									}
									  
								}
							},
							{
								data:'usermid',
								mRender : function(data, type, row) {
									return '<input type="button" onclick="cgpass('+"'"+data+"'"+');" class="btn btn-warning btn-xs" value="Update Password"/>';
									}
							}

					],initComplete : function() {
						var api = this.api();
						api.$('.delac')
						.on(
								'click',
								function(e) {
									e.preventDefault();
									href = $(this).attr('href');
								//alert('value of href'+href);
									var dMsg ='Are you sure?';
								  	 bootbox.confirm({size : 'medium',
										title : 'Active / DeActive User ',
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
										//;
											    }
											 location.reload();
										}
										
									});
											
											
								//	
									 
								});
						
					}

				});

	}
	
	/*User Detail*/

	var $alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000);
	}
	
   
/////	
 });
function showSupplier() {
	var jsonUrl = window.contextRoot + '/POS/json/supplier';
	var text2 = $("#Text2").tautocomplete({
		width : "500px",
		columns : [ 'Supplier Name', 'GST No' ],
		ajax : {
			url : "/POS/json/supplier",
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
	
	
	var jsonUrl = window.contextRoot + '/POS/json/da';
	text3 = $("#Text3").tautocomplete({
 
		width : "500px",
		columns : ['id','pname','gstp'],
		//hide : [ false ],

		ajax : {
			url : "/POS/json/da",
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
//////

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
modalWin.SetLoadingImagePath("../assets/images/loading.gif");
modalWin.SetCloseButtonImagePath("../assets/images/remove.gif");
function detailProduct(){
	var callbackFunctionArray = new Array(refreshpage,myvalsetup,HideModalWindow);
	var url1= window.contextRoot +"/POS/tr";
	 
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
 
	$('#inid').val(prid);
	// alert("I m inside else message of update");
	savepurchasedetail();
	pridfa=prid;
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
	 var url= window.contextRoot +'/POS/purchase?pur_id=0';
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
	var url = "/POS/json/data/"+tidv;
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
		    prdetail=myObj;
		    
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
	if(document.getElementById("Rad")!=null){
		var count =document.getElementById("Rad").checked;
		
		 if(count==true){
			 var mrpdet=document.getElementById("mrp").value;
			 if(mrpdet=="0.0" || mrpdet=="")
			 {
				 errmsg+='KIndly enter MRP value.  ;';
				  return false;
			 } 
		 }
	}
	else{
		 if(bvaluedata=="0.0" || bvaluedata=="")
		 {
			 errmsg+='KIndly enter base value.  ;';
			  return false;
		 } 
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
	 ////
	 if(document.getElementById("Rad")!=null){
			var count =document.getElementById("Rad").checked;
			
			 if(count==true){
				 var mrpdet=document.getElementById("mrp").value;
				 ////

				  if(gsts==0)
					  {
					  if(gstmin==0)
					  {
						  document.getElementById("bvalue").value =mrpdet;
					  }else
						  {
						  document.getElementById("bvalue").value =Math.round(mrpdet/(1+(gstmin/100)));
						  }
					  
					  }else{
						  if(bvaluedata>=gsts)
							  {
							  document.getElementById("bvalue").value =Math.round(mrpdet/(1+(gstmax/100)));
							  }
						  else
							  {
							  document.getElementById("bvalue").value =Math.round(mrpdet/(1+(gstmin/100)));
							  }
						  }
					
				 
				 /////
			 }
		}
		else{
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
		}
return true;
}
 
 function savepurchasedetail()
 {
	/* start update*/
	
 
		var url= window.contextRoot +'/POS/purrege';
		var postdata=$("#form2").serialize();
		//adaasd postdata=postdata;
		//alert("form2 url"+url);
		   //console.log("form2 postdata"+postdata);
		
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
		
		
 
		  
	 /*end update*/
 }
function getall()
{$('#printbill').removeAttr('disabled');
	var $table = $('#productent');
	if ($table.length) {
		var jsonUrl = window.contextRoot + '/POS/json/purdetail/'+pridfa;
		//alert('value of jsonUrl'+jsonUrl);
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
																									+ '/POS/delete'
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
									//;
										    }
										  getall()
									}
									
								});
										
										
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
	var url1= window.contextRoot +"/POS/pliupdate?bar="+barcode;
	 
	 modalWin.ShowURL(url1,800,1400,'PRODUCT DETAILS',null,callbackFunctionArray);
	// getall();
//location.reload();
	}
	function updateRsaledetail(barcode)
{ 
	alert('value of barcode'+barcode);
 var invid=document.getElementById("varbill").value;
alert('value of invid'+invid);
	var callbackFunctionArray = new Array(HideModalWindow );
	var url1= window.contextRoot +"/POS/rsup?bar="+barcode+"&indt="+invid;
	 
	 modalWin.ShowURL(url1,800,1400,'UPDATE PCS/QTY',null,callbackFunctionArray);
	// getall();
//location.reload();
	}
function updateStockdetail(barcode)
{
	var callbackFunctionArray = new Array(HideModalWindow );
	var url1= window.contextRoot +"/POS/stkdetupdate?bar="+barcode;
	 
	 modalWin.ShowURL(url1,800,1400,'PRODUCT DETAILS',null,callbackFunctionArray);
	// getall();
//location.reload();
	}
function formupdatesub(detail)
{	
	//alert('value of detail'+detail);
	var url;
var postdata;
	if(detail=='opening')
		{
		url= window.contextRoot +'/POS/stkdetupdate';
		postdata=$("#formstkup").serialize();
		}
	else{
		 url= window.contextRoot +'/POS/pliupdate';
		 postdata=$("#form3").serialize();
	}
	//alert('inside formup function'); 
	//	var url= window.contextRoot +'/pliupdate';
		//var postdata=$("#form3").serialize();
	 
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
function rsbillupdfr()
{
	var url= window.contextRoot +'/POS/rsup';
		 postdata=$("#formrsup").serialize();
		method="POST";
		alert('value of post data'+postdata);
		$.ajax({
			type:method,
			async: false,
			url : url,
			dataType: "JSON",
			data :postdata,
			success:function(data)
			{  
				window.parent.location.reload();  
				
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
function pcsqty()
{
	 
	
	 var pcs=document.getElementById("rspcs").value;
	var qty=document.getElementById("rsqty").value;
	var baseprice=document.getElementById("rsprice").value; 
	var discount=document.getElementById("discount").value;
	var ppcs=document.getElementById("ppcs").value;
	var pqty=document.getElementById("pqty").value;
	var gst=document.getElementById("gst").value;
	var balance1=document.getElementById("rsbalance").value;
	var bal=balance1*1+(pqty*ppcs);
	  if(bal<(pcs*qty))
{
	 alert('Stock entered is more than available');
console.log('Stock entered is more than available');
 document.getElementById("rsbt").disabled =true;
 
}
else{
	document.getElementById("rsbt").disabled =false; 
	 
		document.getElementById("rsnet").value=(Math.round(baseprice*(1+(gst/100)))*pcs*qty)-discount;
	 
		document.getElementById("rsnet").value=(Math.round(baseprice*(1+(gst/100)))*pcs*qty)-discount;
	
}
 
	 
	
	 
}
function pcsqty1()
{
pcsqty();
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
 if(prdatainv==0)
 {prdatainv=pridfa;
 }
 
	 location.href ="/POS/myreporttrial/"+prdatainv;
 }
 function getallprno(prdatainv)
 {
	if(prdatainv==0)
 {prdatainv=pridfa;
 }
	 location.href ="/POS/allreport/"+prdatainv;
 }
 function printbarcode(pridad,rptop)
 {
	// alert('value of pridad'+pridad);
	 var priddd;
	 if(pridad.includes(","))
		 {
		 priddd=pridad;
		 }else{
			 priddd=pridad.trim();
		 }
	 
	 
	 var callbackFunctionArray = new Array(HideModalWindow);
		var url1= window.contextRoot +"/POS/barcodeprintp/"+priddd+'?ptop='+rptop; //pridfa
		 
		/*window.contextRoot +*/
		 modalWin.ShowURL(url1,800,1400,'PRODUCT DETAILS',null,callbackFunctionArray);
 }
 function readonlyRate(){
	 var count=document.getElementById("checkRadio").checked;
	 if(count==true){
	   document.getElementById("mrp").readOnly = true;
	    document.getElementById("bvalue").readOnly = false;
	   }else{
	     document.getElementById("bvalue").readOnly = true;
	 	document.getElementById("mrp").readOnly = false;
	 	}
	 }
 function openingsave()
 {
	// alert('inside openingsave');
	 var prid=document.getElementById("var").value;
	//alert('value of prid'+prid);
	 
	 var x=savefun();
	//alert('value of x'+x);
	 if(x)
		 { if(prid==0)
			 {

			 //alert('inside prid if');
			 onlinestockdetail();	
			 savestockdetail();
			 getopeningdetl();
			 }
		 else{
			 savestockdetail();
			 getopeningdetl();
		 }
		 
		 }else{
			 alert("Kindly check following items : "+errmsg) ;
		 }
 }
 function onlinestockdetail()
 {
	 var url= window.contextRoot +'/POS/stockOpening?opn_id=0';
	//	var postdata=$("#form1").serialize();
		//alert('value of url for foron '+url);
		//alert('value of postdata'+postdata);
		method="POST";
		$.ajax({
			type:method,
			async: false,
			url : url,
			dataType: "JSON",
			data :{stockid: null,
				stocktype: "current-opening",
				amount: 0,
				nor: 0,
				stockon: "01-04-2021"},
			success:function(data)
			{
				 
			// alert('inside sucess function');
				  $('#var').val(data.status)
				  $('#inid').val(data.status);
				  pridfa=data.status;
			 
		 
				 // getall();
			},
		 error: function (jqXhr, textStatus, errorMessage) { 
		    
		     var err = JSON.parse(JSON.stringify(jqXhr.responseText));
		     alert("error message"+err.message);
		    }
			
			
		});
		
		
		//console.log(postdata);
 }
 function savestockdetail()
 {
	/* start update*/
	//alert('inside savestock');
 
		var url= window.contextRoot +'/POS/stockOpeningdet';
		var postdata=$("#form5").serialize();
		//alert('value of url'+url);
//alert("form2 url"+url);
	//	  console.log("form5 postdata"+postdata);
		//alert('inside form5');
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
		     alert('error inside in form5'+err.message);
		    }
			
			
		});
		
		
 
		  /* document.getElementById('pcs').innerhtml="0";
        	document.getElementById('qty').innerhtml="1.0";
        	document.getElementById('bvalue').innerhtml="0.0";
		*/
	 /*end update*/
 }
 
 function getopeningdetl()
 {$('#openingBatch').removeAttr('disabled');
 	var $table = $('#openingtab');
 	if ($table.length) {
 		var jsonUrl = window.contextRoot + '/POS/json/opdetail/'+pridfa;
 		//alert('value of url inside datatable'+jsonUrl);
 		$table.DataTable({
 			 destroy: true,
 			ajax : {url : jsonUrl,
 				dataSrc : ''
 				},
 				columns :[
 					{
 						data : 'stkid',
 						mRender : function(data, type, row) {
 							return data.stockid;
 						}
 						
 					},
 					{
 						data :'pl',
 						mRender : function(data, type, row) {
 							return data.prId;
 						}
 							},
 					{
 						data :'pl',
 						mRender : function(data, type, row) {
 							return data.pname;
 						}
 							},{
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
 																		data :{qty:'qty',pcs:'pcs',mrp:'mrp'},
 						 												mRender : function(data, type, row) {
 						 													return data.qty*data.pcs*data.mrp;
 						 												}
 																			},
 																			  		{
 																						data:'barcode',
 																						mRender : function(data, type, row) {
 																							//alert("value of data.transf"+data.inid.transf);
 																							
 																									return		'<input type="button" name="s3"  class="btn btn-primary " value="UPDATE"  onclick="updateStockdetail('+data+');"/> &#160;<br>'+'<a href="'
 																									+ window.contextRoot
 																									+ '/POS/openingdelete'
 																									+ '?bar='+data+'" class="btn btn-primary delac"> DELETE </a> &#160;';
 																								 
 																					

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
 										 getopeningdetl();
 									}
 									
 								});
 										
 										
 							//	
 								 
 							});
 				
 				}
 			});
 		
 	}
 		 
 }
 function passwordcheck()
 {
	 var pass=document.getElementById("pass").value;
	 var repass=document.getElementById("repass").value;
	 
	 
	 if(repass!=pass)
		 {
		 alert('confirm password is not matched with password');
		 document.getElementById("pass").value='';
		 }
	 
 }
function cgpass(myid)
{
	//alert('value of myid'+myid);
	var locale = {
    OK: 'I Suppose',
    CONFIRM: 'Go Ahead',
    CANCEL: 'Maybe Not'
};
            
bootbox.addLocale('custom', locale);
            
bootbox.prompt({ 
    title: "New Password", 
    locale: 'custom',
    callback: function (result) {
        //console.log('This was logged in the callback: ' + result);

 										  if (result) {
 										 //   alert('value of bar value '+product);
 										    var activationUrl = window.contextRoot+'/POS/changepass?userid='+myid+'&newpass='+result;
					//alert('value of url'+activationUrl );
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
 										 location.reload();
    }
});
}
 
 
function myvalsetup1(mdid,mditext)
{
	 $("#ta-txt").html(mditext);
	$("#ta-id").html(mdid);
	tidv=mditext;
 tidtext=mdid;
	$('#pcs1').val('0');
 $('#qty1').val('1.0');
 $('#discount').val('0.0');
 $('#net').val('0.0');
calldet1();
}
function calldet1()
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
	var url = "/POS/json/barcode/"+tidv;
	xmlHttp.onreadystatechange = callp1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send();
 }
function callp1()
{
	if (this.readyState == 4 && this.status == 200)
	 { 
		    var myObj = JSON.parse(this.responseText);
	   console.log(myObj);
		    prdetail=myObj;
		    
		    if(myObj.l8==1)
		    	{
		    	$('#qty1').val('1.0');
				 
		    	document.getElementById("qty1").disabled =true;
		    	document.getElementById("qty1").value ="1";
		    	var onoff= document.getElementById("AutoO");
//alert('value of onoff'+onoff);
//alert('value of onoff.checked'+onoff.checked);
if(onoff.checked==true)
{
	document.getElementById("pcs1").value ="1";
	uppcs1();
	billdsave();
}
		    	
		    	}else{
		    		  document.getElementById("qty1").disabled =false;
		    		  
		    		  }
		    	document.getElementById("pcs1").focus();
				//alert('value of barcode'+myObj.l2);
				document.getElementById("barcode").value=myObj.l2;
				document.getElementById("pr1").value=myObj.l3;
				document.getElementById("prname").value=myObj.l12;
				document.getElementById("bprice1").value=myObj.l6;
	
 }
	
}
function uppcs1(){
	var pcs1=document.getElementById("pcs1").value;
	var qty1=document.getElementById("qty1").value;
	var bpr=document.getElementById("bprice1").value;
	var discount=document.getElementById("discount").value;
	document.getElementById("gross").value=(pcs1*qty1*bpr);
	document.getElementById("net").value=(pcs1*qty1*bpr)-discount;
}
function billdsave()
{
	var prid=document.getElementById("varbill").value;
 
	 var x=billsavefun()
 
	 if(x)
		 {
			if(prid==0)
			{//document.getElementById("date").value=new Date();
			 
				salebilldetail();
				bidtinv(tidv);
				//getrsaledt();
			}
			else{
				pridfa=prid;
				$('#billdetailbill').val(prid);
				bidtinv(tidv);
				getrsaledt();
			}
	}
	else{
		alert("Kindly check following items : "+errmsg) ;
	}
}
 function billsavefun()
{
	
	 var prsltd = tidtext;
 //alert('value of prsltd'+prsltd);
var barcd=document.getElementById("barcode").value;
var prnamed=document.getElementById("pr1").value;
	 var pcsdata= document.getElementById("pcs1").value;
	 var qtydata=document.getElementById("qty1").value;
	 var bvaluedata=document.getElementById("bprice1").value;
	 var gsts =prdetail.l10;
	 var gstmin=prdetail.L9;
	 var gstmax=prdetail.L11;
	 
 	
	 if(prsltd == "")
	 {
		 errmsg+='SCAN BARCODE; ';
	    
	    return false;
		}
	 
	 
		 if(pcsdata=="0" || pcsdata=="")
		 {
			 errmsg+='KIndly enter Pcs.  ;';
			  return false;
		 } 
		 
	 
		 if(qtydata=="0.0"||qtydata=="")
		 {
			 errmsg+='KIndly enter Pcs.  ;';
		  return false;
		 }
		 
	 ////
	  
	 
return true;
	
}

function salebilldetail()
 {
	 var url= window.contextRoot +'/POS/bill?bill_id=0';
		var postdata=$("#invform1").serialize();
		//alert('value of postdata in salebill'+postdata);
		method="POST";
		$.ajax({
			type:method,
			async: true,
			url : url,
			dataType: "JSON",
			data :postdata,
			success:function(data)
			{
				 
			 
				  $('#varbill').val(data.status)
				  $('#billInvId').val(data.status);
				$('#billdetailbill').val(data.status);
				  pridfa=data.status;
			 window.location.href='/POS/bill?bill_id='+data.status; 
		 
				 // getall();
			},
		 error: function (jqXhr, textStatus, errorMessage) { 
		    
		     var err = JSON.parse(jqXhr.responseText);
		     alert(err.message);
		    }
			
			
		});
		
			
		//console.log(postdata);
 }
function bidtinv(barc)
{ 
 //alert('value of barc inside bidtinv'+barc);
var url =window.contextRoot+'/POS/json/stockrg/'+barc;
 
	$.getJSON(url ,
function(data) {
	 
 			var pcs1=document.getElementById("pcs1").value;
		    var qty1=document.getElementById("qty1").value;
		    var balpcqty=pcs1*qty1;
		    if(data.tqty<balpcqty)
		    	{
		    	alert('available Stock '+data.tqty+' Pc/No');
 
		    	// 
		    	} 
else{
var url= window.contextRoot +'/POS/billdet';
		var postdata=$("#billdtform").serialize();
		 
		 //alert('value of postdata inside tdata'+postdata);
		method="POST";
		$.ajax({
			type:method,
			async: false,
			url : url,
			dataType: "JSON",
			data :postdata,
			success:function(data)
			{
			 //alert('value of data'+data);
			document.getElementById("Text4").value='';
			 document.getElementById("barcode").value='';
			 document.getElementById("pr1").value='';
			 document.getElementById("qty1").value='';
			 document.getElementById("bprice1").value='';
			 document.getElementById("discount").value='';
			 document.getElementById("net").value='';
			 document.getElementById("pcs1").value='';
			 document.getElementById("gross").value='';
			  getrsaledt();
				 
			},
		 error: function (jqXhr, textStatus, errorMessage) { 
		      
		     var err = JSON.parse(jqXhr.responseText);
		     alert(err.message);
		    }
			
			
		});
		 
		
}
   
});


///
 //getrsaledt();

}
 var mydbarid;
var mydbartxt;
 function getbardet(scdbar)
{
	var url1=window.contextRoot+'/POS/json/barcode/'+scdbar;
	$.getJSON(url1,
function( data) {
	//alert('value of data'+data.l1);
	mydbarid=data.l1;
	mydbartxt=data.l2;
	
	});
	
	var url =window.contextRoot+'/POS/json/stockrg/'+scdbar;
//alert('value of url'+url);
	
	//
	 
	//////
	$.getJSON(url ,
function( data) {
	//alert('value of data'+data.tqty);
	 
  
   // alert('Your query count: ' + data.query.count);
 		 
		    if(data.tqty<1)
		    	{
		    	alert('No  Stock Avialable......' );
// inlineMsg('pcs1','Nos should not exceed available stock',2);
		    	// 
		    	} 
else{
 myvalsetup1(mydbarid,mydbartxt);	
		
}
   
});
	
	
	
}
function getrsaledt()
{
	//alert('value of pridfa inside getrsaledt'+pridfa);
	$('#upbspay').removeAttr('disabled');
	 
	var $table = $('#salebp');
	if ($table.length) {
		var jsonUrl = window.contextRoot + '/POS/json/rsldbill/'+pridfa;
		//alert('value of jsonUrl'+jsonUrl);
		$table.DataTable({
			 
			"footerCallback":function ( row, data, start, end, display ){
				var api = this.api(), data;
 
            // converting to interger to find total
            var intVal = function ( i ) {
                return typeof i === 'string' ?
                    i.replace(/[\$,]/g, '')*1 :
                    typeof i === 'number' ?
                        i : 0;
					};
					 
				var pcstotal=api.column( 3 )
                .data()
                .reduce( function (a, b) {
                    return intVal(a) + intVal(b);
                }, 0 );
				
				
				var qtytotal=api.column( 4 )
                .data()
                .reduce( function (a, b) {
                    return intVal(a) + intVal(b);
                }, 0 );
			
				
				var grosstotal=api.column( 5 )
                .data()
                .reduce( function (a, b) {
                    return intVal(a) + intVal(b);
                }, 0 );

				 //console.log(api.column(5).data());
				var distotal=api.column( 6 )
                .data()
                .reduce( function (a, b) {
	 // data.qty*data.pcs*data.bprice
                    return intVal(a) + (intVal(b.pcs)*intVal(b.qty)*intVal(b.bprice));
                }, 0 );

				
				var nettotal=api.column( 7 )
                .data()
                .reduce( function (a, b) {
                    return intVal(a) + intVal(b);
                }, 0 );
	
				
				var gsttotal=api.column(8)
                .data()
                .reduce( function (a, b) {
	 
                    return intVal(a) + intVal(b);
                }, 0 );

				
				var netptotal=api.column(9)
                .data()
                .reduce( function (a, b) {
					 var x=intVal(b.gst);
				var y=intVal(b.net);
				if(x==0)
				{
					return intVal(a)+(x);
				}
				else{
					return intVal(a)+((y*x)/100).toFixed(2);
				}
	
                    
                }, 0 );
				 
			var netptt=api.column(10)
                .data()
                .reduce( function (a, b) {
	 			 var x=intVal(b.gst);
				var y=intVal(b.net);
				if(x==0)
				{
					return intVal(a)+(y);
				}
				else{
					return intVal(a) + Math.round(y*(1+(x)/100));
				}
	
                    
                }, 0 );
	
			$(api.column(3).header()).html(pcstotal);
			$(api.column(4).header()).html(qtytotal);
			$(api.column(5).header()).html(grosstotal);
			$(api.column(6).header()).html(distotal);
			$(api.column(7).header()).html(nettotal);
			$(api.column(8).header()).html(gsttotal);
			$(api.column(9).header()).html(netptotal);
			$(api.column(10).header()).html(netptt);
			},
			
			 destroy: true,
			ajax : {
				 
				url : jsonUrl,
				dataSrc : ''
				},
				columns :[
					{
						"title": "Serial",
        render: function (data, type, row, meta) {
        return meta.row + meta.settings._iDisplayStart + 1;
        }
						
					},
					{
						data :'barcode'
							},
							
							{
							data:'prname',
							mRender : function(data, type, row) {
													return data.psname;
												}
							},
							{
								data :'pcs'
									},
									{
										data :'qty'
											},
													{
														data :'bprice'
															},
											{
												data :{qty:'qty',pcs:'pcs',bvalue:'bprice'},
												mRender : function(data, type, row) {
													return data.qty*data.pcs*data.bprice;
												}
													},
															{
																data :'discount'
																	},
																	{
																		data :'net'
																			},
																			{
																				 
																				data:{gst:'gst',net:'net'},
																				mRender : function(data, type, row)
																				{
																					if(data.gst==0)
																					{
																						return data.gst;
																					}
																					else{
																						return (data.net*(data.gst)/100).toFixed(2);
																						 
																					}
																				}
																					},
																					{
																						data:{net:'net',gst:'gst'},
																						mRender : function(data, type, row)
																						{if(data.gst==0)
																						{
																							return data.net;
																						}
																						else{
																							return Math.round(data.net*(1+(data.gst)/100));
																						}
																						}
																						 
																					},
																					{
																						data: {barcode:'barcode',billdid:'billdid'} ,
																						mRender : function(data, type, row) {
																							// var ind=data.bill.billInvId;
																						//console.log('value of ind'+ind)
																									return		'<input type="button" name="s11"  class="btn btn-primary " value="UPDATE"  onclick="updateRsaledetail('+data.barcode+');"/> &#160;<br>'+'<a href="'
																									+ window.contextRoot
																									+ '/POS/delrsbill'
																									+ '?bar='+data.barcode+'&bild='+data.billdid+'" class="btn btn-primary delac"> DELETE </a> &#160;';
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
						//alert('value of activationUrl'+activationUrl);
									$.post(
													activationUrl,
													function(data) {
														bootbox.alert({
																	size : 'medium',
																	title : 'Information',
																	message : data
																	
																});

													});
									//;
										    }
						pridfa=document.getElementById("varbill").value;
										 getrsaledt();
									}
									
								});
										
										
							//	
								 
							});
					
				}
			});
		
	}
}