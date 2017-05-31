package com.ztw.springJTA.test.Dao.slave01;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import com.ztw.springJTA.dao.slave01.TeacherMapperA;
import com.ztw.springJTA.test.BaseTest;

public class TeacherMapperTest extends BaseTest {

	@Autowired
	private TeacherMapperA teacherMapper;
	
	@Test
	public void test000(){
		try {
			String teacherName = teacherMapper.getNameByID(1);
			System.out.println(teacherName);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
