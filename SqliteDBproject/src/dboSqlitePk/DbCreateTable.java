package dboSqlitePk;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbCreateTable extends DbConnection {
    public static void creatTable(String tableName) {
        Connection con = DbConnection.connect("test.db");
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            String sql = "CREATE TABLE  IF NOT EXISTS " +tableName+
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " SALARY         REAL)";



        stmt.executeUpdate(sql);
        stmt.close();
        con.close();
    }
    catch (SQLException e){
        System.out.println(e.getMessage());
    }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                }
                stmt = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqlEx) {
                }
                con = null;
            }

        }
}
}
