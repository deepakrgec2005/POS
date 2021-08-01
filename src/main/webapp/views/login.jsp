 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

 
<html lang="en" >
<head>
     

    <title>Log in with your account</title>

    <link href="${contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/assets/css/common.css" rel="stylesheet">
    <link href="${contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
 <style>
body {
  background-image: url('${contextPath}/assets/images/bgpc.jpg');
  background-repeat: no-repeat;
background-size: 100% 100%;
}
</style>
</head>

<body>
 
    <div id="login">
        <h3 class="text-center text-white pt-5">Login form</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
						
						<form id="login-form" class="form" action="${contextPath}/POS/login" method="post" style="background-color: #EAEAEA; height:320px;margin-top: 120px;max-width:600px; padding: 0;border: 1px solid #9C9C9C;">
                            <h3 class="text-center text-info">Login</h3>
                             <div class="form-group ${error != null ? 'has-error' : ''}">
                             <span>${message}</span>
                            <div class="form-group">
                                <label for="username" class="text-info" style="color: Black; ">Username:</label><br>
                                <input type="text" name="username" id="username" placeholder="Username" required autofocus class="form-control">
                                 
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info"style="color: Black; ">Password:</label><br>
                                <input type="password" name="password" id="password" class="form-control" required>
                            </div>
                            <span>${error}</span>
                            <div class="form-group">
                                <label for="remember-me" class="text-info"><span>Remember me</span> <span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br>
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
                                 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </div>
                            <div id="register-link" class="text-right">
                                <a href="#" class="text-info">Register here</a>
                            </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>