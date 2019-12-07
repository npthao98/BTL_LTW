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
import modelDAO.ClientDAO;
import modelDAO.ImageurlDAO;
import modelDAO.TypeDAO;
import modelDAO.UserDAO;

/**
 *
 * @author Duck
 */

@WebServlet("/staff_login")
public class StaffLoginController extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProcessSys.setCharacterUTF8(request, response);

        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath() + "/staff_login.jsp");
    }

	/**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProcessSys.setCharacterUTF8(request, response);

        HttpSession session = request.getSession();

        String username = request.getParameter("staff-username");
        String pass = ProcessSys.decodeSHA(request.getParameter("staff-password"));    
        model.Account account = new model.Account(username, pass);
        
        try {
            User t = UserDAO.getUserByAccount(account);
            if(t == null){
                session.setAttribute("error", "Account is wrong !!!");
                response.sendRedirect(request.getContextPath() + "/staff_login");
            }else{
                Client user = ClientDAO.checkAccountExid(t);
                if(user != null){
                    session.setAttribute("user", user);
                    if(t.getRole() == 0)
                       response.sendRedirect(request.getContextPath() + "/StaffHome"); 
                    else{
                        session.setAttribute("error", "This account is not admin !!!");
                        response.sendRedirect(request.getContextPath() + "/staff_login"); 
                    }
                          
                }
                else{
                    session.setAttribute("error", "Account is wrong !!!");
                    response.sendRedirect(request.getContextPath() + "/staff_login");
                }                 
            }
         
        }catch (ClassNotFoundException ex) {
            response.getWriter().append(ex.getMessage());
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            response.getWriter().append(ex.getMessage());
        }
    }
}
