package com.yzm;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * @Description:
 * @Author :小书包
 * @CreateDate :2018-12-17 11:52
 */
public class bag {
    static Random random = new Random();
    final static int IMG_WIDTH = 300;// 定义图片的width
    final static int IMG_HEIGHT = 60;// 定义图片的height
    final static int CODE_COUNT = 4;// 定义图片上显示验证码的个数
    final static int X_OFFSET = IMG_WIDTH / CODE_COUNT;//X轴的偏移量
    final static int FONT_SIZE = IMG_WIDTH / 6;//字体大小
    final static int Y_OFFSET = FONT_SIZE - random.nextInt(IMG_HEIGHT - FONT_SIZE);//Y轴的偏移量
    final static char[] CODE_SEQUENCE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
    final static int DISTURB_LINE_NUM = 30;//干扰线条数

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        bag.random = random;
    }

    public int getImgWidth() {
        return IMG_WIDTH;
    }

    public int getImgHeight() {
        return IMG_HEIGHT;
    }

    public int getCodeCount() {
        return CODE_COUNT;
    }

    public int getxOffset() {
        return X_OFFSET;
    }

    public int getFontSize() {
        return FONT_SIZE;
    }

    public int getyOffset() {
        return Y_OFFSET;
    }

    public char[] getCodeSequence() {
        return CODE_SEQUENCE;
    }

    public int getDisturbLineNum() {
        return DISTURB_LINE_NUM;
    }

    /**
     * 初始化图像
     */
    public static Graphics initGraphics(BufferedImage buffImg) {
        // 定义图像
        Graphics gd = buffImg.getGraphics();
        // 将图像填充为白色
        gd.setColor(Color.WHITE);
        gd.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);

        // 创建字体，字体的大小应该根据图片的高度来定。
        Font font = new Font("Fixedsys", Font.BOLD, FONT_SIZE);
        // 设置字体。
        gd.setFont(font);

        // 画边框。
        gd.setColor(Color.BLACK);
        gd.drawRect(0, 0, IMG_WIDTH - 1, IMG_HEIGHT - 1);
        return gd;

    }

    /**
     * 绘制文本
     */
    public static char[] drawString(Graphics gd) {
        char[] code = new char[CODE_COUNT];
        // 随机产生codeCount数字的验证码。
        for (int i = 0; i < CODE_COUNT; i++) {
            // 得到随机产生的验证码数字。
            // 用随机产生的颜色将验证码绘制到图像中。
            gd.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            code[i] = CODE_SEQUENCE[random.nextInt(CODE_SEQUENCE.length)];
            gd.drawChars(code, i, 1, i * X_OFFSET, Y_OFFSET);
        }
        return code;
    }

    /**
     * 绘制干扰线条
     */
    public static void drawDisturbLines(Graphics gd) {
        Graphics2D graphics2D = (Graphics2D) gd;
        // 随机产生若干条干扰线，使图象中的认证码不易被其它程序探测到。
        for (int i = 0; i < DISTURB_LINE_NUM; i++) {
            //线条粗细
            graphics2D.setStroke(new BasicStroke(random.nextFloat() * 2));
            graphics2D.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            // 起始点位置，终止点位置
            graphics2D.drawLine(random.nextInt(IMG_WIDTH), random.nextInt(IMG_HEIGHT),
                    random.nextInt(IMG_WIDTH * 2), random.nextInt(IMG_HEIGHT * 2));
        }
    }

    /**
     * 保存图片到本地
     */
    public static void saveImg(BufferedImage buffImg, BufferedOutputStream out) {
//        File file = new File("D://img/" + System.currentTimeMillis() + ".png");
        String fileName = "yzm";
        File file = new File("D:/phpstudy_pro/WWW/carTest/web/img/" + fileName + ".png");
        File file2 = new File(String.valueOf(file));
        if(file2.exists()){
            if(file2.isFile()){
                file2.delete();
            }
        }
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        try {
            out = new BufferedOutputStream(new FileOutputStream(file));
            ImageIO.write(buffImg, "png", out);
        } catch (IOException e) {
            System.out.println("保存图片失败！");
        }

        File file3 = new File("D:/phpstudy_pro/WWW/carTest/out/artifacts/carTest_war_exploded/img/yzm.png");
        File file4 = new File(String.valueOf(file));
        if(file4.exists()){
            if(file4.isFile()){
                file4.delete();
            }
        }
        if (!file3.getParentFile().exists())
            file3.getParentFile().mkdirs();
        try {
            out = new BufferedOutputStream(new FileOutputStream(file3));
            ImageIO.write(buffImg, "png", out);
        } catch (IOException e) {
            System.out.println("保存图片失败！");
        }

    }

//    public static void main(String[] args) {
//        long startTime;
//        BufferedImage buffImg = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
//        BufferedOutputStream out = null;
//        Graphics gd;
//        startTime = System.currentTimeMillis();
//        gd = bag.initGraphics(buffImg);
//        System.out.println("初始化消耗了：" + (System.currentTimeMillis() - startTime) + "ms!");
//
//        startTime = System.currentTimeMillis();
//        drawDisturbLines(gd);
//        System.out.println("绘制干扰线条消耗了：" + (System.currentTimeMillis() - startTime) + "ms!");
//
//        startTime = System.currentTimeMillis();
//        char[] code = drawString(gd);
//        System.out.println("绘制" + new String(code) + "文本消耗了：" + (System.currentTimeMillis() - startTime) + "ms!");
//
//        startTime = System.currentTimeMillis();
//        saveImg(buffImg, out);
//        System.out.println("保存图片消耗了：" + (System.currentTimeMillis() - startTime) + "ms!");
//        for (int i = 0; i < 100; i++) {
//        }
//    }
}