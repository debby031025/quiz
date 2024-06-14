package com.example.quiz;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.quiz.constants.OptionType;
import com.example.quiz.repository.QuizDao;
import com.example.quiz.service.ifs.QuizService;
import com.example.quiz.vo.BasicRes;
import com.example.quiz.vo.CreateOrUpdateReq;
import com.example.quiz.vo.Question;

@SpringBootTest
public class QuizServiceTests {
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private QuizDao quizDao;
	
	@Test
	public void createTest() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1,"健康餐","松阪豬;炸豬排;煎魚;烤雞腿",//
				OptionType.SINGLE_CHOICE.getType(),true));
		questionList.add(new Question(2,"丹丹","1號餐;2號餐;3號餐;4號餐",//
				OptionType.SINGLE_CHOICE.getType(),true));
		questionList.add(new Question(3,"炒飯","豬肉炒飯;海鮮炒飯;干貝馬鈴薯(推);綜合炒飯",//
				OptionType.SINGLE_CHOICE.getType(),true));
		CreateOrUpdateReq req = new CreateOrUpdateReq("午餐吃啥?","午餐吃什麼呢?",LocalDate.of(2024,6,1),//
				LocalDate.of(2024,6,1),questionList,true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getStatusCode() == 200, "create test false!!");
		// 刪除測試資料 TODO		
	}
	
	@Test //分別測試
	public void createNameErrorTest() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1,"健康餐","松阪豬;炸豬排;煎魚;烤雞腿",//
				OptionType.SINGLE_CHOICE.getType(),true));
		questionList.add(new Question(2,"丹丹","1號餐;2號餐;3號餐;4號餐",//
				OptionType.SINGLE_CHOICE.getType(),true));
		questionList.add(new Question(3,"炒飯","豬肉炒飯;海鮮炒飯;干貝馬鈴薯(推);綜合炒飯",//
				OptionType.SINGLE_CHOICE.getType(),true));
		CreateOrUpdateReq req = new CreateOrUpdateReq("","午餐吃什麼呢?",LocalDate.of(2024,6,1),//
				LocalDate.of(2024,6,1),questionList,true);
		BasicRes res = quizService.createOrUpdate(req);
		// res.getMessage().equalsIgnoreCase("Param name error!!")為true
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param name error!!"), "create test false!!");
	}
	
	@Test //分別測試
	public void createStartDateErrorTest() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1,"健康餐","松阪豬;炸豬排;煎魚;烤雞腿",//
				OptionType.SINGLE_CHOICE.getType(),true));
		questionList.add(new Question(2,"丹丹","1號餐;2號餐;3號餐;4號餐",//
				OptionType.SINGLE_CHOICE.getType(),true));
		questionList.add(new Question(3,"炒飯","豬肉炒飯;海鮮炒飯;干貝馬鈴薯(推);綜合炒飯",//
				OptionType.SINGLE_CHOICE.getType(),true));
		// 今天是 2024/5/30，所以開始日期不能是當天或是之前
		CreateOrUpdateReq req = new CreateOrUpdateReq("午餐吃啥?","午餐吃什麼呢?",LocalDate.of(2024,5,30),//
				LocalDate.of(2024,6,1),questionList,true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param start date error!!"), "create test false!!");
	}
	
	@Test //可以合併測試
	public void createTest1() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1,"健康餐","松阪豬;炸豬排;煎魚;烤雞腿",//
				OptionType.SINGLE_CHOICE.getType(),true));
		// 測試 name error: 問題不能為空字串
		CreateOrUpdateReq req = new CreateOrUpdateReq("","午餐吃什麼呢?",LocalDate.of(2024,6,1),//
				LocalDate.of(2024,6,1),questionList,true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param name error!!"), "create test false!!");
		
		// 測試 startDate error: 假設今天是 2024/5/30，所以開始日期不能是當天或是之前
		req = new CreateOrUpdateReq("午餐吃啥?","午餐吃什麼呢?",LocalDate.of(2024,5,30),//
				LocalDate.of(2024,6,1),questionList,true);
		res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param start date error!!"), "create test false!!");
		// 測試 endDate error: 結束日期不能比開始日期早
		req = new CreateOrUpdateReq("午餐吃啥?","午餐吃什麼呢?",LocalDate.of(2024,6,30),//
				LocalDate.of(2024,6,1),questionList,true);
		res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param end date error!!"), "create test false!!");
		// 剩餘的邏輯全部判斷完之後，最後才會是測試成功的情境
		req = new CreateOrUpdateReq("午餐吃啥?","午餐吃什麼呢?",LocalDate.of(2024,6,1),//
				LocalDate.of(2024,6,1),questionList,true);
		res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getStatusCode() == 200, "create test false!!");
	}
	
	
	@Test
	public void createTest2() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1,"星冰樂","咖啡星冰樂;焦糖星冰樂;焦糖可可碎片星冰樂;摩卡可可碎片星冰樂",//
				OptionType.SINGLE_CHOICE.getType(),true));
		questionList.add(new Question(2,"冷萃咖啡","香檸蜜柚冷萃咖啡;經典特調冷萃咖啡;夏日冰柚冷萃咖啡;氮氣冷萃咖啡",//
				OptionType.SINGLE_CHOICE.getType(),true));
		questionList.add(new Question(3,"茶那堤","醇濃抹茶那堤;福吉茶那堤;伯爵茶那堤;經典紅茶那堤",//
				OptionType.SINGLE_CHOICE.getType(),true));
		CreateOrUpdateReq req = new CreateOrUpdateReq("星巴克人氣飲品票選","投出最喜歡的星巴克飲品",LocalDate.of(2024,6,10),//
				LocalDate.of(2024,6,30),questionList,true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getStatusCode() == 200, "create test false!!");
		// 刪除測試資料 TODO		
	}
	
	@Test
	public void createTest3() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1,"最喜歡的飲品系列","星冰樂;冷萃咖啡;茶那堤;星沁爽",//
				OptionType.SINGLE_CHOICE.getType(),true));
		questionList.add(new Question(2,"喜歡的理由","",//
				OptionType.TEXT.getType(),false));
		questionList.add(new Question(3,"已購買過的飲品系列","星冰樂;冷萃咖啡;茶那堤;星沁爽",//
				OptionType.MULTI_CHOICE.getType(),true));
		CreateOrUpdateReq req = new CreateOrUpdateReq("星巴克人氣飲品票選","投出最喜歡的星巴克飲品系列"
				+ "",LocalDate.of(2024,6,10),//
				LocalDate.of(2024,6,30),questionList,true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getStatusCode() == 200, "create test false!!");
		// 刪除測試資料 TODO		
	}
	
	@Test
	public void updateTest() {
		// TODO
	}
}
