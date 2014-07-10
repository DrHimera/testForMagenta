package com.test.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.opensymphony.xwork2.ActionSupport;

public class AdminPage extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private File file;
	private String contentType;
	private String filename;
	private String result;
	private String content;

	public File getUpload() {
		return file;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUploadContentType() {
		return contentType;
	}

	public String getUploadFileName() {
		return filename;
	}

	public void setUpload(File file) {
		this.file = file;
	}

	public void setUploadContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setUploadFileName(String filename) {
		this.filename = filename;
	}

	public String getContent() {
		return this.content;
	}

	public String execute() throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		SAXPars saxp = new SAXPars();
		List arr = new ArrayList();
		Setters impData = new Setters();

		if (file != null) {
			parser.parse(file, saxp);
			arr = saxp.getResult();
			result = impData.insCityData(arr);
		}
		return SUCCESS;
	}

	public String display() {
		return NONE;
	}

}
