package com.ztw.springJTA.test.Dao.master;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import com.ztw.springJTA.dao.master.TeacherMapper;
import com.ztw.springJTA.test.BaseTest;

public class TeacherMapperTest extends BaseTest {

	@Autowired
	private TeacherMapper teacherMapper;
	
	@Test
	public void test000(){
		try {
			String teacherName = teacherMapper.getNameByID(1);
			System.out.println(teacherName);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void test001(){
		try {
			teacherMapper.updateTeacher(1, "ZTW001");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
