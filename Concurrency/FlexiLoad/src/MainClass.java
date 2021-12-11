import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {

    public static void main(String[] args) throws SQLException {
        Queue<FlexiLoadInfo> Q = new LinkedList<>();
        int threadNo = 100;
        //ReentrantLock rlock = new ReentrantLock();

        Object monitor = new Object();
        new FetchFlexiRequests(Q, monitor).start();

        for(int i=0; i< threadNo; i++) {
            new ExecuteSingleFlexiRequest(Q, monitor).start();
        }

        // Insert random data in db
        /*

        Connection connection = DBConnection.getConnection();
        Random random = new Random();

        for(int i = 0; i < 500000; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO flexiload_requests (Sender, Receiver, Amount)" +
                    "VALUES(?, ?, ?)");
            preparedStatement.setString(1, "019" + String.valueOf(random.nextInt(100000000)));
            preparedStatement.setString(2, "019" + String.valueOf(random.nextInt(100000000)));
            preparedStatement.setString(3, String.valueOf(random.nextInt(300)));

            preparedStatement.execute();
            preparedStatement.close();
        }
        connection.close();

        System.out.println("DONE>>>>");
         */

    }

}