package cn.gdpu.action;

import cn.gdpu.dao.UserDAO;
import cn.gdpu.vo.User;


import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class UserAction extends ActionSupport {

	private UserDAO userDAOIMP;

	private String username;
	private String password;

	@Override
	public String execute() throws Exception {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		boolean b = userDAOIMP.insertUser(user);
System.out.println(b);
		if (b)
			return SUCCESS;
		else
			return ERROR;
		
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserDAOIMP(UserDAO userDAOIMP) {
		this.userDAOIMP = userDAOIMP;
	}

}
