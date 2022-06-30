<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
       <link rel="stylesheet" type="text/css" href="styles.css">  
        <script type="text/javascript" src="check.js"></script>
        <title>The Chat Room</title>
    <link rel="shortcut icon" href="icon.jpeg" />

    </head>
    <body>
        <div class="middle" id="result-data">
            <form autocomplete="off">

            <table>
                <tr height="80px">
                    <td>Username:</td>
                    <td><input type="text" id="username" class="textbox" name="username" autocomplete="off"></td>
                </tr>
                <tr height="20px">
                    <td>Password:</td>
                    <td><input type="password" id="password"  name="password" class="textbox"></td>
                </tr>
                <tr>
                    <td><input type="button" value="Go" class="circle" onclick="startchating();"></td>
                    <td><div id="loading-icon"></div></td>
                </tr>
            </table>
            </form>
        </div>

    </body>
</html>
