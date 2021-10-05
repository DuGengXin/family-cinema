package org.newjerry.Dao;

import java.util.List;

import org.newjerry.domain.Myfolder;
import org.newjerry.domain.Myvideo;

public interface MyFileDao {

	List<Myfolder> findAllfolders();

	Integer addFolder(Myfolder myfolder);

	Myvideo findVideoById(int id);
	
	Integer delFolderAndVideos(String id);
}
