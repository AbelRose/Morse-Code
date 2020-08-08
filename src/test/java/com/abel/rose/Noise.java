package com.abel.rose;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.InputStream;

public class Noise implements Runnable {
    @Override
    public void run() {
        try {

            InputStream short_in = new FileInputStream(".\\src\\main\\resources\\1.wav");//找到这个音乐文件
            InputStream long_in = new FileInputStream(".\\src\\main\\resources\\2.wav");//找到这个音乐文件

            AudioStream short_as = new AudioStream(short_in);
            AudioStream long_as = new AudioStream(long_in);

            AudioPlayer.player.start(short_as);// short
            Thread.sleep(2000);
            AudioPlayer.player.start(long_as);// long
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e);
        }
    }


    public static void main(String[] args) throws Exception {
//            System.out.println(Thread.currentThread().getName() + " " + i);
        Noise rtt = new Noise();
        new Thread(rtt, "新线程1").start();
        Thread.sleep(2000);
        new Thread(rtt, "新线程2").start();
        Thread.sleep(2000);
    }
}
