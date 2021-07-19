package com.usermanagement.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "userName")
    private String userName;
	
	@Column(name = "password")
    private String password;
	
	private String token;
	
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime tokenCreationDate;
	
	@Column(name = "email")
    private String email;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;
	
	 @Column(name = "roleName")
    private String roleName;

    @Column(name = "dob")
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;



    public User() {
    }

    public User(String userName, String password, String email, String firstName, String lastName, String roleName, Date dob) {
        userName = userName;
        password = password;
        email = email;
        firstName = firstName;
        lastName = lastName;
		roleName = roleName;
        dob = dob;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getPassword() {
        return password;
    }


	public void setPassword(String password) {
        this.password = password;
    }
	
	public String getPassword() {
        return password;
    }


	public void setToken(String token) {
        this.token = token;
    }
	
	public LocalDateTime getTokenCreationDate() {
        return tokenCreationDate;
    }


	public void setTokenCreationDate(LocalDateTime tokenCreationDate) {
        this.tokenCreationDate = tokenCreationDate;
    }
	
	
	public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
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
	
	 public String getRoleName() {
        return roleName;
    }


	public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public Date getDob() {
        return dob;
    }


    public void setDob(Date dob) {
        this.dob = dob;
    }

}