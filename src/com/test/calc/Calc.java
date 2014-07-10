package com.test.calc;

import java.sql.SQLException;

import com.test.city.*;

public interface Calc {
	// public double calculate(double latitude, double longitude);
	public double calculate(City cit1, City cit2) throws SQLException;

}
