package dboSqlitePk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbInsertDataToTable {
public static void insertDB() throws SQLException {
    Connection con = DbConnection.connect("test.db");
    PreparedStatement ps = null;
    String[] nameColumns = DbGetNameColumnsArray.nameColumnsArray("test.db","COMPANY");
    StringBuilder x = new StringBuilder();
    String y = "";

    try {

        for (int i = 1; i <= nameColumns.length; i++) {
            x.append(nameColumns[i - 1]);
            y+="24";
            if(i<nameColumns.length) {
                x.append(",");
                y += ", ";
            }
        }
        String sql = "INSERT INTO COMPANY ("+x+") VALUES("+y+") ";
        System.out.println(y);
        System.out.println(x);
        System.out.println(sql);
        ps = con.prepareStatement(sql);
        ps.execute();
        System.out.println("done");


    }
    catch (SQLException e){
        System.out.println(e.getMessage());
    }
    finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException sqlEX) {
            }
            ps = null;
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
