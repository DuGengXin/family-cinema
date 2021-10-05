package org.newjerry.util.ffmpeg;

import java.util.ArrayList;
import java.util.List;

public class Commands {
    // 设置图片大小
    private final static String IMG_SIZE = "640x360";

    /**
     * 视频截图方法（windows） gif
     */
    public static List<String> cutVideoToGif(String videoPath, String imagePath, String timePoint) {
        List<String> commands = new ArrayList<String>();
        commands.add("-ss");
        commands.add(timePoint);// 这个参数是设置截取视频多少秒时的画面
        commands.add("-t");
        commands.add("14");
        commands.add("-i");
        commands.add(videoPath);
        commands.add("-s");
        commands.add(IMG_SIZE); // 这个参数是设置截取图片的大小
        commands.add("-r");
        commands.add("7");
        commands.add("-f");
        commands.add("gif");
        commands.add(imagePath);
        return commands;
    }
    //截取图片 png
    public static List<String> cutVideoToPng(String videoPath, String imagePath, String timePoint) {
        List<String> commands = new ArrayList<String>();
        commands.add("-ss");
        commands.add(timePoint);// 这个参数是设置截取视频多少秒时的画面
        commands.add("-i");
        commands.add(videoPath);
        commands.add("-vframes");
        commands.add("1");
        commands.add("-s");
        commands.add(IMG_SIZE); // 这个参数是设置截取图片的大小
        commands.add("-f");
        commands.add("image2");
        commands.add("-y");
        commands.add(imagePath);
        return commands;
    }

}
