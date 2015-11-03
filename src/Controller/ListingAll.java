package Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.rinjin.util.DbUtil;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.mysql.jdbc.Statement;
import com.rinjin.util.DbUtil;

import Business.PostAds;
import DOA.PostDao;

/**
 * Servlet implementation class ListingAll
 */
@WebServlet("/ListingAll")
public class ListingAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			try {
				PostDao userdoaobj=new PostDao();
				List posts=userdoaobj.getAllPost();
			
			//	response.getWriter().append(posts.toString());
			
				request.setAttribute("posts", posts);
				
				RequestDispatcher view = request.getRequestDispatcher("/lister.jsp");
				view.forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//response.getWriter().append(e.toString());
			}
	}



}
