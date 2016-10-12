package com.alex.webParsing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alex on 12.10.2016.
 */
public class ParsingText extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        ArrayList<Word> arrayList = ParsingString.parsing(text);
        String temp = "";
        for (Word word : arrayList)
            temp += "<p>" + word.getName() + " - " + word.getCount() + "</p>";
        req.setAttribute("popularWords", temp);
        req.getRequestDispatcher("PopularWords.jsp").forward(req, resp);
    }
}
