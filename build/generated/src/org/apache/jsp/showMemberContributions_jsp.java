package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class showMemberContributions_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "View.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("articleId", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("", request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("<div class=\"banner\">\n");
      out.write("    <h2>\n");
      out.write("        <a href=\"DashBoardIndex.html\">Home</a>\n");
      out.write("        <i class=\"fa fa-angle-right\"></i>\n");
      out.write("        <span>Show Member Contributions</span>\n");
      out.write("    </h2>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"banner\" style=\"margin-top: 10px\">\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <div class=\" col-md-4 offset-md-4\">\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("    \t<div class=\"horz-grid\">\n");
      out.write("\t\t\n");
      out.write("\t\t\t<div class=\"row \">\n");
      out.write("                            <div class=\"col-md-4 \" style=\"position: relative;left: 70px\">\n");
      out.write("                                <h2>Select Start Date:</h2>\n");
      out.write("                                \n");
      out.write("                                <div class=\"input-group input-icon right\">\n");
      out.write("                    <span class=\"input-group-addon\">\n");
      out.write("                        <i class=\"fa fa-envelope\"></i>\n");
      out.write("                    </span>\n");
      out.write("                                <input type=\"date\" class=\"form-control1\" placeholder=\"Valid email address\" name=\"email\">\n");
      out.write("                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-4 col-md-offset-4\" style=\"position: relative;left: -70px\">\n");
      out.write("                                <h2>Select end Date:</h2>\n");
      out.write("                                <div class=\"input-group input-icon right\">\n");
      out.write("                    <span class=\"input-group-addon\">\n");
      out.write("                        <i class=\"fa fa-envelope\"></i>\n");
      out.write("                    </span>\n");
      out.write("                                    <input type=\"date\" class=\"form-control1\" placeholder=\"Valid email address\" name=\"email\">\n");
      out.write("                </div>\n");
      out.write("                                \n");
      out.write("                            </div>\n");
      out.write("\t\t\t</div>\n");
      out.write("            </div>\n");
      out.write("          \n");
      out.write("          \n");
      out.write("    \n");
      out.write("          \n");
      out.write("    </div> \n");
      out.write("          \n");
      out.write("         <div class=\"grid-system\">\n");
      out.write("    <div class=\"horz-grid\"> \n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("        <table class=\"table table-striped\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th scope=\"col\">#</th>\n");
      out.write("                    <th scope=\"col\">First Name</th>\n");
      out.write("                    <th scope=\"col\">Last Name </th>\n");
      out.write("                    <th scope=\"col\">Amount Contributed</th>\n");
      out.write("                    <th scope=\"col\">Date Contributed</th>\n");
      out.write("                    <th scope=\"col\">Action</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "viewh.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("articleId", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("", request.getCharacterEncoding()), out, false);
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
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${code != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("    There is a user **attribute** in the session\n");
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
