package com.example.quiz.vo;

import java.util.List;

import com.example.quiz.entity.Quiz;

public class SearchRes extends BasicRes {
	// �j�M�X�Ӫ���ƥi��O�h���ݨ� �ҥH�n�� List
	private List<Quiz> quizList;

	public SearchRes() {
		super();
	}

	// List<Quiz> quizList���غc��k�n�X�֦b�@�_
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
