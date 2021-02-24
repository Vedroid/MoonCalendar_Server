package ua.vedroid.mooncalendar.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import ua.vedroid.mooncalendar.server.exception.DataProcessingException;
import ua.vedroid.mooncalendar.server.model.LunarDay;
import ua.vedroid.mooncalendar.server.util.ConnectionUtil;

public class LunarDayDao {
    public LunarDay getLunarDayInfo(int dayId) {
        String query = "SELECT * FROM lunar_data WHERE day = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, dayId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new LunarDay(resultSet.getInt("lunar_day"),
                        resultSet.getString("moonrise"));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Error retrieving lunar day info with id="
                    + dayId, e);
        }
        throw new NoSuchElementException("Lunar day info with id=" + dayId + " not found");
    }
}
