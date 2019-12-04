package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
 * Servlet implementation class DuckTest
 */

@WebServlet("/login")

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public LoginController() {
		// TODO Auto-generated constructor stub
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
//		ServletOutputStream out = response.getOutputStream();
        response.sendRedirect(request.getContextPath() + "/login.jsp");
//            request.getRequestDispatcher("account.jsp").forward(request, response);
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
		// TODO Auto-generated method stub	

        HttpSession session = request.getSession();


        String username = request.getParameter("username");
        String pass = ProcessSys.decodeSHA(request.getParameter("password"));    
        Account account = new Account(username, pass);
        
        try {
            User t = UserDAO.getUserByAccount(account);
            if(t == null){
                session.setAttribute("error", "Account is wrong !!!");
                response.sendRedirect(request.getContextPath() + "/login");
            }else{
                Client user = ClientDAO.checkAccountExid(t);
                if(user != null){
                    session.setAttribute("user", user);
                    response.sendRedirect(request.getContextPath() + "/home.jsp");
                }
                else{
                    session.setAttribute("error", "Account is wrong !!!");
                    response.sendRedirect(request.getContextPath() + "/login");
                }                 
            }
         
        }catch (ClassNotFoundException ex) {
            response.getWriter().append(ex.getMessage());
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            response.getWriter().append(ex.getMessage());
        }

        
    
//     try {
//		if(AccountDAO.checkIsExid(user) == true) {
////			session.setAttribute("user", user);
//			response.getWriter().append("Ahihi").append(request.getContextPath());
////			response.sendRedirect(request.getContextPath() + "/home.jsp");
//		 }
//		else {
//			
////			response.sendRedirect(request.getContextPath() + "/login.jsp");
//		}
//	} catch (ClassNotFoundException e) {
//		// TODO Auto-generated catch block
//		response.getWriter().append(e.getMessage());
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		response.getWriter().append(e.getMessage());
//	}
//     
     
//     session.setAttribute("user", user);
//     	response.sendRedirect(request.getContextPath() + "/home.jsp");
//     response.getWriter().append(" " + username);
     
//       response.sendRedirect(request.getContextPath() + "/home.jsp");
     
     
//       RequestDispatcher dispatcher;
//       dispatcher = this.getServletContext().getRequestDispatcher("/home.jsp");
//       dispatcher.forward(request, response);
     
       
		
    }

}
