package com.ztw.springJTA.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ztw.springJTA.service.TeacherService;

public class TeacherServiceTest extends BaseTest{

	@Autowired
	private TeacherService teacherService;
	
	@Test
	public void test000(){
		try {
			teacherService.updateInfo();
		} catch (Exception e) {
			System.out.println(e);
		}
			
	}
	
}
