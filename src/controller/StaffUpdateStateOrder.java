package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Client;
import modelDAO.OrderDAO;

/**
 * Servlet implementation class StaffUpdateStateOrder
 */
@WebServlet("/StaffUpdateStateOrder")
public class StaffUpdateStateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffUpdateStateOrder() {
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
			response.sendRedirect(request.getContextPath()+"/staff_login");
		}
		else {
			int id= Integer.parseInt(request.getParameter("id"));
			int state= Integer.parseInt(request.getParameter("state"));
			OrderDAO.updateStateOrder(id, state);;
			response.sendRedirect(request.getContextPath()+"/StaffDetailOrder?id="+id);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
