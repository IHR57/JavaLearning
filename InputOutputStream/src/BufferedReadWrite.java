import java.io.*;

public class BufferedReadWrite {

    FileReader fileReader;
    FileWriter fileWriter;

    // useful for reading line instead of character
    BufferedReader br;
    PrintWriter pw;
    BufferedWriter bw;

    public void readFile(String fileName) {
        try {
            this.fileReader = new FileReader("files/" + fileName);
            this.fileWriter = new FileWriter("files/" +"out_" + fileName);

            this.br = new BufferedReader(fileReader);
            this.pw = new PrintWriter(new BufferedWriter(fileWriter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write() {
        String line;
        try {
            while((line = this.br.readLine()) != null) {
                long start = System.nanoTime();
                this.pw.println(line.toUpperCase());
                this.pw.println(line.toUpperCase());
                long end = System.nanoTime();
                System.out.println(end - start);
            }
            this.br.close();
            this.pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
