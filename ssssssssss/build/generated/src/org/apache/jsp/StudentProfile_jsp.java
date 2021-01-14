package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class StudentProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       \n");
      out.write("        <h1><a href=\"EditProfile.jsp\"> Edit Profile</a></h1>\n");
      out.write("        <form action=\"SearchForStaffSubject\" method=\"post\">\n");
      out.write("            <button type=\"submite\">search</button>\n");
      out.write("        </form>\n");
      out.write("        <form action=\"GetStaffConact\" method=\"post\">\n");
      out.write("            <label> Enter the staff member UserNAme </label> <input type=\"text\" required name=\"staffmemberusername\">\n");
      out.write("            <button type=\"submite\"> search</button>\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            .result{\n");
      out.write("                \n");
      out.write("                margin: 50px 300px;\n");
      out.write("                \n");
      out.write("                box-shadow: 2px 2px 20px 2px black ;\n");
      out.write("                    background-color: #11484D;\n");
      out.write("                    padding: 30px 90px 30px 120px ;\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            span{\n");
      out.write("                    font-size: 20px;\n");
      out.write("                    font-weight: bold;\n");
      out.write("                    color: white;\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            body {\n");
      out.write("                 background-color: #246B71;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
