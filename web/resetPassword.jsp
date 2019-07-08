    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="css2/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css2/style.css" rel='stylesheet' type='text/css' />
<link href="css2/font-awesome.css" rel="stylesheet"> 
            <script src="js/jquery.min.js"> </script>
<script src="js/bootstrap.min.js"> </script>
</head>
<body>
    <div class="login">
        <h1><a href="#" style="color: #0d0d0d">Financial Solutons </a></h1>
        <div class="login-bottom">
            <h2>Reset Password</h2>
            <c:if test="${! empty sessionScope.err || ! empty sessionScope.succ}">
                
                <p>${sessionScope.err}</p>
                <p>${sessionScope.succ}</p>
            </c:if>
            <p></p>
            <form action="ReserPasswordServlet" method="post">
                <div class="col-md-6">
                    <div class="login-mail">
                        <input type="text" placeholder="Email" name ="email"required="">
                        <i class="fa fa-envelope"></i>
                    </div>

                </div>
                <div class="col-md-6 login-do">
                    <label class="hvr-shutter-in-horizontal login-sub">
                        <input type="submit" value="Reset">
                    </label>
                    
                </div>

                <div class="clearfix"> </div>
            </form>
        </div>
    </div>
    <!---->
    <div class="copy-right">
        <p> &copy; 2019 . All Rights Reserved | Design by <a href="index.html">Financial Chama Solutions</a> </p>	    </div>  
    <!---->
    <!--scrolling js-->
    <script src="js/jquery.nicescroll.js"></script>
    <script src="js/scripts.js"></script>
    <!--//scrolling js-->
</body>
</html>

