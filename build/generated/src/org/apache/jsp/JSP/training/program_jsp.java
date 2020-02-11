package org.apache.jsp.JSP.training;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import module.training.model.SeanceModel;
import java.text.SimpleDateFormat;
import business.Seance;
import business.Program;
import java.util.ArrayList;

public final class program_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/JSP/training/../../Template/user/header.html");
  }

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"fr\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Page d'accueil</title>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    </head>   \r\n");
      out.write("    <body class=\"h-100\">\r\n");
      out.write("        ");
      out.write("<header>\r\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n");
      out.write("        <a class=\"navbar-brand\" href=\"#\" >\r\n");
      out.write("            <img src=\"Public/img/logo-min.png\" style=\"max-height: 2.5em; padding: 0;\"/>\r\n");
      out.write("        </a>\r\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapsibleNavbar\">\r\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("        </button>\r\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"collapsibleNavbar\">\r\n");
      out.write("            <ul class=\"navbar-nav mr-auto\">\r\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"TrainingHomeServlet\">Mes entrainnements</a></li>\r\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"PerformanceServlet\">Mes performances</a></li>\r\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"#\">Mon coach</a></li>\r\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"#\">Mon profil</a></li>               \r\n");
      out.write("            </ul>\r\n");
      out.write("            <div class=\"navbar-nav right\">            \r\n");
      out.write("                <a class=\"nav-link\" href=\"#\">Deconnection</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container mt-5\">\r\n");
      out.write("            <div class=\"jumbotron\">\r\n");
      out.write("                <h1>Mes Entraînements</h1>     \r\n");
      out.write("                    <div>\r\n");
      out.write("                        <nav>\r\n");
      out.write("                            <ul>\r\n");
      out.write("                               <li><a href='' >S'entrainer</a></li>\r\n");
      out.write("                                  <li><a href='' >Profil</a></li>\r\n");
      out.write("                                  <li><a href='' >Performance</a></li>\r\n");
      out.write("                                  <li><a href='' >Coach</a></li>\r\n");
      out.write("                           </ul>\r\n");
      out.write("                         </nav>\r\n");
      out.write("                    </div>\r\n");
      out.write("        \r\n");
      out.write("                    <p>Programme</p>\r\n");
      out.write("                    <p>ici sera la nom du programme actuel<p/>\r\n");
      out.write("                    <table class = \"table table-hover table-striped mt-3\">\r\n");
      out.write("                        <thead class=\"thead-dark\">                        \r\n");
      out.write("                            <tr><th>No.</th>\r\n");
      out.write("                                <th> Program </th>\r\n");
      out.write("                                <th> Description </th></tr>                    \r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                                ");
//Récupération de la liste avec les attributs.
                                ArrayList<Program> programs = (ArrayList<Program>) request.getAttribute("programs");
                                for (Program p : programs) {
                                     out.println("<tr>" + p.getIdP() + "</tr>");
                                     out.println("<tr>" + p.getNomP() + "</tr>");
                                     out.println("<tr>" + p.getDescriptionP()+ "</tr>");
                                     out.println("<tr>");
                                }
      out.write("\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                        \r\n");
      out.write("                    <p>ici sera l'affichage de la barre de progression</p>\r\n");
      out.write("                    ");
//Récupération de la liste avec les attributs.
                        float tauxReal = (float) request.getAttribute("tauxReal");
                        out.println("<p> Vous avez rélisé" + tauxReal + "d'exercices dans le programme ! </tr>");
                    
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                    <div>\r\n");
      out.write("                        ");
//Récupération de la liste avec les attributs.
                          ArrayList<Seance> seances = (ArrayList<Seance>) request.getAttribute("seances");
                          SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                          String date = sDateFormat.format(new java.util.Date());
                          int nbweek = SeanceModel.getWeekOfYear(date);
                          
                          for(Seance s: seances){
                              if(s.getNumSem() == nbweek){
                              out.println("<input type='button' name='buttonSeance' value="+ s.getIdS() +"/>");
                              }else{
                               out.println("<input type='button' name='buttonSeance' value="+ s.getIdS() +" disabled='disabled'/>");
                              }
                          }
                        
      out.write("\r\n");
      out.write("                        \r\n");
      out.write("                        <script type=\"text/javascript\">\r\n");
      out.write("                           function disable(){\r\n");
      out.write("                              if ((ArrayList<Seance>) request.getAttribute(\"seances\") != null){  \r\n");
      out.write("                                    document.getElementById(\"btnBeginSeance\").disabled = true;}\r\n");
      out.write("                        </script>\r\n");
      out.write("                      <input id='btnBeginSeance' type='button' onclick=\"disable()\" value='Démarrer une séance'/>                               \r\n");
      out.write("                    </div>\r\n");
      out.write("                        \r\n");
      out.write("      </div>\r\n");
      out.write("      <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("    </body> \r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
