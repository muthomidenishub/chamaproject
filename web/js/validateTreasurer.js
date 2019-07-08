
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


