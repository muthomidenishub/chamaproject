package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class repayloan_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"banner\">\n");
      out.write("    <h2>\n");
      out.write("        <a href=\"DashBoardIndex.html\">Home</a>\n");
      out.write("        <i class=\"fa fa-angle-right\"></i>\n");
      out.write("        <span>Repay Member Loans </span>\n");
      out.write("    </h2>\n");
      out.write("</div>\n");
      out.write("<div class=\"grid-system\">\n");
      out.write("    <div class=\"horz-grid\">\n");
      out.write("        <div class=\"grid-hor\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <p class=\"\"><strong>Repay Loans</strong> </p>\n");
      out.write("            <hr style=\"width: 100px\">\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <table class=\" table table-striped\">\n");
      out.write("\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th scope=\"col\">#Loan ID</th>\n");
      out.write("                    <th scope=\"col\">First Name</th>\n");
      out.write("                    <th scope=\"col\">Last Name </th>\n");
      out.write("                    <th scope=\"col\">Amount Issued</th>\n");
      out.write("                    <th scope=\"col\">Last Date Paid</th>\n");
      out.write("                    <th scope=\"col\">Action</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("        <div class=\"modal fade\" id=\"modify\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"deleteMod\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog modal-dialog modal-lg\" role=\"document\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"exampleModalCenterTitle\" style=\"font-size: 20px\">\n");
      out.write("                            <span class=\"fa fa-pencil-square-o\" style=\"color: green\"></span>\n");
      out.write("                            Approve Loan \n");
      out.write("                        </h5>\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                            <span aria-hidden=\"true\" style=\"font-style: inherit;font-family: fantasy\">&times;</span>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <form id=\"modForm\" action=\"repayLoan\" method=\"post\">\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <div class=\"grid-system\">\n");
      out.write("                                <div class=\"horz-grid\" style=\"margin-top: -20px\">\n");
      out.write("                                    <div class=\"grid-hor\">\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-sm-3 col-md-offset-2\">\n");
      out.write("                                                <p>Loan ID::</p>\n");
      out.write("                                                <p id=\"loanid\"></p>\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-sm-3 col-md-offset-2\">\n");
      out.write("                                                <p>Debtor Name:</p>\n");
      out.write("                                                <p id=\"loaneename\"></p>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-sm-3 col-md-offset-2\">\n");
      out.write("                                                <p>Last Repaid Date:</p>\n");
      out.write("                                                <p id=\"repaydate\"></p>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-sm-3 col-md-offset-2\">\n");
      out.write("                                                <p>Outstanding amount:</p>\n");
      out.write("                                                <p id=\"outStanding\"></p>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-sm-3 col-md-offset-2\">\n");
      out.write("                                                <p>Remaining Days to repay:</p>\n");
      out.write("                                                <p id=\"repayDays\"></p>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-sm-3 col-md-offset-2\">\n");
      out.write("                                                <p>Charges Accumulated:</p>\n");
      out.write("                                                <p id=\"pen\"></p>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-sm-3 col-md-offset-2\">\n");
      out.write("                                                <p>Total Amount Expected:</p>\n");
      out.write("                                                <p id=\"totalLoan\"></p>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-sm-3 col-md-offset-2\">\n");
      out.write("                                                 <p>Repaid Amount</p>\n");
      out.write("                                                <div class=\"input-group input-icon right\">\n");
      out.write("                                                    <span class=\"input-group-addon\">\n");
      out.write("                                                        <i class=\"fa fa-envelope\"></i>\n");
      out.write("                                                    </span>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control1\" placeholder=\"0.00\" name=\"amountpaid\" required >\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    <div class=\"container\">\n");
      out.write("\n");
      out.write("                                        <div class=\"col-sm-3 col-md-offset\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                  \n");
      out.write("                                    <input type=\"hidden\" value=\"\" name=\"loanid\">\n");
      out.write("                                    <input type=\"hidden\" value=\"\" name=\"amountExpected\">\n");
      out.write("                                    <input type=\"hidden\" value=\"\" name=\"amountLoaned\">\n");
      out.write("                                    <input type=\"hidden\" value=\"\" name=\"supid\">\n");
      out.write("                                      <input type=\"hidden\" value=\"\" name=\"national\">\n");
      out.write("                                   \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("\n");
      out.write("                            <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                            <button type=\"reset\" class=\"btn btn-default\" value=\"\">Reset</button>\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-success\" value=\"\">Save</button>\n");
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
      out.write("\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    $('#modify').on('show.bs.modal', function (event) {\n");
      out.write("        var button = $(event.relatedTarget); // Button that triggered the modal\n");
      out.write("        var idNumber = button.data('todo').national;\n");
      out.write("        var firstname = button.data('todo').fname;\n");
      out.write("        var lastname = button.data('todo').lname;\n");
      out.write("        var loanedid = button.data('todo').accountnum;\n");
      out.write("        var loanedamount = button.data('todo').loanedamount;\n");
      out.write("        var outstandingAmount = button.data('todo').outstandingAmount;\n");
      out.write("        var dateRepay = button.data('todo').lastDatePaid;\n");
      out.write("        var supid = button.data('todo').supid;\n");
      out.write("       \n");
      out.write("        var penalty = button.data('todo').penCharges;\n");
      out.write("        var daysToPen = button.data('todo').daysToPen;\n");
      out.write("        var totalLoanAndCharge  = +penalty + +outstandingAmount;\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        $('#modForm').find('[name=\"national\"]').val(idNumber);\n");
      out.write("\n");
      out.write("        $('#modForm').find('[name=\"supid\"]').val(supid);\n");
      out.write("     \n");
      out.write("        $('#modForm').find('[name=\"loanid\"]').val(loanedid);\n");
      out.write("        $('#modForm').find('[name=\"amountLoaned\"]').val(loanedamount);\n");
      out.write("        $('#modForm').find('[name=\"amountExpected\"]').val(totalLoanAndCharge);\n");
      out.write("       \n");
      out.write("        \n");
      out.write("\n");
      out.write("\n");
      out.write("        $(\"#loanid\").append(loanedid);\n");
      out.write("        $(\"#loanamount\").append(loanedamount);\n");
      out.write("        $(\"#outStanding\").append(outstandingAmount);\n");
      out.write("        $(\"#pen\").append(penalty);\n");
      out.write("        $(\"#loaneename\").append(firstname + \"-\" + lastname);\n");
      out.write("        $(\"#repaydate\").append(dateRepay);\n");
      out.write("        $(\"#repayDays\").append(daysToPen);\n");
      out.write("        $(\"#totalLoan\").append(totalLoanAndCharge);\n");
      out.write("    });\n");
      out.write("\n");
      out.write("\n");
      out.write("    $('#modify').on('hidden.bs.modal', function () {\n");
      out.write("        $('#loanamount').empty();\n");
      out.write("        $('#loaneename').empty();\n");
      out.write("        $('#repaydate').empty();\n");
      out.write("        $('#loanid').empty();\n");
      out.write("        $('#totalLoan').empty();\n");
      out.write("        $('#repayDays').empty();\n");
      out.write("        $('#pen').empty();\n");
      out.write("        $('#outStanding').empty();\n");
      out.write("        console.log(\"modal closed and content cleared\");\n");
      out.write("    });\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ ! empty sessionScope.allow  ||  ! empty sessionScope.loanRepayMessageID}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\n");
        out.write("            <div class=\"col-sm-4 col-md-offset-1\" style=\"margin-top: -40px\">\n");
        out.write("\n");
        out.write("                <div class=\"form-group has-error\">\n");
        out.write("                    <!--IF loan exists check or ID is wrong-->\n");
        out.write("\n");
        out.write("                    <label class=\" control-label\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.loanRepayMessageID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</label>\n");
        out.write("                    <label class=\" control-label\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.loannotexist}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</label>\n");
        out.write("\n");
        out.write("\n");
        out.write("                </div>\n");
        out.write("\n");
        out.write("\n");
        out.write("            </div>\n");
        out.write("            <form action=\"repayLoan\" method=\"get\">\n");
        out.write("                <div class=\"container\">\n");
        out.write("                    <div class=\"col-sm-4 col-md-offset-8\" style=\"margin-top: -40px\">\n");
        out.write("                        <div class=\"input-group input-icon right\">\n");
        out.write("                            <span class=\"input-group-addon\">\n");
        out.write("                                <i class=\"fa fa-search-plus\"></i>\n");
        out.write("                            </span>\n");
        out.write("                            <input type=\"text\" class=\"form-control1\" placeholder=\"Member ID\" name=\"idnumber\" >\n");
        out.write("                            <input type=\"hidden\"  name=\"uniqueT\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.adminUnique}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                        </div>\n");
        out.write("                        <button type=\"submit\" class=\"form-control1\" id=\"search\"\n");
        out.write("                                style=\"width: 150px;position: relative;left: 200px\"> Search\n");
        out.write("                        </button>\n");
        out.write("\n");
        out.write("\n");
        out.write("                    </div>\n");
        out.write("\n");
        out.write("                </div>\n");
        out.write("            </form>\n");
        out.write("\n");
        out.write("        ");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.loanDetails}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("name");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    <tr>\n");
          out.write("                        <td scope=\"row\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${name.loanid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${name.firstName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${name.secondName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.loanedAmount}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${name.dateRepaid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("\n");
          out.write("                        <td>\n");
          out.write("\n");
          out.write("                            <button type=\"button\" id=\"mod\" class=\"btn btn-success btn-md \"   data-toggle=\"modal\" data-target=\"#modify\" \n");
          out.write("\n");
          out.write("                                    data-todo='{\"fname\":\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${name.firstName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\",\"lname\":\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${name.secondName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\",\"accountnum\":\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${name.loanid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\",\"national\":\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${name.memberidNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\",\"supid\":\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.adminUnique}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\",\n");
          out.write("                                    \"lastDatePaid\":\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${name.dateRepaid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\",\"penCharges\":\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.interestCharged}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\",\"daysToPen\":\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.daysToPenalty}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\", \"outstandingAmount\":\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.amountToBeRapaid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\",\n");
          out.write("                                    \"loanedamount\":\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.loanedAmount}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"}' ><span class=\"fa fa-eye\" ></span>View Loan</button>\n");
          out.write("\n");
          out.write("\n");
          out.write("\n");
          out.write("\n");
          out.write("\n");
          out.write("\n");
          out.write("\n");
          out.write("                        </td>\n");
          out.write("\n");
          out.write("                    </tr>\n");
          out.write("\n");
          out.write("                    <!--Create modify modal-->\n");
          out.write("\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
