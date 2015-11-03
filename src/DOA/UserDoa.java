package DOA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Business.PostAds;
import Business.User;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.rinjin.util.DbUtil;

public class UserDoa {
	
	public UserDoa(){
		
		
	}
	

	public void insertUser(User user) throws Exception{
		
		 try {   
		        
			 Connection objConn = DbUtil.getConnection();
		      Statement objStatement=(Statement) objConn.createStatement();
		       
		     // INSERT INTO `businessApplication`.`user` (`iduser`, `firstname`, `lastname`, `email`, `password`) VALUES ('12', '12', '12', '12@gmail.com', '12');

		       String sql= "INSERT INTO businessApplication.user(iduser,firstname,lastname,email,password)" +
		       "VALUES('"
		               +user.getuserID() + "','"
		               +user.getFirstName()+ "','" 
		               +user.getLastName() + "','"
		                +user.getEmail() + "','"
		               +user.getPassword()  + "')";
		                       
		       int rowsAffected= objStatement.executeUpdate(sql);
		          if (rowsAffected!=1) {
		              throw new UnsupportedOperationException("Insert Query Failed");
		          }
		       	       
		       objConn.close();
		      
		     }catch(Exception objE){
		             throw new Exception("Error in database_Load()method- " + objE.toString());
		     }
		    }
	public List<User> getAllUser() throws Exception {
		List<User> userlist = new ArrayList<User>();
		try {
			Connection connection = DbUtil.getConnection();
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from user");
			while (rs.next()) {
			User user= new User();
			user.setuserID(rs.getString("iduser"));
			user.setFirstName(rs.getString("firstname"));
			user.setLastName(rs.getString("lastname"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
	
			userlist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userlist;
	}
}
