package src.database;

import java.util.ArrayList;
import java.util.List;
import src.database.model.*;
import src.database.model.objects.*;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DataSourceThread extends Thread {

    Connection conn;
    Statement statement;
    ResultSet results;
    SQL_Constants constant = new SQL_Constants();

    public DataSourceThread() {
        run();
    }

    @Override
    public void run(){
        open();
    }

    public Boolean open(){
        // initiates SQL connection
        try {
            conn = DriverManager.getConnection(constant.dbPath());
            statement = conn.createStatement();
            System.out.println("SQL connection is open.");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
            System.out.println("Something went wrong during opening SQL connection.");
            return false;
        }
    }

    public void exit(){
        try {
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
            System.out.println("Something went wrong during closing SQL connection.");
        }
    }

    public void close(){
        try {
            if (results!=null){
                results.close();
            }
        }catch (SQLException e) {
            System.out.println("something went wrong during closnig SQLResultSet");
            e.getMessage();
            e.printStackTrace();
        }
        try {
            if (statement!=null){
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("something went wrong during closnig SQLStatement");
            e.getMessage();
            e.printStackTrace();
        }
    }


    public void testQueryReturns(){
        // System.out.println(dbstruct.CONNECTION_STRING());
        // System.out.println(dbstruct.createTable("contacts"));
        // System.out.println(dbstruct.selectContactRecords("'Oma'", "'112alarmcentrale'", "'grennie@gmail.com'"));
        // System.out.println(dbstruct.insertContactsRecords("'Oma'", "'112alarmcentrale'", "'grennie@gmail.com'"));
    }

    // statement.execute("CREATE TABLE IF NOT EXISTS contacts"+ "(name TEXT, phone TEXT, email TEXT)");
    // statement.execute("SELECT * FROM contacts");
    // ResultSet results = statement.getResultSet();


    public List<Wine> QueryWines(){

        try (Statement statement = conn.createStatement(); ResultSet results = statement.executeQuery("SELECT * FROM "+ constant.getWineTable());){
            
            List<Wine> wines = new ArrayList<>();
            while(results.next()){
                Wine wine = new Wine();
                wine.setWineId(results.getInt(constant.getIndexWineId()));
                wine.setWineGrape(results.getString(constant.getIndexWineGrape()));
                wine.setWineColor(results.getString(constant.getIndexWineColor()));
                wine.setWineTaste(results.getString(constant.getIndexWineTaste()));
                wine.setWineProducer(results.getInt(constant.getIndexWineProducer()));
                wines.add(wine);                
            }
            return wines;
        } catch (Exception e) {
            System.out.println("something went wrong during SQLquery: ");
            e.printStackTrace();
            e.getMessage();
            return null;
        }finally{
            close();
        }
    }


}
