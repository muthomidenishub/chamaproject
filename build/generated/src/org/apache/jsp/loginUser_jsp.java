package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginUser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<title>Login in Chama</title>\n");
      out.write(" <!-- Meta-Tags -->\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        addEventListener(\"load\", function () {\n");
      out.write("            setTimeout(hideURLbar, 0);\n");
      out.write("        }, false);\n");
      out.write("\n");
      out.write("        function hideURLbar() {\n");
      out.write("            window.scrollTo(0, 1);\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("    <!-- //Meta-Tags -->\n");
      out.write("\t\n");
      out.write("\t<!-- css files -->\n");
      out.write("\t<link href=\"css1/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\">\n");
      out.write("\t<link href=\"css1/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\"/>\n");
      out.write("\t<!-- //css files -->\n");
      out.write("\t\n");
      out.write("\t<!-- google fonts -->\n");
      out.write("\t<link href=\"//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i\" rel=\"stylesheet\">\n");
      out.write("\t<!-- //google fonts -->\n");
      out.write("        <!-- Custom-Files -->\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("\t<!-- Bootstrap-Core-CSS -->\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" media=\"all\" />\n");
      out.write("\t<!-- Style-CSS -->\n");
      out.write("\t<link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("\t<!-- Font-Awesome-Icons-CSS -->\n");
      out.write("\t<!-- //Custom-Files -->\n");
      out.write("\n");
      out.write("\t<!-- Web-Fonts -->\n");
      out.write("\t<link href=\"//fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=devanagari,latin-ext\"\n");
      out.write("\t rel=\"stylesheet\">\n");
      out.write("\t\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("  <div class=\"main-top\" id=\"home\">\n");
      out.write("\t\t<!-- header -->\n");
      out.write("\t\t<header>\n");
      out.write("\t\t\t<div class=\"container-fluid\">\n");
      out.write("\t\t\t\t<div class=\"header d-lg-flex justify-content-between align-items-center py-3 px-sm-3\">\n");
      out.write("\t\t\t\t\t<!-- logo -->\n");
      out.write("\t\t\t\t\t<div id=\"logo\">\n");
      out.write("\t\t\t\t\t\t<h1><a href=\"index.html\"><span class=\"fa fa-linode mr-2\"></span>Chama Solutions</a></h1>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<!-- //logo -->\n");
      out.write("\t\t\t\t\t<!-- nav -->\n");
      out.write("\t\t\t\t\t<div class=\"nav_w3ls\" >\n");
      out.write("\t\t\t\t\t\t<nav>\n");
      out.write("\t\t\t\t\t\t\t<label for=\"drop\" class=\"toggle\">Menu</label>\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"drop\" />\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"menu\">\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"index.html\" class=\"active\">Home</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"about.html\">About Us</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"pricing.html\">Pricing</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"contact.html\">Contact Us</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"login.html\">Create a Chama</a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t</nav>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<!-- //nav -->\n");
      out.write("\t\t\t\t\t<div class=\"d-flex mt-lg-1 mt-sm-2 mt-3 justify-content-center\">\n");
      out.write("\t\t\t\t\t\t<!-- search -->\n");
      out.write("\t\t\t\t\t\t<div class=\"search-w3layouts mr-3\">\n");
      out.write("\t\t\t\t\t\t\t<form action=\"#\" method=\"post\" class=\"search-bottom-wthree d-flex\">\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"search\" type=\"search\" placeholder=\"Search Here...\" required=\"\">\n");
      out.write("\t\t\t\t\t\t\t\t<button class=\"form-control btn\" type=\"submit\"><span class=\"fa fa-search\"></span></button>\n");
      out.write("\t\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<!-- //search -->\n");
      out.write("\t\t\t\t\t\t<!-- download -->\n");
      out.write("\t\t\t\t\t\t<a class=\"dwn-w3ls btn\" href=\"loginUser.html\" >\n");
      out.write("\t\t\t\t\t\t\t<span class=\"fa fa-sign-in\"></span>\n");
      out.write("\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t<!-- //download -->\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</header>\n");
      out.write("\t\t<!-- //header -->\n");
      out.write("\n");
      out.write("\t\t<!-- banner -->\n");
      out.write("\t\t<!-- //banner -->\n");
      out.write("\t</div>\n");
      out.write("<div class=\"signupform\">\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<!-- main content -->\n");
      out.write("\t\t<div class=\"agile_info\">\n");
      out.write("\t\t\t<div class=\"w3l_form\">\n");
      out.write("\t\t\t\t<div class=\"left_grid_info\">\n");
      out.write("\t\t\t\t\t<h1>Log in into your Chama</h1>\n");
      out.write("\t\t\t\t\t<p>Your Chama Success Starts here.Its all but one click away!!!</p>\n");
      out.write("\t\t\t\t\t<img src=\"images/image.jpg\" alt=\"\" />\n");
      out.write("                                       \n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"w3_info\">\n");
      out.write("\t\t\t\t<h2>Create Chama Account</h2>\n");
      out.write("\t\t\t\t<p>Enter your details</p>\n");
      out.write("                                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t<form action=\"LoginServlet\" method=\"post\">\n");
      out.write("\t\t\t\t\t<label>Username</label>\n");
      out.write("\t\t\t\t\t<div class=\"input-group\">\n");
      out.write("\t\t\t\t\t\t<span class=\"fa fa-user\" aria-hidden=\"true\"></span>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" placeholder=\"Username\"  name=\"username\" required> \n");
      out.write("                                        </div>\n");
      out.write("\t\t\t\t\t<label>Password</label>\n");
      out.write("\t\t\t\t\t<div class=\"input-group\">\n");
      out.write("\t\t\t\t\t\t<span class=\"fa fa-lock\" aria-hidden=\"true\"></span>\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" placeholder=\"Enter your password\" name=\"pass\" required> \n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</div>\t\t\n");
      out.write("\t\t\t\t\t\t<button class=\"btn btn-danger btn-block\" type=\"submit\">Login</button > \n");
      out.write("                                                <a href=\"resetPassword.jsp\">Forgot Password?Reset Password</a>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- //main content -->\n");
      out.write("\t</div>\n");
      out.write("\t<!-- footer -->\n");
      out.write("\t<div class=\"footer\">\n");
      out.write("\t\t<p>&copy;Finacial solution 2019</p>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- footer -->\n");
      out.write("</div>\n");
      out.write("\t\n");
      out.write("</body>\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ ! empty sessionScope.errMess}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    <p style=\"color: red\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.errMess}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\n");
        out.write("                                    \n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
