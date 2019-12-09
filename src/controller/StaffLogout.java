/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.soap.AddressingFeature;
import model.CakeInfor;
import model.Client;

/**
 *
 * @author Duck
 */
@WebServlet("/StaffLogout")
public class StaffLogout extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public StaffLogout() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
//		ServletOutputStream out = response.getOutputStream();
        ProcessSys.setCharacterUTF8(request, response);
        
        HttpSession session = request.getSession();
        Client user = (Client)session.getAttribute("user");
        if(user != null){
            session.removeAttribute("user");
        }
        response.sendRedirect(request.getContextPath() +  "/staff_login");
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
        
		
    }

}

