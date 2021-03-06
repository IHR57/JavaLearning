import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class ExecuteSingleFlexiRequest extends Thread {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    int fetchSize = 5000;
    Queue<FlexiLoadInfo> Q;
    Object monitor;

    public  ExecuteSingleFlexiRequest(Queue<FlexiLoadInfo> Q, Object monitor) {
        this.Q = Q;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while(true) {
            if(Q.isEmpty()) {
                try {
                    Thread.sleep(100);
                    continue;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            FlexiLoadInfo flexiloadInfo;

            synchronized (monitor) {
                flexiloadInfo = Q.poll();
            }

            if(flexiloadInfo != null) {
                this.singleFlexiTransaction(flexiloadInfo);
            }
        }
    }

    public void singleFlexiTransaction(FlexiLoadInfo flexiloadInfo) {
        String flexiStatus = this.sendAmountTransaction(flexiloadInfo);
        flexiloadInfo.setStatus(flexiStatus);

        this.updateStatus(flexiloadInfo);
    }

    public String sendAmountTransaction(FlexiLoadInfo flexiloadInfo) {
        // just applying some delay for the transaction

        try {
            Thread.sleep(new Random().nextInt(50)+50);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    public boolean updateStatus(FlexiLoadInfo flexiloadInfo) {
        System.out.println(flexiloadInfo.getId()+" - "+flexiloadInfo.getStatus());
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE flexiload_requests " +
                    "SET `Status`= ?, updated_at= NOW() WHERE id = ? ");
            preparedStatement.setString(1, flexiloadInfo.getStatus());
            preparedStatement.setInt(2, flexiloadInfo.getId());
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}