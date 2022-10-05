package com.example.catalog.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "catalogServletAsync", value = "/catalogServletAsync", asyncSupported = true)
public class CatalogServletAsync extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AsyncContext asyncContext = request.getAsyncContext();
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println("response returned by:" + Thread.currentThread().getName());
                    getResponse(request, response);
                    asyncContext.complete();
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("initialized response returned by:" + Thread.currentThread().getName());
    }

    protected void getResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        for (CatalogItem item : Catalog.getItems()) {
            out.println("<tr>");
            out.println("<td>");
            out.print(item.getName());
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
