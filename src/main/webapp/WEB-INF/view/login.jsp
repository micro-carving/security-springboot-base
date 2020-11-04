<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<form action="login" method="post">
    <table>
        <tr>
            <td>账&nbsp;&nbsp;号：</td>
            <td><input type="text" name="userName"/></td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;码: </td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td colspan="3" align="center">
                <input type="submit" value="登录"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>