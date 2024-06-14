package com.example.quiz.vo;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CreateOrUpdateReq {
	
	private int id;
	// 前四項為 問卷
	private String name;

	private String description;
	//名字由兩個字組成的 或是布林值的話 要加@JsonProperty
	@JsonProperty("start_date")
	private LocalDate startDate;
	
	@JsonProperty("end_date")
	private LocalDate endDate;
	
	
	// 後四項為 題目	
//	@JsonProperty("question_id")
//	private int questionId;
//
//	private String content;
//
//	private String type;
//	
//	@JsonProperty("is_necessary")
//	private boolean necessary;
	
	@JsonProperty("question_list")
	private List<Question> questionList;
	
	//==========================
	@JsonProperty("is_published")
	private boolean published;
	
	public CreateOrUpdateReq() {
		super();		
	}

	public CreateOrUpdateReq(String name, String description, LocalDate startDate, LocalDate endDate,
			List<Question> questionList, boolean published) {
		super();
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.questionList = questionList;
		this.published = published;
	}
	

	public CreateOrUpdateReq(int id, String name, String description, LocalDate startDate, LocalDate endDate,
			List<Question> questionList, boolean published) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.questionList = questionList;
		this.published = published;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	
	public List<Question> getQuestionList() {
		return questionList;
	}
	

	public boolean isPublished() {
		return published;
	}

	public int getId() {
		return id;
	}


}
