package com.chama.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();
       
    }

	/**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//            @Override
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       
//	}

	
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //log out members
            String logout = request.getParameter("logout");
                String url = "loginUser.jsp";
                
                if(logout.equals("logout")){
                HttpSession session = request.getSession();
                session.invalidate();
                
                request.getRequestDispatcher(url).forward(request, response);
		
		}
		
	}

        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		//create the bean
                 HttpSession session = request.getSession();
		UserClass user = new UserClass();
		//add the properties
		user.setUsername(username);
		user.setPassword(password);
		//String validatedUser ;
		if("admin_role".equals(DatabaseHandler.validateUser(user))) {
                    try {
                        System.out.println("Send to Admin");
                        String url = "homepage.jsp";
                        //create a session
                       
                        
                        int adminID = DatabaseHandler.getUserDetails(username);
                            List<chamaModel> chamaDet;
            chamaDet = DatabaseHandler.getChamaDetails(adminID);
            int chamaID = chamaDet.get(0).getChamaID();
            chamaModel chama = new chamaModel();
            chama.setChamaID(chamaID);
            int totalContributions = DatabaseHandler.getTotalChamaContribution(chama);
            int totalLoans = DatabaseHandler.getTotalLoans(chama);
            int mem = DatabaseHandler.getMembers(chama);
            
                        
                        session.setAttribute("username", user.getUsername());
                        session.setAttribute("role", DatabaseHandler.validateUser(user));
                        session.setAttribute("totalcon",totalContributions);
                         session.setAttribute("totalaons",totalLoans);
                         session.setAttribute("memb", mem);
                        
                        session.setAttribute("adminUnique", adminID);
                        //request.setAttribute("username", username);
                        //create a dispatcher
                        request.getRequestDispatcher(url).forward(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
			
			
		}
		if  ("treasurer_role".equals(DatabaseHandler.validateUser(user))) {
                    try {
                        int adminID = DatabaseHandler.getUserDetails(username);
                        System.out.println("Send to treasurer");
                        String url = "homepage.jsp";
                        //create a session
                       
                        session.setAttribute("role", DatabaseHandler.validateUser(user));
                               session.setAttribute("username", user.getUsername());
                        session.setAttribute("adminUnique", adminID);
                         List<chamaModel> chamaDet;
            chamaDet = DatabaseHandler.getChamaDetails(adminID);
            int chamaID = chamaDet.get(0).getChamaID();
            chamaModel chama = new chamaModel();
            chama.setChamaID(chamaID);
            int totalContributions = DatabaseHandler.getTotalChamaContribution(chama);
              session.setAttribute("totalcon",totalContributions);
              //create session to allow loan issuing
              String allow = "allow";
              session.setAttribute("allow", allow);
            
                        // session.setAttribute("role", user.getRole_type());
                        //request.setAttribute("username", username);
                        //create a dispatcher
                        request.getRequestDispatcher(url).forward(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
			
			
		}
		else {
                    String errM = DatabaseHandler.validateUser(user);
			System.out.println("Error message = "+DatabaseHandler.validateUser(user));
			 request.setAttribute("errMessage", DatabaseHandler.validateUser(user));
			 session.setAttribute("errMess", errM);
			 request.getRequestDispatcher("loginUser.jsp").forward(request, response);
			 }
                
               
        }
	

}
 