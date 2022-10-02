package com.example.catalog.jstl;

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

@WebServlet(name = "catalogJSTLServlet", value = "/catalogJSTLServlet")
public class CatalogJSTLServlet extends HttpServlet {
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

        request.setAttribute("catalogItem", Catalog.getItems());
        RequestDispatcher dispatcher = request.getRequestDispatcher("categoryListJSTL.jsp");
        dispatcher.forward(request, response);

    }
}
