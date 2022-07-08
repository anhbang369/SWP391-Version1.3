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
import receiptAccountant.UserReceiptDetail;
import receiptAccountant.UserReceiptVirtual;
import virtual.ListReceipt;
import virtual.ListReceiptM;

/**
 *
 * @author 84348
 */
@WebServlet(name = "AddReceiptController", urlPatterns = {"/AddReceiptController"})
public class AddReceiptController extends HttpServlet {

    private static final String ERROR = "createReceiptDetail.jsp";
    private static final String SUCCESS = "MainController?action=AddReceiptDetail";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            ListReceipt cart = (ListReceipt) session.getAttribute("VIRTUAL_RECEI_BASIC");
            ListReceiptM ca = (ListReceiptM) session.getAttribute("VIRTUAL_RECEI");
            boolean createReceipt = false;
            if (ca != null) {
                if (ca.getListReceipt().size() > 0) {
                    int a = 0;
                    for (UserReceiptDetail tm : ca.getListReceipt().values()) {
                        a += tm.getQuantityInBill();
                    }
                    if (cart != null) {
                        if (cart.getListReceipt().size() > 0) {
                            for (UserReceiptVirtual tm : cart.getListReceipt().values()) {
                                DAOReceipt dao = new DAOReceipt();
                                String inputDate = tm.getInputDate();
                                String status = tm.getStatus();
                                int totalQuantity = a;
                                String note = tm.getNote();
                                String accountantID = tm.getAccountantID();
                                String stockKeeperID = request.getParameter("stockKeeperID");
                                boolean checkS = dao.checkExistAccount(stockKeeperID);
                                if (checkS == true) {
                                    UserReceiptVirtual userReceipt = new UserReceiptVirtual(stockKeeperID, inputDate, status, totalQuantity, note, accountantID, stockKeeperID);
                                    createReceipt = dao.createReceipt(userReceipt);
                                    if (createReceipt == true) {
                                        if (session != null) {
                                            if (cart != null) {
                                                session.removeAttribute("VIRTUAL_RECEI_BASIC");
                                                url = SUCCESS;

                                            }
                                        }

                                    }
                                } else {
                                    request.setAttribute("VIRTUAL_RECEI_ERROR", "stockKeeperID not exist. Please enter again!!");
                                }

                            }

                        }
                    }
                }else{
                    request.setAttribute("ERROR_FINISH", "You have to add Product into Receipt");
                }
            } else {
                request.setAttribute("ERROR_FINISH", "You have to add Product into Receipt");
            }

        } catch (Exception e) {
            System.out.println("Error at InsertController: " + e.toString());
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
