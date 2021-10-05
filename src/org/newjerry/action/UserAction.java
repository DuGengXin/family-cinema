package org.newjerry.action;



import org.apache.struts2.ServletActionContext;
import org.newjerry.domain.Userinfo;
import org.newjerry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@Controller("userAction")
public class UserAction extends ActionSupport implements ModelDriven<Userinfo> {
	Userinfo user = new Userinfo();
	@Autowired
	UserService service;

	// 获取request
	public static HttpServletRequest getHttpServletRequest() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return request;
	}

	public Userinfo getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public String login() {
		Userinfo loginUser = service.login(user);
		HttpServletRequest request = getHttpServletRequest();
		HttpSession session = getHttpServletRequest().getSession();
		session.removeAttribute("loginUser");
		if (loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			return "success";
		} else {
			request.setAttribute("message", "登陆失败!账号或密码有误，请重试。");
			return "faild";
		}
	}

	public String register() {
		HttpServletRequest request = getHttpServletRequest();
		HttpSession session = getHttpServletRequest().getSession();
		int temp = service.addUser(user);
		if (temp > 0) {
			session.setAttribute("loginUser", user);
			return "success";
		} else {
			request.setAttribute("message", "注册失败!该用户名已存在。");
			return "faild";
		}
	}
}
