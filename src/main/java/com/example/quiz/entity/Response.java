package com.example.quiz.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "response")
public class Response {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "quiz_id")
	private int quizId;
	
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "fillin")
	private String fillin;
	
	@Column(name = "fillin_date_time")
	private LocalDateTime fillinDateTime = LocalDateTime.now();//給予預設值就不用在建構方法寫入(save也不用寫入)

	public Response() {
		super();
	}

	// id為流水號所以拿掉
	public Response(int quizId, String name, String phone, String email, int age, String fillin) {
		super();
		this.quizId = quizId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.fillin = fillin;
	}

	public Response(int id, int quizId, String name, String phone, String email, int age, String fillin,
			LocalDateTime fillinDateTime) {
		super();
		this.id = id;
		this.quizId = quizId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.fillin = fillin;
		this.fillinDateTime = fillinDateTime;
	}

	public int getId() {
		return id;
	}

	public int getQuizId() {
		return quizId;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public String getFillin() {
		return fillin;
	}

	public LocalDateTime getFillinDateTime() {
		return fillinDateTime;
	}

	
	

}
