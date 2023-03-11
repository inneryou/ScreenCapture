package com.turedurenaru;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// import application.utility.FileUtil;

public class ScreenCapture {

    public static void execute(String dirPath) {

        File dir = new File(dirPath);
        if(!dir.exists()) {
            dir.mkdir();
        }
        File file = FileUtil.createUniqueFile(dir, "capture.png");

        try {
            Robot robot = new Robot();
            Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenShot = robot.createScreenCapture(screenSize);
            ImageIO.write(screenShot, "png", file);
        } catch (Exception e) {
            System.out.println("キャプチャの取得に失敗しました。" + e.getMessage());
        }
        System.out.println("画面キャプチャを取得しました。" + "\r\n" + file.getPath());
    }
}