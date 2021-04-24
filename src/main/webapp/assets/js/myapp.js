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

	var $table = $('#deepak');
	if ($table.length) {
		var jsonUrl = window.contextRoot + '/json/data';
		$table.DataTable({
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
				{
					data: 'prId'
				},
				{
					data: 'sg',
					mRender: function(data, type, row){
						return data.mg.mname;
					}
					
				},
				{
					data: 'sg',
					mRender: function(data, type, row){
						return data.sname;
					}
					
				},
				{
					data: 'pname'
				},
				
				{
					data: 'ptype'
				},
				{
					data: 'hsncode'
				},
			 

				{
					data: 'gstp'
				},
				
				
				{
					data: 'gstonSale'
				},
				
				{
					data: 'gstpm'
				}
				 
				]
		
		
		});
		
		
	}
	
/*	Supplier Details*/
	
	var $table = $('#supplierdata');
	if ($table.length) {
		var jsonUrl = window.contextRoot + '/json/supplier';
		$table.DataTable({
	 
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
				{
					data: 'sid'
				},
				{
					data: 'sname',
					 
					
				},
				{
					data: 'gstno',
				 
					
				},
				{
					data: 'add1'
				}, 
				{
					data: 'add2'
				},
				{
					data: 'city'
				},
			 

				{
					data: 'distrcit'
				},
				
				
				{
					data: 'state'
				},
				
				{
					data: 'pincode'
				},
				 
				{
					data: 'phoneno'
				},
				
				
				{
					data: 'mobile'
				},
				
				{
					data: 'email'
				},{
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
	
	
	
/*Supplier details End*/	

	var $alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000);
	}
});
function   showSupplier(){
	 var jsonUrl= window.contextRoot+'/json/supplier';
	               var text2 = $("#Text2").tautocomplete ({
       width: "500px",
       columns: ['Supplier Name','GST No'],
       ajax: {
           url: "json/supplier",
           type: "GET",
           data: function () {
               return [{ test: text2.searchdata() }];
           },
           success: function (data) {
               
               var filterData = [];

               var searchData = eval("/" + text2.searchdata() + "/gi");

               $.each(data, function (i, v) {
                   if (   (v.sname.search(new RegExp(searchData)) != -1)   ) {
                       filterData.push(v);
                   }
               });
               return filterData;
           }
       },
                   onchange: function () {
                       $("#splid").val(text2.id());
                      
                 //      $("#ta-id").html(text2.id());
                   }
               });
}
function   showProduct(){
	 var jsonUrl= window.contextRoot+'/json/data';
	               var text3 = $("#Text3").tautocomplete ({
	            	   
      width: "500px",
      columns: ['AS','As','as','as'],
      hide: [true,false,true],

      ajax: {
          url: "json/data",
          type: "GET",
          data: function () {
              return [{ test: text3.searchdata() }];
          },
          success: function (data) {
              
              var filterData = [];

              var searchData = eval("/" + text3.searchdata() + "/gi");

              $.each(data, function (i, v) {
            	  
                  if (   (v.pname.search(new RegExp(searchData)) != -1)   ) {
                      filterData.push(v);
                  }
              });
             // alert(filterData);
              return filterData;
          }
      },
                  onchange: function () {
                      $("#splid").val(text3.value());
                     
                //      $("#ta-id").html(text2.id());
                  }
              });
}