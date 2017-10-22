<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 导入spring的表单标签库 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>增加</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>

<body>

<!-- 在使用表单标签的时候需要获取到一个user模型数据，那我们不能直接访问页面（通过/user/add.abc访问），必须通过访问一次服务器，获取到一个user数据模型后才行，否则会出错 -->
<form:form modelAttribute="member" action="member/create">
    <!-- 输出所有的错误信息 -->
    <form:errors path="*" /><br/>
    <hr/>

    <!-- 输出单个错误信息 -->
    <form:errors path="userName" ></form:errors><br/>
    用户名：<form:input path="userName"/><br/>

    <form:errors path="password" ></form:errors><br/>
    密 码:<form:password path="password"/><br/>



    <form:errors path="salary" ></form:errors><br/>
    工资：<form:input path="salary"/><br/>

    <form:errors path="phone" ></form:errors><br/>
    电话：<form:input path="phone"/><br/>

    <input type="submit">
</form:form>
</body>
</html>