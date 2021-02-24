package ua.vedroid.mooncalendar.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import ua.vedroid.mooncalendar.server.exception.DataProcessingException;
import ua.vedroid.mooncalendar.server.util.ConnectionUtil;

public class PredictionDao {
    private static final String C1 = "Günün Özelliği";
    private static final String C2 = "Kişilik Üzerindeki Etkisi";
    private static final String C3 = "İş ve Para";
    private static final String C4 = "İlişkiler";
    private static final String C5 = "Sağlık";
    private static final String C6 = "Diyet";
    private static final String C7 = "Saç Kesimi";
    private static final String C8 = "Genel Öneriler";
    private static final String C9 = "Uyarılar";
    private static final String C10 = "Rüyalar";
    private static final String C11 = "Meditasyon";

    public String getPrediction(int dayId) {
        String query = "SELECT * FROM predictions WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, dayId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getPredictionFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Error retrieving prediction with id=" + dayId, e);
        }
        throw new NoSuchElementException("Prediction with id=" + dayId + " not found");
    }

    private String getPredictionFromResultSet(ResultSet resultSet) throws SQLException {
        return "<b>Bugün ayın " + resultSet.getString("id")
                + " günü" + "</b>" + "\n\n"
                + "<b>" + C1 + ":</b> " + resultSet.getString(C1) + "\n\n"
                + "<b>" + C2 + ":</b> " + resultSet.getString(C2) + "\n\n"
                + "<b>" + C3 + ":</b> " + resultSet.getString(C3) + "\n\n"
                + "<b>" + C4 + ":</b> " + resultSet.getString(C4) + "\n\n"
                + "<b>" + C5 + ":</b> " + resultSet.getString(C5) + "\n\n"
                + "<b>" + C6 + ":</b> " + resultSet.getString(C6) + "\n\n"
                + "<b>" + C7 + ":</b> " + resultSet.getString(C7) + "\n\n"
                + "<b>" + C8 + ":</b> " + resultSet.getString(C8) + "\n\n"
                + "<b>" + C9 + ":</b> " + resultSet.getString(C9) + "\n\n"
                + "<b>" + C10 + ":</b> " + resultSet.getString(C10) + "\n\n"
                + "<b>" + C11 + ":</b> " + resultSet.getString(C11);
    }
}
