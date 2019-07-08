<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page='View.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>



<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>




<div class="login" style="margin-top: -40px">
        <h1><a href="#" style="color: #0d0d0d">ENTER YOUR NEW PASSWORD </a></h1>
        <div class="login-bottom">
            <h2>Login</h2>
            <c:if test="${! empty sessionScope.pasChaneg}">
                
                <p>${sessionScope.pasChaneg}</p>
                
            </c:if>
            <p></p>
            <form action="ResetUserPass" method="post">
                <div class="col-md-6">
                    <div class="login-mail">
                        <input type="password" placeholder="pass" name ="pass" data-validation="strength" data-validation-strength="2">
                        <input type="hidden" name="sup" value="${sessionScope.adminUnique}"
                        <i class="fa fa-lock"></i>
                    </div>

                </div>
                <div class="col-md-6 login-do">
                    <label class="hvr-shutter-in-horizontal login-sub">
                        <input type="submit" value="Reset">
                    </label>
                    
                </div>

                <div class="clearfix"> </div>
            </form>
        </div>
    </div>



<script>
$.validate({
  modules : 'security',
  onModulesLoaded : function() {
    var optionalConfig = {
      fontSize: '12pt',
      padding: '4px',
      bad : 'Very bad',
      weak : 'Weak',
      good : 'Good',
      strong : 'Strong'
    };

    $('input[name="pass"]').displayPasswordStrength(optionalConfig);
  }
});
</script>









<jsp:include page='viewh.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
