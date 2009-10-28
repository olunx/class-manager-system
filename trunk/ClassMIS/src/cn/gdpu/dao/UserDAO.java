package cn.gdpu.dao;

import java.util.List;

import cn.gdpu.vo.User;

public interface UserDAO {
	
	boolean insertUser(User user);

	List<User> queryAll();
}
