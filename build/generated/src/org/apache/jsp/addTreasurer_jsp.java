package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addTreasurer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_remove_var_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_remove_var_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_remove_var_nobody.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_when_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "View.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("articleId", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("", request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js\"></script>\r\n");
      out.write("<div class=\"banner\">\r\n");
      out.write("    <h2>\r\n");
      out.write("        <a href=\"homepage.jsp\">Home</a>\r\n");
      out.write("        <i class=\"fa fa-angle-right\"></i>\r\n");
      out.write("        <span>Add treasurer</span>\r\n");
      out.write("    </h2>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"grid-system\">\r\n");
      out.write("    <div class=\"horz-grid\">\r\n");
      out.write("        ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        ");
      if (_jspx_meth_c_remove_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        <div class=\"grid-hor\">\r\n");
      out.write("\r\n");
      out.write("            <p class=\"\">Please provide treasurer details and they will receive an email notiftying them of thier creation\r\n");
      out.write("                into the system</p>\r\n");
      out.write("            <hr style=\"width: 100px\">\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <form action=\"addTreasurer\" method=\"post\" id=\"addtreasurer\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"col-sm-4 col-md-offset\">\r\n");
      out.write("                    <div class=\"input-group input-icon right\">\r\n");
      out.write("                        <span class=\"input-group-addon\">\r\n");
      out.write("                            <i class=\"fa fa-user\"></i>\r\n");
      out.write("                        </span>\r\n");
      out.write("                        <label for=\"username\"><span></span></label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control1\" placeholder=\"Username\" name=\"username\"  data-validation=\"user_name\">\r\n");
      out.write("                          <input data-validation=\"length alphanumeric\" data-validation-length=\"min4\">\r\n");
      out.write("                    </div>\r\n");
      out.write("              <div class=\"input-group input-icon right\">\r\n");
      out.write("                        <span class=\"input-group-addon\">\r\n");
      out.write("                            <i class=\"fa fa-envelope\"></i>\r\n");
      out.write("                        </span>\r\n");
      out.write("                        \r\n");
      out.write("                        <input type=\"email\" class=\"form-control1\" data-validation=\"email\" placeholder=\"Valid email address\" name=\"email\" >\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("     \r\n");
      out.write("      \r\n");
      out.write("                <div class=\"col-sm-4 col-md-offset\">\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"input-group input-icon right\">\r\n");
      out.write("                        <span class=\"input-group-addon\">\r\n");
      out.write("                            <i class=\"fa fa-key\"></i>\r\n");
      out.write("                        </span>\r\n");
      out.write("                        <input type=\"password\" class=\"form-control1\" placeholder=\"Password\" disabled=\"true\" name=\"pass\">\r\n");
      out.write("                        <input type=\"hidden\" class=\"form-control1\" placeholder=\"admin\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.adminUnique}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"adminunique\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-sm-12 col-md-offset-5\">\r\n");
      out.write("\r\n");
      out.write("                    <button type=\"submit\" id=\"submit-treasurer\" class=\"btn btn-primary\">Submit</button>\r\n");
      out.write("                    <button type=\"reset\" class=\"btn btn-default\">Reset</button>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$.validate({\r\n");
      out.write("    modules : 'location, date, security, file',\r\n");
      out.write("    onModulesLoaded : function() {\r\n");
      out.write("      $('#email').suggestCountry();\r\n");
      out.write("    }\r\n");
      out.write("  });\r\n");
      out.write("\r\n");
      out.write("$.validate({\r\n");
      out.write("  modules : 'toggleDisabled',\r\n");
      out.write("  disabledFormFilter : 'form.toggle-disabled',\r\n");
      out.write("  showErrorDialogs : false\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("// Add custom validation rule\r\n");
      out.write("$.formUtils.addValidator({\r\n");
      out.write("  name : 'user_name',\r\n");
      out.write("  validatorFunction : function(value, $el, config, language, $form) {\r\n");
      out.write("      \r\n");
      out.write("      var re = new RegExp(\"^[a-zA-Z]+$\");\r\n");
      out.write("    return re.test(value);\r\n");
      out.write("  },\r\n");
      out.write("  errorMessage : 'Only Characters are allowed!!',\r\n");
      out.write("  errorMessageKey: 'badEvenNumber'\r\n");
      out.write("});\r\n");
      out.write(" \r\n");
      out.write("// Setup form validation\r\n");
      out.write("$.validate();\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "viewh.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("articleId", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("", request.getCharacterEncoding()), out, false);
      out.write('\r');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("      \r\n");
        out.write("            ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message=='success'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" \r\n");
        out.write("                <div class=\"alert alert-success \" style=\"width: 300px\" role=\"alert\">\r\n");
        out.write("                    User added successfully\r\n");
        out.write("                </div>\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_remove_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_remove_0 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _jspx_tagPool_c_remove_var_nobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    _jspx_th_c_remove_0.setPageContext(_jspx_page_context);
    _jspx_th_c_remove_0.setParent(null);
    _jspx_th_c_remove_0.setVar("message");
    int _jspx_eval_c_remove_0 = _jspx_th_c_remove_0.doStartTag();
    if (_jspx_th_c_remove_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_remove_var_nobody.reuse(_jspx_th_c_remove_0);
      return true;
    }
    _jspx_tagPool_c_remove_var_nobody.reuse(_jspx_th_c_remove_0);
    return false;
  }
}
