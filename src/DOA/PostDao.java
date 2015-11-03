package DOA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.rinjin.util.DbUtil;

import Business.PostAds;


public class PostDao {

	private Connection connection;

	public PostDao() throws Exception {
			
	}
	
	public List<PostAds> getAllPost() throws Exception {
		List<PostAds> postlist = new ArrayList<PostAds>();
		try {
			connection = DbUtil.getConnection();
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from post");
			while (rs.next()) {
			PostAds post= new PostAds();
			post.setPostid(rs.getString("idPost"));
			post.setUserid(rs.getString("UserID"));
			post.setName(rs.getString("Name"));
			post.setEmail(rs.getString("Email"));
			post.setSubject(rs.getString("Subject"));
			post.setPhone(rs.getString("Phone"));
			post.setDescription(rs.getString("Description"));
			post.setTimestamp(rs.getString("TimeStamp"));
			postlist.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return postlist;
	}
	
	public void insertPost(PostAds post) throws Exception{
		
		 try {   
		        
			 Connection objConn = DbUtil.getConnection();
		      Statement objStatement=(Statement) objConn.createStatement();
		       
		    //UPDATE `businessApplication`.`Post` SET `TimeStamp`='12/1/2015' WHERE `idpost`='2';
		    //  INSERT INTO `businessApplication`.`Post` (`idpost`, `userid`, `name`, `email`, `subject`, `phone`, `description`) VALUES ('3', '3', 'loucis', 'locusi@gmail.come', 'loci room', '33-333-3333', 'hello this is loci');

		       
		       String sql= "INSERT INTO businessApplication.post(idpost,userid,name,email,subject,phone,description,Timestamp)" +
		       "VALUES('"
		               +post.getPostid() + "','"
		               +post.getUserid()+ "','" 
		               +post.getName() + "','"
		               +post.getEmail() + "','"
		               +post.getSubject() + "','" 
		               +post.getPhone() + "','"
		               +post.getDescription() + "','"
		               +post.getTimestamp() + "')";
		               
		               
		       int rowsAffected= objStatement.executeUpdate(sql);
		          if (rowsAffected!=1) {
		              throw new UnsupportedOperationException("Insert Query Failed");
		          }
		       
		       
		       objConn.close();
		      
		     }catch(Exception objE){
		             throw new Exception("Error in database_Load()method- " + objE.toString());
		     }
		    }
		    	
		

	}



