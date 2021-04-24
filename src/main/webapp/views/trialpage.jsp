<html>
    <head>
        <title></title>
        <style type="text/css">
            body {
            }
        </style>
        <link rel="stylesheet" type="text/css" href="/assets/css/tautocomplete.css" />
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script src="/assets/js/tautocomplete.js" type="text/javascript"></script>
        <script>
            $(document).ready(function () {
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
                        $("#ta-txt").html(text2.text());
                        $("#ta-id").html(text2.id());
                    }
                });
            });
        </script>
    </head>
    <body><br /><br /><br /><br /><br />
        <div style="width: 100%; text-align:center;">
            <input type="text" id="Text2" style="width: 200px; font-size:1.2em;" /><br /><br />
            Text: <span id="ta-txt"></span><br />
            ID: <span id="ta-id"></span><br />
        </div>
    </body>
</html>