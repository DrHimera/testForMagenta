package com.test.action;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import com.test.city.City;

public class SAXPars extends DefaultHandler {

	City city1 = new City();
	City city2 = new City();
	List arr = new ArrayList();
	String curElemArg = "";
	String curElem = "";
	Double dist = 0d;

	public List getResult() {

		return arr;
	}

	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		// TODO Auto-generated method stub
		String str = new String(arg0, arg1, arg2).trim();
		if (!curElemArg.equals("name")) {
			str = str.replace(',', '.');
		}

		if (curElem == "city1") {
			if (curElemArg.equals("name")) {
				city1.setName(str);
			}

			if (curElemArg.equals("latitude")) {
				city1.setLatitude(new Double(str));
			}
			if (curElemArg.equals("longitude")) {
				city1.setLongitude(new Double(str));
			}
		}

		if (curElem == "city2") {

			if (curElemArg.equals("name")) {
				city2.setName(str);
			}
			if (curElemArg.equals("latitude")) {
				city2.setLatitude(new Double(str));
			}
			if (curElemArg.equals("longitude")) {
				city2.setLongitude(new Double(str));
			}
		}
		if (curElem.equals("distance") && !str.isEmpty()) {
			dist = new Double(str);
		}

	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		// super.endDocument();
	}

	@Override
	public void endElement(String arg0, String arg1, String arg2)
			throws SAXException {
		// TODO Auto-generated method stub
		// super.endElement(arg0, arg1, arg2);
		if (arg2 == "row") {
			arr.add(city1);
			arr.add(city2);
			arr.add(dist);

			city1 = new City();
			city2 = new City();
			dist = 0d;
		}
		curElemArg = "";
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		// super.startDocument();
	}

	@Override
	public void startElement(String arg0, String arg1, String arg2,
			Attributes arg3) throws SAXException {
		// TODO Auto-generated method stub
		// super.startElement(arg0, arg1, arg2, arg3);

		if (arg2 == "city1" || arg2 == "city2" || arg2 == "distance") {

			curElem = arg2;
		} else {
			curElemArg = arg2;
		}
	}

}
