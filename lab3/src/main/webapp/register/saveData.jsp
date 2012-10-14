<%--
  Created by IntelliJ IDEA.
  User: meloman
  Date: 14.10.12
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="clientModel" scope="request" class="bsu.lab.presentation.model.ClientModel"/>
<jsp:setProperty name="clientModel" property="*"/>
<jsp:forward page="/registration"/>
<html>
<head>
    <title></title>
</head>
<body>

</body>
</html>