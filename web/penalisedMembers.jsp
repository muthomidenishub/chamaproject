<%-- 
    Document   : approveMemberDel
    Created on : May 21, 2019, 12:50:26 PM
    Author     : denis
--%>
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
        <span>Penalized Members</span>
    </h2>
</div>
<div class="grid-system">
    <div class="horz-grid"> 

        <table class=" table table-striped">
            <thead>
                <tr>
                    <th scope="col">#Penalty ID</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name </th>
                    <th scope="col">ID Number</th>
                    <th scope="col">Date Penalized</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${ empty penalisedMember }">
                    <tr>

                        <td>No records are available</td>
                    </tr>

                </c:if>
                <c:forEach items="${penalisedM}" var="name">
                    <tr>
                        <td scope="row">${name.penaltyID}</td>
                        <td>${name.firstname}</td>
                        <td>${name.secondname}</td>
                        <td>${name.idnumber}</td>
                        <td>${name.dateCreated}</td>
                        <td>

                            <button type="button" id="mod" class="btn btn-success btn-md "   data-toggle="modal" data-target="#modify" 

                                    data-todo='{"fname":"${name.firstname}","lname":"${name.secondname}","accountnum":"${name.memberaccountID}",
                                    "idnumber":"${name.idnumber}","charges":"${name.amountCharged}","pen":"${name.penaltyID}","datecreated":"${name.dateCreated}","supid":"${sessionScope.adminUnique}"}' ><span class="fa fa-plus" ></span>Clear Penalty</button>







                        </td>

                    </tr>

                    <!--Create modify modal-->

                </c:forEach>

            </tbody>
            <form method="post" action="ManagaePenalties">
                
                 
                 <input type="hidden" value="${sessionScope.adminUnique}" name="sup">
                 <button type="submit" class="btn-success"><i class="fa fa-print"></i>Print Penalty Report</button>
            </form>
        </table>
                 
                      <%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>
     <nav aria-label="Page navigation example">
  <ul class="pagination">
       <c:forEach begin="1" end="${sessionScope.numberOfPP}" var="i">
                <c:choose>
                         <c:when test="${sessionScope.currentPP eq i}">
                        <li class="page-item"><a class="page-link" href="#">${i}</a></li>
                        </c:when>
                            <c:otherwise>
       
         <li class="page-item"><a class="page-link" href="ManagePenalties?page=${i}&&sup=${sessionScope.adminUnique}">${i}</a></li>
         </c:otherwise>
         </c:choose>
         </c:forEach>
          <c:if test="${sessionScope.currentPP != 1}">
       
        
         <li class="page-item"><a class="page-link" href="ManagePenalties?page=${sessionScope.currentPP - 1}&&sup=${sessionScope.adminUnique}">Previous</a></li>
  
    </c:if>
         
         
    <c:if test="${sessionScope.currentPP lt sessionScope.numberOfPP}">
       
         <li class="page-item"><a class="page-link" href="ManagePenalties?page=${sessionScope.currentPP + 1}&&sup=${sessionScope.adminUnique}">Next</a></li>
  
    </c:if>
      
  </ul>
     </nav>
        <!--Place your modal here-->
        <div class="modal fade" id="modify" tabindex="-1" role="dialog" aria-labelledby="deleteMod" aria-hidden="true">
            <div class="modal-dialog modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle" style="font-size: 20px">
                            <span class="fa fa-pencil-square-o" style="color: green"></span>
                            Clear member penalty
                        </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true" style="font-style: inherit;font-family: fantasy">&times;</span>
                        </button>
                    </div>
                    <form id="modForm" action="ManagePenalties" method="post">
                        <div class="modal-body">
                            <div class="grid-system">
                                <div class="horz-grid" style="margin-top: -20px">
                                    <div class="grid-hor">


                                        <div class="col-xs-12 col-md-8">
                                            <p class=""> provide member penalty and late contribution</p>
                                        </div>
                                        <div class="col-xs-6 col-md-4">
                                            <p id="charges"></p>
                                        </div>
                                        <div class="col-xs-12 col-md-8">
                                            <p id="accountnum"> </p>
                                        </div>
                                        <div class="col-xs-12 col-md-5">
                                            <p class=""> Name:</p>
                                        </div>
                                        <div class="col-xs-6 col-md-3">
                                            <p id="memname"></p>
                                        </div>
                                        <div class="col-xs-12 col-md-5">
                                            <p class=""> Penalty</p>
                                        </div>
                                        <div class="col-xs-6 col-md-3">
                                            <div class="input-group input-icon right">
                                                <span class="input-group-addon">
                                                    KSH
                                                </span>
                                                <input type="text" class="form-control1" placeholder="0.00" name="penalty" value="" data-validation="amount">
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-md-5">
                                            <p class="">Late Contribution:</p>
                                        </div>
                                        <div class="col-xs-6 col-md-3">
                                            <div class="input-group input-icon right">
                                                <span class="input-group-addon">
                                                    KSH
                                                </span>
                                                <input type="text" class="form-control1" placeholder="0.00" name="lcont" value="" data-validation="amount">
                                           
                                            <input type="hidden" value="" name="datecreated">
                                        <input type="hidden" value="" name="national">
                                        <input type="hidden" value="" name="supid">
                                        <input type="hidden" value="" name="fname">
                                        <input type="hidden" value="" name="lname">
                                          <input type="hidden" value="" name="pen">
                                            
                                            </div>
                                        </div>
                                        
                                    </div>



                                    <div class="container">

                                        <div class="col-sm-3 col-md-offset">


                                        </div>


                                    </div>



                                </div>

                            </div>



                        </div>
                        <div class="modal-footer">

                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="reset" class="btn btn-default" value="">Reset</button>
                            <button type="submit" class="btn btn-success" value="">Save</button>


                        </div>
                    </form>
                </div>
            </div>

        </div>


    </div>

