package com.test.action;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.test.calc.Types;
import com.test.action.Getters;

public class UserPage extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> cityList;
	private Types[] tp;
	private double result;
	public String typ;
	public String str;
	public String city1, city2;

	public double getResult() throws SQLException {
		Getters get = new Getters();

		return get.getCalcRouteCity(city1, city2, typ);
	}

	public void setResult(double result) {
		this.result = result;
	}

	public Types[] getTp() {
		Getters get = new Getters();
		return get.getTypes();
	}

	public void setTp(Types[] tp) {
		this.tp = tp;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getCity1() {
		return city1;
	}

	public void setCity1(String city1) {
		this.city1 = city1;
	}

	public String getCity2() {
		return city2;
	}

	public void setCity2(String city2) {
		this.city2 = city2;
	}

	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}

	public List<String> getCityList() throws SQLException {
		Getters g = new Getters();
		List<String> list = g.getCityList();
		return cityList = list;
		// return cityList;
	}

	public String getDefaultSearchEngine() {
		return "samara";
	}

	public UserPage() throws SQLException {

		/*
		 * cityList = new ArrayList<String>(); cityList.add("google.com");
		 * cityList.add("bing.com"); cityList.add("yahoo.com");
		 * cityList.add("baidu.com");
		 */
		Getters g = new Getters();
		List<String> list = g.getCityList();
		cityList = list;
	}

	public String execute() {

		return SUCCESS;
	}

	public String display() {
		return NONE;
	}

}
