package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Business.User;
import DOA.UserDoa;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String email=request.getParameter("email");
				String password= request.getParameter("password");
				
				User userobj= new User();
				try {				
					UserDoa userdoaobj=new UserDoa();
					List <User>userList=userdoaobj.getAllUser();
					for (int i = 0; i < userList.size(); i++) {
						String emailDB=userList.get(i).getEmail();
						String passwordDB=userList.get(i).getPassword();
						String name=userList.get(i).getFirstName();
						if (email.equals(emailDB) && password.equals(passwordDB)) {
							HttpSession session=request.getSession();
							session.setAttribute("name", name);
							response.sendRedirect("http://localhost:8080/Rental/ListingAll");
							break;
						}else{
							response.getWriter().print("Please check your password");	
							
						}
					}
					//return result;
				
					
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
	

}
