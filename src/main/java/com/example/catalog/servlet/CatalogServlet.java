package com.example.catalog.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "catalogServlet", value = "/catalogServlet")
public class CatalogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String catalogName = request.getParameter("name");
        String catalogDescription = request.getParameter("description");
        Long catalogId = Long.valueOf(request.getParameter("id"));

        Catalog.addItem(new CatalogItem(catalogName, catalogDescription, catalogId));

        response.setHeader("someHeader", "someHeaderValue");
        response.addCookie(new Cookie("someCookies", "someCookiesValue"));

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head></head>");
        out.println("<body>");
        out.println("<table>");
        for(CatalogItem item:Catalog.getItems()) {
            out.println("<tr>");
            out.println("<td>");
            out.print(item.getName());
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");    }
}
