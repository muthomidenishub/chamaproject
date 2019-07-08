package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addMember_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("   ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "View.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("articleId", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("", request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"banner\">\n");
      out.write("    <h2>\n");
      out.write("        <a href=\"DashBoardIndex.html\">Home</a>\n");
      out.write("        <i class=\"fa fa-angle-right\"></i>\n");
      out.write("        <span>Add treasurer</span>\n");
      out.write("    </h2>\n");
      out.write("</div>\n");
      out.write("<div class=\"grid-system\">\n");
      out.write("    <div class=\"horz-grid\">\n");
      out.write("\n");
      out.write("        <div id=\"message\">\n");
      out.write("     \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"grid-hor \" style=\"margin-left: 150px;margin-bottom: 20px\" >\n");
      out.write("\n");
      out.write("            <h class=\"\" style=\"color: gray\"> <i class=\"fa fa-pencil fa-2x \"></i><b>Enter Chama member details</b></h>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <form  action=\"addMember\" id=\"myForm\" method=\"get\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("                <div class=\"col-sm-4 col-md-offset-1\">\n");
      out.write("                    <div class=\"input-group input-icon right\">\n");
      out.write("                        <span class=\"input-group-addon\">\n");
      out.write("                            <i class=\"fa fa-user\"></i>\n");
      out.write("                        </span>\n");
      out.write("                        <input type=\"text\" class=\"form-control1\" placeholder=\"First name\"  id=\"fname\" name=\"fname\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-group input-icon right\">\n");
      out.write("                        <span class=\"input-group-addon\">\n");
      out.write("                            <i class=\"fa fa-phone\"></i>\n");
      out.write("                        </span>\n");
      out.write("                        <input type=\"text\" class=\"form-control1\" placeholder=\"phone number\" id=\"phone\" name=\"phone\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-4 col-md-offset-1\">\n");
      out.write("                    <div class=\"input-group input-icon right\">\n");
      out.write("                        <span class=\"input-group-addon\">\n");
      out.write("                            <i class=\"fa fa-user\"></i>\n");
      out.write("                        </span>\n");
      out.write("                        <input type=\"text\" class=\"form-control1\" placeholder=\"Last name\" id=\"lname\" name=\"lname\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-group input-icon right\">\n");
      out.write("                        <span class=\"input-group-addon\">\n");
      out.write("                            <i class=\"fa fa-envelope\"></i>\n");
      out.write("                        </span>\n");
      out.write("                        <input type=\"email\" class=\"form-control1\" placeholder=\"Valid email address\"  id=\"email\" name=\"email\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"col-sm-4 col-md-offset-1\">\n");
      out.write("\n");
      out.write("                    <div class=\"input-group input-icon right\">\n");
      out.write("                        <span class=\"input-group-addon\">\n");
      out.write("                            <i class=\"fa fa-file\"></i>\n");
      out.write("                        </span>\n");
      out.write("                        <input type=\"text\" class=\"form-control1\" placeholder=\"ID number\" id=\"idnumber\" name=\"idnumber\">\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-4 col-md-offset-1\">\n");
      out.write("\n");
      out.write("                    <div class=\"input-group input-icon right\">\n");
      out.write("                        <span class=\"input-group-addon\">\n");
      out.write("                            <i class=\"fa fa-location-arrow\"></i>\n");
      out.write("                        </span>\n");
      out.write("                        <input type=\"text\" class=\"form-control1\" placeholder=\"location\"  id=\"local\" name=\"local\">\n");
      out.write("                        <input type=\"hidden\" class=\"form-control1\" placeholder=\"treasurerUni\" name=\"treasurerUni\" \n");
      out.write("                               value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.adminUnique}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("                             >\n");
      out.write("                    </div>\n");
      out.write("  \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"col-sm-12 col-md-offset-8\">\n");
      out.write("\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\" id=\"sub\"><i class=\"fa fa-location-arrow\"></i>Submit </button>\n");
      out.write("                    <button type=\"reset\" class=\"btn btn-default\">Reset</button>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("    \n");
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
