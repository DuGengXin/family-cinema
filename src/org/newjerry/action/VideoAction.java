package org.newjerry.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.newjerry.Dao.MessDao;
import org.newjerry.domain.Mess;
import org.newjerry.domain.Myfolder;
import org.newjerry.domain.Myvideo;
import org.newjerry.service.MyFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("videoAction")
public class VideoAction extends ActionSupport implements ModelDriven<Myfolder> {
	@Autowired
	MyFileService fileService;
	@Autowired
	MessDao messDao;
	
	
	Myfolder myfolder = new Myfolder();
	// 获取request
	public Myfolder getModel() {
		// TODO Auto-generated method stub
		return myfolder;
	}

	public static HttpServletRequest getHttpServletRequest() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return request;
	}

	public String findAll() {
		HttpServletRequest request = getHttpServletRequest();
		List<Myfolder> folderList = fileService.findAllfolders();
		HttpSession session = request.getSession();
		// 将查询的的视频及分类信息存入session域中
		session.setAttribute("folderList", folderList);
		session.removeAttribute("message");
		return "success";
	}

	public String addFolder() {
		HttpServletRequest request = getHttpServletRequest();
		HttpSession session = request.getSession();
		myfolder.setFolderPathUrl("/"+myfolder.getFolderName());
		Integer result = fileService.addFolder(myfolder);
		if (result != 0) {
			session.removeAttribute("message");
			return "findAll";
		} else {
			session.setAttribute("message", "当前分类已存在请重新输入！");
			return "faild";
		}
	}
	
	public String play() {
		HttpServletRequest request = getHttpServletRequest();
		String sId = request.getParameter("videoId");
		if(sId==null){
		 sId = request.getAttribute("videoId").toString();
		}
		int id = Integer.valueOf(sId);
		HttpSession session = request.getSession();
		Myvideo myvideo = fileService.findVideoById(id);
		session.setAttribute("video", myvideo);
		//查询留言
		List<Mess> allMessage = messDao.findAllMessage(id);
		session.setAttribute("allMessage", allMessage);
		return "play";
	}

	public String delFAV() {
		HttpServletRequest request = getHttpServletRequest();
		String id = request.getParameter("id");
		Integer result = fileService.delFolderAndVideos(id);
		if (result == 1) {
			return "findAll";
		} else {
			return "findAll";
		}
	}
}
