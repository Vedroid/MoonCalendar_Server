package ua.vedroid.mooncalendar.server.model;

public class LunarDay {
    private final int lunarDay;
    private final String moonrise;

    public LunarDay(int lunarDay, String moonrise) {
        this.lunarDay = lunarDay;
        this.moonrise = moonrise;
    }

    public int getLunarDay() {
        return lunarDay;
    }

    public String getMoonrise() {
        return moonrise;
    }
}
