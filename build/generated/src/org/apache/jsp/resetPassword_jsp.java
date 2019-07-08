package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class resetPassword_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("    \n");
      out.write("\n");
      out.write("<link href=\"css2/bootstrap.min.css\" rel='stylesheet' type='text/css' />\n");
      out.write("<!-- Custom Theme files -->\n");
      out.write("<link href=\"css2/style.css\" rel='stylesheet' type='text/css' />\n");
      out.write("<link href=\"css2/font-awesome.css\" rel=\"stylesheet\"> \n");
      out.write("            <script src=\"js/jquery.min.js\"> </script>\n");
      out.write("<script src=\"js/bootstrap.min.js\"> </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"login\">\n");
      out.write("        <h1><a href=\"#\" style=\"color: #0d0d0d\">Financial Solutons </a></h1>\n");
      out.write("        <div class=\"login-bottom\">\n");
      out.write("            <h2>Reset Password</h2>\n");
      out.write("            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            <p></p>\n");
      out.write("            <form action=\"ReserPasswordServlet\" method=\"post\">\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <div class=\"login-mail\">\n");
      out.write("                        <input type=\"text\" placeholder=\"Email\" name =\"email\"required=\"\">\n");
      out.write("                        <i class=\"fa fa-envelope\"></i>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-6 login-do\">\n");
      out.write("                    <label class=\"hvr-shutter-in-horizontal login-sub\">\n");
      out.write("                        <input type=\"submit\" value=\"Reset\">\n");
      out.write("                    </label>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"clearfix\"> </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!---->\n");
      out.write("    <div class=\"copy-right\">\n");
      out.write("        <p> &copy; 2019 . All Rights Reserved | Design by <a href=\"index.html\">Financial Chama Solutions</a> </p>\t    </div>  \n");
      out.write("    <!---->\n");
      out.write("    <!--scrolling js-->\n");
      out.write("    <script src=\"js/jquery.nicescroll.js\"></script>\n");
      out.write("    <script src=\"js/scripts.js\"></script>\n");
      out.write("    <!--//scrolling js-->\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${! empty sessionScope.err || ! empty sessionScope.succ}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                \n");
        out.write("                <p>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.err}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\n");
        out.write("                <p>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.succ}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\n");
        out.write("            ");
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
