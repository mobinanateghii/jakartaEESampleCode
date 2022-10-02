package com.example.catalog.jsp;

import com.example.catalog.servlet.Catalog;
import com.example.catalog.servlet.CatalogItem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "catalogJSPServlet", value = "/catalogJSPServlet")
public class CatalogJSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String catalogName = request.getParameter("name");
        String catalogDescription = request.getParameter("description");
        String catalogId = request.getParameter("id");

        Catalog.addItem(new CatalogItem(catalogName, catalogDescription, catalogId));

        response.setHeader("someHeader", "someHeaderValue");
        response.addCookie(new Cookie("someCookies", "someCookiesValue"));

        request.setAttribute("message", "sampleName");
        RequestDispatcher dispatcher = request.getRequestDispatcher("categoryList.jsp");
        dispatcher.forward(request, response);

    }
}
