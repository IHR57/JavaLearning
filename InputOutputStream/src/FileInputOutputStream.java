import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStream {

    // used for byte input pictures, videos etc.
    FileInputStream fis;
    FileOutputStream fos;

    public FileInputOutputStream(String fileName) {
        try {
            this.fis = new FileInputStream("files/"+fileName);
            this.fos = new FileOutputStream("files/Copy_of_"+fileName);

        } catch (IOException e) {
            System.out.println("Specified File not found!");
        }
    }

    public void write() {
        byte[] bytes = new byte[4096];
        try {
            while(this.fis.read(bytes) != -1) {
                this.fos.write(bytes);
            }

            this.fis.close();
            this.fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
