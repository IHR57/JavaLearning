package com.iqbal.ThreadJoin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileDownloader extends Thread{

    private String url;
    private String fileName;

    public FileDownloader(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            System.out.println("Started to download " + fileName);
            URL resourceToDownload = new URL(url);
            URLConnection urlConnection = resourceToDownload.openConnection();
            InputStream inputStream = urlConnection.getInputStream();

            File fileToSave = new File(fileName);
            Files.copy(inputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
