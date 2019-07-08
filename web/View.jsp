<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML>
<html>
<head>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Minimal Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css2/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css2/style.css" rel='stylesheet' type='text/css' />
<link href="css2/font-awesome.css" rel="stylesheet"> 
<script src="js/jquery.min.js"> </script>
<!-- Mainly scripts -->
<script src="js/jquery.metisMenu.js"></script>
<script src="js/jquery.slimscroll.min.js"></script>
<!-- Custom and plugin javascript -->
<link href="css2/custom.css" rel="stylesheet">
<script src="js/custom.js"></script>
<script src="js/screenfull.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>


		<script>
		$(function () {
			$('#supported').text('Supported/allowed: ' + !!screenfull.enabled);

			if (!screenfull.enabled) {
				return false;
			}

			

			$('#toggle').click(function () {
				screenfull.toggle($('#container')[0]);
			})
			

			
		});
		</script>
                <script type="text/javascript">

        $(document).ready(function () {
            $('#demo-pie-1').pieChart({
                barColor: '#3bb2d0',
                trackColor: '#eee',
                lineCap: 'round',
                lineWidth: 8,
                onStep: function (from, to, percent) {
                    $(this.element).find('.pie-value').text(Math.round(percent) + '%');
                }
            });

            $('#demo-pie-2').pieChart({
                barColor: '#fbb03b',
                trackColor: '#eee',
                lineCap: 'butt',
                lineWidth: 8,
                onStep: function (from, to, percent) {
                    $(this.element).find('.pie-value').text(Math.round(percent) + '%');
                }
            });

            $('#demo-pie-3').pieChart({
                barColor: '#ed6498',
                trackColor: '#eee',
                lineCap: 'square',
                lineWidth: 8,
                onStep: function (from, to, percent) {
                    $(this.element).find('.pie-value').text(Math.round(percent) + '%');
                }
            });
            $('#demo-pie-8').pieChart({
                barColor: '#ed6498',
                trackColor: '#eee',
                lineCap: 'square',
                lineWidth: 8,
                onStep: function (from, to, percent) {
                    $(this.element).find('.pie-value').text(Math.round(percent) + '%');
                }
            });
            $('#demo-pie-6').pieChart({
                barColor: '#ed6498',
                trackColor: '#eee',
                lineCap: 'square',
                lineWidth: 8,
                onStep: function (from, to, percent) {
                    $(this.element).find('.pie-value').text(Math.round(percent) + '%');
                }
            });
       
        $('#demo-pie-9').pieChart({
                barColor: '#ed6498',
                trackColor: '#eee',
                lineCap: 'square',
                lineWidth: 8,
                onStep: function (from, to, percent) {
                    $(this.element).find('.pie-value').text(Math.round(percent) + '%');
                }
            });
           
        });

    </script>

<!----->

<!--pie-chart--->
<script src="js/pie-chart.js" type="text/javascript"></script>
 
<!--skycons-icons-->
<script src="js/skycons.js"></script>
<!--//skycons-icons-->
</head>
<body>
<div id="wrapper">

