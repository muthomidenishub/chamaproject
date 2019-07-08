<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page='View.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>

  
<div class="banner">
    <h2>
        <a href="DashBoardIndex.html">Home</a>
        <i class="fa fa-angle-right"></i>
        <span>Show Member Contributions</span>
    </h2>
</div>


<div class="banner" style="margin-top: 10px">


    <div class=" col-md-4 offset-md-4">



    </div>
    <div class="horz-grid">
        <form action="showMemberContribution" method="get" >
            <div class="row ">
                <div class="col-md-4 " style="position: relative;left: 70px">
                    <h2 style="color: gray"  >Select Start Date:</h2>

                    <div class="input-group input-icon right" style="margin-top: 10px">
                        <span class="input-group-addon">
                            <i class="fa fa-calendar"></i>
                        </span>
                        <input type="date" id="txtDate" class="form-control1" placeholder="Valid email address" name="startdate">
                    </div>
                    
              
                </div>
                <div class="col-md-4 col-md-offset-4" style="position: relative;left: -70px">
                    <h2 style="color: gray">Select end Date:</h2>
                    <div class="input-group input-icon right" style="margin-top: 10px">
                        <span class="input-group-addon">
                            <i class="fa fa-calendar"></i>
                        </span>
                        <input type="date" class="form-control1" placeholder="Valid email address" name="enddate" id="edDate">
                    </div>
                    <input type="text" name="sup" value="${sessionScope.adminUnique}" hidden="true"/> 
                </div>
                <div class="col-md-4 col-md-offset-11" style="">
                    <button type="submit" class="btn btn-success"><i class="fa fa-eye"></i>View</button>
                </div>

            </div>
        </form>
    </div>




</div> 

<div class="grid-system">
    <div class="horz-grid"> 
        <c:if test="${code != null}">
            There is a user **attribute** in the session
        </c:if>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name </th>
                    <th scope="col">Amount Contributed</th>
                    <th scope="col">Date Contributed</th>

                </tr>
            </thead>
            <tbody>
                <c:if test="${ empty contrib }">
                    <tr>

                        <td>No records are available</td>
                    </tr>

                </c:if>
                <c:forEach items="${contrib}" var="name">
                    <tr>
                        <td scope="row">1</td>
                        <td>${name.fname}</td>
                        <td>${name.lname}</td>
                        <td>${name.amount}</td>
                        <td>${name.dateContributed}</td>

                    </tr>
                </c:forEach>


            </tbody>
            <form method="post" action="showMemberContribution">

                <input type="hidden" value="${sessionScope.sdate}" name="stardate">
                <input type="hidden" value="${sessionScope.edate}" name="enddate">
                <input type="hidden" value="${sessionScope.adminUnique}" name="sup">
                <button type="submit" class="btn-success"><i class="fa fa-print"></i>Print report</button>
            </form>

        </table>

      <script>

        
            $(function () {
                var dtToday = new Date();

                var month = dtToday.getMonth() + 1;
                var day = dtToday.getDate();
                var year = dtToday.getFullYear();
                if (month < 10)
                    month = '0' + month.toString();
                if (day < 10)
                    day = '0' + day.toString();

                var maxDate = year + '-' + month + '-' + day;
               
                $('#edDae').attr('min', maxDate);
            });
            
            $(function(){
    var dtToday = new Date();
    
    var month = dtToday.getMonth() + 1;
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();
    if(month < 10)
        month = '0' + month.toString();
    if(day < 10)
        day = '0' + day.toString();
    
    var maxDate = year + '-' + month + '-' + day;
   
    $('#txtDate').attr('max', maxDate);
     $('#edDate').attr('max', maxDate);
});
            
        </script>

        <jsp:include page='viewh.jsp'>
            <jsp:param name="articleId" value=""/>
        </jsp:include>


