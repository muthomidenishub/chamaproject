
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login in Chama</title>
 <!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- //Meta-Tags -->
	
	<!-- css files -->
	<link href="css1/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
	<link href="css1/style.css" rel="stylesheet" type="text/css" media="all"/>
	<!-- //css files -->
	
	<!-- google fonts -->
	<link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
	<!-- //google fonts -->
        <!-- Custom-Files -->
	<link rel="stylesheet" href="css/bootstrap.css">
	<!-- Bootstrap-Core-CSS -->
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<!-- Style-CSS -->
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<!-- Font-Awesome-Icons-CSS -->
	<!-- //Custom-Files -->

	<!-- Web-Fonts -->
	<link href="//fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=devanagari,latin-ext"
	 rel="stylesheet">
	
</head>
<body>
  <div class="main-top" id="home">
		<!-- header -->
		<header>
			<div class="container-fluid">
				<div class="header d-lg-flex justify-content-between align-items-center py-3 px-sm-3">
					<!-- logo -->
					<div id="logo">
						<h1><a href="index.html"><span class="fa fa-linode mr-2"></span>Chama Solutions</a></h1>
					</div>
					<!-- //logo -->
					<!-- nav -->
					<div class="nav_w3ls" >
						<nav>
							<label for="drop" class="toggle">Menu</label>
							<input type="checkbox" id="drop" />
							<ul class="menu">
								<li><a href="index.html" class="active">Home</a></li>
						
								<li><a href="contact.html">Contact Us</a></li>
								<li><a href="createchama.jsp">Create a Chama </a></li>
							</ul>
						</nav>
					</div>
					<!-- //nav -->
					<div class="d-flex mt-lg-1 mt-sm-2 mt-3 justify-content-center">
						<!-- search -->
						<div class="search-w3layouts mr-3">
							<form action="#" method="post" class="search-bottom-wthree d-flex">
								<input class="search" type="search" placeholder="Search Here..." required="">
								<button class="form-control btn" type="submit"><span class="fa fa-search"></span></button>
							</form>
						</div>
						<!-- //search -->
						<!-- download -->
						
                                               <a  href="loginUser.jsp" >< <button class="btn btn-primary">LOG IN</button></a>
                                                
						<!-- //download -->
					</div>
				</div>
			</div>
		</header>
		<!-- //header -->

		<!-- banner -->
		<!-- //banner -->
	</div>
<div class="signupform">
	<div class="container">
		<!-- main content -->
		<div class="agile_info">
			<div class="w3l_form">
				<div class="left_grid_info">
					<h1>Log in into your Chama</h1>
					<p>Your Chama Success Starts here.Its all but one click away!!!</p>
					<img src="images/image.jpg" alt="" />
                                       
				</div>
			</div>
			<div class="w3_info">
				<h2>Create Chama Account</h2>
				<p>Enter your details</p>
                                <c:if test="${ ! empty sessionScope.errMess}">
                                    <p style="color: red">${sessionScope.errMess}</p>
                                    
                                </c:if>
				<form action="LoginServlet" method="post">
					<label>Username</label>
					<div class="input-group">
						<span class="fa fa-user" aria-hidden="true"></span>
						<input type="text" placeholder="Username"  name="username" required> 
                                        </div>
					<label>Password</label>
					<div class="input-group">
						<span class="fa fa-lock" aria-hidden="true"></span>
						<input type="password" placeholder="Enter your password" name="pass" required> 
						
					</div>		
						<button class="btn btn-danger btn-block" type="submit">Login</button > 
                                                <a href="resetPassword.jsp">Forgot Password?Reset Password</a>
				</form>
				</div>
		</div>
		<!-- //main content -->
	</div>
	<!-- footer -->
	<div class="footer">
		<p>&copy;Finacial solution 2019</p>
	</div>
	<!-- footer -->
</div>
	
</body>
</html>