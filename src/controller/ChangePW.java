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
		if(client == null) {
			response.sendRedirect("/BTL_LTW/login");
		}
		else {
			User user = UserDAO.getByClientID(client.getID());
			request.setAttribute("user", user);
			request.getRequestDispatcher("changePW.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		Client client = null;
//		client = (Client)session.getAttribute("user");
//		String name = request.getParameter("name");
//		System.out.print(name);
//		String address = request.getParameter("address");
//		ClientDAO.update(client.getID(), name, address);
//		Client acc=ClientDAO.getByID(client.getID());
//		session.setAttribute("user", acc);
		response.sendRedirect("/BTL_LTW/Account");
	}

}
