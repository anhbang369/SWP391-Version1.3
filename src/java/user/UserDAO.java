/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

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
public class UserDAO {

    private static final String LOGIN = "SELECT name,role,status,phoneNumber FROM Account WHERE accountID=? AND password=?"; 
    private static final String SHOW_PRODUCT = "SELECT productID,model,brand,status,type,width,depth,height,screenSize,voiceRemote,bluetooth,manufacturingDate,madeIn,quantity,name FROM Product WHERE productID like ? ";
    private static final String SHOW_PRODUCT_NOTIFY = "SELECT p.name FROM Product AS p, Inventory AS i WHERE p.quantity>=i.quantityOnHand AND p.productID=i.productID";
    private static final String SHOW_PRODUCT_PRO = "SELECT productID,model,brand,status,type,width,depth,height,screenSize,voiceRemote,bluetooth,manufacturingDate,madeIn,quantity,name FROM Product WHERE productID like ? AND name like ? AND brand like ? AND model like ?";

    public UserDTO checkLogin(String accountID, String password) throws SQLException {
        UserDTO user = null;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(LOGIN);
                ptm.setString(1, accountID);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    String role = rs.getString("role");
                    String status = rs.getString("status");
                    String phoneNumber = rs.getString("phoneNumber");
                    user = new UserDTO(accountID, password, name, role, status, phoneNumber);

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
        return user;
    }

    

    

    public List<UserProduct> getListShowProduct(String search) throws SQLException {
        List<UserProduct> listProduct = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(SHOW_PRODUCT);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String model = rs.getString("model");
                    String brand = rs.getString("brand");
                    String status = rs.getString("status");
                    String type = rs.getString("type");
                    float width = Float.parseFloat(rs.getString("width"));
                    float depth = Float.parseFloat(rs.getString("depth"));
                    float height = Float.parseFloat(rs.getString("height"));
                    float screenSize = Float.parseFloat(rs.getString("screenSize"));
                    String voiceRemote = rs.getString("voiceRemote");
                    String bluetooth = rs.getString("bluetooth");
                    int manufacturingDate = Integer.parseInt(rs.getString("manufacturingDate"));
                    String madeIn = rs.getString("madeIn");
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String name = rs.getString("name");
                    listProduct.add(new UserProduct(productID, name, model, brand, status, type, width, depth, height, screenSize, voiceRemote, bluetooth, manufacturingDate, madeIn, quantity));

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
        return listProduct;
    }
    
    
    public List<UserNotify> getListNotify() throws SQLException {
        List<UserNotify> listProduct = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(SHOW_PRODUCT_NOTIFY);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    listProduct.add(new UserNotify(name));
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
        return listProduct;
    }
    
    
    
    public List<UserProduct> getListShowPro(String search,String search1,String search2,String search3) throws SQLException {
        List<UserProduct> listProduct = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(SHOW_PRODUCT_PRO);
                ptm.setString(1, "%" + search + "%");
                ptm.setString(2, "%" + search1 + "%");
                ptm.setString(3, "%" + search2 + "%");
                ptm.setString(4, "%" + search3 + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String model = rs.getString("model");
                    String brand = rs.getString("brand");
                    String status = rs.getString("status");
                    String type = rs.getString("type");
                    float width = Float.parseFloat(rs.getString("width"));
                    float depth = Float.parseFloat(rs.getString("depth"));
                    float height = Float.parseFloat(rs.getString("height"));
                    float screenSize = Float.parseFloat(rs.getString("screenSize"));
                    String voiceRemote = rs.getString("voiceRemote");
                    String bluetooth = rs.getString("bluetooth");
                    int manufacturingDate = Integer.parseInt(rs.getString("manufacturingDate"));
                    String madeIn = rs.getString("madeIn");
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String name = rs.getString("name");
                    listProduct.add(new UserProduct(productID, name, model, brand, status, type, width, depth, height, screenSize, voiceRemote, bluetooth, manufacturingDate, madeIn, quantity));

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
        return listProduct;
    }
    

}
