<!--
    Redirection automatique sur la HomeServlet si url vide "/"
-->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.getRequestDispatcher("HomeServlet").forward(request, response);
%>
