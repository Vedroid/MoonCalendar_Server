package ua.vedroid.mooncalendar.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import ua.vedroid.mooncalendar.server.exception.DataProcessingException;
import ua.vedroid.mooncalendar.server.util.ConnectionUtil;

public class PersonalPredictionDao {
    public String getPrediction(int lunarDay) {
        String query = "SELECT * FROM personal_predictions WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, lunarDay);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return lunarDay + " ay günde doğmuş" + "\n\n"
                        + resultSet.getString("day_predict");
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Error retrieving prediction with id=" + lunarDay, e);
        }
        throw new NoSuchElementException("Prediction with id=" + lunarDay + " not found");
    }

    public String getZodiacInfo(int zodiacId) {
        String queryZodiac = ("select * from zodiac WHERE id = ?");
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(queryZodiac)) {
            statement.setInt(1, zodiacId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return "<b>" + resultSet.getString("zodiac") + "</b>" + "\n\n"
                        + resultSet.getString("zodiac_info");
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Error retrieving zodiac info with id="
                    + zodiacId, e);
        }
        throw new NoSuchElementException("Zodiac info with id=" + zodiacId + " not found");
    }
}
