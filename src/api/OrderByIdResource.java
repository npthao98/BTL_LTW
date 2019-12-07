package api;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Cake;
import model.Order;
import modelDAO.CakeDAO;
import modelDAO.OrderDAO;

@WebServlet("/api/orderById/*")
public class OrderByIdResource extends HttpServlet {
	private Gson _gson = new Gson();
	
	//a utility method to send object
	//as JSON response
	private void sendAsJson(HttpServletResponse response, Object obj) throws IOException {
		
		response.setContentType("application/json");
		
		String res = _gson.toJson(obj);
		     
		PrintWriter out = response.getWriter();
		  
		out.print(res);
		out.flush();
	}
		
		
	// Get models
	// GET/JavaViewer/models/
	// GET/JavaViewer/models/id 
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		String pathInfo = request.getPathInfo();

		if(pathInfo == null || pathInfo.equals("/")){

			Order order = OrderDAO.getByID(id);
			
			sendAsJson(response, order);
			return;
		}
	}
}
