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
  <div class="grid-system">
  <div class="horz-grid">
            <div class="grid-hor">
               
            
                <p class=""><strong>Issue members with loans</strong> </p>
            <hr style="width: 100px">

        </div>
       
      <c:if test="${!empty sessionScope.IDmessage || !empty sessionScope.loanexist
                    || !empty sessionScope.loancreate || !empty sessionScope.allow || !empty sessionScope.sera }">
                
                 <div class="col-sm-4 col-md-offset-1" style="margin-top: -40px">
               
              <div class="form-group has-error">
                    <!--IF loan exists check or ID is wrong-->
                  
		<label class=" control-label">${sessionScope.IDmessage}</label>
                <label class=" control-label">${sessionScope.loanexist}</label>
							
							
						</div>
                    
                
            </div>
                            <form action="manageLoans" method="get">
        <div class="container">
            <div class="col-sm-4 col-md-offset-8" style="margin-top: -40px">
                <div class="input-group input-icon right">
                    <span class="input-group-addon">
                        <i class="fa fa-search-plus"></i>
                    </span>
                    <input type="text" class="form-control1" placeholder="Member ID" name="idnumber" data-validation="id_num">
                    <input type="hidden"  name="uniqueT" value="${sessionScope.adminUnique}">
                </div>
                 <button type="submit" class="form-control1" id="search"
                            style="width: 150px;position: relative;left: 200px"> Search
                    </button>
                
                
            </div>
 
        </div>
 </form>
                
           </c:if>
         <!--Use to display loan form if none exist-->
         <c:if test="${!empty sessionScope.loanfalse  }">
             
          <div class="horz-grid">
           
                  <div class="container">
           
                

                 <div class="col-md-4 offset-1 ">
                  
           
             <p id="memberID" style="position: relative;left: 10px;color: lightgray"> Transaction type :DEBIT</p>
              
        </div>
                
                   <div class="col-md-4 offset-1 ">
              <p id="memberID" style="position: relative;left: 20px ;color: lightgrey"> #Name:
               <c:forEach items="${memberdetail}" var="name">
                ${name.firstName}${name.lastName}
                 
              
              </p>
        </div>
                  <div class="col-md-4 offset-1 ">
              <p id="memberID" style="position: relative;left: 10px;color: lightgrey"> #Account ID:
              ${name.memberID}
              
              </p>
        </div>
                 </c:forEach>
        
                </div>
                <div class="row ">
			  <div class="col-md-2 col-md-offset-8">
                              <p class="fa fa-money"  style="color:darkgray"> Float:</p>
                          
                          <p  style="color:darkgray">KSH: ${sessionScope.amounttolend}</p>
                          
                      
                        
                  
                          
                          </div>
			  <div class="col-md-8 col-md-offset-2"> <div class="input-group input-icon right">
                                  <hr>
                          
                                         
                </div></div>
			</div>
               <form action="manageLoans" method="post">
              <div class="row ">
                  <div class="col-md-2 col-md-offset-2">
                      
                      <p id="memberID" style="color: lightgrey"> Amount to Loan:
                          <input type="hidden" name="am" value="${sessionScope.amounttolend}" id="am">
              </p>
                  </div>
			  <div class="col-md-3 col-md-offset-2"> <div class="input-group input-icon right">
                    <span class="input-group-addon">
                        <i class="fa fa-calendar-plus-o"></i>
                    </span>
                                  
                       <input type="text" class="form-control1" id="loan" placeholder="loan amount" name="loan" data-validation="amount">
                     
                </div></div>
			</div>
                 <div class="row ">
                  <div class="col-md-2 col-md-offset-2">
                      
                      <p id="memberID" style="color: lightgrey"> DATE DUE :
              
              </p>
                  </div>
			  <div class="col-md-3 col-md-offset-2"> <div class="input-group input-icon right">
                    <span class="input-group-addon">
                        <i class="fa fa-calendar-plus-o"></i>
                    </span>
                       <input type="date" class="form-control1" placeholder="duedate" name="daterepay" id="txtDate">
                     
                </div></div>
			</div>
               <div class="row ">
                  
                   <div class="col-md-3 col-md-offset-2">
                       <c:forEach items="${memberdetail}" var="name">
                       
                       <input type="hidden" name="idnum" value="${name.idNumber}">
                       </c:forEach>
                     <input type="hidden"  name="supervisorid" value="${sessionScope.adminUnique}">
                   </div>
			</div>
                        <div class="row">
                            <div class="col-md-2 col-md-offset-2">
                            
                   <a href="cancelTransaction?cancel=cancel" class="btn btn-default">Cancel Transaction</a>
                  </div>
                            <div class="col-md-2 col-md-offset-4">
                   
                        <button type="submit" class="btn btn-primary">Submit</button>
                        <button type="reset" class="btn btn-default">Reset</button>
                   
                  </div>
                        </div>
               </form>
                       
        </div>
            </div>
            
            </div>
             
            </c:if>
      

			
			<div class="row ">
                         
			</div>
			 
	<script>

        
           $(function () {
                var dtToday = new Date();

                var month = dtToday.getMonth() + 1;
                var day = dtToday.getDate();
                var year = dtToday.getFullYear();
                if (month < 10)
                    month = '0' + month.toString();
                if (day < 10)
                    day = '0' + day.toString();

                var maxDate = year + '-' + month + '-' + day;
               
                $('#txtDate').attr('min', maxDate);
            });
        </script>	
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
$(function() {
    $("#first,#am").on("keyup",function() {
        var first = $("#lamount").val();
        var sec = $("#am").val();
        if(Number(first)> Number(sec)){
            alert("true");
            return true;
        }
    
});
    
});
 
jQuery(document).ready(function ($) {

    $.validator.addMethod('le', function (value, element, param) {
        return this.optional(element) || parseInt(value) <= parseInt($(param).val());
    }, 'Invalid value');


    $('#am').validate({
        errorElement: "small",
        rules: {
            bid_price: {
                required: true,
                number: true

            },
            bid_auto_decrement: {
                required: true,
                number: true,
                le: '#am'
            }
        },
        messages: {
            bid_auto_decrement: {
                le: 'Must be less than bid price.'
            }
        }
    });
    
    $('[name="am"]').on('change blur keyup', function() {
        $('[name="loan"]').valid();
    });
    
});
</script>
    
    

    
              
   
          
         
          
     
      
    







                              <jsp:include page='viewh.jsp'>
                <jsp:param name="articleId" value=""/>
                    </jsp:include>
