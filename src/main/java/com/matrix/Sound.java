package com.matrix;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.*;

public class Sound {

    public static String readTxtFile(String filePath) throws Exception {
        String encoding = "UTF-8";
        File file = new File(filePath);
        if (file.isFile() && file.exists()) { //判断文件是否存在
            InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file), encoding);//考虑到编码格式
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
//                    System.out.println(lineTxt);
                return lineTxt;
            }
            read.close();
        } else {
//                System.out.println("找不到指定的文件");
            return "找不到指定的文件";
        }
        return "";
    }



    public static void main(String[] args) throws Exception {


//        InputStream short_in = new FileInputStream(".\\src\\main\\resources\\1.wav");//找到这个音乐文件
//        InputStream long_in = new FileInputStream(".\\src\\main\\resources\\2.wav");//找到这个音乐文件
//
//        AudioStream short_as = new AudioStream(short_in);
//        AudioStream long_as = new AudioStream(long_in);

        String res = readTxtFile(".\\src\\main\\resources\\out.txt");//．━ ━ ━ ━ | ．━ | ━ ．．．
//        System.out.println(res);
        char[] chars = res.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            InputStream short_in = new FileInputStream(".\\src\\main\\resources\\1.wav");//找到这个音乐文件
            InputStream long_in = new FileInputStream(".\\src\\main\\resources\\2.wav");//找到这个音乐文件

            AudioStream short_as = new AudioStream(short_in);
            AudioStream long_as = new AudioStream(long_in);

            System.out.print(chars[i]);
            if (chars[i] == '．'){
                AudioPlayer.player.start(short_as);// short
                Thread.sleep(300);
            }else if(chars[i] == '━'){
                AudioPlayer.player.start(long_as);// long
                Thread.sleep(300);
            }else {
//                System.out.println(" 不正确的格式 ");
                Thread.sleep(500);
            }
        }

//        AudioPlayer.player.start(as);// 开始dao播放
////        AudioPlayer.player.stop(as);
    }
}