package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.spi.RegisterableService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.RegisterService;

/**
 * Servlet implementation class RegiseterServlet
 */
@WebServlet("/RegiseterServlet")
public class RegiseterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String middleName = request.getParameter("middlename");
		String id = request.getParameter("id");
		String Email = request.getParameter("Email");
		String password = request.getParameter("password");
		
		 User user = new User (id,firstName,lastName,middleName,password,Email,password);
		 try{
			 
			 RegisterService registerService = new RegisterService();
			 boolean result = registerService.register(user);
			 out.println("<html>");
	         out.println("<head>");      
	         out.println("<title>Registration Successful</title>");    
	         out.println("</head>");
	         out.println("<body>");
	         out.println("<center>");
	         if(result){
	             out.println("<h1>Thanks for Registering with us :</h1>");
	             out.println("To login with new UserId and Password<a href=login.jsp>Click here</a>");
	         }else{
	             out.println("<h1>Registration Failed</h1>");
	             out.println("To try again<a href=register.jsp>Click here</a>");
	         }
	         out.println("</center>");
	         out.println("</body>");
	         out.println("</html>");
	     } finally {       
	         out.close();
	     }

	}

}
