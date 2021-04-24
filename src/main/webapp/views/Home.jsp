
<!DOCTYPE html>
<html lang="en">
  <head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="PHP/MySQL | INVENTORY MANAGEMENT SYSTEM">
  <meta name="author" content="Erwin Agpasa">
    <link rel="icon" href="favicon.ico">
    <title>Kaushik | INVENTORY MANAGEMENT SYSTEM</title>
    <!-- Bootstrap core CSS -->
    <link type="text/css" rel="stylesheet" href="assets/css/bootstrap.css" />

    <link type="text/css" rel="stylesheet" href="assets/css/font-awesome.css" />
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap-datetimepicker.css">
  	<link type="text/css" rel="stylesheet" href="assets/css/global.css" />

	  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.min.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="login">
<div class="container">
  <div class="row">
    <div class="wrap">


    <div class="col-xs-12 col-sm-12 col-md-12">
      <div class="col-md-12 text-center">
      <img src="assets/images/logo.jpg" id="logo" />
     
      </div>

      <form method="post" action="/inventory/signin" style="height: 311px; ">
      



      <div class="form-group">
        <label class="control-label">USERNAME</label>
        <!--<input type="text"  class="form-control input-lg" name="username" value="">-->
        <input type="text"  class="form-control input-lg" name="username" value="root">
      </div>

      <br />
      <div class="form-group">
        <label class="control-label">PASSWORD</label>
        <!--<input type="password"  class="form-control input-lg" name="password" value="">-->
        <input type="password"  class="form-control input-lg" name="password" value="demo">
      </div>



        <input type="hidden" name="formsubmitted" value="TRUE" />
        <button type="submit" style="margin:20px 5px 0 0;width:100%;" class="input-lg btn btn-primary">SIGN IN</button>

        <div class="col-md-12 text-center" style="padding:20px 0;">
        <!--<a href="#">Forgot password?</a>-->
        </div>
        <div class="clearfix"></div>
    </form>
  </div>


      <div class="clearfix"></div>




</div><!-- wrap-event -->


</div><!-- row -->
</div><!-- container -->



  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="assets/js/jquery-1.11.2.min.js"></script>
  <script type="text/javascript" src="assets/js/bootstrap.js"></script>

   </body>
</html>
