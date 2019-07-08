<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page='View.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
<div class="banner">
    <h2>
        <a href="homepage.jsp">Home</a>
        <i class="fa fa-angle-right"></i>
        <span>Add treasurer</span>
    </h2>
</div>
<div class="grid-system">
    <div class="horz-grid">
        <c:choose>      
            <c:when test="${message=='success'}"> 
                <div class="alert alert-success " style="width: 300px" role="alert">
                    User added successfully
                </div>
            </c:when>
        </c:choose>
        <c:remove var="message" />
        <div class="grid-hor">

            <p class="">Please provide treasurer details and they will receive an email notiftying them of thier creation
                into the system</p>
            <hr style="width: 100px">

        </div>
        <form action="addTreasurer" method="post" id="addtreasurer">




            <div class="container">
                <div class="col-sm-4 col-md-offset">
                    <div class="input-group input-icon right">
                        <span class="input-group-addon">
                            <i class="fa fa-user"></i>
                        </span>
                        <label for="username"><span></span></label>
                        <input type="text" class="form-control1" placeholder="Username" name="username"  data-validation="user_name">
                          
                    </div>
              <div class="input-group input-icon right">
                        <span class="input-group-addon">
                            <i class="fa fa-envelope"></i>
                        </span>
                        
                        <input type="email" class="form-control1" data-validation="email" placeholder="Valid email address" name="email" >
                    </div>
                </div>
     
      
                <div class="col-sm-4 col-md-offset">

                    <div class="input-group input-icon right">
                        <span class="input-group-addon">
                            <i class="fa fa-key"></i>
                        </span>
                        <input type="password" class="form-control1" placeholder="Password" disabled="true" name="pass">
                        <input type="hidden" class="form-control1" placeholder="admin" value="${sessionScope.adminUnique}" name="adminunique">
                    </div>

                </div>

                <div class="col-sm-12 col-md-offset-5">

                    <button type="submit" id="submit-treasurer" class="btn btn-primary">Submit</button>
                    <button type="reset" class="btn btn-default">Reset</button>

                </div>
            </div>
        </form>


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
 
// Setup form validation
$.validate();
 

</script>

<jsp:include page='viewh.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
