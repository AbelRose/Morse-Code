package com.abel.rose;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sun.audio.*;

public class TestSound extends JFrame implements ActionListener {

    JButton btnStart;
    JButton btnStop;

    AudioStream as;

    public static void main(String[] args) {
        new TestSound();
    }

    public TestSound() {

        FileInputStream fis;

        try {
            fis = new FileInputStream(".\\src\\main\\resources\\Noise.wav");                                                                     //似乎只能是AU格式的。反正mp3格式的不行。可以先下载下来mp3格式的，再用ESFAudioConventer这款小工具来转换
            as = new AudioStream(fis);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        JPanel contentPanel = new JPanel();

        setContentPane(contentPanel);

        btnStart = new JButton("Click here to start music");
        btnStart.setBounds(0, 0, 100, 50);

        contentPanel.add(btnStart);

        btnStart.addActionListener(this);

        btnStop = new JButton("Click here to stop the music");
        btnStop.setBounds(0, 100, 100, 50);

        contentPanel.add(btnStop);

        btnStop.addActionListener(this);

        setVisible(true);
        setBounds(500, 300, 500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnStart) {
            AudioPlayer.player.start(as);
        } else {
            AudioPlayer.player.stop(as);
        }
    }
}
