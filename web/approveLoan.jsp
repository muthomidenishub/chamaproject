<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page='View.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>

<div class="banner">
    <h2>
        <a href="DashBoardIndex.html">Home</a>
        <i class="fa fa-angle-right"></i>
        <span>Approve Loans</span>
    </h2>
</div>
<div class="grid-system">
    <div class="horz-grid"> 

        <table class=" table table-striped">
            <thead>
                <tr>
                    <th scope="col">#Loan ID</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name </th>
                    <th scope="col">ID Number</th>
                    <th scope="col">Date Created</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                 <c:if test="${ empty message }">
                    <tr>

                        <td>Loan approved successfully</td>
                    </tr>

                </c:if>
                <c:if test="${ empty apploans }">
                    <tr>

                        <td>No records are available</td>
                    </tr>

                </c:if>
                <c:forEach items="${apploans}" var="name">
                    <tr>
                        <td scope="row">${name.loanid}</td>
                        <td>${name.firstName}</td>
                        <td>${name.secondName}</td>
                        <td>${name.memberidNumber}</td>
                        <td>${name.dateCreated}</td>
                        <td>

                            <button type="button" id="mod" class="btn btn-success btn-md "   data-toggle="modal" data-target="#modify" 

                                    data-todo='{"fname":"${name.firstName}","lname":"${name.secondName}","accountnum":"${name.loanid}",
                                    "idnumber":"${name.memberidNumber}","supid":"${sessionScope.adminUnique}","daterepay":"${name.dateRepaid}","loanedamount":"${name.loanedamount}"}' ><span class="fa fa-eye" ></span>View Loan</button>







                        </td>

                    </tr>

                    <!--Create modify modal-->

                </c:forEach>

            </tbody>
        </table>
        <!--Place your modal here-->
        <div class="modal fade" id="modify" tabindex="-1" role="dialog" aria-labelledby="deleteMod" aria-hidden="true">
            <div class="modal-dialog modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle" style="font-size: 20px">
                            <span class="fa fa-pencil-square-o" style="color: green"></span>
                            Approve Loan 
                        </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true" style="font-style: inherit;font-family: fantasy">&times;</span>
                        </button>
                    </div>
                    <form id="modForm" action="loanApproveServlet" method="get">
                        <div class="modal-body">
                            <div class="grid-system">
                                <div class="horz-grid" style="margin-top: -20px">
                                    <div class="grid-hor">
                                        <div class="row">
                                            <div class="col-sm-3 col-md-offset-2">
                                                <p>Loan ID::</p>
                                                <p id="loanid"></p>

                                            </div>
                                            <div class="col-sm-3 col-md-offset-2">
                                                <p>Debtor Name:</p>
                                                <p id="loaneename"></p>
                                            </div>


                                        </div>
                                        <div class="row">
                                            <div class="col-sm-3 col-md-offset-2">
                                                <p>Repayment Date:</p>
                                                <p id="repaydate"></p>
                                            </div>
                                            <div class="col-sm-3 col-md-offset-2">
                                                <p>Amount issued:</p>
                                                <p id="loanamount"></p>
                                            </div>


                                        </div>



                                    </div>



                                    <div class="container">

                                        <div class="col-sm-3 col-md-offset">


                                        </div>


                                    </div>


                                    <input type="hidden" value="" name="national">
                                    <input type="hidden" value="" name="supid">
                                    <input type="hidden" value="" name="lname">
                                    <input type="hidden" value="" name="fname">
                                    <input type="hidden" value="" name="loanid">



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
        var loanedamount = button.data('todo').loanedamount;
        var dateRepay = button.data('todo').daterepay;
        var supid = button.data('todo').supid;



        $('#modForm').find('[name="national"]').val(idNumber);

        $('#modForm').find('[name="supid"]').val(supid);
        $('#modForm').find('[name="lname"]').val(lastname);
        $('#modForm').find('[name="fname"]').val(firstname);
        $('#modForm').find('[name="loanid"]').val(accountnumber);


        $("#loanid").append(accountnumber);
        $("#loanamount").append(loanedamount);
        $("#loaneename").append(firstname + "-" + lastname);
        $("#repaydate").append(dateRepay);
    });


    $('#modify').on('hidden.bs.modal', function () {
        $('#loanamount').empty();
        $('#loaneename').empty();
        $('#repaydate').empty();
        $('#loanid').empty();
        console.log("modal closed and content cleared");
    });

</script>





<jsp:include page='viewh.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
