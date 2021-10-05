package org.newjerry.util.folders.videos;

import org.newjerry.domain.Myfolder;
import org.newjerry.domain.Myvideo;
import org.newjerry.util.ffmpeg.Commands;
import org.newjerry.util.ffmpeg.FfmpegUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VideoUtil {

    public List<Myvideo> findVideos(Myfolder folder) {
        // 视频实体集合
        List<Myvideo> videoList = new ArrayList<Myvideo>();
        // 视频源文件夹实体
        File file = new File(folder.getFolderTrueUrl());
        // 拟视频文件数组
        File[] listFiles = file.listFiles();
        for (File file2 : listFiles) {
            // 判断该文件是否为所要的文件类型
            if (file2.getName().endsWith(".mp4")
                    || file2.getName().endsWith(".mkv")
                    || file2.getName().endsWith(".ogg")
                    || file2.getName().endsWith(".webm")) {
                Myvideo myvideo = new Myvideo();
                // 将视频绝对路径写入实体中
                myvideo.setVideoTrueUrl(file2.getAbsolutePath());
                // 生成视频虚拟路径并写入
                myvideo.setVideoPathUrl(folder.getFolderPathUrl() + "/"
                        + file2.getName());
                // 对视频名进行处理（删除后4位）并写入
                myvideo.setVideoName(file2.getName().substring(0,
                        file2.getName().length() - 4));
                // 将类别写入实体中
                myvideo.setMyfolder(folder);
                // 将已补充完整的实体添加到集合中
                videoList.add(myvideo);
            } else {
                continue;
            }
        }
        return videoList;
    }

    public List<Myvideo> creatImg(Myfolder folder) {
        List<Myvideo> videoList = new ArrayList<Myvideo>();
        for (Myvideo myvideo : folder.getMyvideos()) {
            // 拟创建视频缩略图路径
            myvideo.setImgTrueUrl(folder.getImgFolderTrueUrl() + "\\" +"v" + myvideo.getId());
            myvideo.setImgPathUrl(folder.getImgFolderPathUrl() +"v" + myvideo.getId());
            /**
             * 缩略图生成
             * 1.查看要生成的缩略图文件是否存在
             * 2.若该缩略图存在则跳过，若不存则调用ffmpegUtil创建
             */
            // 2------
            File imgPathUrl = new File(myvideo.getImgTrueUrl() + ".gif");
            if (!imgPathUrl.exists()) {
                FfmpegUtil.executeCommand(Commands.cutVideoToGif(myvideo.getVideoTrueUrl(),imgPathUrl.getAbsolutePath(),"180"));
            } else {
                System.out.println(myvideo.getVideoName() + ".gif已存在");
            }
           File imgPathUrl2 = new File(myvideo.getImgTrueUrl() + ".png");
            if (!imgPathUrl2.exists()) {
                FfmpegUtil.executeCommand(Commands.cutVideoToPng(myvideo.getVideoTrueUrl(), imgPathUrl2.getAbsolutePath(), "180"));
            } else {
                System.out.println(myvideo.getVideoName() + ".png已存在");
            }
            videoList.add(myvideo);
        }
        return videoList;
    }

}
