package com.ztw.springJTA.dao.master;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface TeacherMapper {

	String getNameByID(int teacherID);
	
	void updateTeacher(@Param("teacherID") int teacherID, @Param("teacherName") String teacherName);
	
}