<!----->
        <nav class="navbar-default navbar-static-top" role="navigation">
             <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               <h1> <a class="navbar-brand" href="DashBoardIndex.jsp"> </a></h1>   
               
			   </div>
			 <div class=" border-bottom">
        	<div class="full-left">
        	  <section class="full-top">
				<button id="toggle"><i class="fa fa-arrows-alt"></i></button>	
			</section>
			
            <div class="clearfix"> 
            
            
            </div>
                    
           </div>
                      
     
     
       
            <!-- Brand and toggle get grouped for better mobile display -->
		 
		   <!-- Collect the nav links, forms, and other content for toggling -->
                   
		    <div class="drop-men" >
                        
		        <ul class=" nav_1">
                            <li class="dropdown" style="margin-right: 30px;margin-top: 2px">
		              <a href="#" class="dropdown-toggle dropdown-at" data-toggle="dropdown"><span class=" name-caret">
                                      
                                      <c:if test="${not empty username}">
                                          <c:out value="${sessionScope.username}"/></c:if>
                                      
                                          <i class="caret"></i></span><img src="images/wo.png" style="height: 60px;width: 80px"></a>
                                      <ul class="dropdown-menu " role="menu" style="margin-right: 20px">
		                <li><a href="#"><i class="fa fa-user"></i>Edit Profile</a></li>
		               
		              </ul>
		            </li>
					<li class="dropdown" >
		              
		            </li>
                            
		           
		        </ul>
		     </div>
                         
                 <!-- /.navbar-collapse -->
			<div class="clearfix">
       
     </div>
	  
		    <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <c:choose>      
                        <c:when test="${sessionScope.role=='admin_role'}">     
        <ul class="nav" id="side-menu">
                    
                    <!--Create the conditions to check for role and direct to the specific pages-->
                    
				
                    <li>
                        <a href="homepage.jsp" class=" hvr-bounce-to-right"><i class="fa fa-dashboard nav_icon "></i><span class="nav-label">Dashboard</span> </a>
                    </li>
					 <li>
                        <a href="addTreasurer.jsp" class=" hvr-bounce-to-right"><i class="fa fa-plus-circle nav_icon"></i> <span class="nav-label">Add treasurer</span> </a>
                    </li>
                     <li>
                        <a href="DeleteChamaMember?sup=${sessionScope.adminUnique}" class=" hvr-bounce-to-right"><i class="fa fa-warning nav_icon"></i> <span class="nav-label">Delete Member</span> </a>
                    </li>
                    <li>
                        <a href="Createcharges.jsp" class=" hvr-bounce-to-right"><i class="fa fa-warning nav_icon"></i> <span class="nav-label">Set Chama Charges</span> </a>
                    </li>
                    
                   
                   
                    <li>
                        <a href="" class=" hvr-bounce-to-right"><i class="fa fa-money nav_icon"></i> <span class="nav-label">Loans</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="ApproveLoans?sup=${sessionScope.adminUnique}"class=" hvr-bounce-to-right"> <i class="fa fa-clock-o nav_icon"></i> Approve loans</a></li>
                            
                       </ul>
                    </li>
                    
                    <li>
                        <a href="" class=" hvr-bounce-to-right"><i class="fa fa-cog nav_icon"></i> <span class="nav-label">Settings</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="userResetPassword.jsp" class=" hvr-bounce-to-right"> <i class="fa fa-key nav_icon"></i>Change Password</a></li>
                            <li><a href="LoginServlet?logout=logout" class=" hvr-bounce-to-right"><i class="fa fa-sign-out nav_icon"></i>Log out</a></li>
                           
                       </ul>
                    </li>
                   <li>
                        <a href="OnlineHelp.jsp" class=" hvr-bounce-to-right"><i class="fa fa-question-circle nav_icon"></i> <span class="nav-label">Help</span> </a>
                    </li>
                </ul>
    </c:when>
                        

                        <c:when test="${sessionScope.role=='treasurer_role'}">   
                         <ul class="nav" id="side-menu">
                    
                    <!--Create the conditions to check for role and direct to the specific pages-->
                    
				
                    <li>
                        <a href="homepage.jsp" class=" hvr-bounce-to-right"><i class="fa fa-dashboard nav_icon "></i><span class="nav-label">Dashboard</span> </a>
                    </li>

					 <li>
                        <a href="MembersServlet?sup=${sessionScope.adminUnique}" class=" hvr-bounce-to-right"><i class="fa fa-users nav_icon"></i> <span class="nav-label">Members</span> </a>
                    </li>
                     <li>
                        <a href="addMember.jsp" class=" hvr-bounce-to-right"><i class="fa fa-plus-circle nav_icon"></i> <span class="nav-label">Add Member</span> </a>
                    </li>
                    
                    <li>
                        <a href="addMemberContribution.jsp" class=" hvr-bounce-to-right"><i class="fa fa-money nav_icon"></i> <span class="nav-label">Add Contribution</span> </a>
                    </li>
                    <li>
                        <a href="showMemberContributions.jsp" class=" hvr-bounce-to-right"><i class="fa fa-money nav_icon"></i> <span class="nav-label">View Contributions</span> </a>
                    </li>
                         
                    <li><a href="ManagePenalties?sup=${sessionScope.adminUnique}&&page=1" class=" hvr-bounce-to-right"> <i class="fa fa-warning nav_icon"></i> Pending Penalties</a></li>
                     <li>
                        <a href="" class=" hvr-bounce-to-right"><i class="fa fa-money nav_icon"></i> <span class="nav-label">Loans</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="loanPage.jsp" class=" hvr-bounce-to-right"> <i class="fa fa-clock-o nav_icon"></i> Issue loans</a></li>
                            <li><a href="loansIssuedDisplay?sup=${sessionScope.adminUnique}&&page=1" class=" hvr-bounce-to-right"><i class="fa fa-check nav_icon"></i>Approved Loans</a></li>
                       <li><a href="repayloan.jsp" class=" hvr-bounce-to-right"><i class="fa fa-check nav_icon"></i>Active Loans</a></li>
                         <li><a href="showRepaidLoans.jsp" class=" hvr-bounce-to-right"><i class="fa fa-check nav_icon"></i>Repaid  Loans</a></li>
                             
                       </ul>
                    </li>
                     <li>
                        <a href="" class=" hvr-bounce-to-right"><i class="fa fa-cog nav_icon"></i> <span class="nav-label">Settings</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                             <li><a href="userResetPassword.jsp" class=" hvr-bounce-to-right"> <i class="fa fa-key nav_icon"></i>Change Password</a></li>
                            <li><a href="LoginServlet?logout=logout" class=" hvr-bounce-to-right"><i class="fa fa-sign-out nav_icon"></i>Log out</a></li>
                           
                       </ul>
                    </li>
                   
                     <li>
                        <a href="OnlineHelp.jsp" class=" hvr-bounce-to-right"><i class="fa fa-question-circle nav_icon"></i> <span class="nav-label">Help</span> </a>
                    </li>
                   
                 
                </ul>
      
    </c:when>
</c:choose>   
                
            </div>
			</div>
        </nav>
        <div id="page-wrapper" class="gray-bg dashbard-1">
       <div class="content-main">
 
  	
		<div class="clearfix"> </div>
      
            

