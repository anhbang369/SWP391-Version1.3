/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import inventoryAccountant.DAOInventory;
import inventoryAccountant.UserInventoryFull;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import time.Timer;

/**
 *
 * @author 84348
 */
@WebServlet(name = "ExportInventoryController", urlPatterns = {"/ExportInventoryController"})
public class ExportInventoryController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "Account.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            Timer t = new Timer();
            String a = t.dateFull();
            DAOInventory dao = new DAOInventory();
            FileOutputStream file = new FileOutputStream("C:/Users/84348/Downloads/SWPNHOM/"+a+".xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("name");
            XSSFRow row;
            XSSFRow row1;
            XSSFRow row2;
            XSSFCell cellA;
            XSSFCell cellB;
            XSSFCell cellC;
            XSSFCell cellD;
            XSSFCell cellE;
            XSSFCell cellF;
            XSSFCell cellG;
            
            row = sheet.createRow(0);
            Cell cell0 = row.createCell(5);
            cell0.setCellValue("Phiếu Nhập Báo Cáo Kho");
            
            row1 = sheet.createRow(2);
            Cell cell1 = row1.createCell(0);
            cell1.setCellValue("checkingDate");
            Cell cell2 = row1.createCell(2);
            cell2.setCellValue("reportDetailID");
            Cell cell3 = row1.createCell(4);
            cell3.setCellValue("productID");
            Cell cell4 = row1.createCell(6);
            cell4.setCellValue("quality");
            Cell cell5 = row1.createCell(8);
            cell5.setCellValue("quantityInChecking");
            Cell cell6 = row1.createCell(11);
            cell6.setCellValue("quantity");
            Cell cell7 = row1.createCell(13);
            cell7.setCellValue("note");           
            int report = dao.getReportID();
            List<UserInventoryFull> list = dao.getListShowReportFull(report);
            if(list !=null){
                if(list.size()>0){
                    for (int i = 0; i < list.size(); i++) {
                        row2 = sheet.createRow((short) i+3);
                        cellA = row2.createCell((short) 0);
                        cellA.setCellValue(list.get(i).getCheckingDate());
                        cellB = row2.createCell((short) 2);
                        cellB.setCellValue(list.get(i).getReportDetailID());
                        cellC = row2.createCell((short) 4);
                        cellC.setCellValue(list.get(i).getProductID());
                        cellD = row2.createCell((short) 6);
                        cellD.setCellValue(list.get(i).getQuality());
                        cellE = row2.createCell((short) 8);
                        cellE.setCellValue(list.get(i).getQuantityInChecking());
                        cellF = row2.createCell((short) 11);
                        cellF.setCellValue(list.get(i).getQuantity());
                        cellG = row2.createCell((short) 13);
                        cellG.setCellValue(list.get(i).getNote());
                    }
                }
            }

            workbook.write(file);
            workbook.close();
            file.close();
            url = SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();;
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
