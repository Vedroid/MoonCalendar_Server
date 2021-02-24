package ua.vedroid.mooncalendar.server.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import ua.vedroid.mooncalendar.server.dao.LunarDayDao;
import ua.vedroid.mooncalendar.server.model.LunarDay;

public class LunarDayService {
    private static final String PATTERN = "yyy-MM-dd HH:mm:ss.S";

    public int getLunarDay(int dayId) {
        return new LunarDayDao().getLunarDayInfo(dayId).getLunarDay();
    }

    public int getCurrentLunarDay() {
        LocalDateTime currentDate = LocalDateTime.now();
        LunarDayDao dao = new LunarDayDao();
        LunarDay lunarDayInfo;
        int day = 1;
        while (true) {
            lunarDayInfo = dao.getLunarDayInfo(day++);
            LocalDateTime date = LocalDateTime.parse(lunarDayInfo.getMoonrise(),
                    DateTimeFormatter.ofPattern(PATTERN));
            if (date.isAfter(currentDate)) {
                break;
            }
        }
        return lunarDayInfo.getLunarDay();
    }
}
