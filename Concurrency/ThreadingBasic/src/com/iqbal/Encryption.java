package com.iqbal;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Encryption extends Thread {

    FileReader fileReader;
    FileWriter fileWriter;

    public Encryption(String fileName) {
        try {
            this.fileReader = new FileReader("original_files/" + fileName);
            this.fileWriter = new FileWriter("encrypted_files/" + fileName);
        } catch (IOException e) {
            System.out.println("File Not Specified!!");
        }
    }
    @Override
    public void run() {
        try {
            int currentLetter;
            while ((currentLetter = fileReader.read()) != -1) {
                if (currentLetter == 'z') {
                    fileWriter.append('a');
                } else if (currentLetter == 'Z') {
                    fileWriter.append(('A'));
                } else if (currentLetter == '\n' || currentLetter == '\r' || currentLetter == ' ') {
                    fileWriter.append((char) currentLetter);
                } else {
                    fileWriter.append((char) (currentLetter + 1));
                }
            }
            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
