package Controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Business.User;
import DOA.UserDoa;


/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/Sign")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UUID idOne = UUID.randomUUID();
		User userobj= new User();
		
		userobj.setuserID(idOne.toString());
		userobj.setFirstName(request.getParameter("first_name"));
		userobj.setLastName(request.getParameter("last_name"));
		userobj.setEmail(request.getParameter("email"));
		userobj.setPassword(request.getParameter("password"));
		//response.getWriter().print(request.getParameter("first_name"));
		
		UserDoa objuserdoa= new UserDoa();
		try {
			objuserdoa.insertUser(userobj);
			HttpSession session= request.getSession();
			session.setAttribute("sessionObj", userobj);		
			response.sendRedirect("ListingAll");
			
			//response.getWriter().print(userobj.getFirstName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
