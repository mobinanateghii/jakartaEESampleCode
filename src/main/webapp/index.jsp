<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - index</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            margin: auto;
            width: 70%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }

        #logo {
            width: 30%;
            text-align: center;
            margin: auto;
            display: block;
        }
    </style>
</head>
<body>
<img src="resources/img/jakartaEE.png" id="logo"/>
<table>
    <tr>
        <th>Topic</th>
        <th>description</th>
    </tr>
    <tr>
        <td><a href="categoryForm.html">categoryForm.html</a>
        </td>
        <td> when we use categoryForm we navigate to html form and then catalog servlet that actually is a java class give response whit html tag
        </td>
    </tr>
    <tr>
        <td><a href="categoryJSPForm.html">categoryJSPForm.html</a></td>
        <td><p>
            but when we use categoryJSPForm first step we navigate to html form and then CatalogJSPServlet but here in CatalogJSPServlet we have java class for processed data and then pasting jsp file(categoryList.jsp).
            jsp file is like ftl. in this file we can show param that send via java class(we can use java code inside jsp file but is better to dont do this)
        </p></td>
    </tr>
    <tr>
        <td><a href="categoryJSTLForm.html">categoryJSTLForm.html</a></td>
        <td><p>
            here we use jstl for having login in jsp file.
            actually JSTL has support for common, structural tasks such as iteration and conditionals, tags for manipulating XML documents, internationalization tags, and SQL;
        </p></td>
    </tr>
    <tr>
        <td><a href="JSF_includes/categoryFormJSF.xhtml">categoryFormJSF.html</a></td>
        <td><p>
            like jst and JSP! we have both them here.its Based on MVC pattern.this Facelets integrated whit server side backing beans and it has Large community of JSF components
        </p></td>
    </tr>
    <tr>
        <td><a href="JSF_includes/categoryFormProJSF.xhtml">categoryFormProJSF.html</a></td>
        <td><p>
            like jst and JSP! we have both them here.its Based on MVC pattern.this Facelets integrated whit server side backing beans and it has Large community of JSF components
        </p></td>
    </tr>
</table>

</body>
</html>
