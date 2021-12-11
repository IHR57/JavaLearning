import java.util.Scanner;

public class JavaEof {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lineNo = 0;
        while(sc.hasNext()) {
            String str = sc.nextLine();
            System.out.println(++lineNo + " " + str);
        }
    }
}
