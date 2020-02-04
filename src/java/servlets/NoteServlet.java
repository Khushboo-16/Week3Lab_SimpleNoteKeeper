/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import domain.Note;
import java.util.ArrayList;

/**
 *
 * @author 792807
 */
public class NoteServlet extends HttpServlet {

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
            throws ServletException, IOException {
        
    }
    
    private Note noteRead (HttpServletRequest request) throws IOException {
        String title = "";
        String contents = "";
       
        
        ArrayList<String> notecontents = new ArrayList<>();
        
         //Get note.txt path
         String path = getServletContext().getRealPath("/WEB-INF/note.txt");
         // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        while(br.ready()) {
            notecontents.add(br.readLine());
        }
        
        title = notecontents.get(0);
        
        for(int i=1; i < notecontents.size(); i++) {
            contents += notecontents.get(i) + "\n";
        }
        
        Note note = new Note(title, contents);
        
        br.close();
        
        return note;
    }
    
    private Note noteWrite(HttpServletRequest request) throws IOException {
        String formtitle = "";
        String formcontent = "";
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        formtitle = request.getParameter("title");
        formcontent = request.getParameter("contents");
        // to write to a file
       PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
       
       pw.printf("%s%n",formtitle);
       pw.printf(formcontent);
       
       pw.close();
       
       Note n = new Note(formtitle, formcontent);
       
       return n;
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
       // processRequest(request, response);
       response.setContentType("text/html;charset=UTF-8");
       
       String edit = request.getParameter("edit");
       
       Note note = noteRead(request);
       request.setAttribute("note", note);
      // System.out.println("doGet():");
       
       if (edit != null) {
           //System.out.println("Edit Mode");
           getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
       }else {
           //System.out.println("View Mode");
           getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
       }
       
       //response.setContentType("text/html;charset=UTF-8");
       
       
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
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        
        Note n = noteWrite(request);
        request.setAttribute("note", n);
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        //System.out.println("POST Request:");
        //System.out.println("doPost():");
       
       
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
