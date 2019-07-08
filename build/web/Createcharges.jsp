<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page='View.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>

<div class="banner">

    <h2>
        <a href="index.html">Home</a>
        <i class="fa fa-angle-right"></i>
        <span>Create loan and penalty Charges for the chama</span>
    </h2>
</div >

<!--Create content pane-->
<div class="grid-system">
    <div class="horz-grid"> 
        <div class="row">


            <div class="col-md-4 col-md-offset-1 " style="margin-bottom: 15px">
                <div class="content-top-1 offset-1">
                    <div class="col-md-6 top-content">
                        <h5>Late Loan Charges</h5>
                        
                    </div>
                    <div class="col-md-6 top-content1">	   
                        <button class="btn btn-success"   data-toggle="modal" data-target="#penID" >Late Loan Charges</button>


                    </div>
                    <div class="clearfix"> </div>
                </div>


            </div>
            <div class="col-md-4 col-md-offset-1 " style="margin-bottom: 15px">
                <div class="content-top-1 offset-1">
                    <div class="col-md-6 top-content">
                        <h5>Loan Interest charges</h5>
                        
                    </div>
                    <div class="col-md-6 top-content1">	   
                        <button class="btn btn-success"   data-toggle="modal" data-target="#loanCid" >Loan interest</button>

                    </div>
                    <div class="clearfix"> </div>
                </div>


            </div>
                    <div class="col-md-4 col-md-offset-1 " style="margin-bottom: 15px">
                <div class="content-top-1 offset-1">
                    <div class="col-md-6 top-content">
                        <h5>Late Contribution Charges</h5>
                        
                    </div>
                    <div class="col-md-6 top-content1">	   
                        <button class="btn btn-success"   data-toggle="modal" data-target="#late" >Late Charges</button>

                    </div>
                    <div class="clearfix"> </div>
                </div>


            </div>

        </div>
        <!--Add charges modals-->
        <div class="modal fade" id="loanCid" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle" style="font-size:20px">
                            <span class="fa fa-money"></span>
                            Modify Loan Interest Rate
                        </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true" style="font-style: inherit;font-family: fantasy">&times;</span>
                        </button>
                    </div>
                    <form id="deleteForm" action="manageCharges" method="post">
                        <div class="modal-body">
                            <!--Have the contents here-->

                            <div class="input-group input-icon right">
                                <span class="input-group-addon">
                                    <i class="fa fa-percent"></i>
                                </span>
                                <label for="loanintrest"><span></span></label>
                                <select class="form-control form-control-sm" id='interest' name="charge">Interest Rate</select>
                                <input type="hidden" name="rate" value="loanint">
                            </div>
                            
                            <input type="hidden" name="dUnique" value="${sessionScope.adminUnique}"  />
                            
                        </div>
                        <div class="modal-footer">

                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

                            <button type="submit" class="btn btn-success" value="">Save</button>


                        </div>
                    </form>
                </div>
            </div>

        </div>
        <div class="modal fade" id="penID" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle" style="font-size:20px">
                            <span class="fa fa-money"></span>
                            Loan Penalty Charges Rate
                        </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true" style="font-style: inherit;font-family: fantasy">&times;</span>
                        </button>
                    </div>
                    <form id="deleteForm" action="manageCharges" method="post">
                        <div class="modal-body">
                            <!--Have the contents here-->

                            <div class="input-group input-icon right">
                                <span class="input-group-addon">
                                    <i class="fa fa-percent"></i>
                                </span>
                                <label for="loanPena"><span></span></label>
                                <select class="form-control form-control-sm" id='loanPen' name="charge">Penalty Rate</select>
                                 <input type="hidden" name="rate" value="penrate">
                            </div>

                            <input type="hidden" name="dUnique" value="${sessionScope.adminUnique}"  />
                          
                        </div>
                        <div class="modal-footer">

                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

                            <button type="submit" class="btn btn-success" value="">Save</button>


                        </div>
                    </form>
                </div>
            </div>

        </div>
                                <div class="modal fade" id="late" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle" style="font-size:20px">
                            <span class="fa fa-money"></span>
                            Late Contribution Charges
                        </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true" style="font-style: inherit;font-family: fantasy">&times;</span>
                        </button>
                    </div>
                    <form id="deleteForm" action="manageCharges" method="post">
                        <div class="modal-body">
                            <!--Have the contents here-->

                            <div class="input-group input-icon right">
                                <span class="input-group-addon">
                                    <i class="fa fa-percent"></i>
                                </span>
                                <label for="lateCon"><span></span></label>
                                <select class="form-control form-control-sm" id='lateID' name="charge">Penalty </select>
                            </div>
                           <input type="hidden" name="rate" value="latecon">
                            <input type="hidden" name="dUnique" value="${sessionScope.adminUnique}"  />
                          
                        </div>
                        <div class="modal-footer">

                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

                            <button type="submit" class="btn btn-success
                                    " value="">Save</button>


                        </div>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>
                            <script>
                                var select = '';
                                for(i=1;i <=30;i++){
                                    select +='<option val='+ i +'>'+ i + '</option>'; 
                                }
                                $('#interest').html(select);
                     
                                
                            </script>
                             <script>
                                var select = '';
                                for(i=1;i <=30;i++){
                                    select +='<option val='+ i +'>'+ i + '</option>'; 
                                }
                                $('#loanPen').html(select);
                     
                                
                            </script>
                             <script>
                                var select = '';
                                for(i=1;i <=30;i++){
                                    select +='<option val='+ i +'>'+ i + '</option>'; 
                                }
                                $('#lateID').html(select);
                     
                                
                            </script>


<jsp:include page='viewh.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>