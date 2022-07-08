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
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import reportAccountant.UserReport;
import time.Timer;
import virtual.ListReport;

/**
 *
 * @author 84348
 */
@WebServlet(name = "ExportReportController", urlPatterns = {"/ExportReportController"})
public class ExportReportController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "Account.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            Timer t = new Timer();
            String a = t.dateFull();
            HttpSession session = request.getSession();
            FileOutputStream file = new FileOutputStream("C:/Users/84348/Downloads/SWPNHOM/" + a + ".xlsx");
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
            cell0.setCellValue("Phiếu Báo Cáo Kho");

            row1 = sheet.createRow(2);
            Cell cell1 = row1.createCell(0);
            cell1.setCellValue("ProductID");
            Cell cell2 = row1.createCell(2);
            cell2.setCellValue("Name");
            Cell cell3 = row1.createCell(4);
            cell3.setCellValue("Brand");
            Cell cell4 = row1.createCell(6);
            cell4.setCellValue("Quantity Begin");
            Cell cell5 = row1.createCell(8);
            cell5.setCellValue("Quantity End");
            Cell cell6 = row1.createCell(11);
            cell6.setCellValue("Import");
            Cell cell7 = row1.createCell(13);
            cell7.setCellValue("Export");
            ListReport list = (ListReport) session.getAttribute("LIST_REPORT");
            if (list != null) {
                if (list.getListReport().size() > 0) {
                    int i = 0;
                    for (UserReport tm : list.getListReport().values()) {
                        row2 = sheet.createRow((short) i + 3);
                        cellA = row2.createCell((short) 0);
                        cellA.setCellValue(tm.getProductID());
                        cellB = row2.createCell((short) 2);
                        cellB.setCellValue(tm.getName());
                        cellC = row2.createCell((short) 4);
                        cellC.setCellValue(tm.getBrand());
                        cellD = row2.createCell((short) 6);
                        cellD.setCellValue(tm.getQuantityBegin());
                        cellE = row2.createCell((short) 8);
                        cellE.setCellValue(tm.getQuantityEnd());
                        cellF = row2.createCell((short) 11);
                        cellF.setCellValue(tm.getImport());
                        cellG = row2.createCell((short) 13);
                        cellG.setCellValue(tm.getExport());
                        i++;
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
