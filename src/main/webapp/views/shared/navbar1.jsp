<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="${contetxRoot}/POS/home">Kaushik Dress Matterial</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li id="home" class="nav-item">
            <a class="nav-link" href="${contetxRoot}/POS/home">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li id="about" class="nav-item">
            <a class="nav-link" href="${contetxRoot}/POS/about">About</a>
          </li>
          <li  id="pmaster"class="nav-item">
            <a class="nav-link" href="${contetxRoot}/POS/mg">ProductMaster</a>
          </li>
          <li id="contact" class="nav-item">
            <a class="nav-link" href="${contetxRoot}/POS/contact">Contact</a>
          </li>
            <li id="purchasedetail" class="nav-item">
            <a class="nav-link" href="${contetxRoot}/POS/trial">Purchase</a>
          </li>
          <li id="usericon" class="nav-item" >
             <span class="input-group-text"> <i class="fas fa-user"></i> </span> 
			 
          </li>
          <li id="usericon" class="nav-item" style="color:white;">
           <security:authentication property="principal.username"/>
          </li>
          <li id="role" class="nav-item" style="color:FloralWhite;">
           <security:authentication property="principal.authorities"/>
           </li>
          <li id="logout" class="nav-item">
          <a class="nav-link" href="${contetxRoot}/POS/login?logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a>
           </li>
        </ul>
      </div>
    </div>
  </nav>
