    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" isELIgnored="false"%>

            <%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String password = request.getParameter("password");

%>

        您提交的账号名是 :<%=name%> <br/>
        您提交的密码是 :<%=password%>
        <br>
        <a href="javascript:history.back()">返回</a>
