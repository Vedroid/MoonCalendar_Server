package ua.projekt_vedroid.mooncalendar_server;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

import java.sql.*;

class DBConnectorDAY {

    //----- Настройки БД
    private static final String URL = "jdbc:mysql://localhost:3306/db_predict";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String TABLE = "db_predict";
    //-----

    private static final String C = "Lunar day";
    private static final String C1 = "Günün Özelliği";
    private static final String C2 = "Kişilik Üzerindeki Etkisi";
    private static final String C3 = "İş ve Para";
    private static final String C4 = "İlişkiler";
    private static final String C5 = "Sağlık";
    private static final String C6 = "Diyet";
    private static final String C7 = "Saç Kesimi";
    private static final String C8 = "Genel Öneriler";
    private static final String C9 = "Uyarılar";
    private static final String C10 = "Rüyalar";
    private static final String C11 = "Meditasyon";

    private int dayID;
    private String resQ = "";
    private Connection currentConnect;

    DBConnectorDAY(int date) {
        try {
            dayID = date;
            initConnection();
            connect();
        } catch (CommunicationsException e) {
            System.err.println("DBConnectorDAY ::: No communication with the database.");
            System.err.println("DBConnectorDAY ::: CommunicationException: " + e.toString());
            resQ = "No communication with the database.";
        } catch (SQLException e) {
            System.err.println("DBConnectorDAY ::: SQLException: " + e.toString());
        } catch (Exception e) {
            System.err.println("DBConnectorDAY ::: Exception: " + e.toString());
        } finally {
            initDisconnection();
        }
    }

    private void initConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        currentConnect = DriverManager.getConnection(URL, USER, PASSWORD); //Коннект к БД
        System.out.println("DBConnectorDAY ::: Connected!");
    }

    private void connect() throws Exception {  //Медод для вывода Текста из БД
        Statement statement = currentConnect.createStatement();
        String query = ("select * from " + TABLE + " WHERE id_day =" + dayID);
        ResultSet resultQuery = statement.executeQuery(query);
        while (resultQuery.next()) {

            String day = resultQuery.getString("id_Day");

            resQ = "";

            resQ = resQ + "<b>" + "Bugün ayın " + day + " günü" + "</b>";

            resQ = resQ + "\n\n<b>" + C1 + ":</b> ";
            resQ = resQ + resultQuery.getString(C1);

            resQ = resQ + "\n\n<b>" + C2 + ":</b> ";
            resQ = resQ + resultQuery.getString(C2);

            resQ = resQ + "\n\n<b>" + C3 + ":</b> ";
            resQ = resQ + resultQuery.getString(C3);

            resQ = resQ + "\n\n<b>" + C4 + ":</b> ";
            resQ = resQ + resultQuery.getString(C4);

            resQ = resQ + "\n\n<b>" + C5 + ":</b> ";
            resQ = resQ + resultQuery.getString(C5);

            resQ = resQ + "\n\n<b>" + C6 + ":</b> ";
            resQ = resQ + resultQuery.getString(C6);

            resQ = resQ + "\n\n<b>" + C7 + ":</b> ";
            resQ = resQ + resultQuery.getString(C7);

            resQ = resQ + "\n\n<b>" + C8 + ":</b> ";
            resQ = resQ + resultQuery.getString(C8);

            resQ = resQ + "\n\n<b>" + C9 + ":</b> ";
            resQ = resQ + resultQuery.getString(C9);

            resQ = resQ + "\n\n<b>" + C10 + ":</b> ";
            resQ = resQ + resultQuery.getString(C10);

            resQ = resQ + "\n\n<b>" + C11 + ":</b> ";
            resQ = resQ + resultQuery.getString(C11);

            System.out.println("DBConnectorDAY ::: Resourses execute.");
        }
    }

    private void initDisconnection() {
        if (currentConnect != null) {
            try {
                currentConnect.close();
                System.out.println("DBConnectorDAY ::: CurrentConnect close.\n");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    String getResQ() {
        return resQ;
    }
}