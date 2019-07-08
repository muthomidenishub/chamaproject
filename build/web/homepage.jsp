
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page='View.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>


		     
       
 
  		<!--banner-->	
                 <div class="banner">
		   
				<h2>
				<a href="index.html">Home</a>
				<i class="fa fa-angle-right"></i>
				<span>Dashboard</span>
				</h2>
		    </div>
                <div class="content-top">
			
			
                    <div class="col-md-4 col-md-offset-1 " style="margin-bottom: 15px">
				<div class="content-top-1 offset-1">
				<div class="col-md-6 top-content">
					<h5>Loans</h5>
                                        <label>${sessionScope.totalaons}</label>
				</div>
				<div class="col-md-6 top-content1">	   
					<div id="demo-pie-1" class="pie-title-center" data-percent="40"> <span class="pie-value"></span> </div>
				</div>
				 <div class="clearfix"> </div>
				</div>
				
				
			</div>
                    <div class="col-md-4 col-md-offset-1">
				<div class="content-top-1 offset-1">
				<div class="col-md-6 top-content">
                                    <div id="demo-pie-1" class="pie-title-center" data-percent="0"> <span class="pie-value"></span> </div>
					<h5>Contributions</h5>
                                        
					<label>${sessionScope.totalcon}</label>
				</div>
				<div class="col-md-6 top-content1">	   
					<div id="demo-pie-8" class="pie-title-center" data-percent="40"> <span class="pie-value"></span> </div>
				</div>
				 <div class="clearfix"> </div>
				</div>
				
			</div>
                
                           
                                

		</div>
		<div class="clearfix"> </div>
       </div>
     </div>

  
<jsp:include page='viewh.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
