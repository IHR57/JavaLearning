import java.io.*;

public class BufferedIOStream {
    FileInputStream fis;
    FileOutputStream fos;

    // useful for reading single byte. show better performance for single byte reading and writing than file IO stream
    BufferedInputStream bis;
    BufferedOutputStream bos;

    public BufferedIOStream(String fileName) {
        try {
            this.fis = new FileInputStream("files/"+fileName);
            this.fos = new FileOutputStream("files/Copy_of_"+fileName);

            this.bis = new BufferedInputStream(new FileInputStream("files/"+fileName), 40960);
            this.bos = new BufferedOutputStream(new FileOutputStream("files/Copy_buffered_"+fileName), 40960);

        } catch (IOException e) {
            System.out.println("Specified File not found!");
        }
    }

    public void write() {
        int singleByte;
        try {
            long start = System.currentTimeMillis();

            while((singleByte = this.fis.read()) != -1) {
                this.fos.write(singleByte);
            }

            long end = System.currentTimeMillis();
            System.out.println("File I/O: "+ (end-start));

            start = System.currentTimeMillis();

            while((singleByte = this.bis.read()) != -1) {
                this.bos.write(singleByte);
            }

            end = System.currentTimeMillis();
            System.out.println("Buffered I/O: "+ (end-start));

            this.fis.close();
            this.fos.close();

            this.bis.close();
            this.bos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
