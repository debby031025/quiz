package com.example.quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;

//@SpringBootTest
class QuizApplicationTests {

	@Test
	void contextLoads() {
		String str = "AB;B;C;D";// 選項
		String ansStr = "A;AB;E";// 回答
		String[] strArray = str.split(";");// ["AB","B","C","D"]
		List<String> strList = List.of(strArray);// ["AB","B","C","D"]
		String[] ansArray = ansStr.split(";");// ["A","AB","E"]

		for (String item : ansArray) {
			System.out.println(item + ":" + strList.contains(item));
			System.out.println(item + ":" + str.contains(item));
			System.out.println("=============");
		}
	}

	@Test
	public void test1() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "AAA");
		System.out.println(map);
		System.out.println("=================");
		map.forEach((k, v) -> {
			map.replace(k, "ABC");
			map.put(k, "DDD");
		});
		System.out.println(map);
	}

	@Test
	public void test2() {
		List<Integer> need = new ArrayList<>(List.of(1, 2));
		List<Integer> qIds = new ArrayList<>(List.of(1, 3));
		System.out.println(need.contains(qIds));
		List<Integer> need1 = new ArrayList<>(List.of(1, 2));
		System.out.println(need.containsAll(need1));
	}

	@Test
	public void THtest3() {
		List<String> list = List.of("A", "B", "C", "D", "E");
		String str = "AABBBCDDAEEEAACCDD";
		// 計算 A,B,C,D,E 各出現了幾次
		Map<String, Integer> map = new HashMap<>();
		;
		for (String item : list) {
			String newStr = str.replace(item, "");// "BBBCDDEEECCDD","AACDDAEEEAACCDD"...等
			int count = str.length() - newStr.length();
			map.put(item, count);
		}
		System.out.println(map);
	}

	@Test
	public void test3() {
		List<String> list = List.of("A", "B", "C", "D", "E");
		String str = "AABBBCDDAEEEAACCDD";
		// A,B,C,D,E 各出現了幾次
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) { // hasNext(): 判斷是否有下一個元素
			String item = iter.next(); // .next(): 取得下一個元素
			System.out.println(item + ":" + StringUtils.countOccurrencesOf(str, item));
		}

	}

}