</div>


<script>

    $('#modify').on('show.bs.modal', function (event) {
      var button = $(event.relatedTarget); // Button that triggered the modal
        var idNumber = button.data('todo').idnumber;
        var firstname = button.data('todo').fname;
        var lastname = button.data('todo').lname;
        var accountnumber = button.data('todo').accountnum;
        var charges = button.data('todo').charges;
        var dateCreated = button.data('todo').datecreated;
        var supid =button.data('todo').supid;
           var pen =button.data('todo').pen;



        $('#modForm').find('[name="national"]').val(idNumber);
         $('#modForm').find('[name="pen"]').val(pen);
        $('#modForm').find('[name="fname"]').val(firstname);
        $('#modForm').find('[name="lname"]').val(lastname);
        $('#modForm').find('[name="supid"]').val(supid);
        $('#modForm').find('[name="datecreated"]').val(dateCreated);
        $('#modForm').find('[name="accountnum"]').val(accountnumber);
        $("#accountnum").append("Member Account ID:" + accountnumber);
        $("#charges").append("Penalty Charges:" + charges);
        $("#memname").append(firstname+lastname);
    });
    
  $('#modify').on('hidden.bs.modal', function() {
  $('#charges').empty();
  $('#accountnum').empty();
  $('#memname').empty();
  console.log("modal closed and content cleared");
});
//use jquery form validator
$.validate({
    modules : 'location, date, security, file',
    onModulesLoaded : function() {
      $('#country').suggestCountry();
    }
  });

$.formUtils.addValidator({
            name: 'amount',
            validatorFunction: function (value, $el, config, language, $form) {

                var re = new RegExp("^([0-9]{2,4})$");
                return re.test(value);
            },
            errorMessage: 'Only valid number is allowed!!',
            errorMessageKey: 'badEvenNumber'
        });
</script>

   





<jsp:include page='viewh.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
