package com.ztw.jta.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ztw.jta.dao.TestSlaveDao;

@Repository
public class TestSlaveDaoImpl implements TestSlaveDao {

	@Resource(name = "slaveJdbcTemplate")
	JdbcTemplate slaveJdbcTemplate;

	@Override
	public String slave() {
		slaveJdbcTemplate.execute("update student set name='slave' where id=1");
		return "success";
	}

}
