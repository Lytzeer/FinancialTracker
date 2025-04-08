package com.financialtracker.db;

import com.financialtracker.Revenus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RevenusDAO {
    public static void insertRevenus(Revenus revenus) {
        String insertRevenus = "INSERT INTO revenus(date, salary, helpers, self_enterprise, passive_income, other) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection connection = Database.connect()) {
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(insertRevenus);
            statement.setString(1, revenus.getPeriod());
            statement.setFloat(2, revenus.getSalary());
            statement.setFloat(3, revenus.getHelpers());
            statement.setFloat(4, revenus.getSelf_enterprise());
            statement.setFloat(5, revenus.getPassive_income());
            statement.setFloat(6, revenus.getOther());
            statement.executeUpdate();
        } catch (SQLException exception) {
            Logger.getAnonymousLogger().log(Level.SEVERE, LocalDateTime.now() + ": Could not insert revenus into database : "+ exception);
        }
    }

    public static List<Revenus> getRevenus() {
        String getRevenus = "SELECT * FROM revenus";
        List<Revenus> revenusList = new ArrayList<>();
        try (Connection connection = Database.connect()) {
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(getRevenus);
            statement.execute();
            var resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Revenus revenus = new Revenus();
                revenus.setPeriod(resultSet.getString("date"));
                revenus.setSalary(resultSet.getFloat("salary"));
                revenus.setHelpers(resultSet.getFloat("helpers"));
                revenus.setSelf_enterprise(resultSet.getFloat("self_enterprise"));
                revenus.setPassive_income(resultSet.getFloat("passive_income"));
                revenus.setOther(resultSet.getFloat("other"));
                revenusList.add(revenus);
            }
        } catch (SQLException exception) {
            Logger.getAnonymousLogger().log(Level.SEVERE, LocalDateTime.now() + ": Could not get revenus from database");
        }
        return revenusList;
    }
}
