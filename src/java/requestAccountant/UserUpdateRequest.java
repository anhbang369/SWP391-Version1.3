/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requestAccountant;

/**
 *
 * @author 84348
 */
public class UserUpdateRequest {
    public String receiptID;
    public String productID;
    public String solution;

    public UserUpdateRequest() {
    }

    public UserUpdateRequest(String receiptID, String productID, String solution) {
        this.receiptID = receiptID;
        this.productID = productID;
        this.solution = solution;
    }

    public String getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
    
}
