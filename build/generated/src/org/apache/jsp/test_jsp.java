package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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

      out.write(" \n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "View.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("articleId", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("", request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"banner\">\n");
      out.write("    <h2>\n");
      out.write("        <a href=\"DashBoardIndex.html\">Home</a>\n");
      out.write("        <i class=\"fa fa-angle-right\"></i>\n");
      out.write("        <span>Add member Contribution</span>\n");
      out.write("    </h2>\n");
      out.write("</div>\n");
      out.write("  <div class=\"grid-system\">\n");
      out.write("  <div class=\"horz-grid\">\n");
      out.write("            <div class=\"grid-hor\">\n");
      out.write("               \n");
      out.write("            \n");
      out.write("                <p class=\"\"><strong>Issue members with loans</strong> </p>\n");
      out.write("            <hr style=\"width: 100px\">\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("       \n");
      out.write("      <div>\n");
      out.write("          <a href=\"memberLoanReport\"> View Penal</a>\n");
      out.write("          \n");
      out.write("          \n");
      out.write("      </div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<div class=\"row \">\n");
      out.write("                         \n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t \n");
      out.write("\t\t\n");
      out.write("            \n");
      out.write("    \n");
      out.write("              \n");
      out.write("   \n");
      out.write("          \n");
      out.write("         \n");
      out.write("          \n");
      out.write("     \n");
      out.write("      \n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                              ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "viewh.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("articleId", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("", request.getCharacterEncoding()), out, false);
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
}
