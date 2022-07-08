/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requestAccountant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author 84348
 */
public class DAORequest {
    private static final String SHOW_REQUEST = "SELECT receiptID,productID,quantityInShipping,quantityInBill,solution FROM ReceiptDetail WHERE receiptID like ? AND productID like ?";
    private static final String UPDATE_REQUEST = "UPDATE ReceiptDetail SET solution=? WHERE receiptID=? AND productID=?";
    
    public List<UserRequest> getListShowRequest(String search, String searchSecond) throws SQLException {
        List<UserRequest> listRequest = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(SHOW_REQUEST);
                ptm.setString(1, "%" + search + "%");
                ptm.setString(2, "%" + searchSecond + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int quantityInBill = Integer.parseInt(rs.getString("quantityInBill"));
                    int quantityInShipping = Integer.parseInt(rs.getString("quantityInShipping"));                    
                    String productID = rs.getString("productID");
                    String solution = rs.getString("solution");
                    int receiptID = Integer.parseInt(rs.getString("receiptID"));
                    listRequest.add(new UserRequest(receiptID, quantityInBill, quantityInShipping, productID, receiptID, solution));
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listRequest;
    }
    
    public boolean updateRequest(UserUpdateRequest user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_REQUEST);
                ptm.setString(1, user.getSolution());
                ptm.setString(2, user.getReceiptID());
                ptm.setString(3, user.getProductID());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
            
        }
        return check;
    }
}
