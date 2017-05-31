package com.ztw.springJTA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ztw.springJTA.dao.master.TeacherMapper;
import com.ztw.springJTA.dao.slave01.TeacherMapperA;

@Transactional
@Service
public class TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;
	
	@Autowired
	private TeacherMapperA teacherMapper01;
	
	public void updateInfo() {
		teacherMapper.updateTeacher(1, "DXBA00111asd");
		teacherMapper.updateTeacher(2, "DXBA00222asd");
		teacherMapper01.updateTeacher(1, "DXBA00000000asd");
		int i = 1 / 0;
		System.out.println(i);
	}
	
}
