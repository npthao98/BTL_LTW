/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Client;
import model.User;
import modelDAO.ClientDAO;
import modelDAO.UserDAO;

/**
 *
 * @author Duck
 */
@WebServlet("/regist")

public class RegistAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
        ProcessSys.setCharacterUTF8(request, response);

        response.sendRedirect(request.getContextPath() + "/registAccount.jsp");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
        ProcessSys.setCharacterUTF8(request, response);
            
        HttpSession session = request.getSession();
            
        String username = (String) request.getParameter("username"),
            password = ProcessSys.decodeSHA((String) request.getParameter("password")),
            name = (String) request.getParameter("fullname"),
            addr = (String) request.getParameter("address"),
            phone = (String) request.getParameter("phone"),
            email = (String) request.getParameter("email");
        
        Account account = new Account(username, password);

        try {
            if(UserDAO.checkAccountExid(account)){
                session.setAttribute("error", "This username isn't allowed, try again !!!");
                response.sendRedirect(request.getContextPath() + "/regist");
                return;
            }else{
                Client client = new Client(name, addr, phone, email);
                boolean saveClient = ClientDAO.registClient(client);
                if(saveClient == true){
                    User user = new User(client.getID(), username, password, 1);
                    boolean saveUser = UserDAO.saveNewUser(user);
                    if(saveUser == false){
                        session.setAttribute("error", "This username isn't allowed, try again !!!");
                        response.sendRedirect(request.getContextPath() + "/regist");
                    }else{
                        session.setAttribute("user", client);
                        response.sendRedirect(request.getContextPath() + "/home.jsp");
                    }
                }else{
                    session.setAttribute("error", "This username isn't allowed, try again !!!");
                    response.sendRedirect(request.getContextPath() + "/regist");
                }
            }
        } catch (ClassNotFoundException ex) {
            response.getWriter().append(ex.getMessage());
        } catch (SQLException ex) {
            response.getWriter().append(ex.getMessage());
        }

        
    }

}