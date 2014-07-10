<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User's Page</title>
</head>
<body>
	<s:form action="resultAction" namespace="/">
		<s:select label="Посчитать расстояние от города " list="cityList"
			name="city1" value="defaultSearchEngine" />
		<br>
		<s:select label="Посчитать расстояние до города " list="cityList"
			name="city2" value="defaultSearchEngine" />
		<br>
		<s:select label="Метод расчета " list="tp" name="typ" />
		<br>
		<s:submit value="submit" name="submit" />
		<br>

	</s:form>
</body>
</html>