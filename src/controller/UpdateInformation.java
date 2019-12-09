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

import model.Client;
import modelDAO.ClientDAO;

/**
 * Servlet implementation class UpdateInformation
 */
@WebServlet("/UpdateInformation")
public class UpdateInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Client client = null;
		client = (Client)session.getAttribute("user");
		if(client == null) {
			response.sendRedirect(request.getContextPath()+"/login");
		}
		else {
			request.getRequestDispatcher("updateInformation.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Client client = null;
		client = (Client)session.getAttribute("user");
		if(client == null) {
			response.sendRedirect(request.getContextPath()+"/login");
		}
		else {
                    try {
                        String name = request.getParameter("name");
                        System.out.print(name);
                        String address = request.getParameter("address");
                        ClientDAO.update(client.getID(), name, address);
                        Client acc=ClientDAO.getByID(client.getID());
                        session.setAttribute("user", acc);
                        response.sendRedirect(request.getContextPath()+"/Account");
                    } catch (SQLException ex) {
                        Logger.getLogger(UpdateInformation.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
		
	}

}
