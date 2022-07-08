/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtual;

import java.util.HashMap;
import java.util.Map;
import receiptAccountant.UserReceiptVirtual;

/**
 *
 * @author 84348
 */
public class ListReceipt {
    private Map<String, UserReceiptVirtual> listReceipt;

    public ListReceipt() {
    }

    public ListReceipt(Map<String, UserReceiptVirtual> listReceipt) {
        this.listReceipt = listReceipt;
    }

    public Map<String, UserReceiptVirtual> getListReceipt() {
        return listReceipt;
    }

    public void setListReceipt(Map<String, UserReceiptVirtual> listReceipt) {
        this.listReceipt = listReceipt;
    }   
    
    public boolean add(UserReceiptVirtual tm){
        boolean check = false;
        if(this.listReceipt == null){
            this.listReceipt=new HashMap<>();
        }if(this.listReceipt.containsKey(tm.getReceiptID())){
            
        }
        listReceipt.put((String)tm.getReceiptID(), tm);
        check=true;
        return check;
    }
    
    public boolean remove(String ReceiptID){
        boolean check = false;
        if(this.listReceipt!=null){
            if(this.listReceipt.containsKey(ReceiptID)){
                this.listReceipt.remove(ReceiptID);
            }
        }
        return check;
    }
}
