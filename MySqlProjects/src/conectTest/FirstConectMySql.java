package conectTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FirstConectMySql {

    public static void main(String[] args) throws Exception {


        //getConnection();
        //createTable();
        //post();
        get();
    }

    public static ArrayList<String> get() throws Exception {

        try{
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT firstName, lastName FROM names");

            ResultSet result = statement.executeQuery();

            ArrayList<String> array = new ArrayList<String>();
            while (result.next()){
                System.out.print(result.getString("firstName"));
                System.out.print(" ");
                System.out.println(result.getString("lastName"));

                array.add(result.getString("lastName"));
            }
            System.out.println("All record has been selected");
            return array;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;


    }



    public static void post() throws Exception {
        final String var1 = "John";
        final String var2 = "Miller";

        try{
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO names(firstName,lastName) VALUES ('"+var1+"', '"+var2+"')");
            posted.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Insert completed");
        }
    }


    public static void createTable() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS names(Id int NOT NULL AUTO_INCREMENT, firstName varchar(255), lastName varchar(255), PRIMARY KEY(Id) ) ");
            create.executeUpdate();

    }catch (Exception e){
            System.out.println(e.getMessage());}
        finally {
            System.out.println("Tabel has been created");
        }
    }


    public static Connection getConnection() throws Exception {
        try {

            //jdbc:mysql://localhost:3306/mysql
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/world?serverTimezone=UTC";
            String username = "maciejwolak";
            String password = "Iron0486.";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
            return conn;
        } catch (Exception e) { System.out.println(e.getMessage()+" Nie polaczono");}

        return null;
        }
    }
