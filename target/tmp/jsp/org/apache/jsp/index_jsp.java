package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Credit Scheduler</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<form action=\"Credit\" method=\"get\">\n");
      out.write("\t<fieldset>\n");
      out.write("\t\t<h1>Credit scheduler</h1><hr />\n");
      out.write("\t\t<label>Amount: <input type=\"number\" id=\"amount\" name=\"amount\" required /> zł</label><hr />\n");
      out.write("\t\t<label>Instalment quantity: \n");
      out.write("\t\t<select name=\"instalmentQuantity\">\n");
      out.write("\t\t\t<option value=\"6\">6</option>\n");
      out.write("\t\t\t<option value=\"12\">12</option>\n");
      out.write("\t\t\t<option value=\"18\">18</option>\t\t\n");
      out.write("\t\t\t<option value=\"24\">24</option>\n");
      out.write("\t\t\t<option value=\"30\">30</option>\n");
      out.write("\t\t\t<option value=\"36\">36</option>\n");
      out.write("\t\t</select><hr/>\n");
      out.write("\t\t</label>\n");
      out.write("\t\t<label>Interest rate: <input type=\"number\" id=\"interestRate\" name=\"interestRate\"\n");
      out.write("\t\tmin=\"0\" max=\"99\" required /> %<hr /></label>\n");
      out.write("\t\t<label>Constant charge: <input type=\"number\" id=\"constantCharge\" name=\"constantCharge\" required /> zł</label><hr /> \n");
      out.write("\t\t<label>Instalment type:<br />\n");
      out.write("\t\t\t<input type=\"radio\" id=\"instalmentType\" name=\"instalmentType\" value=\"constant\" required />Constant<br /> \n");
      out.write("\t\t\t<input type=\"radio\" id=\"instalmentType\" name=\"instalmentType\" value=\"decreasing\" required />Decreasing<br /> \n");
      out.write("\t\t</label>\n");
      out.write("\t\t<hr />\n");
      out.write("\t\t<input type=\"submit\" name=\"action\" value=\"Calculate\"/>\n");
      out.write("\t\t<input type=\"submit\" name=\"action\" value=\"Generate PDF\"/>\n");
      out.write("\t\t</fieldset>\n");
      out.write("\t</form>\n");
      out.write("\t<p>\n");
      out.write("\t\t<i>Credit scheduler accepts only <b>integer</b> values.</i><br />\n");
      out.write("\t</p>\n");
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
}
