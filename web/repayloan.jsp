<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page='View.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>


<div class="banner">
    <h2>
        <a href="DashBoardIndex.html">Home</a>
        <i class="fa fa-angle-right"></i>
        <span>Repay Member Loans </span>
    </h2>
</div>
<div class="grid-system">
    <div class="horz-grid">
        <div class="grid-hor">


            <p class=""><strong>Repay Loans</strong> </p>
            <hr style="width: 100px">

        </div>

        <c:if test="${ ! empty sessionScope.allow  ||  empty sessionScope.loanRepayMessageID}">

            <div class="col-sm-4 col-md-offset-1" style="margin-top: -40px">

                <div class="form-group has-error">
                    <!--IF loan exists check or ID is wrong-->

                    <label class=" control-label">${sessionScope.loanRepayMessageID}</label>
                    <label class=" control-label">${sessionScope.loannotexist}</label>


                </div>


            </div>
            <form action="repayLoan" method="get">
                <div class="container">
                    <div class="col-sm-4 col-md-offset-8" style="margin-top: -40px">
                        <div class="input-group input-icon right">
                            <span class="input-group-addon">
                                <i class="fa fa-search-plus"></i>
                            </span>
                            <input type="text" class="form-control1" placeholder="Member ID" name="idnumber" data-validation="id_num" >
                            <input type="hidden"  name="uniqueT" value="${sessionScope.adminUnique}">
                        </div>
                        <button type="submit" class="form-control1" id="search"
                                style="width: 150px;position: relative;left: 200px"> Search
                        </button>


                    </div>

                </div>
            </form>

        </c:if>



        <table class=" table table-striped">

            <thead>
                <tr>
                    <th scope="col">#Loan ID</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name </th>
                    <th scope="col">Amount Issued</th>
                    <th scope="col">Last Date Paid</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${sessionScope.loanDetails}" var="name">
                    <tr>
                        <td scope="row">${name.loanid}</td>

                        <td>${name.firstName}</td>
                        <td>${name.secondName}</td>
                        <td>${sessionScope.loanedAmount}</td>
                        <td>${name.dateRepaid}</td>

                        <td>

                            <button type="button" id="mod" class="btn btn-success btn-md "   data-toggle="modal" data-target="#modify" 

                                    data-todo='{"fname":"${name.firstName}","lname":"${name.secondName}","accountnum":"${name.loanid}","national":"${name.memberidNumber}","supid":"${sessionScope.adminUnique}",
                                    "lastDatePaid":"${name.dateRepaid}","penCharges":"${sessionScope.interestCharged}","daysToPen":"${sessionScope.daysToPenalty}", "outstandingAmount":"${sessionScope.amountToBeRapaid}",
                                    "loanedamount":"${sessionScope.loanedAmount}"}' ><span class="fa fa-eye" ></span>View Loan</button>







                        </td>

                    </tr>

                    <!--Create modify modal-->

                </c:forEach>

            </tbody>
        </table>
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
                    <form id="modForm" action="repayLoan" method="post">
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
                                                <p>Last Repaid Date:</p>
                                                <p id="repaydate"></p>
                                            </div>
                                            <div class="col-sm-3 col-md-offset-2">
                                                <p>Outstanding amount:</p>
                                                <p id="outStanding"></p>
                                            </div>


                                        </div>
                                        <div class="row">
                                            <div class="col-sm-3 col-md-offset-2">
                                                <p>Remaining Days to repay:</p>
                                                <p id="repayDays"></p>
                                            </div>
                                            <div class="col-sm-3 col-md-offset-2">
                                                <p>Charges Accumulated:</p>
                                                <p id="pen"></p>
                                            </div>


                                        </div>
                                        <div class="row">
                                            <div class="col-sm-3 col-md-offset-2">
                                                <p>Total Amount Expected:</p>
                                                <p id="totalLoan"></p>
                                            </div>
                                            <div class="col-sm-3 col-md-offset-2">
                                                 <p>Repaid Amount</p>
                                                <div class="input-group input-icon right">
                                                    <span class="input-group-addon">
                                                        <i class="fa fa-envelope"></i>
                                                    </span>
                                                    <input type="text" class="form-control1" placeholder="0.00" name="amountpaid" required data-validation="amount" >
                                                </div>
                                            </div>


                                        </div>



                                    </div>



                                    <div class="container">

                                        <div class="col-sm-3 col-md-offset">


                                        </div>


                                    </div>
                                  
                                    <input type="hidden" value="" name="loanid">
                                    <input type="hidden" value="" name="amountExpected">
                                    <input type="hidden" value="" name="amountLoaned">
                                    <input type="hidden" value="" name="supid">
                                      <input type="hidden" value="" name="national">
                                   



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

</div>
</div>

<script>
    $('#modify').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        var idNumber = button.data('todo').national;
        var firstname = button.data('todo').fname;
        var lastname = button.data('todo').lname;
        var loanedid = button.data('todo').accountnum;
        var loanedamount = button.data('todo').loanedamount;
        var outstandingAmount = button.data('todo').outstandingAmount;
        var dateRepay = button.data('todo').lastDatePaid;
        var supid = button.data('todo').supid;
       
        var penalty = button.data('todo').penCharges;
        var daysToPen = button.data('todo').daysToPen;
        var totalLoanAndCharge  = +penalty + +outstandingAmount;



        $('#modForm').find('[name="national"]').val(idNumber);

        $('#modForm').find('[name="supid"]').val(supid);
     
        $('#modForm').find('[name="loanid"]').val(loanedid);
        $('#modForm').find('[name="amountLoaned"]').val(loanedamount);
        $('#modForm').find('[name="amountExpected"]').val(totalLoanAndCharge);
       
        


        $("#loanid").append(loanedid);
        $("#loanamount").append(loanedamount);
        $("#outStanding").append(outstandingAmount);
        $("#pen").append(penalty);
        $("#loaneename").append(firstname + "-" + lastname);
        $("#repaydate").append(dateRepay);
        $("#repayDays").append(daysToPen);
        $("#totalLoan").append(totalLoanAndCharge);
    });


    $('#modify').on('hidden.bs.modal', function () {
        $('#loanamount').empty();
        $('#loaneename').empty();
        $('#repaydate').empty();
        $('#loanid').empty();
        $('#totalLoan').empty();
        $('#repayDays').empty();
        $('#pen').empty();
        $('#outStanding').empty();
        console.log("modal closed and content cleared");
    });

</script>
<script>
 $.formUtils.addValidator({
            name: 'amount',
            validatorFunction: function (value, $el, config, language, $form) {

                var re = new RegExp("^([0-9]{2,4})$");
                return re.test(value);
            },
            errorMessage: 'Only valid number is allowed!!',
            errorMessageKey: 'badEvenNumber'
        });

  // Setup form validation
        $.validate();
        $.formUtils.addValidator({
            name: 'id_num',
            validatorFunction: function (value, $el, config, language, $form) {

                var re = new RegExp("^([0-9]{7,8})$");
                return re.test(value);
            },
            errorMessage: 'Only valid number is allowed!!',
            errorMessageKey: 'badEvenNumber'
        });
 
</script>



<jsp:include page='viewh.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
