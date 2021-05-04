package dboSqlitePk;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        //DbConnection.connect("test.db").close();

       /* DbCreateTable.creatTable();
        //DbReadNameColumns.readDbNameColumns();
        String[] a = DbGetNumberColumns.getNumberColumn();
        System.out.println("-----------------------");

        System.out.println(a[1]);*/

        //DbInsertDataToTable.insertDB();
        //DbReadNameColumns.readDbNameColumns("test.db","COMPANY");
        //String[] a = DbGetNameColumnsArray.nameColumnsArray("test.db","COMPANY");
        //System.out.println();
        //System.out.println(a[1]);
        DbReadFullTable.readFullTable("test.db","COMPANY");


    }
}
