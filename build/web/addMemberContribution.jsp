<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page='View.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>

<div class="banner">
    <h2>
        <a href="DashBoardIndex.html">Home</a>
        <i class="fa fa-angle-right"></i>
        <span>Add member Contribution</span>
    </h2>
</div>
<c:if test="${ empty sessionScope.begin }">
    <form action="manageTransaction" method="post">
        <div class="banner" style="margin-top: 10px">

            <h2>

                <i class="fa fa-plus fa-2x" ></i>       
                <button type="submit" class="btn btn-primary btn-default" id="beginTransact"
                        style=""> Begin Transactions
                </button>
                <input type="text" class="form-control1"  name="uniqueID" value="${sessionScope.adminUnique}" hidden="true"/>

            </h2>

            <h2 style="position: relative;left: 300px;margin-top: -30px;color: lightgrey">Begin transaction to be able to add member contribution</h2>






        </div>
    </form>
</c:if>
<c:if test="${!empty sessionScope.begin }">
    <form action="manageTransaction" method="get">
        <div class="banner" style="margin-top: 10px">

            <h2>

                <i class="fa fa-close fa-2x" ></i>       
                <button type="submit" class="btn btn-danger btn-default" id="endTransact"
                        style=""> End Transactions
                </button>
                <input type="text" class="form-control1"  name="uniqueID" value="${sessionScope.adminUnique}" hidden="true"/>

            </h2>
        </div>
    </form>
</c:if>






<div class="grid-hor">

    <div class="grid-system">

        <div class="horz-grid">
            <p>${sessionScope.IDmessages}</p>
            <c:if test="${  ! empty sessionScope.begin  || sessionScope.pen == 'false'}">

                <form action="AddContribution" method="post">
                    <div class="col-md-2 col-md-offset-7" style="margin-bottom: 10px">
                        <div class="input-group input-icon right">
                            <div class="input-group input-icon right">
                                <p style="color: lightgrey;font-style:  oblique">  Member ID: </p>

                                <input type="text" class="form-control1" placeholder="Member ID" name="id" data-validation="id_num"/>
                                <input type="text" name="uniqueT" value="${sessionScope.adminUnique}" hidden="true"/>
                            </div>

                        </div>
                        <div class="input-group input-icon right">
                            <div class="input-group input-icon right">

                                <button type="submit" class="btn btn-primary btn-default" id="search"
                                        style=""> <i class="fa fa-search">Search</i>
                                </button>
                            </div>

                        </div>

                    </div>
                </form>
               


            </c:if>

            <c:if test="${sessionScope.pen == 'yes'}">
                <form action="AddContribution" method="post">

                </form>
                <div class="col-sm-4 col-md-offset-1">
                    <div class="input-group input-icon right">

                        <c:forEach items="${member}" var="name">
                            <p>Member ${name.firstName} needs to clear their penalty before proceeding</p>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-sm-4 col-md-offset-1">
                    <div class="input-group input-icon right" style="height: 20px">

                        <a type="submit" class="btn btn-secondary btn-default" id="search"
                           style="position: relative;left: 50px"> Clear Penalty</a>

                    </div>
                </div>

            </c:if>













            <c:if test="${ ! empty sessionScope.begin }">
                <div class="container">
                    <form action="AddContribution" method="get">
                        <c:if test="${sessionScope.pen =='false'}">
                            <c:forEach items="${member}" var="name">
                                <div class="col-md-4 offset-1 ">

                                    <p id="memberID" style="position: relative;left: 10px;color: lightgray"> Transaction type :Credit</p>
                                    <p id="memberID" style="position: relative;left: 20px ;color: lightgrey"> #Chama ID:</p>
                                    <p id="memberID" style="position: relative;left: 10px;color: lightgrey"> #Account ID:${name.memberID}</p>
                                </div>
                                <div class="col-sm-4 col-md-offset-1">
                                    <div class="input-group input-icon right">

                                        <span class="input-group-addon">
                                            <i class="fa fa-user"></i>
                                        </span>

                                        <input type="text" class="form-control1" placeholder="Name" name="username" value="${name.firstName} ${name.lastName} " disabled="true">
                                    </div>
                                    <div class="input-group input-icon right">
                                        <span class="input-group-addon">
                                            <i class="fa fa-dollar"></i>
                                        </span>
                                        <input type="text" class="form-control1" placeholder="balance" disabled="true" name="pass" value="" >
                                    </div>

                                    <div class="input-group input-icon right">
                                        <span class="input-group-addon">
                                            <i class="fa fa-dollar"></i>
                                        </span>
                                        <input type="text" class="form-control1" placeholder="Contribute"  name="contribute" data-validation="amount">
                                        <input type="text" name="uniqueT" value="${sessionScope.adminUnique}" hidden="true">
                                        <input type="text" name="idnumber" value="${name.idNumber}" hidden="true">
                                        <input type="text" class="form-control1" placeholder="Member ID" name="id" value="${name.idNumber}" hidden="true">
                                    </div>
                                </div>


                                <div class="col-sm-12 col-md-offset-6">

                                    <button type="submit" class="btn btn-primary">Submit</button>
                                    <button type="reset" class="btn btn-default">Reset</button>

                                </div>
                            </form>
                        </div>




                    </div>


                </div>



            </c:forEach>
        </c:if>
    </c:if>

    <script>

        $.validate({
            modules: 'location, date, security, file',
            onModulesLoaded: function () {
                $('#email').suggestCountry();
            }
        });

        $.validate({
            modules: 'toggleDisabled',
            disabledFormFilter: 'form.toggle-disabled',
            showErrorDialogs: false
        });


  // Add custom validation rule
        $.formUtils.addValidator({
            name: 'user_name',
            validatorFunction: function (value, $el, config, language, $form) {

                var re = new RegExp("^[a-zA-Z]+$");
                return re.test(value);
            },
            errorMessage: 'Only Characters are allowed!!',
            errorMessageKey: 'badEvenNumber'
        });
        $.formUtils.addValidator({
            name: 'phone_n',
            validatorFunction: function (value, $el, config, language, $form) {

                var re = new RegExp("^(0)([0-9]{9})$");
                return re.test(value);
            },
            errorMessage: 'Only valid phone numbers are allowed!!',
            errorMessageKey: 'badEvenNumber'
        });
        $.formUtils.addValidator({
            name: 'id_num',
            validatorFunction: function (value, $el, config, language, $form) {

                var re = new RegExp("^([0-9]{7,8})$");
                return re.test(value);
            },
            errorMessage: 'Only valid number is allowed!!',
            errorMessageKey: 'badEvenNumber'
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

  // Setup form validation
        $.validate();


    </script>





    <jsp:include page='viewh.jsp'>
        <jsp:param name="articleId" value=""/>
    </jsp:include>