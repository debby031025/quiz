package com.example.quiz.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteReq {
	// 因為可能一次刪多筆問卷資料 所以要用 List
	@JsonProperty("id_list")
	private List<Integer> idList;

	public DeleteReq() {
		super();
		System.out.println("預設建構方法");
	}

	public DeleteReq(List<Integer> idList) {
		super();
		this.idList = idList;
		System.out.println("有參數的建構方法");
	}

	public List<Integer> getIdList() {
		return idList;
	}

}
