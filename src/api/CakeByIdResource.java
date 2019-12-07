package api;

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

import com.google.gson.Gson;

import model.Cake;
import model.OrderDetail;
import modelDAO.CakeDAO;
import modelDAO.OrderDetailDAO;
@WebServlet("/api/cake/*")
public class CakeByIdResource extends HttpServlet {
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

				Cake cake = new Cake();
				try {
					cake = CakeDAO.getByID(id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				sendAsJson(response, cake);
				return;
			}
		}

}
