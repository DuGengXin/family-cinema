package org.newjerry.util.folders;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.newjerry.domain.Myfolder;

public class FolderUtil {
	//tomcat 映射文件目录
	private	static String TOMCATE_PATH=System.getProperty("catalina.home")+"\\conf\\Catalina\\localhost";
	//tomcat 视频缩略图目录
	private static String IMAGE_URL = System.getProperty("catalina.home")+ "\\webapps\\familyCinema\\image\\img";
	//	创建映射文件
	public String creatImgFolder(String folderName) {
		String path=IMAGE_URL+"\\"+folderName;
		File imgSourseUrl = new File(IMAGE_URL);
		File imgUrl = new File(path);
		if (!imgSourseUrl.exists()) {
			imgSourseUrl.mkdir();
		}
		if (!imgUrl.exists()) {
			imgUrl.mkdir();
		}
		return imgUrl.getAbsolutePath();
	}
	
	public String creatXmlPath(String url,String path) {
		//判断虚拟路径映射文件是否存在 不存在则创建 存在的跳出
		File file = new File(TOMCATE_PATH+"\\"+path+".xml");
		if (!file.exists()) {
			try {
				// 创建一个新文件
				file.createNewFile();
					System.out.println("映射文件创建成功！");
					//写入内容
					BufferedWriter writer = new BufferedWriter (new OutputStreamWriter (new FileOutputStream (file,true),"UTF-8"));
					writer.write("<Context docBase=\""+url+"\" reloadable=\"true\"/>");
					writer.close();
					
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("映射文件创建成功！");
				e.printStackTrace();
			}
		}else {
			System.out.println("映射文件已存在！");
		}
		//操作成功返回1;
		return file.getAbsolutePath();
	}
	//删除映射文件
	public int delXmlByFolder(Myfolder myfolder){
		File file=new File(myfolder.getXmlTrueUrl());
		if(file.exists()){
			file.delete();
			System.out.println("删除成功!");
		}else {
			System.out.println("删除失败!映射文件不存在");
			return 0;
		}
		//操作成功返回1;
		return 1;
	}
		//删除缩略图及其文件夹
	public int delImgByVideo(String ImgFolderTrueUrl) {
		 try {  
		        delAllFile(ImgFolderTrueUrl); //删除完里面所有内容  
		        String filePath = ImgFolderTrueUrl;  
		        filePath = filePath.toString();  
		        java.io.File myFilePath = new java.io.File(filePath);  
		        myFilePath.delete(); //删除空文件夹  
		     } catch (Exception e) {  
		       e.printStackTrace();   
		     }
		return 1;  
	}
	
	public boolean delAllFile(String path) {  
	       boolean flag = false;  
	       File file = new File(path);  
	       if (!file.exists()) {  
	         return flag;  
	       }  
	       if (!file.isDirectory()) {  
	         return flag;  
	       }  
	       String[] tempList = file.list();  
	       File temp = null;  
	       for (int i = 0; i < tempList.length; i++) {  
	          if (path.endsWith(File.separator)) {  
	             temp = new File(path + tempList[i]);  
	          } else {  
	              temp = new File(path + File.separator + tempList[i]);  
	          }  
	          if (temp.isFile()) {  
	             temp.delete();  
	          }  
	          if (temp.isDirectory()) {  
	             delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件  
	             delImgByVideo(path + "/" + tempList[i]);//再删除空文件夹  
	             flag = true;  
	          }  
	       }  
	       return flag;  
	  }
	
}
