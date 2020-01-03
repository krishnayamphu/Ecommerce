package com.aptech.controllers.media;

import com.aptech.mediahelper.Media;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MediaDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("imageName");
        if (Media.deleteMedia(filename)) {
            response.sendRedirect("http://localhost:8080/ecommerce/admin/media");
        } else {
            //error message
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
