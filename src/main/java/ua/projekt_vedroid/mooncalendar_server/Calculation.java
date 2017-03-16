package ua.projekt_vedroid.mooncalendar_server;

class Calculation {

    private final static int c = 2070; // Constant

    private static int d;              // Day of the month
    private static int m;              // Serial number of the month
    private static int y;              // Year

    private static int march = 0;
    private static int aprel = 30;
    private static int may = 60;
    private static int iun = 90;
    private static int iul = 120;
    private static int avgust = 150;
    private static int sentabr = 180;
    private static int oktbr = 210;
    private static int noyabr = 240;
    private static int dekabr = 270;
    private static int yanvar = 300;
    private static int fevral = 330;

    static String setData(int d, int m, int y) {
        Calculation.d = d;
        Calculation.m = m;
        Calculation.y = y;


        DBConnectorPAY dbc = new DBConnectorPAY(calculationLunarDate());

        return dbc.getResQ();
    }

    private static int calculationLunarDate() {
        int i = c;

        while (i > y) {
            i = i - 19;
        }
        int l = y - i;
        int n = (l * 11) - 14 + d + m;

        while (n > 30) {
            n = n - 30;
        }
        return n;
    }

    int calculationZodiak() {
        int SUN = 0;
        int id = 0;
        if (m == 1) {
            SUN = yanvar + d - 21;
            System.out.println("SUN = " + SUN);
        }
        if (m == 2) {
            SUN = fevral + d - 20;
            System.out.println("SUN = " + SUN);
        }
        if (m == 3) {
            SUN = march + d - 21;
            System.out.println("SUN = " + SUN);
        }
        if (m == 4) {
            SUN = aprel + d - 21;
            System.out.println("SUN = " + SUN);
        }
        if (m == 5) {
            SUN = may + d - 20;
            System.out.println("SUN = " + SUN);
        }
        if (m == 6) {
            SUN = iun + d - 23;
            System.out.println("SUN = " + SUN);
        }
        if (m == 7) {
            SUN = iul + d - 23;
            System.out.println("SUN = " + SUN);
        }
        if (m == 8) {
            SUN = avgust + d - 23;
            System.out.println("SUN = " + SUN);
        }
        if (m == 9) {
            SUN = sentabr + d - 22;
            System.out.println("SUN = " + SUN);
        }
        if (m == 10) {
            SUN = oktbr + d - 22;
            System.out.println("SUN = " + SUN);
        }
        if (m == 11) {
            SUN = noyabr + d - 20;
            System.out.println("SUN = " + SUN);
        }
        if (m == 12) {
            SUN = dekabr + d - 19;
            System.out.println("SUN = " + SUN);
        }
        int i = c;
        while (i > y) {
            i = i - 19;
        }
        int l = y - i;
        int n = (l * 11) - 14 + d + m;

        while (n > 30) {
            n = n - 30;
        }
        int moon_otkloneie = n * 12 - 5;
        int moon_degree = moon_otkloneie + SUN;

        if (moon_degree > 360) {
            moon_degree = moon_degree - 360;
        }
        System.out.println("Градус = " + moon_degree);

        if (moon_degree <= 30) {
            id = 1;
        }
        if (60 >= moon_degree && moon_degree > 30) {
            id = 2;
        }
        if (moon_degree > 60 && 90 >= moon_degree) {
            id = 3;
        }
        if (moon_degree > 90 && 120 >= moon_degree) {
            id = 4;
        }
        if (moon_degree > 120 && 150 >= moon_degree) {
            id = 5;
        }
        if (moon_degree > 150 && 180 >= moon_degree) {
            id = 6;
        }
        if (moon_degree > 180 && 210 >= moon_degree) {
            id = 7;
        }
        if (moon_degree > 210 && 240 >= moon_degree) {
            id = 8;
        }
        if (moon_degree > 240 && 270 >= moon_degree) {
            id = 9;
        }
        if (moon_degree > 270 && 300 >= moon_degree) {
            id = 10;
        }
        if (moon_degree > 300 && 330 >= moon_degree) {
            id = 11;
        }
        if (moon_degree > 330 && 360 >= moon_degree) {
            id = 12;
        }

        return id;
    }
}
