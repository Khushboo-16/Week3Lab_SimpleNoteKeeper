<%-- 
    Document   : viewnote
    Created on : Jan 27, 2020, 12:38:47 PM
    Author     : 792807
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <div>Title: ${note.title}</div>
        <div>Contents: <br />${note.contents}</div>
        <a href="note?edit">Edit</a>
    </body>
</html>
