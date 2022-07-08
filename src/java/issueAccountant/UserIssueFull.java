/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package issueAccountant;

/**
 *
 * @author 84348
 */
public class UserIssueFull {
    public int issueID;
    public String note;
    public String accountantID;
    public String sellerID;
    public String DateP;
    public int orderDetailID;
    public int quantity;
    public String productID;

    public UserIssueFull() {
    }

    public UserIssueFull(int issueID, String note, String accountantID, String sellerID, String DateP, int orderDetailID, int quantity, String productID) {
        this.issueID = issueID;
        this.note = note;
        this.accountantID = accountantID;
        this.sellerID = sellerID;
        this.DateP = DateP;
        this.orderDetailID = orderDetailID;
        this.quantity = quantity;
        this.productID = productID;
    }

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAccountantID() {
        return accountantID;
    }

    public void setAccountantID(String accountantID) {
        this.accountantID = accountantID;
    }

    public String getSellerID() {
        return sellerID;
    }

    public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }

    public String getDateP() {
        return DateP;
    }

    public void setDateP(String DateP) {
        this.DateP = DateP;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }
    
    
    
}
