package com.iqbal.ThreadJoin;

public class Runner {

    public void run() {
        FileDownloader dl1 = new FileDownloader("https://goo.gl/nqZJn4", "jugbd-meetup7_1.jpeg");
        FileDownloader dl2 = new FileDownloader("https://goo.gl/UoSMMt", "jugbd-meetup7_2.jpeg");

        DownloadingHeartBeat heartBeat = new DownloadingHeartBeat();

        dl1.start();
        dl2.start();
        heartBeat.start();

        try {
            dl1.join();
            dl2.join();

            heartBeat.shutdown();
            heartBeat.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Download finished!!");
    }
}
