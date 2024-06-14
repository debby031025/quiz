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
		questionList.add(new Question(1,"���d�\","�Q����;���ޱ�;�γ�;�N���L",//
				OptionType.SINGLE_CHOICE.getType(),true));
		questionList.add(new Question(2,"����","1���\;2���\;3���\;4���\",//
				OptionType.SINGLE_CHOICE.getType(),true));
		questionList.add(new Question(3,"����","�ަת���;���A����;�z�����a��(��);��X����",//
				OptionType.SINGLE_CHOICE.getType(),true));
		CreateOrUpdateReq req = new CreateOrUpdateReq("���\�Yԣ?","���\�Y����O?",LocalDate.of(2024,6,1),//
				LocalDate.of(2024,6,1),questionList,true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getStatusCode() == 200, "create test false!!");
		// �R�����ո�� TODO		
	}
	
	@Test //���O����
	public void createNameErrorTest() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1,"���d�\","�Q����;���ޱ�;�γ�;�N���L",//
				OptionType.SINGLE_CHOICE.getType(),true));
		questionList.add(new Question(2,"����","1���\;2���\;3���\;4���\",//
				OptionType.SINGLE_CHOICE.getType(),true));
		questionList.add(new Question(3,"����","�ަת���;���A����;�z�����a��(��);��X����",//
				OptionType.SINGLE_CHOICE.getType(),true));
		CreateOrUpdateReq req = new CreateOrUpdateReq("","���\�Y����O?",LocalDate.of(2024,6,1),//
				LocalDate.of(2024,6,1),questionList,true);
		BasicRes res = quizService.createOrUpdate(req);
		// res.getMessage().equalsIgnoreCase("Param name error!!")��true
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param name error!!"), "create test false!!");
	}
	
	@Test //���O����
	public void createStartDateErrorTest() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1,"���d�\","�Q����;���ޱ�;�γ�;�N���L",//
				OptionType.SINGLE_CHOICE.getType(),true));
		questionList.add(new Question(2,"����","1���\;2���\;3���\;4���\",//
				OptionType.SINGLE_CHOICE.getType(),true));
		questionList.add(new Question(3,"����","�ަת���;���A����;�z�����a��(��);��X����",//
				OptionType.SINGLE_CHOICE.getType(),true));
		// ���ѬO 2024/5/30�A�ҥH�}�l�������O��ѩάO���e
		CreateOrUpdateReq req = new CreateOrUpdateReq("���\�Yԣ?","���\�Y����O?",LocalDate.of(2024,5,30),//
				LocalDate.of(2024,6,1),questionList,true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param start date error!!"), "create test false!!");
	}
	
	@Test //�i�H�X�ִ���
	public void createTest1() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1,"���d�\","�Q����;���ޱ�;�γ�;�N���L",//
				OptionType.SINGLE_CHOICE.getType(),true));
		// ���� name error: ���D���ର�Ŧr��
		CreateOrUpdateReq req = new CreateOrUpdateReq("","���\�Y����O?",LocalDate.of(2024,6,1),//
				LocalDate.of(2024,6,1),questionList,true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param name error!!"), "create test false!!");
		
		// ���� startDate error: ���]���ѬO 2024/5/30�A�ҥH�}�l�������O��ѩάO���e
		req = new CreateOrUpdateReq("���\�Yԣ?","���\�Y����O?",LocalDate.of(2024,5,30),//
				LocalDate.of(2024,6,1),questionList,true);
		res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param start date error!!"), "create test false!!");
		// ���� endDate error: ������������}�l�����
		req = new CreateOrUpdateReq("���\�Yԣ?","���\�Y����O?",LocalDate.of(2024,6,30),//
				LocalDate.of(2024,6,1),questionList,true);
		res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param end date error!!"), "create test false!!");
		// �Ѿl���޿�����P�_������A�̫�~�|�O���զ��\������
		req = new CreateOrUpdateReq("���\�Yԣ?","���\�Y����O?",LocalDate.of(2024,6,1),//
				LocalDate.of(2024,6,1),questionList,true);
		res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getStatusCode() == 200, "create test false!!");
	}
	
	
	@Test
	public void createTest2() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1,"�P�B��","�@�جP�B��;�J�}�P�B��;�J�}�i�i�H���P�B��;���d�i�i�H���P�B��",//
				OptionType.SINGLE_CHOICE.getType(),true));
		questionList.add(new Question(2,"�N�ѩ@��","���f�e�c�N�ѩ@��;�g��S�էN�ѩ@��;�L��B�c�N�ѩ@��;���N�ѩ@��",//
				OptionType.SINGLE_CHOICE.getType(),true));
		questionList.add(new Question(3,"������","�J�@�ٯ�����;�֦N������;�B�������;�g���������",//
				OptionType.SINGLE_CHOICE.getType(),true));
		CreateOrUpdateReq req = new CreateOrUpdateReq("�P�ڧJ�H�𶼫~����","��X�̳��w���P�ڧJ���~",LocalDate.of(2024,6,10),//
				LocalDate.of(2024,6,30),questionList,true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getStatusCode() == 200, "create test false!!");
		// �R�����ո�� TODO		
	}
	
	@Test
	public void createTest3() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1,"�̳��w�����~�t�C","�P�B��;�N�ѩ@��;������;�P�G�n",//
				OptionType.SINGLE_CHOICE.getType(),true));
		questionList.add(new Question(2,"���w���z��","",//
				OptionType.TEXT.getType(),false));
		questionList.add(new Question(3,"�w�ʶR�L�����~�t�C","�P�B��;�N�ѩ@��;������;�P�G�n",//
				OptionType.MULTI_CHOICE.getType(),true));
		CreateOrUpdateReq req = new CreateOrUpdateReq("�P�ڧJ�H�𶼫~����","��X�̳��w���P�ڧJ���~�t�C"
				+ "",LocalDate.of(2024,6,10),//
				LocalDate.of(2024,6,30),questionList,true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getStatusCode() == 200, "create test false!!");
		// �R�����ո�� TODO		
	}
	
	@Test
	public void updateTest() {
		// TODO
	}
}
