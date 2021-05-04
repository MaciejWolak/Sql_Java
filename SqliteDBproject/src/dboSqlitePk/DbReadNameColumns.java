package dboSqlitePk;

import java.sql.*;

public class DbReadNameColumns {

    public static void readDbNameColumns(String dbName, String tableName) {
        Connection con = DbConnection.connect(dbName);
        ResultSet rs = null;
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM "+tableName);
            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = metadata.getColumnCount();
            String[] nameArray = new String[columnCount];

            System.out.println("test_table columns : ");

            for (int i = 1; i <= columnCount; i++) {
                String columnName = metadata.getColumnName(i);
                nameArray[i-1] = metadata.getColumnName(i);
            }

            for (String e:nameArray) {
                System.out.print(e+" | ");
            }



        } catch (SQLException e) {
            System.out.println("Could not retrieve database metadata " + e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEX) {
                }
                rs = null;
            }
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


