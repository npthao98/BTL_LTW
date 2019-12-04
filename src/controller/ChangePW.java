package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Client;
import model.User;
import modelDAO.ClientDAO;
import modelDAO.UserDAO;

/**
 * Servlet implementation class ChangePW
 */
@WebServlet("/ChangePW")
public class ChangePW extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePW() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client client = null;
		client = (Client)session.getAttribute("user");
		String alert ="";
		if(client == null) {
			response.sendRedirect("/BTL_LTW/login");
		}
		else {
			User user = UserDAO.getByClientID(client.getID());
			request.setAttribute("user", user);
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("changePW.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client client = null;
		client = (Client)session.getAttribute("user");
		if(client == null) {
			response.sendRedirect("/BTL_LTW/login");
		}
		else {
			User user = UserDAO.getByClientID(client.getID());
			String pw1 = request.getParameter("pw1");
			String pw2 = request.getParameter("pw2");
			String pw = user.getPassword();
			String alert;
			System.out.println(pw1);
			System.out.println(ProcessSys.decodeSHA(pw1));
			System.out.println(ProcessSys.decodeSHA("helloworld"));
			System.out.println(pw);
			if(pw.equals(ProcessSys.decodeSHA(pw1))) {
				UserDAO.updatePW(user.getID(), ProcessSys.decodeSHA(pw2));
				alert = "Success";
			}
			else {
				
				alert = "Fail";
			}
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("/changePW.jsp").forward(request, response);
		}
		
		
	}

}
