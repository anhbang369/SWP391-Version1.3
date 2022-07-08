/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import receiptAccountant.DAOReceipt;
import receiptAccountant.UserReceiptVirtual;
import time.Timer;
import user.UserDTO;
import virtual.ListReceipt;

/**
 *
 * @author 84348
 */
@WebServlet(name = "AddReceiptVirtualController", urlPatterns = {"/AddReceiptVirtualController"})
public class AddReceiptVirtualController extends HttpServlet {

    private static final String ERROR = "createReceipt.jsp";
    private static final String SUCCESS = "createReceiptDetail.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            Timer t = new Timer();
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            String receiptID = "1";
            String inputDate = t.timeNow();
            String status = "True";
            String note = "";
            String accountantID = loginUser.getAccountID();
            String stockKeeperID = "";
            UserReceiptVirtual tm = new UserReceiptVirtual(receiptID, inputDate, status, 0, note, accountantID, stockKeeperID);
            ListReceipt cart = (ListReceipt) session.getAttribute("VIRTUAL_RECEI_BASIC");
            if (cart == null) {
                cart = new ListReceipt();
            }
            cart.add(tm);
            session.setAttribute("VIRTUAL_RECEI_BASIC", cart);
            url = SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
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
