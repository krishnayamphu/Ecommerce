package com.aptech.controllers.media;

import com.aptech.dao.MediaDao;
import com.aptech.models.Media;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MediaDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("imageId"));
        String name = request.getParameter("imageName");
        Media media = new Media();
        media.setId(id);
        media.setName(name);
        if (MediaDao.deleteMedia(media)) {
            response.sendRedirect("http://localhost:8080/ecommerce/admin/media");
        } else {
            //error message
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
