package ua.vedroid.mooncalendar.server.service;

import ua.vedroid.mooncalendar.server.dao.PersonalPredictionDao;
import ua.vedroid.mooncalendar.server.util.CalculationUtil;

public class PersonalPredictionService {
    public String getPrediction(int day, int month, int year) {
        return new PersonalPredictionDao()
                .getPrediction(CalculationUtil.calculationLunarDay(day, month, year));
    }

    public String getZodiacInfo(int day, int month, int year) {
        return new PersonalPredictionDao()
                .getZodiacInfo(CalculationUtil.calculationZodiac(day, month, year));
    }
}
