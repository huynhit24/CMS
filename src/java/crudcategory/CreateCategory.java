/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudcategory;

import dao.PostDAO;
import entity.User;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author pc
 */
@WebServlet(name = "CreateCategory", urlPatterns = {"/CreateCategory"})
public class CreateCategory extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException, Exception {
        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CreateCategory</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CreateCategory at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//        HttpSession session = request.getSession();
//        User a = (User) session.getAttribute("acc");
//        if (a != null) {
//            Long id = a.getUserId();
//            response.sendRedirect("CreateCategory.jsp");
//        } else {
//            request.setAttribute("mess", "B???n ch??a ????ng nh???p ????? v??o trang n??y!");
//            request.getRequestDispatcher("Login.jsp").forward(request, response);
//        }
        String category_title = request.getParameter("category_title");
        String slug = request.getParameter("slug");
        String icon = request.getParameter("icon");

        HttpSession session = request.getSession();
        User a = (User) session.getAttribute("acc");
        if (a != null) {
            //CH??N N???U ????NG NH???P
            PostDAO dao = new PostDAO();

            //Upload file
            
            
            //end
            
            dao.insertCategory(category_title, slug, icon);
            //request.setAttribute("mess", "B???n c?? mu???n ????ng nh???p kh??ng!");
            response.sendRedirect("IndexCategory.jsp");
        } else {
            //day ve trang login.jsp
            request.setAttribute("mess", "Email n??y ???? t???n t???i! M???i b???n nh???p email kh??c!");
            response.sendRedirect("Login.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(CreateCategory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CreateCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(CreateCategory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CreateCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
