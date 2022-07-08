<%-- 
    Document   : inventory
    Created on : Jun 17, 2022, 4:57:06 PM
    Author     : 84348
--%>

<%@page import="inventoryAccountant.UserInventory"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="stylesheet" href="css/styles.css">
        <script src="js/mycode.js"></script>
        <title>Inventory Page</title>
    </head>
    <body>
        <a href="MainController?action=ShowRequest&showRequest=&howRequest=">Request</a>
        <a href="MainController?action=SeacrhReceipt&search=">Receipt</a>
        <a href="MainController?action=SeacrhOrder&OrderI=&CustomerNam=&Addres=&PhoneNumbe=">Issue</a>
        <a href="report.jsp">Report</a>
        <a href="MainController?action=SearchInventoryF&searchInventoryF=">Inventory Report</a>
        <a href="createInventory.jsp">Create Inventory</a>

        <form action="MainController">
            <input type="text" name="productID" placeholder="ProductID"/>
            <input type="text" name="name" placeholder="Product Name" />
            <input type="submit" name="action" value="SearchInventoryAlpha"/>
        </form>


        <form action="">

            <i class="fa-solid fa-filter" onclick="ShowDateReceipt()"></i>

        </form>
        <div class="show_date_receipt" id="showDateReceipt">
            <form action="MainController">
                Search<input type="date" name="searchInventory"/>
                To<input type="date" name="searchInventoryM" />
                <input type="submit" name="action" value="SearchInventory"/>
            </form>
        </div>

        <%
            List<UserInventory> inventory = (List<UserInventory>) request.getAttribute("LIST_INVENTORY");
            if (inventory != null) {
                if (inventory.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>productID</th>
                    <th>Name</th>
                    <th>checkingDate</th>
                    <th>quantityInChecking</th>
                    <th>Quantity</th>
                    <th>quality</th>
                    <th>Deviant</th>
                    <th>note</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (UserInventory rc : inventory) {
                %>
                <tr>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getProductID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="name" value="<%= rc.getName()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getCheckingDate()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getQuantityInChecking()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getQuantity()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getQuality()%>" readonly=""/>
                    </td>
                    <%
                    float a = (float)(rc.getQuantity()-rc.getQuantityInChecking())/rc.getQuantity();
                    %>
                    <td>
                        <input type="text" name="productID" value="<%= a*100 %>%" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getNote()%>" readonly=""/>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>

        </table>
        <%
                }
            }
        %>

        <%
            String error = (String) request.getAttribute("ERROR");
            if (error == null) {
                error = "";
            }
        %>
        <h2><%=error%></h2>
    </body>
</html>
