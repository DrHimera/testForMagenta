package com.test.calc;

public class Factory {
	private static Factory _instance;

	private Factory() {

	}

	public synchronized static Factory getInstance() {
		if (_instance == null)
			_instance = new Factory();
		return _instance;
	}

	public Calc getCalc(Types type) {

		switch (type) {
		case Direct:
			return new CalculateDirect();
			// break;
		case ByMatrix:
			return new CalculateByMatrix();
			// break;
		default:
			return null;
			// break;
		}

	}

}
