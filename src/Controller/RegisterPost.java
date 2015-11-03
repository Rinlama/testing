package Controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Business.PostAds;
import DOA.PostDao;

/**
 * Servlet implementation class RegisterPost
 */
@WebServlet("/RegisterPost")
public class RegisterPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//create a user id 
		UUID idOne = UUID.randomUUID();
	    UUID idTwo = UUID.randomUUID();
	    //create a obj 
		PostAds post= new PostAds();
			post.setName(request.getParameter("name"));
			post.setPhone(request.getParameter("phone"));
			post.setEmail(request.getParameter("email"));
			post.setPhone(request.getParameter("phone"));
			post.setSubject(request.getParameter("subject"));
			post.setDescription(request.getParameter("description"));
			//Inserting a timestamp
			Calendar date=Calendar.getInstance();
			String currentdate=date.getTime().toString();
			post.setTimestamp(currentdate);
			response.getWriter().print(currentdate);
		    post.setPostid(idOne.toString());
			post.setUserid(idTwo.toString());
			response.getWriter().print("df");
			
			//PostDOA object 
			try {
				PostDao doaobj= new PostDao();
				doaobj.insertPost(post);
				
				response.sendRedirect("http://localhost:8080/Rental/ListingAll");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
