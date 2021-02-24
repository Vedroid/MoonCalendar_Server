package ua.vedroid.mooncalendar.server.util;

public class CalculationUtil {
    private static final int CALCULATION_CONSTANT = 2070;

    private static final int MARCH = 0;
    private static final int APRIL = 30;
    private static final int MAY = 60;
    private static final int JUNE = 90;
    private static final int JULY = 120;
    private static final int AUGUST = 150;
    private static final int SEPTEMBER = 180;
    private static final int OCTOBER = 210;
    private static final int NOVEMBER = 240;
    private static final int DECEMBER = 270;
    private static final int JANUARY = 300;
    private static final int FEBRUARY = 330;

    private CalculationUtil() {
    }

    public static int calculationZodiac(int day, int month, int year) {
        int lunarDay = calculationLunarDay(day, month, year);
        int moonDeviation = lunarDay * 12 - 5;
        int moonDegree = moonDeviation + calculationSunPosition(day, month);

        if (moonDegree > 360) {
            moonDegree = moonDegree - 360;
        }
        return (int) Math.ceil(moonDegree / 30.0);
    }

    public static int calculationLunarDay(int day, int month, int year) {
        int i = CALCULATION_CONSTANT;
        while (i > year) {
            i = i - 19;
        }
        int l = year - i;
        int lunarDay = (l * 11) - 14 + day + month;
        while (lunarDay > 30) {
            lunarDay = lunarDay - 30;
        }
        return lunarDay;
    }

    private static int calculationSunPosition(int day, int month) {
        switch (month) {
            case 1:
                return JANUARY + day - 21;
            case 2:
                return FEBRUARY + day - 20;
            case 3:
                return MARCH + day - 21;
            case 4:
                return APRIL + day - 21;
            case 5:
                return MAY + day - 20;
            case 6:
                return JUNE + day - 23;
            case 7:
                return JULY + day - 23;
            case 8:
                return AUGUST + day - 23;
            case 9:
                return SEPTEMBER + day - 22;
            case 10:
                return OCTOBER + day - 22;
            case 11:
                return NOVEMBER + day - 20;
            case 12:
                return DECEMBER + day - 19;
            default:
                throw new IllegalStateException("Unexpected value: " + month);
        }
    }
}
