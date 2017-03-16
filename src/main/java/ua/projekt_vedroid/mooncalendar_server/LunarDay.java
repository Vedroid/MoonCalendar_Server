package ua.projekt_vedroid.mooncalendar_server;

class LunarDay {

    private static int lunarDay;

    static int get(int dayID) {

        System.out.println("LunarDay ::: ");

        try {
            DBConnectorTEST dbConnector = new DBConnectorTEST(dayID);

            lunarDay = dbConnector.getLunarDay();
            System.out.println("LunarDay ::: Lunar day is " + lunarDay);

        } catch (Exception e) {
            System.out.println("LunarDay ::: Exception: " + e.toString());
        }
        return lunarDay;
    }
}
