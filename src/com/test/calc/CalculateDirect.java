package com.test.calc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;
import com.test.city.City;
import com.test.action.DBConn;
import java.math.*;

public class CalculateDirect implements Calc {

	@Override
	public double calculate(City cit1, City cit2) throws SQLException {
		DBConn get = DBConn.getInstance();
		Double res = 0d;
		Double midres1 = 0d;
		Double midres2 = 0d;
		Connection conn = null;
		ResultSet result1 = null;
		ResultSet result2 = null;
		Double lon1 = 0d;
		Double lat1 = 0d;
		Double lat2 = 0d;
		Double lon2 = 0d;
		java.sql.PreparedStatement select = null;
		java.sql.PreparedStatement select2 = null;
		double R = 3959d;
		try {
			conn = get.getConnection();
			select = conn
					.prepareStatement("SELECT c.Latitude as lat , c.Longitude as lon FROM city c where c.Name = ?");
			select.setString(1, cit1.getName());
			select2 = conn
					.prepareStatement("SELECT c.Latitude as lat , c.Longitude as lon FROM city c where c.Name = ?");
			select2.setString(1, cit2.getName());
			result1 = select.executeQuery();
			result2 = select2.executeQuery();
			result1.first();
			result2.first();
			lon1 = result1.getDouble("lon") * Math.PI / 180;
			lat1 = result1.getDouble("lat") * Math.PI / 180;
			lat2 = result2.getDouble("lat") * Math.PI / 180;
			lon2 = result2.getDouble("lon") * Math.PI / 180;
			midres1 = Math.pow(Math.cos(lon2) * Math.sin(lon1 - lon2), 2d);
			midres1 = midres1
					+ Math.pow(Math.cos(lat1) * Math.sin(lat2) - Math.sin(lat1)
							* Math.cos(lat2) * Math.cos(lon1 - lon2), 2d);
			midres1 = Math.sqrt(midres1);
			midres2 = (Math.sin(lat1) * Math.sin(lat2))
					+ (Math.cos(lon1) * Math.cos(lon2) * Math.cos(lon1 - lon2));
			// res = (Math.sin(result1.getDouble("lat")) *
			// Math.sin(result2.getDouble("lat"))) +
			// (Math.cos(result1.getDouble("lon"))*
			// Math.cos(result2.getDouble("lon"))*
			// Math.cos(result1.getDouble("lon")-result2.getDouble("lon")));
			// res = Math.acos(res) * R;
			res = midres1 / midres2;
			res = Math.atan(res) * R;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return res;
	}

}
