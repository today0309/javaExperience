package com.ztw.proxy.easy.dao;

import com.ztw.proxy.easy.model.Person;

/***
 * 动态代理测试dao
 * @author qindongliang
 *
 */
public interface PersonDao {
	
	//add user
	public void addUser(Person user);
	//delete user
	public void deleteUser(String name);
	//update user
	public void updateUser(String name);

}
