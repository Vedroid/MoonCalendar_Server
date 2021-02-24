package ua.vedroid.mooncalendar.server.service;

import ua.vedroid.mooncalendar.server.dao.PredictionDao;

public class PredictionService {
    public String getPrediction(int dayId) {
        return new PredictionDao().getPrediction(dayId);
    }
}
