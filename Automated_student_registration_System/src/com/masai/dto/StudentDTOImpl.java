package com.masai.dto;

public class StudentDTOImpl implements StudentDTO {

	private String stdId;
	private String firstName;
	private String lastName;
	private String address;
	private String mobile;
	private String email;
	private String password;
	private int course_id;
	
	public StudentDTOImpl(String stdId, String firstName, String lastName, String address, String mobile, String email,
			String password, int course_id) {
		super();
		this.stdId = stdId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.course_id = course_id;
	}


	public String getStdId() {
		return stdId;
	}

	public void setStdId(String stdId) {
		this.stdId = stdId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	@Override
	public String toString() {
		return "StudentDTOImpl [stdId=" + stdId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", mobile=" + mobile + ", email=" + email + ", password=" + password + ", course_id="
				+ course_id + "]";
	}

	
	
	
	
}
