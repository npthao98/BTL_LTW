package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cake;
import model.Cake_Order;
import model.Client;
import model.Order;
import model.Order_Client;
import modelDAO.CakeDAO;
import modelDAO.CakeOrderDAO;
import modelDAO.ClientDAO;
import modelDAO.OrderClientDAO;
import modelDAO.OrderDAO;

/**
 * Servlet implementation class StaffDetailOrder
 */
@WebServlet("/StaffDetailOrder")
public class StaffDetailOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffDetailOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client client1 = null;
		client1 = (Client)session.getAttribute("user");
		if(client1 == null) {
			response.sendRedirect("/BTL_LTW/staff_login");
		}
		else {
			int id= Integer.parseInt(request.getParameter("id"));
			Order order= OrderDAO.getByID(id);
			Order_Client orderClient= OrderClientDAO.getByOrderID(id);
			Client client = new Client();
			try {
				client = ClientDAO.getByID(orderClient.getClientID());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("order", order);
	        request.setAttribute("client", client);
	        List<Cake_Order> CakeOrders = CakeOrderDAO.getByOrderID(order.getID());
	        request.setAttribute("cakeOrders", CakeOrders);
	        List<Cake> cakes= new ArrayList<Cake>();
			try {
				cakes = CakeDAO.getCakesByOrderCakes(CakeOrders);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(client);
	        request.setAttribute("cakes", cakes);
	        request.getRequestDispatcher("/staff_detail_order.jsp").forward(request, response);
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
