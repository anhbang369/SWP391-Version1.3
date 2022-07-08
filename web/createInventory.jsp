<%-- 
    Document   : createInventory
    Created on : Jun 21, 2022, 10:38:35 PM
    Author     : 84348
--%>

<%@page import="inventoryAccountant.UserInventoryVirtual"%>
<%@page import="virtual.ListInventory"%>
<%@page import="user.UserProduct"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/backNoWork.js" type="text/javascript" ></script>
        <title>Create Inventory Page</title>
    </head>
    <body>

        <form action="MainController">
            <input type="text" name="ProductID" placeholder="ProductID">
            <input type="text" name="Name" placeholder="Name">
            <input type="text" name="Brand" placeholder="Brand">
            <input type="text" name="Model" placeholder="Model">
            <input type="submit" name="action" value="ShowProductReprot">
        </form>
        
        <%
    String errorSearch = (String) request.getAttribute("ERROR_SEARCH");
    if (errorSearch == null) {
        errorSearch = "";
    }
%>
<h2><%=errorSearch%></h2>


        <%
            List<UserProduct> product = (List<UserProduct>) request.getAttribute("LIST_PRODUCT_REPORT");
            if (product != null) {
                if (product.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>ProductID</th>
                    <th>Name</th>
                    <th>Brand</th>
                    <th>Model</th>
                    <th>quality</th>
                    <th>quantityInChecking</th>
                    <th>note</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (UserProduct rc : product) {
                %>
            <form action="MainController">
                <tr>
                    <td>
                        <input type="text" name="productID" value="<%=rc.getProductID()%>"/>
                    </td>
                    <td>
                        <input type="text" name="name" value="<%=rc.getName()%>"/>
                    </td>
                    <td>
                        <input type="text" name="brand" value="<%=rc.getBrand()%>"/>
                    </td>
                    <td>
                        <input type="text" name="model" value="<%=rc.getModel()%>"/>
                    </td>
                    <td>
                        <input type="number" name="quality" required="" min="1"/>
                    </td>
                    <td>
                        <input type="number" name="quantityInChecking" required="" min="1"/>
                    </td>
                    <td>
                        <input type="text" name="note" required=""/>
                    </td>
                    <td>
                        <input type="submit" name="action" value="AddVirtualInventory"/>
                    </td>
                </tr>
            </form>
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
    String errorCheck = (String) request.getAttribute("ERROR_CHECK");
    if (errorCheck == null) {
        errorCheck = "";
    }
%>
<h2><%=errorCheck%></h2>


    <h3>Product Will Add Detail</h3>

    <%
        ListInventory rd = (ListInventory) session.getAttribute("LIST_INVEN_VIRTUAL");
        if (rd != null) {
            if (rd.getListInventory().size() > 0) {
    %>
    <table border="1">
        <thead>
            <tr>
                <th>No</th>
                <th>productID</th>
                <th>quality</th>
                <th>quantityInChecking</th>
                <th>note</th>
            </tr>
        </thead>
        <tbody>
            <%
                int count = 1;
                for (UserInventoryVirtual tm : rd.getListInventory().values()) {
            %>
        <form action="MainController">
            <tr>
                <td>
                    <input type="text" name="" value="<%= count++%>" readonly=""/>
                </td>
                <td>
                    <input type="text" name="productID" value="<%= tm.getProductID()%>" readonly=""/>
                </td>
                <td>
                    <input type="text" name="quality" value="<%= tm.getQuality()%>" required="" min="1"/>
                </td>
                <td>
                    <input type="text" name="quantityInChecking" value="<%= tm.getQuantityInChecking()%>" required="" min="1"/>
                </td>
                <td>
                    <input type="text" name="note" value="<%= tm.getNote()%>" required=""/>
                </td>
                <td>
                    <input type="submit" name="action" value="UpdateInventoryVirtua" readonly=""/>
                </td>
                <td>
                    <input type="submit" name="action" value="RemoveInventoryVirtual" readonly=""/>
                </td>
            </tr>
        </form>
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


<form action="MainController">
    <input type="submit" name="action" value="Complete">
</form>


<%
    String errorAdd = (String) request.getAttribute("ERROR_ADD");
    if (errorAdd == null) {
        errorAdd = "";
    }
%>
<h2><%=errorAdd%></h2>


<form action="MainController">
    <input type="submit" name="action" value="BackInventory">
</form>


</body>
</html>
