import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RAccessFile {
    RandomAccessFile randomAccessFile;

    public RAccessFile(String fileName) {
        try {
            this.randomAccessFile = new RandomAccessFile("files/" + fileName, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void write() {
        try {
            this.randomAccessFile.writeBytes("\nPsychedelic\n");
            this.randomAccessFile.seek(512);        //skipping first 512
            this.randomAccessFile.writeBytes("\nSkipping 512 Bytes");
            this.randomAccessFile.writeInt(100);

            this.randomAccessFile.seek(512 + 2048);
            this.randomAccessFile.writeBytes("\nSkipping 2048 Bytes after last write");

            this.randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
