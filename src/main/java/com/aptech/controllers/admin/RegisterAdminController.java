package com.aptech.controllers.admin;

import com.aptech.dao.AdminDao;
import com.aptech.models.Admin;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class RegisterAdminController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        String firstname = null;
        String lastname = null;
        String email = null;
        String contact = null;
        String password = null;
        String cpassword = null;
        String imageName = null;
        boolean checkPassword = false;

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List items = upload.parseRequest(request);
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();
                    if (!item.isFormField()) {
                        String fileName = item.getName();
                        String root = getServletContext().getRealPath("/");
//                        File path = new File(root + "/uploads");
                        File path = new File("E:\\Server\\tomcat 9.0\\webapps\\ecommerce\\uploads\\admin");
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }
                        File uploadedFile = new File(path + "/" + fileName);
                        item.write(uploadedFile);
                        imageName = fileName;
                        System.out.println(uploadedFile.getAbsolutePath());
                        System.out.println(fileName);
                    } else {
                        String fieldname = item.getFieldName();
                        String filedvalue = item.getString();
                        if (fieldname.equals("firstname")) {
                            firstname = filedvalue;
                        }
                        if (fieldname.equals("lastname")) {
                            lastname = filedvalue;
                        }
                        if (fieldname.equals("email")) {
                            email = filedvalue;
                        }
                        if (fieldname.equals("contact")) {
                            contact = filedvalue;
                        }
                        if (fieldname.equals("password")) {
                            password = filedvalue;
                        }
                        if (fieldname.equals("cpassword")) {
                            cpassword = filedvalue;
                        }
                    }
                }

                if (password.equals(cpassword)) {
                    //save admin user
                    Admin admin = new Admin();
                    admin.setFirstname(firstname);
                    admin.setLastname(lastname);
                    admin.setEmail(email);
                    admin.setContact(contact);
                    admin.setImage(imageName);
                    admin.setPassword(password);
                    int status = AdminDao.saveAdmin(admin);
                } else {
                    //password do not match
                    pw.print("password do not match");
                }
//                pw.print(firstname + ", " + lastname + ", " + email + ", " + contact + ", " + password + ","+cpassword+"," + imageName);
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/ecommerce/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("auth/register.jsp").forward(request, response);
    }

}
