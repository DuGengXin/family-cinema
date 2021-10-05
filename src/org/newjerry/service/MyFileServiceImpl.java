package org.newjerry.service;

import java.util.List;

import org.newjerry.Dao.MyFileDao;
import org.newjerry.domain.Myfolder;
import org.newjerry.domain.Myvideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("myFileService")
public class MyFileServiceImpl implements MyFileService {
	@Autowired
	MyFileDao fileDao;

	public List<Myfolder> findAllfolders() {
		// TODO Auto-generated method stub
		return fileDao.findAllfolders();
	}

	public Integer addFolder(Myfolder myfolder) {
		// TODO Auto-generated method stub
		return fileDao.addFolder(myfolder);
	}

	public Myvideo findVideoById(int id) {
		// TODO Auto-generated method stub
		return fileDao.findVideoById(id);
	}

	public Integer delFolderAndVideos(String id) {
		// TODO Auto-generated method stub
		return fileDao.delFolderAndVideos(id);
	}

}
