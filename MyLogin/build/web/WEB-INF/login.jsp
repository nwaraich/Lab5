

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST" action ="login">
            <label>Username:</label>
            <input type="text" name ="u_username" value="${username}">
            <br>
            <label>Password:</label>
            <input type="text" name="p_password" value="${password}">
            <br>
            <input type="submit"  value="login">
             <p>${message}</p>
    </body>
   
</html>
