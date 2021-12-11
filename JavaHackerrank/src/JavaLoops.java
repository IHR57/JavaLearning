import java.util.Scanner;

public class JavaLoops {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int currPow = 2;
            for(int j = 0; j < n; j++) {
                int ans = a + (currPow - 1) * b;
                System.out.print(ans + ((j == n - 1) ? "" : " "));
                currPow *= 2;
            }
            System.out.println();
        }
        in.close();
    }
}
