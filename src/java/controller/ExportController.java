/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import receiptAccountant.DAOReceipt;
import receiptAccountant.UserFakeList;
import time.Timer;

/**
 *
 * @author 84348
 */
@WebServlet(name = "ExportController", urlPatterns = {"/ExportController"})
public class ExportController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "Account.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            Timer t = new Timer();
            String a = t.dateFull();
            DAOReceipt dao = new DAOReceipt();
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
            XSSFCell cellH;
            XSSFCell cellJ;
            XSSFCell cellK;
            
            row = sheet.createRow(0);
            Cell cell0 = row.createCell(10);
            cell0.setCellValue("Phiếu Nhập Kho");
            
            row1 = sheet.createRow(2);
            Cell cell1 = row1.createCell(0);
            cell1.setCellValue("inputDate");
            Cell cell2 = row1.createCell(2);
            cell2.setCellValue("totalQuantity");
            Cell cell3 = row1.createCell(4);
            cell3.setCellValue("note");
            Cell cell4 = row1.createCell(6);
            cell4.setCellValue("accountantID");
            Cell cell5 = row1.createCell(8);
            cell5.setCellValue("stockKeeperID");
            Cell cell6 = row1.createCell(10);
            cell6.setCellValue("receiptDetailID");
            Cell cell7 = row1.createCell(12);
            cell7.setCellValue("quantityInBill");
            Cell cell8 = row1.createCell(14);
            cell8.setCellValue("quantityInShipping");
            Cell cell9 = row1.createCell(17);
            cell9.setCellValue("productID");
            Cell cell10 = row1.createCell(19);
            cell10.setCellValue("solution");
            int receipt = dao.getReceiptID();
            List<UserFakeList> list = dao.getListReceiptFull(receipt);
            if(list !=null){
                if(list.size()>0){
                    for (int i = 0; i < list.size(); i++) {
                        row2 = sheet.createRow((short) i+3);
                        cellA = row2.createCell((short) 0);
                        cellA.setCellValue(list.get(i).getInputDate());
                        cellB = row2.createCell((short) 2);
                        cellB.setCellValue(list.get(i).getTotalQuantity());
                        cellC = row2.createCell((short) 4);
                        cellC.setCellValue(list.get(i).getNote());
                        cellD = row2.createCell((short) 6);
                        cellD.setCellValue(list.get(i).getAccountantID());
                        cellE = row2.createCell((short) 8);
                        cellE.setCellValue(list.get(i).getStockKeeperID());
                        cellF = row2.createCell((short) 10);
                        cellF.setCellValue(list.get(i).getReceiptDetailID());
                        cellG = row2.createCell((short) 12);
                        cellG.setCellValue(list.get(i).getQuantityInBill());
                        cellH = row2.createCell((short) 14);
                        cellH.setCellValue(list.get(i).getQuantityInShipping());
                        cellJ = row2.createCell((short) 17);
                        cellJ.setCellValue(list.get(i).getProductID());
                        cellK = row2.createCell((short) 19);
                        cellK.setCellValue(list.get(i).getSolution());
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
