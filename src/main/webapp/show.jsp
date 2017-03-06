<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>
<html>
<head>
    <meta charset="utf-8">
    <title>数据显示</title>
</head>
<body>
<h3>数据显示</h3>
<c:iterator value="books" var="b">
    <s:property value="name"/>&nbsp;<a href="del.action?id=${b.id}">删除</a><br>
</c:iterator>
</body>
</html>
