<%-- 
    Document   : createSuccessInventory
    Created on : Jul 7, 2022, 11:41:37 AM
    Author     : 84348
--%>

<%@page import="java.util.List"%>
<%@page import="inventoryAccountant.UserInventoryFull"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Success Inventory Page</title>
    </head>
    <body>
        <a href="MainController?action=ShowRequest&showRequest=&howRequest=">Request</a>
        <a href="MainController?action=SeacrhReceipt&search=">Receipt</a>
        <a href="MainController?action=SeacrhOrder&OrderI=&CustomerNam=&Addres=&PhoneNumbe=">Issue</a>
        <a href="report.jsp">Report</a>
        <a href="MainController?action=SearchInventoryF&searchInventoryF=">Inventory Report</a>

        <form action="MainController">
            <%
                List<UserInventoryFull> list = (List<UserInventoryFull>) request.getAttribute("LIST_DETAIL_RECEIPT");
                if (list != null) {
                    if (list.size() > 0) {

            %>

            <table border="1">
                <thead>
                    <tr>
                        <th>reportDetailID</th>
                        <th>reportID</th>
                        <th>productID</th>
                        <th>quality</th>
                        <th>quantityInChecking</th>
                        <th>quantity</th>
                        <th>Note</th>
                    </tr>
                </thead>
                <tbody>
                    <%                    for (UserInventoryFull elem : list) {


                    %>
                    ReportID: <%=elem.getReportID()%></br>
                    Checking Data: <%=elem.getCheckingDate()%></br>
                    <%
                            break;
                        }
                    %>

                    <%
                        for (UserInventoryFull rc : list) {

                    %>

                    <tr>
                        <td>
                            <input type="text" name="reportDetailID" value="<%= rc.getReportDetailID()%>" readonly=""/>
                        </td>
                        <td>
                            <input type="text" name="reportID" value="<%= rc.getReportID()%>" readonly=""/>
                        </td>
                        <td>
                            <input type="text" name="productID" value="<%= rc.getProductID()%>" readonly=""/>
                        </td>
                        <td>
                            <input type="text" name="quality" value="<%= rc.getQuality()%>" readonly=""/>
                        </td>
                        <td>
                            <input type="number" name="quantityInChecking" value="<%= rc.getQuantityInChecking()%>" readonly=""/>
                        </td>
                        <td>
                            <input type="number" name="quantity" value="<%= rc.getQuantity()%>" readonly=""/>
                        </td>
                        <td>
                            <input type="text" name="note" value="<%= rc.getNote()%>"readonly=""/>
                        </td>
                </tr>   

                </tbody>
                <%

                    }
                %>
            </table>



            <%
                    }
                }
            %>
            
            <input type="submit" name="action" value="ExportInventory">
        </form>
    </body>
</html>
