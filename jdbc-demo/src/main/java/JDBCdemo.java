import java.sql.*;

public class JDBCdemo {
    private static final String URL = "jdbc:mysql://localhost:3306/college";
    private static final String USER = "root";
    private static final String PASSWORD = "tanu3456";

    public static void main(String[] args) {

        //this syntax automatically close the opened connection
        try(Connection conn = DriverManager.getConnection(URL , USER , PASSWORD)){
            System.out.println("connection established");
            insertStudent(conn , 18 , "virat");
            updateUser(conn , 45  , "salty");
            //delete(conn , 101);
            selectStudent(conn);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void insertStudent(Connection conn , int student_id , String name){
        String sql = " INSERT INTO student (student_id , name) VALUES ('"+student_id+"' , '"+name+"')";
        try(Statement stmt = conn.createStatement()){
            int rows = stmt.executeUpdate(sql);
            System.out.println("INSERTED :" + rows);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    private static void selectStudent(Connection conn){
        String sql = "SELECT * FROM STUDENT";
        try(Statement stmt = conn.createStatement()){
            ResultSet resultSet = stmt.executeQuery(sql);
            System.out.println("Student list :");
            while(resultSet.next()){
                int id = resultSet.getInt("student_id");
                String name = resultSet.getString("name");
                System.out.println(id + " : " + name);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    private static void updateUser(Connection conn , int student_id , String name){
        // String sql = "UPDATE student SET student_id = '"+student_id+"' , name = '"+name+"'WHERE student_id = "+student_id;
        String sql = "UPDATE student SET student_id = ? , name = ? WHERE student_id = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,student_id);
            pstmt.setString(2,name);
            pstmt.setInt(3,student_id );
            int rows = pstmt.executeUpdate();
            System.out.println("UPDATED :"+rows);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void delete(Connection conn , int student_id){
         String sql = "DELETE FROM STUDENT WHERE student_id = "+student_id;
         try(Statement stmt = conn.createStatement()){
             int rows = stmt.executeUpdate(sql);
             System.out.println("DELETED :"+rows);
         } catch (SQLException e){
             e.printStackTrace();
         }
    }

    //same code as above but manual closing
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(URL , USER , PASSWORD);
//            System.out.println("Connected to Database");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally{
//            try {
//                conn.close();
//                System.out.println("connection closed");
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
}
