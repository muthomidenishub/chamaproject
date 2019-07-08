<%-- 
    Document   : approveMemberDel
    Created on : May 21, 2019, 12:50:26 PM
    Author     : denis
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page='View.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>



<div class="banner">
    <h2>
        <a href="#">Home</a>
        <i class="fa fa-angle-right"></i>
        <span>approve member deletion</span>
    </h2>
</div>
<div class="grid-system">
    <div class="horz-grid"> 

        <table id="mytable" class="table table-striped" >
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name </th>
                    <th scope="col">ID Number</th>
                    <th scope="col">Email Address</th>
                    <th scope="col">Location</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${ empty members }">
                    <tr>
                        
                        <td>No records are available</td>
                    </tr>
                    
                </c:if>
                      <c:if test="${ !empty message }">
                    <tr>
                        
                        <td>${sessionScope.message}</td>
                    </tr>
                    
                </c:if>
                <c:forEach items="${members}" var="name">
                    <tr>
                        <td scope="row">${name.memberID}</td>
                        <td>${name.firstName}</td>
                        <td>${name.lastName}</td>
                        <td>${name.idNumber}</td>
                        <td>${name.emailAddress}</td>
                        <td>${name.location}</td>
                        <td>
                      
                             <button type="button" class="btn btn-danger btn-md " delete-id="${name.memberID}"  data-toggle="modal" data-target="#delete">delete</button>
                           



                           


                        </td>

                    </tr>

                    <!--Create modify modal-->

                </c:forEach>

            </tbody>
        </table>
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
                                        <form id="deleteForm" action="deleteMember" method="get">
                                            <div class="modal-body">
                                                <!--Have the contents here-->

                                                <p>Are you sure you want to delete the  member?</p>
                                                <p style="color: red">This action cannot be undone</p>

                                                <input type="hidden" name="dUnique" value="" hidden="true" />
                                                <input type="hidden" name="action" value="delete" hidden="true" />
                                                <input type="hidden" name="adminUnique" value="${sessionScope.adminUnique}" hidden="true"/>
                                            </div>
                                            <div class="modal-footer">

                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                
                                                <button type="submit" class="btn btn-danger" value="">Delete</button>
                                                


                                            </div>
                                        </form>
                                    </div>
                                </div>

                            </div>
       

    </div>

</div>


<script>

   $('#delete').on('show.bs.modal', function (e) {
  // get information to update quickly to modal view as loading begins
  var opener=e.relatedTarget;//this holds the element who called the modal
   
   //we get details from attributes
  var uniqueID=$(opener).attr('delete-id');

//set what we got to our form
  $('#deleteForm').find('[name="dUnique"]').val(uniqueID);
   
});



$('#modif').on('show.bs.modal', function (e) {
  // get information to update quickly to modal view as loading begins
  var opener=e.relatedTarget;//this holds the element who called the modal
   
   //we get details from attributes
  //var fname=$(opener).attr('delete-id');
  
//  var firstname = $('#mod').data('todo').fname;
//   var lastname = $('#mod').data('todo').lname;
//    var idNumber = $('#mod').data('todo').idnum;
//
////set what we got to our form

 
  
  
  
  
  
  
  
  
  
  
  
  
  
   
});
$('#modify').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget); // Button that triggered the modal
  var idNumber = button.data('todo').idnum; 
  var firstname = button.data('todo').fname;
  var lastname = button.data('todo').lname;
  

   $('#modForm').find('[name="location"]').val(idNumber);
     $('#modForm').find('[name="fname"]').val(firstname);
     $('#modForm').find('[name="lname"]').val(lastname);
});

 $(function(){
    $("#mytable").dataTable();
  });


</script>




<jsp:include page='viewh.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
