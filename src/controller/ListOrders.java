package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
import model.OrderDetail;
import model.Order_Client;
import modelDAO.CakeDAO;
import modelDAO.CakeOrderDAO;
import modelDAO.OrderClientDAO;
import modelDAO.OrderDAO;
import modelDAO.OrderDetailDAO;

/**
 * Servlet implementation class ListOrders
 */
@WebServlet("/ListOrders")
public class ListOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOrders() {
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
			List<Order_Client> orderClients = OrderClientDAO.getByClientID(client.getID());
			List<OrderDetail> orders = new ArrayList<OrderDetail>();
			try {
				orders = (List<OrderDetail>)OrderDetailDAO.getOrdersByClient(client.getID());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("orders", orders);
			request.setAttribute("client", client);
			request.getRequestDispatcher("/listOrders.jsp").forward(request, response);
			
			
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
