package com.matthew.javabase.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 图片加水印处理方法
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-03-03 16:34
 */
public class ImageReamarkUtil {
    //水印透明度
    private static float alpha = 0.5f;
    //水印横向位置
    private static int positionWidth = 150;
    //水印纵向位置
    private static int positionHeight = 300;
    //水印文字字体
    private static Font font = new Font("宋体",Font.BOLD,72);
    //水印文字颜色
    private static Color color = Color.red;
    /**
     * 测试执行
     * @param args
     */
    public static void main(String[] args) {
        String iconPath = "F:\\srcIcon.jpg";
        String srcImagPath = "F:\\targetPic.jpg";
        String targetPath = "F:\\compositeImg.jpg";
        matkImageByIcon(iconPath,srcImagPath,targetPath);

    }

    /**
     * 给图片添加水印图片
     * @param iconPath 水印图片路径
     * @param srcImgPath 源图片路径
     * @param targetPath 目标图片路径
     */
    public static void matkImageByIcon(String iconPath,String srcImgPath,String targetPath){
        markImageByIcon(iconPath,srcImgPath,targetPath,null);
    }
    /**
     * 给图片添加水印图片，可设置水印图片旋转角度
     * @param iconPath  水印图片路径
     * @param srcImgPath 原图片路径
     * @param targetPath 目标图片路径
     * @param degree    水印图片旋转角度
     */
    public static void markImageByIcon(String iconPath,String srcImgPath,String targetPath,Integer degree){
        OutputStream os = null;
        try {
            Image srcImage = ImageIO.read(new File(srcImgPath));

            BufferedImage bufferedImage = new BufferedImage(srcImage.getWidth(null),srcImage.getHeight(null),BufferedImage.TYPE_INT_RGB);

            //1，得到画笔对象
            Graphics2D graphics2D = bufferedImage.createGraphics();
            //2，设置对线段的锯齿状边缘处理
            graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            graphics2D.drawImage(srcImage.getScaledInstance(
                    srcImage.getWidth(null),srcImage.getHeight(null),Image.SCALE_SMOOTH),
                    0,0,null);
            //3,设置水印旋转
            if(null!= degree){
                graphics2D.rotate(Math.toRadians(degree),
                        (double)bufferedImage.getWidth()/2,
                        (double)bufferedImage.getHeight()/2);
            }
            //4，水印图片的路径 水印图片一般存储为GIF或者png的，这样可以设置水印
            ImageIcon imageIcon = new ImageIcon(iconPath);
            //5,得到img对象
            Image img = imageIcon.getImage();
            graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
            //6，水印图片的位置
            graphics2D.drawImage(img,positionWidth,positionHeight,null);
            graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            //7，释放资源
            graphics2D.dispose();
            //8，生成图片
            os = new FileOutputStream(targetPath);
            ImageIO.write(bufferedImage,"JPG",os);
            System.out.println("图片完成添加水印图片");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(null != os)
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
