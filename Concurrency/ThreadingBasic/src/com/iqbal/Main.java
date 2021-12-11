package com.iqbal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {
        File directory = new File("original_files");
        FileWriter fileWriter = null;

        fileWriter = new FileWriter("concurrent_runtime.txt", true);

        if(directory.isDirectory()) {
            List<Encryption> threadObjList = new LinkedList<Encryption>();

            long startTime = System.currentTimeMillis();
            for(File file: Objects.requireNonNull(directory.listFiles())) {
                Encryption encryption = new Encryption(file.getName());
                encryption.start();
                threadObjList.add(encryption);
            }

            for(Encryption enc: threadObjList) {
                try {
                    enc.join();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }

            long endTime = System.currentTimeMillis();
            System.out.println("DONE___");
            fileWriter.write((endTime - startTime) / 1000.0 + "\n");
            fileWriter.close();
        }
    }
}
