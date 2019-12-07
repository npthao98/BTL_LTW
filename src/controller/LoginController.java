package controller;

import java.io.IOException;
import java.io.Serializable;
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
import model.Cake;
import model.CakeInfor;
import model.Client;
import model.User;
import modelDAO.ClientDAO;
import modelDAO.UserDAO;

/**
 * Servlet implementation class DuckTest
 */

@WebServlet("/login")
public class LoginController extends HttpServlet implements Serializable{
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
        ProcessSys.setCharacterUTF8(request, response);
        HttpSession session = request.getSession();
        
        session.removeAttribute("user");
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
        ProcessSys.setCharacterUTF8(request, response);		
    }

}
