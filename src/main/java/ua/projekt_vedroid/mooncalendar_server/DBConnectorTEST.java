package ua.projekt_vedroid.mooncalendar_server;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

import java.sql.*;

class DBConnectorTEST {

    //----- Настройки БД
    private static final String URL = "jdbc:mysql://localhost:3306/db_predict";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String TABLE = "lunar_data";
    //-----

    private int dayID;
    private String resQ = "";
    private int lunarDay = 0;
    private Connection currentConnect;


    DBConnectorTEST(int date) {
        try {
            dayID = date;
            initConnection();
            connect();
        } catch (CommunicationsException e) {
            System.err.println("DBConnectorTEST ::: No communication with the database.");
            System.err.println("DBConnectorTEST ::: CommunicationException: " + e.toString());
            resQ = "No communication with the database.";
        } catch (SQLException e) {
            System.err.println("DBConnectorTEST ::: SQLException: " + e.toString());
        } catch (Exception e) {
            System.err.println("DBConnectorTEST ::: Exception: " + e.toString());
        } finally {
            initDisconnection();
        }
    }

    private void initConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        currentConnect = DriverManager.getConnection(URL, USER, PASSWORD); //Коннект к БД
        System.out.println("DBConnectorTEST ::: Connected!");
    }

    private void connect() throws Exception {  //Медод для вывода Текста из БД
        Statement statement = currentConnect.createStatement();
        String query = ("select * from " + TABLE + " WHERE day =" + dayID);
        ResultSet resultQuery = statement.executeQuery(query);
        while (resultQuery.next()) {

            String day = resultQuery.getString("day");

            resQ = "";

            resQ = resQ + resultQuery.getString("moonrise");

            lunarDay = resultQuery.getInt("lunar_day");

            System.out.println("DBConnectorTEST ::: Resourses execute: " + resQ);
        }
    }

    private void initDisconnection() {
        if (currentConnect != null) {
            try {
                currentConnect.close();
                System.out.println("DBConnectorTEST ::: CurrentConnect close.\n");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    String getResQ() {
        return resQ;
    }

    int getLunarDay() {
        return lunarDay;
    }
}