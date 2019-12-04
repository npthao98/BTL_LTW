package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
import modelDAO.AccountDAO;
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
            request.getRequestDispatcher("login.jsp").forward(request, response);
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

//    String username = request.getParameter("username");
//    String pass = request.getParameter("password");     
//    Account user = new Account(username, pass);
//     
//    String decode = ProcessSys.decodeSHA("helloworld");
//    
//    try {
//        ArrayList<Account> list = AccountDAO.getAll();
//        response.getWriter().append(decode);
//    } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//        response.getWriter().append(e.getMessage());
//    } catch (SQLException e) {
//            // TODO Auto-generated catch block
//        response.getWriter().append(e.getMessage());
//    }

    //Tam
    Client acc= ClientDAO.getByID(1);
    session.setAttribute("user", acc);
    response.sendRedirect("home.jsp");
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
