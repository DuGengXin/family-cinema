package org.newjerry.Dao;

import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.newjerry.domain.Myfolder;
import org.newjerry.domain.Myvideo;
import org.newjerry.util.folders.FolderUtil;
import org.newjerry.util.folders.videos.VideoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("myFileDao")
public class MyFileDaoImpl implements MyFileDao {
    @Autowired
    private HibernateTemplate template;
    
    // 查找数据库中所有的视频分类信息
    public List<Myfolder> findAllfolders() {
        Session session = template.getSessionFactory().openSession();
        Query query = session.createQuery("from Myfolder");
        @SuppressWarnings("unchecked")
        List<Myfolder> list = query.list();
        session.close();
        return list;
    }

    // 根据分类名查找数据库中的分类信息
    public Myfolder findFolderByName(String folderName) {
        Myfolder myfolder =null;
        Session session = template.getSessionFactory().openSession();
        Query query = session.createQuery("from Myfolder where folderName=:name");
        query.setString("name", folderName);
        @SuppressWarnings("unchecked")
        List<Myfolder> list = query.list();
        if (list.size() != 0) {
            myfolder = list.get(0);
        }
        session.close();
        return myfolder;

    }

    /*
     * @see org.newjerry.Dao.MyFileDao#addFolder(org.newjerry.domain.Myfolder)
     * 1.建立虚拟路径映射文件
     * 2.初步查询相关信息进行初步保存
     * 3.二次查询已保存的信息并对视频进行缩略图生成,最后对数据库进行更新
     */
    public Integer addFolder(Myfolder myfolder) {
    	
        Session session = template.getSessionFactory().openSession();
        // 查询是否已存在该分类
        if (findFolderByName(myfolder.getFolderName()) == null) {
            //生成tomcat映射文件
            String xmlPath = new FolderUtil().creatXmlPath(myfolder.getFolderTrueUrl(), myfolder.getFolderName());
            //生成缩略图源文件
            String imgFolder = new FolderUtil().creatImgFolder(myfolder.getFolderName());
            //查找相应的视频文件
            List<Myvideo> findVideos = new VideoUtil().findVideos(myfolder);

            // 写入实体类
            myfolder.setXmlTrueUrl(xmlPath);
            myfolder.setImgFolderTrueUrl(imgFolder);
            myfolder.setImgFolderPathUrl("image/img/"+myfolder.getFolderName()+"/");
            myfolder.setMyvideos(new HashSet<Myvideo>(findVideos));

            //第一次级联保存 使video自生成id
            Transaction transaction = session.beginTransaction();
            session.save(myfolder);
            transaction.commit();
            //关闭session
            session.close();
            /**
             * 创建相应的视频缩略图
             */
            //第二次查询获得已保存的信息
            //重新开启session
            Session session2 = template.getSessionFactory().openSession();
            Myfolder folder = findFolderByName(myfolder.getFolderName());
            //调用videoUtil 先调用 后删除
            List<Myvideo> myvideos = new VideoUtil().creatImg(folder);
            // 更新已保存的信息 1.将当前实体中的videos 删除 2.将重新生成的videos 写入 最后调用session更新信息
            folder.getMyvideos().remove(Myvideo.class);
            folder.setMyvideos(new HashSet<Myvideo>(myvideos));
            Transaction transaction1 = session2.beginTransaction();
            session2.update(folder);
            transaction1.commit();
            // 操做结束关闭session
            session2.close();
        } else {
            session.close();
            System.out.println("该分类已存在请更换分类名称！");
            return 0;
        }
        // 操作成功返回1
        return 1;
    }


    public Myvideo findVideoById(int id) {
        Session session = template.getSessionFactory().openSession();
        Query query = session.createQuery("from Myvideo where id=:id");
        query.setString("id", id + "");
        List<Myvideo> list = query.list();
        session.close();
        return list.get(0);
    }
    public Integer delFolderAndVideos(String id) {
        //先在数据库中查找此视频源文件夹并创建实体
        Session session = template.getSessionFactory().openSession();
        Query query = session.createQuery("from Myfolder where id=:id");
        @SuppressWarnings("unchecked")
        List<Myfolder> list = query.setString("id", id).list();
        Myfolder myfolder = list.get(0);
        //删除相应的映射文件
        new FolderUtil().delXmlByFolder(myfolder);
        //删除缩略图文件
        new FolderUtil().delImgByVideo(myfolder.getImgFolderTrueUrl());
        //级联删除表信息
        Transaction transaction = session.beginTransaction();
        try {
            //完成操作，判断结果，关闭session
            session.delete(myfolder);
            transaction.commit();
        } catch (Exception e) {
            //出现异常 返回0 删除失败
            return 0;
        } finally {
            session.close();
        }
        //操作成功 返回1 删除成功
        return 1;
    }


}
