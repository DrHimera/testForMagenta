package com.test.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.calc.Calc;
import com.test.calc.Factory;
import com.test.calc.Types;
import com.test.city.City;
import com.test.action.DBConn;

public class Getters {
	public List<String> getCityList() throws SQLException {
		List<String> list = new ArrayList<String>();

		DBConn get = DBConn.getInstance();
		Connection conn = null;
		ResultSet result = null;
		Statement select = null;
		try {
			conn = get.getConnection();
			select = conn.createStatement();
			result = select.executeQuery("SELECT Name as nm FROM city ");
			result.first();
			while (!result.isAfterLast()) {
				list.add(result.getString("nm"));
				result.next();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return list;

	}

	public Types[] getTypes() {
		return Types.values();
	}

	public double getCalcRouteCity(String city1, String city2, String types)
			throws SQLException {
		City cit1 = new City(city1);
		City cit2 = new City(city2);
		Factory fact = Factory.getInstance();

		Calc clc = fact.getCalc(Types.valueOf(types));

		return clc.calculate(cit1, cit2);
	}
}
