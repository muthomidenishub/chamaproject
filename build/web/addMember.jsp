


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page='View.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>


<div class="banner">
    <h2>
        <a href="DashBoardIndex.html">Home</a>
        <i class="fa fa-angle-right"></i>
        <span>Add Member</span>
    </h2>
</div>
<div class="grid-system">
    <div class="horz-grid">

        <div id="message">

        </div>

        <div class="grid-hor " style="margin-left: 150px;margin-bottom: 20px" >
            <c:if test="${! empty addSuc}">
                <p>${addSuc}</p>
                
                
            </c:if>

            <h class="" style="color: gray"> <i class="fa fa-pencil fa-2x "></i><b>Enter Chama member details</b></h>



        </div>
        <form  action="addMember" id="myForm" method="get">




            <div class="container">

                <div class="col-sm-4 col-md-offset-1">
                    <div class="input-group input-icon right">
                        <span class="input-group-addon">
                            <i class="fa fa-user"></i>
                        </span>
                        <input type="text" class="form-control1" placeholder="First name"  id="fname" name="fname" data-validation="user_name">
                    </div>
                    <div class="input-group input-icon right">
                        <span class="input-group-addon">
                            <i class="fa fa-phone"></i>
                        </span>
                        <input type="text" class="form-control1" placeholder="phone number" id="phone" name="phone" data-validation="phone_n">
                    </div>
                </div>
                <div class="col-sm-4 col-md-offset-1">
                    <div class="input-group input-icon right">
                        <span class="input-group-addon">
                            <i class="fa fa-user"></i>
                        </span>
                        <input type="text" class="form-control1" placeholder="Last name" id="lname" name="lname" data-validation="user_name">
                    </div>
                    <div class="input-group input-icon right">
                        <span class="input-group-addon">
                            <i class="fa fa-envelope"></i>
                        </span>
                        <input type="email" class="form-control1" placeholder="Valid email address"  id="email" name="email" data-validation="email">
                    </div>
                </div>

                <div class="col-sm-4 col-md-offset-1">

                    <div class="input-group input-icon right">
                        <span class="input-group-addon">
                            <i class="fa fa-file"></i>
                        </span>
                        <input type="text" class="form-control1" placeholder="ID number" id="idnumber" name="idnumber"data-validation="id_num">
                    </div>

                </div>
                
                <div class="col-sm-4 col-md-offset-1">

                    <div class="input-group input-icon right">
                        <span class="input-group-addon">
                            <i class="fa fa-location-arrow"></i>
                        </span>
                        <input type="text" class="form-control1" placeholder="location"  id="local" name="local" data-validation="user_name" >
                        <input type="hidden" class="form-control1" placeholder="treasurerUni" name="treasurerUni" 
                               value="${sessionScope.adminUnique}"
                               >
                    </div>

                </div>

                <div class="col-sm-12 col-md-offset-8">

                    <button type="submit" class="btn btn-primary" id="sub"><i class="fa fa-location-arrow"></i>Submit </button>
                    <button type="reset" class="btn btn-default">Reset</button>

                </div>
            </div>
        </form>


    </div>

</div>
<!--Create validation-->
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
  errorMessage : 'Only valid number is allowed!!',
  errorMessageKey: 'badEvenNumber'
});
 
// Setup form validation
$.validate();
 

</script>
    
    


<jsp:include page='viewh.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
