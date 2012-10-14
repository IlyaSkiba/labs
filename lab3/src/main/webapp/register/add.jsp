<%--
  Created by IntelliJ IDEA.
  User: meloman
  Date: 11.10.12
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="saveData.jsp" METHOD="post">
    <div>
        <label for="name">Name:</label>
        <input id="name" name="name" value=""/>
    </div>
    <div>
        <label for="address">Adress:</label>
        <input id="address" name="address" value=""/>
    </div>
    <div>
        <label for="phone">Phone</label>
        <input id="phone" name="phone" value=""/>
    </div>
    <input value="Add" type="submit"/>
</form>


</body>
</html>