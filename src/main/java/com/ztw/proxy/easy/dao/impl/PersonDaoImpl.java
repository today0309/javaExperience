package com.ztw.proxy.easy.dao.impl;

import com.ztw.proxy.easy.dao.PersonDao;
import com.ztw.proxy.easy.model.Person;

/***
 * Dao的实现类
 * @author qindongliang
 *
 */
public class PersonDaoImpl implements PersonDao {

	@Override
	public void addUser(Person user) {
		// TODO Auto-generated method stub
//		System.out.println("add user name: "+user.getName());
		try{
			Thread.sleep(1000);//sleep 1 second
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(String name) {
//		System.out.println("delete user name: "+name);
		try{
			Thread.sleep(1500);//sleep 1.5 second
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateUser(String name) {
//		System.out.println("update user name: "+name);
		try{
			Thread.sleep(2000);//sleep 2 second
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
