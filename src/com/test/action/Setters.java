package com.test.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import com.test.calc.Calc;
import com.test.calc.CalculateByMatrix;
import com.test.city.City;

public class Setters {
	public String insCityData(List arr) throws SQLException {

		DBConn get = DBConn.getInstance();
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement select = null;
		PreparedStatement insert = null;
		CalculateByMatrix calc = new CalculateByMatrix();
		String log = "";
		try {
			conn = get.getConnection();
			int i = 0;
			while (i < arr.size()) {
				City city1 = (City) arr.get(i);
				City city2 = (City) arr.get(i + 1);
				int id1 = 0;
				int id2 = 0;
				Double dist = (Double) arr.get(i + 2);
				select = conn
						.prepareStatement("SELECT count( Name) as cnt FROM city where Name like ?");
				select.setString(1, city1.getName());
				result = select.executeQuery();
				result.first();
				if (result.getInt("cnt") == 0) {
					insert = conn
							.prepareStatement("insert into city (Name,Latitude,Longitude) values (?,?,?)");
					insert.setString(1, city1.getName());
					insert.setDouble(2, city1.getLatitude());
					insert.setDouble(3, city1.getLongitude());
					insert.executeUpdate();
					if (log.isEmpty()) {
						log = "Импортированы следующие города: "
								+ city1.getName();
					} else {
						log = log + ", " + city1.getName();
					}
				}

				select = conn
						.prepareStatement("SELECT count( Name) as cnt FROM city where Name like ?");
				select.setString(1, city2.getName());
				result.first();
				if (result.getInt("cnt") == 0) {
					insert = conn
							.prepareStatement("insert into city (Name,Latitude,Longitude) values (?,?,?)");
					insert.setString(1, city2.getName());
					insert.setDouble(2, city2.getLatitude());
					insert.setDouble(3, city2.getLongitude());
					insert.executeUpdate();
					if (log.isEmpty()) {
						log = "Импортированы следующие города: "
								+ city2.getName();
					} else {
						log = log + ", " + city2.getName();
					}

				}

				if (dist > 0) {
					if (calc.calculate(city1, city2) == 0d) {
						select = conn
								.prepareStatement("SELECT ID FROM city where Name like ?");
						select.setString(1, city1.getName());
						result = select.executeQuery();
						result.first();
						id1 = result.getInt("id");

						select = conn
								.prepareStatement("SELECT ID FROM city where Name like ?");
						select.setString(1, city2.getName());
						result = select.executeQuery();
						result.first();
						id2 = result.getInt("id");

						insert = conn
								.prepareStatement("insert into route (City1_ID,City2_ID,Distance) values (?,?,?)");
						insert.setInt(1, id1);
						insert.setInt(2, id2);
						insert.setDouble(3, dist);
						insert.executeUpdate();

					}
				}

				i = i + 3;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return log;

	}
}
