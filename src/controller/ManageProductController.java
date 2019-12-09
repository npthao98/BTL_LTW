/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cake;
import model.CakeInfor;
import model.Client;
import model.ImageUrl;
import model.Type;
import model.User;
import modelDAO.CakeDAO;
import modelDAO.ImageurlDAO;
import modelDAO.TypeDAO;
import modelDAO.UserDAO;

/**
 *
 * @author Duck
 */

@WebServlet("/staff_manage/StaffListProducts")
public class ManageProductController extends HttpServlet{
    public ManageProductController(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        Client user = (Client) session.getAttribute("user");
        User u = UserDAO.getByClientID(user.getID());
        if(u.getRole() != 0){
            response.sendRedirect(request.getContextPath() + "/staff_login");
        }else{
            
            try {
                ArrayList<Cake> list = (ArrayList<Cake>) CakeDAO.getAllCake();
                request.setAttribute("products", list);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/staff_list_product.jsp");
                dispatcher.forward(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageProductController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ManageProductController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
}
