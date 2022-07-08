/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtual;

import java.util.HashMap;
import java.util.Map;
import reportAccountant.UserReport;

/*
 *
 * @author 84348
 */
public class ListReport {
    private Map<String, UserReport> listReport;

    public ListReport() {
    }

    public ListReport(Map<String, UserReport> listReport) {
        this.listReport = listReport;
    }

    public Map<String, UserReport> getListReport() {
        return listReport;
    }

    public void setListReport(Map<String, UserReport> listReport) {
        this.listReport = listReport;
    }
    
    public boolean add(UserReport tm){
        boolean check = false;
        if(this.listReport == null){
            this.listReport=new HashMap<>();
        }if(this.listReport.containsKey(tm.getProductID())){
            
        }
        listReport.put(tm.getProductID(), tm);
        check=true;
        return check;
    }
}
