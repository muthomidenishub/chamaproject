package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Create_0020charges_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "View.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("articleId", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("", request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"banner\">\n");
      out.write("\n");
      out.write("    <h2>\n");
      out.write("        <a href=\"index.html\">Home</a>\n");
      out.write("        <i class=\"fa fa-angle-right\"></i>\n");
      out.write("        <span>Create loan and penalty Charges for the chama</span>\n");
      out.write("    </h2>\n");
      out.write("</div >\n");
      out.write("\n");
      out.write("<!--Create content pane-->\n");
      out.write("<div class=\"grid-system\">\n");
      out.write("    <div class=\"horz-grid\"> \n");
      out.write("        <div class=\"row\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"col-md-4 col-md-offset-1 \" style=\"margin-bottom: 15px\">\n");
      out.write("                <div class=\"content-top-1 offset-1\">\n");
      out.write("                    <div class=\"col-md-6 top-content\">\n");
      out.write("                        <h5>Loan charges</h5>\n");
      out.write("                        <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.totalaons}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-6 top-content1\">\t   \n");
      out.write("                        <button class=\"btn btn-success\"   data-toggle=\"modal\" data-target=\"#penID\" >Late Loan Charges</button>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"clearfix\"> </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-4 col-md-offset-1 \" style=\"margin-bottom: 15px\">\n");
      out.write("                <div class=\"content-top-1 offset-1\">\n");
      out.write("                    <div class=\"col-md-6 top-content\">\n");
      out.write("                        <h5>Loan charges</h5>\n");
      out.write("                        <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.totalaons}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-6 top-content1\">\t   \n");
      out.write("                        <button class=\"btn btn-success\"   data-toggle=\"modal\" data-target=\"#loanCid\" >Loan interest</button>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"clearfix\"> </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!--Add charges modals-->\n");
      out.write("        <div class=\"modal fade\" id=\"loanCid\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"exampleModalCenterTitle\" style=\"font-size:20px\">\n");
      out.write("                            <span class=\"fa fa-money\"></span>\n");
      out.write("                            Modify Loan Interest\n");
      out.write("                        </h5>\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                            <span aria-hidden=\"true\" style=\"font-style: inherit;font-family: fantasy\">&times;</span>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <form id=\"deleteForm\" action=\"charges\" method=\"post\">\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <!--Have the contents here-->\n");
      out.write("\n");
      out.write("                            <div class=\"input-group input-icon right\">\n");
      out.write("                                <span class=\"input-group-addon\">\n");
      out.write("                                    <i class=\"fa fa-percent\"></i>\n");
      out.write("                                </span>\n");
      out.write("                                <label for=\"loanintrest\"><span></span></label>\n");
      out.write("                                <select id='interest'>Interest Rate</select>\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <input type=\"hidden\" name=\"dUnique\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.adminUnique}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"  />\n");
      out.write("                            <input type=\"text\" name=\"idnumber\" value=\"\" hidden=\"true\"/>\n");
      out.write("                            <input type=\"text\" value=\"delete\" hidden=\"true\" name=\"action\"/>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("\n");
      out.write("                            <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-danger\" value=\"\">Delete</button>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"modal fade\" id=\"penID\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"exampleModalCenterTitle\" style=\"font-size:20px\">\n");
      out.write("                            <span class=\"fa fa-bitbucket\" style=\"color: red\"></span>\n");
      out.write("                            Delete Member\n");
      out.write("                        </h5>\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                            <span aria-hidden=\"true\" style=\"font-style: inherit;font-family: fantasy\">&times;</span>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <form id=\"deleteForm\" action=\"MemberController\" method=\"post\">\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <!--Have the contents here-->\n");
      out.write("\n");
      out.write("                            <p>Are you sure you want to <strong style=\"color:  red\">delete </strong>the  member?</p>\n");
      out.write("\n");
      out.write("                            <input type=\"hidden\" name=\"dUnique\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.adminUnique}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"  />\n");
      out.write("                            <input type=\"text\" name=\"idnumber\" value=\"\" hidden=\"true\"/>\n");
      out.write("                            <input type=\"text\" value=\"delete\" hidden=\"true\" name=\"action\"/>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("\n");
      out.write("                            <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-danger\" value=\"\">Delete</button>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("                            <script>\n");
      out.write("                                var select = '';\n");
      out.write("                                for(i=1;i <=100;i++){\n");
      out.write("                                    select +='<option val='+ i +'>'+ i + '</option>'; \n");
      out.write("                                }\n");
      out.write("                                $('#interest').html(select);\n");
      out.write("                     \n");
      out.write("                                \n");
      out.write("                            </script>\n");
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
}
