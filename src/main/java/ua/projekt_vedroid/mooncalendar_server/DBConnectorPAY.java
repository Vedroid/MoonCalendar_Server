package ua.projekt_vedroid.mooncalendar_server;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

import java.sql.*;

class DBConnectorPAY {

    //----- Настройки БД
    private static final String URL = "jdbc:mysql://localhost:3306/db_predict";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String TABLE = "birthday_table";
    private static final String TABLE1 = "zodiak";
    //-----

    private int dayID;
    private String resQ = "";
    private Connection currentConnect;

    private static final String C = "Zodiak";
    private static final String C1 = "Zodial_text";

    DBConnectorPAY(int numLB) {
        try {
            dayID = numLB;
            initConnection();
            connect();

        } catch (CommunicationsException e) {
            System.err.println("DBConnectorPAY ::: No communication with the database.");
            System.err.println("DBConnectorPAY ::: CommunicationException: " + e.toString());
            resQ = "No communication with the database.";
        } catch (SQLException e) {
            System.err.println("DBConnectorPAY ::: SQLException: " + e.toString());
        } catch (Exception e) {
            System.err.println("DBConnectorPAY ::: Exception: " + e.toString());
        } finally {
            initDisconnection();
        }
    }

    private void initConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        currentConnect = DriverManager.getConnection(URL, USER, PASSWORD); //Коннект к БД
        System.out.println("DBConnectorPAY ::: Connected!");
    }

    private void connect() throws Exception {  //Медод для вывода Текста из БД
        Calculation calculation = new Calculation();
        int IDZ = calculation.calculationZodiak();
        Statement statement = currentConnect.createStatement();

        String query = ("select * from " + TABLE + " WHERE ID_DAY =" + dayID);
        ResultSet resultQuery = statement.executeQuery(query);
        while (resultQuery.next()) {
            resQ = "";

            resQ = resQ + dayID + " ay günde doğmuş" + "\n\n";
            resQ = resQ + resultQuery.getString("Day_predict");

            System.out.println("DBConnectorPAY ::: Resourses execute.");
        }

        String queryZodiak = ("select * from " + TABLE1 + " WHERE ID =" + IDZ);
        ResultSet resultQueryZodiak = statement.executeQuery(queryZodiak);
        while (resultQueryZodiak.next()) {
            resQ = resQ + "\n\n<b>" + "" + "</b>";
            resQ = resQ + "<b>" + resultQueryZodiak.getString(C) + "</b>";

            resQ = resQ + "\n\n<b>" + "" + "</b>";
            resQ = resQ + resultQueryZodiak.getString(C1);
        }
    }

    private void initDisconnection() {
        if (currentConnect != null) {
            try {
                currentConnect.close();
                System.out.println("DBConnectorPAY ::: CurrentConnect close.\n");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    String getResQ() {
        return resQ;
    }
}