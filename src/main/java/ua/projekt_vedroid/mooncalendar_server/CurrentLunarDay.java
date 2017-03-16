package ua.projekt_vedroid.mooncalendar_server;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentLunarDay extends Thread {

    static int currentLunarDay;
    static int currentDayID;
    static boolean isStarted = false;

    private DBConnectorTEST dbConnector;
    private LocalDateTime currentDate = LocalDateTime.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
    private String pattern = "yyy-MM-dd HH:mm:ss.S";
    private int day = 1;

    public void run() {

        System.out.println("CurrentLunarDay ::: Current Date is " + currentDate);

        try {
            while (true) {
                isStarted = false;
                currentDate = LocalDateTime.now();

                while (true) {                                      // Магия. Не трогать.
                    day++;
                    dbConnector = new DBConnectorTEST(day);

                    LocalDateTime date = LocalDateTime.parse(dbConnector.getResQ(),
                            DateTimeFormatter.ofPattern(pattern));

                    if (date.isAfter(currentDate)) {
                        day--;
                        break;
                    }
                }

                dbConnector = new DBConnectorTEST(day);
                currentDayID = day;
                currentLunarDay = dbConnector.getLunarDay();
                System.out.println(currentLunarDay);
                isStarted = true;

                try {
                    Thread.sleep(3 * 1000);
                } catch (InterruptedException e) {
                    System.out.println("CurrentLunarDay ::: InterruptedException: " + e.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("CurrentLunarDay ::: Exception: " + e.toString());
        }
    }
}
