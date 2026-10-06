<html>
    <head>
        <title>Login Page</title>
    </head>
    <body>

    <%
       String msg = (String) request.getAttribute("message");
       if(msg !=null){
       out.println("<font color = 'red'>" + msg + "</font>");
       }
    %>
        <form action="./check" method="post">
        <table>

            <tr>
                <td>Username</td>
                <td> <input type="text" name="username"></td>
            </tr>

            <tr>
                <td>Password</td>
                <td> <input type="password" name="password"></td>
            </tr>
        </table>
        <button  type="submit">CLICK</button>

          </form>
    </body>
</html>