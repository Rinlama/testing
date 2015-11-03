package Business;

public class PostAds {
	String userid;
	String postid;
	String name;
	String email;
	String subject;
	String phone;
	String description;
	String timestamp;
	
	public PostAds(){
		
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPostid() {
		return postid;
	}

	public void setPostid(String postid) {
		this.postid = postid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public PostAds(String userid, String postid, String name, String email,
			String subject, String phone, String description, String timestamp) {
		super();
		this.userid = userid;
		this.postid = postid;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.phone = phone;
		this.description = description;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "PostAds [userid=" + userid + ", postid=" + postid + ", name="
				+ name + ", email=" + email + ", subject=" + subject
				+ ", phone=" + phone + ", description=" + description
				+ ", timestamp=" + timestamp + "]";
	}
	
	
	
}
