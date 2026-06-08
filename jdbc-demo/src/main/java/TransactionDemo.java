import java.sql.*;

public class TransactionDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/demo_db";
    private static final String USER = "root";
    private static final String PASSWORD = "tanu3456";

    public  static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(URL , USER , PASSWORD)){
            System.out.println("connection created");

            try{
                //no auto save
                conn.setAutoCommit(false);

                //insert into order
                int orderId = insertOrder(conn , 101 , "yuvraj" , 2309.38);

                //insert into order_item
                insertOrderItem(conn , orderId , "laptop01" , 1 , 2309.38);

                //manual commit
                conn.commit();
                System.out.println("transaction commited sucessfully");
            }catch (Exception e){
                e.printStackTrace();
                conn.rollback();
                System.out.println("operation rolled back");
            }finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void  insertOrderItem(Connection conn , int orderId , String product_name ,int quantity ,double price){
        String sql = "INSERT INTO order_items (order_id , product_name , quantity , price)" + " VALUES (? , ? , ? , ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, orderId);
            pstmt.setString(2, product_name);
            pstmt.setInt(3, quantity);
            pstmt.setDouble(4, price);

            // int x = 10/0;

            int rows = pstmt.executeUpdate();
            System.out.println("inserted into order items:" + rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int insertOrder(Connection conn, int user_id, String customer_name, double total_amount) {
        String sql = "INSERT INTO orders (user_id , customer_name , total_amount)" + " VALUES (? , ? , ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, user_id);
            pstmt.setString(2, customer_name);
            pstmt.setDouble(3, total_amount);
            int rows = pstmt.executeUpdate();
            System.out.println("inserted into orders :" + rows);

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int orderId = rs.getInt(1);
                    System.out.println("order id :" + orderId);
                    return orderId;
                } else {
                    throw new SQLException("order id not generated..");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
