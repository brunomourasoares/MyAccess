package com.myaccess.Models;

import java.sql.Timestamp;

public class User {
    
    private Integer id;
	private String username;
	private String password;
	private Timestamp createDate;
	private Boolean blocked;
	private Boolean admin;
    private String question;
    private String answer;
    private Boolean logged;

    public User(Integer id, String username, String password, Timestamp createDate, Boolean blocked, Boolean admin, String question, String answer, Boolean logged) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createDate = createDate;
        this.blocked = blocked;
        this.admin = admin;
        this.question = question;
        this.answer = answer;
        this.logged = logged;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Boolean getLogged() {
		return logged;
	}

	public void setLogged(Boolean logged) {
		this.logged = logged;
	}
}
