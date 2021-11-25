package com.dao;

import com.bean.sCar;
import com.bean.sUser;

import java.util.List;

public interface UserMapper {
	/**
	 * 获取用户名对应的密码
	 * @param id 用户名
	 * @return  密码
	 */
	List<sUser> getPassAndId(String id);

	int insertUser(sUser user);

	/**
	 * 获取用户对应的个人信息
	 * @param id 用户名
	 * @return 用户个人信息
	 */
	List<sUser> getsUser(String id);

	/**
	 * 更新用户信息
	 * @param user 用户信息bean类
	 * @return 是否成功
	 */
	int upDataUser(sUser user);

	/**
	 * 获取车辆的信息
	 * @return 车辆信息
	 */
	List<sCar> getsCar();

	/**
	 * 查询某一辆汽车根据名字
	 * @param name 车辆名字
	 * @return 查询结果
	 */
	List<sCar> reSelectCar(String name);

	/**
	 * 注销用户账号
	 * @param username 用户名
	 * @return 是否成功
	 */
	int deleteUser(String username);
}
