package com.test.calc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.action.DBConn;
import com.test.city.City;

public class CalculateByMatrix implements Calc {

	@Override
	public double calculate(City cit1, City cit2) throws SQLException {
		DBConn get = DBConn.getInstance();
		Double res = 0d;
		Connection conn = null;
		ResultSet result = null;
		java.sql.PreparedStatement select = null;
		try {
			if (cit1.getName() != cit2.getName()) {
				conn = get.getConnection();
				select = conn
						.prepareStatement("SELECT r.Distance as route FROM route r, city  c1 , city c2 WHERE c1.id =r.City1_ID and c2.id =r.City2_ID and c1.name = ? and c2.name = ?");
				select.setString(1, cit1.getName());
				select.setString(2, cit2.getName());
				result = select.executeQuery();
				if (result.first()) {
					res = result.getDouble("route");
				} else {
					select = conn
							.prepareStatement("SELECT ifnull(r.Distance,0) as route FROM route r, city  c1 , city c2 WHERE c1.id =r.City1_ID and c2.id =r.City2_ID and c1.name = ? and c2.name = ?");
					select.setString(1, cit2.getName());
					select.setString(2, cit1.getName());
					result = select.executeQuery();
					if (result.first()) {
						res = result.getDouble("route");
					} else {
						res = 0d;
					}

				}

			} else {
				res = 0d;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return res;
	}

}
