public class Main {
    public static  void main(String args[]) {
        // runBufferedReadWrite();
        // runFileInputOutputStream();
        // runBufferedInputOutputStream();
        // runRandomAccessFile();
        runObjectIOStream();
    }

    public static void runBufferedReadWrite() {
        BufferedReadWrite bufferedReadWrite = new BufferedReadWrite();
        bufferedReadWrite.readFile("test.txt");
        bufferedReadWrite.write();
    }

    public static void runFileInputOutputStream() {
        FileInputOutputStream fileInputOutputStream = new FileInputOutputStream("code_1.PNG");
        fileInputOutputStream.write();
    }

    public static void runBufferedInputOutputStream() {
        BufferedIOStream bufferedIOStream = new BufferedIOStream("code_1.PNG");
        bufferedIOStream.write();
    }

    public static void runRandomAccessFile() {
        RAccessFile rAccessFile = new RAccessFile("random_test.txt");
        rAccessFile.write();
    }

    public static void runObjectIOStream() {
        ObjectIOStream objectIOStream = new ObjectIOStream();
        objectIOStream.writeObj();
    }
}
