<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page='View.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>



<div class="banner">
    <h2>
        <a href="DashBoardIndex.html">Home</a>
        <i class="fa fa-angle-right"></i>
        <span>Chama Members</span>
    </h2>
</div>
<div class="grid-system">
    <div class="horz-grid"> 
        <c:if test="${! empty mesM}">
            <p>${mesM}</p>
</c:if>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name </th>
                    <th scope="col">ID Number</th>
                    <th scope="col">Email Address</th>
                    <th scope="col">Phone Number</th>
                    <th scope="col">Location</th>
                    <th scope="col">Action</th>
                   
                </tr>
            </thead>
            <tbody>
                <c:if test="${ empty memberRecords }">
                    <tr>
                        
                        <td>No records are available</td>
                    </tr>
                    
                </c:if>
                <c:forEach items="${memberRecords}" var="name">
                    <tr>
                        <td scope="row">${name.memberID}</td>
                        <td>${name.firstName}</td>
                        <td>${name.lastName}</td>
                        <td>${name.idNumber}</td>
                        <td>${name.emailAddress}</td>
                        <td>${name.phoneNumber}</td>
                        <td>${name.location}</td>
                        <td>
                             <button type="button" id="mod" class="btn btn-primary btn-md "   data-toggle="modal" data-target="#modify" 
                                     
                                     data-todo='{"fname":"${name.firstName}","lname":"${name.lastName}","phone":"${name.phoneNumber}",
                                     "email":"${name.emailAddress}","location":"${name.location}","idnumber":${name.idNumber}}' >Modify</button>
                             <button type="button" class="btn btn-danger btn-md "  data-delete='{"memID":"${name.memberID}","dunique":"${sessionScope.adminUnique}","memNational":"${name.idNumber}"}'
                                     
                                     data-toggle="modal" data-target="#delete">delete</button>
                           



                           


                        </td>

                    </tr>

                    <!--Create modify modal-->

                </c:forEach>

            </tbody>
        </table>
       
        <%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>
     <nav aria-label="Page navigation example">
  <ul class="pagination">
       <c:forEach begin="1" end="${sessionScope.numberOfPages}" var="i">
                <c:choose>
                         <c:when test="${sessionScope.currentPage eq i}">
                        <li class="page-item"><a class="page-link" href="#">${i}</a></li>
                        </c:when>
                            <c:otherwise>
       
         <li class="page-item"><a class="page-link" href="MembersServlet?page=${i}">${i}</a></li>
         </c:otherwise>
         </c:choose>
         </c:forEach>
          <c:if test="${sessionScope.currentPage != 1}">
       
        
         <li class="page-item"><a class="page-link" href="MembersServlet?page=${sessionScope.currentPage - 1}">Previous</a></li>
  
    </c:if>
         
         
    <c:if test="${sessionScope.currentPage lt sessionScope.numberOfPages}">
       
         <li class="page-item"><a class="page-link" href="MembersServlet?page=${sessionScope.currentPage + 1}">Next</a></li>
  
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

                                                <input type="hidden" name="dUnique" value="${sessionScope.adminUnique}"  />
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
        <div class="modal fade" id="modify" tabindex="-1" role="dialog" aria-labelledby="deleteMod" aria-hidden="true">
                                <div class="modal-dialog modal-dialog modal-lg" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalCenterTitle" style="font-size: 30px">
                                                <span class="fa fa-pencil-square-o" style="color: green"></span>
                                                Edit member details
                                            </h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true" style="font-style: inherit;font-family: fantasy">&times;</span>
                                            </button>
                                        </div>
                                        <form id="modForm" action="MemberController">
                                            <div class="modal-body">
                                                <div class="grid-system">
    <div class="horz-grid">
        <div class="grid-hor">
            
            <p class="">Please provide correct member details</p>
            <hr style="width: 100px">

        </div>
        
        <input type="text" value="${sessionScope.adminUnique}" hidden="true" name="uniqueAdmin"/>
        <input type="text" value="modify" hidden="true" name="action"/>
            
            
        

        <div class="container">
            <div class="col-sm-3 col-md-offset-1">
                <div class="input-group input-icon right">
                    <span class="input-group-addon">
                        <i class="fa fa-user"></i>
                    </span>
                    <input type="text" class="form-control1" placeholder="First name" name="fname" data-validation="user_name" value="">
                </div>
                <div class="input-group input-icon right">
                    <span class="input-group-addon">
                        <i class="fa fa-user"></i>
                    </span>
                    <input type="text" class="form-control1" placeholder="last name" name="lname" data-validation="user_name" value="">
                     
                </div>
                <div class="input-group input-icon right">
                    <span class="input-group-addon">
                        <i class="fa fa-envelope"></i>
                    </span>
                    <input type="email" class="form-control1" placeholder="email address" name="email" data-validation="email" value="">
                </div>
            </div>
           <div class="col-sm-3 col-md-offset">
                <div class="input-group input-icon right">
                    <span class="input-group-addon">
                        <i class="fa fa-phone"></i>
                    </span>
                    <input type="text" class="form-control1" placeholder="Phone number" name="phone"  data-validation="phone_n"value="">
                    
                </div>
                <div class="input-group input-icon right">
                    <span class="input-group-addon">
                        <i class="fa fa-bookmark"></i>
                    </span>
                    <input type="text" class="form-control1" placeholder="Location" name="location" data-validation="user_name" value="">
                </div>
                  <div class="input-group input-icon right">
                    <span class="input-group-addon">
                        <i class="fa fa-code"></i>
                    </span>
                    <input type="text" class="form-control1" placeholder="ID Number" name="idnumber" data-validation="id_num" value="">
                </div>
               
            </div>
           

        </div>


        
    </div>
   
</div>


                                               
                                            </div>
                                            <div class="modal-footer">

                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                
                                                    <button type="submit" class="btn btn-success" value="">Modify</button>


                                            </div>
                                        </form>
                                    </div>
                                </div>

                            </div>

    </div>

</div>
  
<script>
$.validate({
    modules : 'location, date, security, file',
    onModulesLoaded : function() {
      $('#email').suggestCountry();
    }
  });

$.validate({
  modules : 'toggleDisabled',
  disabledFormFilter : 'form.toggle-disabled',
  showErrorDialogs : false
});

 
// Add custom validation rule
$.formUtils.addValidator({
  name : 'user_name',
  validatorFunction : function(value, $el, config, language, $form) {
      
      var re = new RegExp("^[a-zA-Z]+$");
    return re.test(value);
  },
  errorMessage : 'Only Characters are allowed!!',
  errorMessageKey: 'badEvenNumber'
});
$.formUtils.addValidator({
  name : 'phone_n',
  validatorFunction : function(value, $el, config, language, $form) {
      
      var re = new RegExp("^(0)([0-9]{9})$");
    return re.test(value);
  },
  errorMessage : 'Only valid phone numbers are allowed!!',
  errorMessageKey: 'badEvenNumber'
});
 $.formUtils.addValidator({
  name : 'id_num',
  validatorFunction : function(value, $el, config, language, $form) {
      
      var re = new RegExp("^([0-9]{7,8})$");
    return re.test(value);
  },
  errorMessage : 'Only valid phone numbers are allowed!!',
  errorMessageKey: 'badEvenNumber'
});
 
// Setup form validation
$.validate();
 

</script>
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
