<%-- 
    Document   : editnote
    Created on : Jan 27, 2020, 12:39:06 PM
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
        <h2>Edit Note</h2>
        <form method="post" action="/Week03Lab_SimpleNoteKeeper/note">
            Title: <input type="text" name="title" value="${note.title}" /><br/>
            Contents: <textarea name="contents">${note.contents}</textarea><br/>
            <input type="submit" value="Save" />
        </form>
    </body>
</html>
