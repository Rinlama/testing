package Business;

import java.util.List;

import DOA.PostDao;
import DOA.UserDoa;



public class User implements java.io.Serializable {
	private String userID;
	private String FirstName;
	private String LastName;
	private String Email;
	private String Password;
	
	
	public User() {
		super();
	}

	public User(String userID, String firstName, String lastName, String email,
		String password) {
		this.userID = userID;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Email = email;
		this.Password = password;
	}

	public String getuserID() {
		return userID;
	}

	public void setuserID(String userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		this.LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}
	
	

	@Override
	public String toString() {
		return "User [userID=" + userID + ", FirstName=" + FirstName
				+ ", LastName=" + LastName + ", Email=" + Email + ", Password="
				+ Password + "]";
	}
	
	public String authetication(String email,String password) throws Exception{
		boolean result=false;
		String test=null;
		UserDoa userdoaobj=new UserDoa();
		List <User>userList=userdoaobj.getAllUser();
		for (int i = 0; i < userList.size(); i++) {
			String emailDB=userList.get(i).getEmail();
			String passwordDB=userList.get(i).getPassword();
			if (email.equals(emailDB) && password.equals(emailDB)) {
				return email;
			}
		}
		//return result;
		return test;
	}
		
	
	
	
}
