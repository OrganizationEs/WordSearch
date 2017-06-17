<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head>
	<body>

<center>
■■■■<br>
<form action="result" method="post" target="result_frame">
			<input type="text" id="message" name="message">
			<input type="submit" value="検索">
</form>
</center>


		<iframe src="manual" name="result_frame" width="100%" height="400">
この部分はインラインフレームを使用しています。
</iframe>
	</body>
</html>
