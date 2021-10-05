package org.newjerry.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.newjerry.Dao.MessDao;
import org.newjerry.domain.Mess;
import org.newjerry.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("serial")
@Controller("messAction")
public class MessAction extends ActionSupport implements ModelDriven<Mess> {
	Mess mess = new Mess();
	@Autowired
	MessDao messDao;

	// 获取request
	public static HttpServletRequest getHttpServletRequest() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return request;
	}

	public Mess getModel() {
		// TODO Auto-generated method stub
		return mess;
	}
	public String addMes(){
		new TimeUtil();
		mess.setDate(TimeUtil.getStringDate());
		messDao.addMessage(mess);
		HttpServletRequest request = getHttpServletRequest();
		request.setAttribute("videoId", mess.getVid());
		return "success";
	}
	
}
