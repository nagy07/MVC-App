package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="USER-TABLE")
public class User implements Serializable {

	private String id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String password;
	private String Email;
	private String userId;
	
	public User(){
		
	}
	
	public User (String id , String firstName , String lastName , String middleName , String password , String Email , String userId){
		
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.Email = Email;
			this.middleName = middleName;
			this.password = password;
			this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
