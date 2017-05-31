package com.ztw.springJTA.dao.slave01;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface TeacherMapperA {

	String getNameByID(int teacherID);
	
	void updateTeacher(@Param("teacherID") int teacherID, @Param("teacherName") String teacherName);
	
}
