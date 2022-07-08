<%-- 
    Document   : Account
    Created on : Jun 16, 2022, 4:25:07 PM
    Author     : 84348
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
        <input type="submit" name="action" value="Logout">
        <a href="MainController?action=ShowRequest&showRequest=&howRequest=">Request</a>
        <a href="MainController?action=SeacrhReceipt&search=">Receipt</a>
        <a href="MainController?action=SeacrhOrder&OrderI=&CustomerNam=&Addres=&PhoneNumbe=">Issue</a>
        <a href="report.jsp">Report</a>
        <a href="MainController?action=SearchInventoryF&searchInventoryF=">Inventory Report</a>
    </body>
</html>
