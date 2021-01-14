package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class replymessage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Send Message</title>\n");
      out.write("        <style>\n");
      out.write("            .result{\n");
      out.write("\n");
      out.write("                margin: 50px 300px;\n");
      out.write("\n");
      out.write("                box-shadow: 2px 2px 20px 2px black ;\n");
      out.write("                background-color: #11484D;\n");
      out.write("                padding: 30px 90px 30px 120px ;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            span{\n");
      out.write("                font-size: 20px;\n");
      out.write("                font-weight: bold;\n");
      out.write("                color: white;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            body {\n");
      out.write("                background-color: #246B71;\n");
      out.write("            }\n");
      out.write("            #result{\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String senderName, message, messageID;
            String receiverName = session.getAttribute("username").toString();
            String currentReceiver;
            Connection Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject", "root", "root");
            Statement stmt = (Statement) Con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM messages");

        
      out.write("\n");
      out.write("        <form action=\"sendingMessage\" method=\"POST\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Enter student username:</td>\n");
      out.write("                    <td><input type=\"text\" name=\"studentName\" placeholder=\"username\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Enter your message:</td>\n");
      out.write("                    <td><input type=\"text\" name=\"message\" placeholder=\"message\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td><input type=\"submit\" value=\"Send\"></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("        <form action=\"StudentProfile.jsp\" method=\"get\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td><input type=\"submit\" value=\"return\"></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form> \n");
      out.write("        <table border=\"2\" cellspacing=\"3\" id=\"result\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Message ID</th>\n");
      out.write("                <th>Sender</th>\n");
      out.write("                <th>Message</th>\n");
      out.write("            </tr>\n");
      out.write("            ");
                    while (rs.next()) {
                    currentReceiver = rs.getString("receiver");
                    if (currentReceiver.equals(receiverName)) {


            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    ");
                            messageID = rs.getString("messageID");
                        out.println(messageID);
                    
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");

                        senderName = rs.getString("senderName");
                        out.println(senderName);
                    
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");

                        message = rs.getString("message");
                        out.println(message);
                    
      out.write("\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            ");
}
                }
      out.write("\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("    </body>\n");
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
}
