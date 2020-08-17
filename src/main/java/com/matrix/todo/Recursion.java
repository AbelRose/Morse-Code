package com.matrix.todo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Recursion {

    public static void main(String[] args) {

            writeFile("test");
    }


    public static void writeFile(String str) {

        try {
            File writeName = new File(".\\src\\main\\resources\\recursion.txt");
            writeName.createNewFile();
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                for (int i = 0; i < 100; i++) {
                    out.write(str + "\n");

                }
//                out.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
