package com.example.quiz.vo;

import java.util.List;

import com.example.quiz.entity.Quiz;

public class SearchRes extends BasicRes {
	// 搜尋出來的資料可能是多筆問卷 所以要用 List
	private List<Quiz> quizList;

	public SearchRes() {
		super();
	}

	// List<Quiz> quizList的建構方法要合併在一起
	public SearchRes(int statusCode, String message,List<Quiz> quizList) {
		super(statusCode, message);
		this.quizList = quizList;
		
	}

	public List<Quiz> getQuizList() {
		return quizList;
	}

	public void setQuizList(List<Quiz> quizList) {
		this.quizList = quizList;
	}

}
