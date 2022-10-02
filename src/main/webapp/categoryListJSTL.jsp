<%--
  Created by IntelliJ IDEA.
  User: mobina
  Date: 9/30/2022
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>H+ Sports</title>
    <style type="text/css">
        body {
            font-family: Verdana, Arial, Helvetica, sans-serif;
            font-size: 14px;
        }

        .header {
            font-family: Verdana, Arial, Helvetica, sans-serif;
            font-size: 18px;
        }

        .bottom {
            font-family: Verdana, Arial, Helvetica, sans-serif;
            font-size: 9px;
            text-align: center;
            vertical-align: middle;
            color: #8E969D;
        }
    </style>
    <link type="text/css" rel="stylesheet" href="resources/css/global.css"/>
</head>
<body>
<table style="border: 1px solid #CAD6E0" align="center" cellpadding="0"
       cellspacing="0" border="0" width="400">
    <tbody>
    <tr>
        <td class="header" height="42" align="center" valign="middle"
            width="100%" bgcolor="#E4EBEB">Entry Form List | Catalog
        </td>
    </tr>
    <tr>
        <td height="1" width="100%" bgcolor="#CAD6E0"></td>
    </tr>
    <tr>
        <td><img src="resources/img/banner.jpeg"/></td>
    </tr>
    <tr>
        <td width="100%" colspan="2">
            <p> pageContextPath is: ${pageContext.request.contextPath}<br/></p>
            <p> param.name is: ${param.name}<br/></p>
            <p> cookie.someCookies is: ${cookie.someCookies.value}<br/></p>
            <p> catalog Item count is: ${catalogItem.size() * 2 }<br/></p>
            <table width="100%" style="height: 150px" align="left"
                   cellpadding="0" cellspacing="0" border="0">
                <tbody>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>description</th>
                </tr>
                <c:forEach items="${catalogItem}" var="item">
                    <tr>
                        <td align="center" width="100%" valign="middle">
                            <c:out value="${item.id}"/>
                        </td>
                        <td align="center" width="100%" valign="middle">
                            <c:out value="${item.name}"/>
                        </td>
                        <td align="center" width="100%" valign="middle">
                            <c:out value="${item.description}"/>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </td>
    </tr>

    <tr>
        <td colspan="2" valign="bottom" height="1" width="100%"
            bgcolor="#CAD6E0"></td>
    </tr>
    </tbody>
</table>
</body>
</html>
