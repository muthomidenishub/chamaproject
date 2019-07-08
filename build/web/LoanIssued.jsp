<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page='View.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>



<div class="banner">
    <h2>
        <a href="DashBoardIndex.html">Home</a>
        <i class="fa fa-angle-right"></i>
        <span>Loans Issued</span>
    </h2>
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
                    <th scope="col">Amount Issued</th>
                    <th scope="col">Date Issued</th>
                    <th scope="col">Repay Date</th>
                    
                </tr>
            </thead>
            <tbody>
                <c:if test="${ empty loanRecords }">
                    <tr>
                        
                        <td>No records are available</td>
                    </tr>
                    
                </c:if>
                <c:forEach items="${loanRecords}" var="name">
                    <tr>
                        <td scope="row">${name.loanid}</td>
                        <td>${name.firstName}</td>
                        <td>${name.secondName}</td>
                        <td>${name.loanedamount}</td>
                        <td>${name.dateCreated}</td>
                          <td>${name.dateRepaid}</td>
                      

                    </tr>

                    <!--Create modify modal-->

                </c:forEach>

            </tbody>
             <form method="post" action="loansIssuedDisplay">
                
                 
                 <input type="hidden" value="${sessionScope.adminUnique}" name="sup">
                 <button type="submit" class="btn-success"><i class="fa fa-print"></i>Print Loan report</button>
            </form>
        </table>
       
        <%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>
     <nav aria-label="Page navigation example">
  <ul class="pagination">
       <c:forEach begin="1" end="${sessionScope.numberOfP}" var="i">
                <c:choose>
                         <c:when test="${sessionScope.currentP eq i}">
                        <li class="page-item"><a class="page-link" href="#">${i}</a></li>
                        </c:when>
                            <c:otherwise>
       
         <li class="page-item"><a class="page-link" href="?page=${i}">${i}</a></li>
         </c:otherwise>
         </c:choose>
         </c:forEach>
          <c:if test="${sessionScope.currentP != 1}">
       
        
         <li class="page-item"><a class="page-link" href="loansIssuedDisplay?page=${sessionScope.currentP - 1}">Previous</a></li>
  
    </c:if>
         
         
    <c:if test="${sessionScope.currentPage lt sessionScope.numberOfP}">
       
         <li class="page-item"><a class="page-link" href="loansIssuedDisplay?page=${sessionScope.currentP + 1}">Next</a></li>
  
    </c:if>
      
  </ul>
     </nav>
    
    
    <%--For displaying Next link --%>
    
        <!--Place your modal here-->
 <div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalCenterTitle" style="font-size:20px">
                                                <span class="fa fa-bitbucket" style="color: red"></span>
                                                Delete Member
                                            </h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true" style="font-style: inherit;font-family: fantasy">&times;</span>
                                            </button>
                                        </div>
                                        <form id="deleteForm" action="MemberController" method="post">
                                            <div class="modal-body">
                                                <!--Have the contents here-->

                                                <p>Are you sure you want to <strong style="color:  red">delete </strong>the  member?</p>

                                                <input type="text" name="dUnique" value="${sessionScope.adminUnique}"  />
                                                <input type="text" name="idnumber" value="" hidden="true"/>
                                                 <input type="text" value="delete" hidden="true" name="action"/>
                                            </div>
                                            <div class="modal-footer">

                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                
                                                    <button type="submit" class="btn btn-danger" value="">Delete</button>


                                            </div>
                                        </form>
                                    </div>
                                </div>

                            </div>
        <!--Place modify modal here-->
      

    </div>

</div>


<script>

   $('#delete').on('show.bs.modal', function (event) {
//  // get information to update quickly to modal view as loading begins
//  var opener=e.relatedTarget;//this holds the element who called the modal
//   
//   //we get details from attributes
//  var uniqueID=$(opener).attr('delete-id');
//
////set what we got to our form
//  $('#deleteForm').find('[name="dUnique"]').val(uniqueID);

   var button = $(event.relatedTarget); // Button that triggered the modal
    var  memberID = button.data('delete').memID; 
    var idNumber = button.data('delete').memNational;
     var adminunique = button.data('delete').dunique;
    deleteForm;
    
    
     $('#deleteForm').find('[name="idnumber"]').val(idNumber);
   $('#deleteForm').find('[name="dUnique"]').val(adminunique);
    
    
    
});


$('#modify').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget); // Button that triggered the modal
  var idNumber = button.data('todo').idnumber; 
  var firstname = button.data('todo').fname;
  var lastname = button.data('todo').lname;
  var phoneNumber = button.data('todo').phone;
  var email = button.data('todo').email;
  var location = button.data('todo').location;
  

   $('#modForm').find('[name="idnumber"]').val(idNumber);
   $('#modForm').find('[name="phone"]').val(phoneNumber);
     $('#modForm').find('[name="fname"]').val(firstname);
     $('#modForm').find('[name="lname"]').val(lastname);
      $('#modForm').find('[name="email"]').val(email);
       $('#modForm').find('[name="location"]').val(location);
});
</script>

<jsp:include page='viewh.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
