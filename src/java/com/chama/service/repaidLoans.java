/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chama.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author denis
 */
public class repaidLoans extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            //get paremeters to display the loans
            String repaidLoan_contr_url = "showRepaidLoans.jsp";
            String startDate = request.getParameter("startdate");
            String endDate = request.getParameter("enddate");
            int chamaSuperv = Integer.parseInt(request.getParameter("sup"));
            
            ///get chamaID
            List<chamaModel> chamaDet;
            chamaDet = DatabaseHandler.getChamaDetails(chamaSuperv);
            int chamaID = chamaDet.get(0).getChamaID();
            retrieveLoan loan = new retrieveLoan();
            loan.setLoanStatus("false");
            loan.setChamaID(chamaID);
            System.out.println(endDate);
            List<retrieveLoan> memberContr = DatabaseHandler.repaidLoans(loan, startDate, endDate);
           //create session to return to the display
            System.out.println(memberContr);
            session.setAttribute("loan", memberContr);
            session.setAttribute("state", startDate);
             session.setAttribute("endate", endDate);
            request.getRequestDispatcher(repaidLoan_contr_url).forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(repaidLoans.class.getName()).log(Level.SEVERE, null, ex);
        }
            
     
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try {
            String startdate = request.getParameter("stardate");
            String enddate = request.getParameter("enddate");
            int supervisorID = Integer.parseInt(request.getParameter("sup"));
            
            List<chamaModel> chamaDet;
            chamaDet = DatabaseHandler.getChamaDetails(supervisorID);
            
            int chamaID = chamaDet.get(0).getChamaID();
            
            String str = "pdf";
        try {
            Document document = new Document();
            if (str.equals("pdf")) {
                response.setContentType("application/pdf");
                PdfWriter.getInstance(document, response.getOutputStream());
            }
          retrieveLoan loan = new retrieveLoan();
          loan.setChamaID(chamaID);
          loan.setLoanStatus("false");
           
            List<retrieveLoan> memberContr = DatabaseHandler.repaidLoans(loan, startdate, enddate);

            //Got total amount of contributions;
            int amount = 0;
            for (int i = 0; i < memberContr.size(); i++) {
                amount += memberContr.get(i).getLoanedamount();

            }
            document.open();

            /* new paragraph instance initialized and add function write in pdf file*/
            document.add(new Paragraph("---------------------------------------------------------REPORT---------------------------------------------------------\n\n"));
            document.add(new Paragraph("                                                 \n"));
            document.add(new Paragraph("                                                 SUMMARY OF LOANS REPAID\n"));
            document.add(new Paragraph("                                                 BETWEEN" + "  " + startdate + " AND " + "  " + enddate + "\n"));
            document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------\n\n"));
            Date date = new Date();

            //  document.add(new Paragraph("CHAMA CONTRIBUTIONS:" + amount));
            //create a table
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            Font font = FontFactory.getFont(FontFactory.TIMES_BOLD, 12);
            PdfPCell cell = new PdfPCell(new Phrase("First Name", font));

            cell.setBorder(Rectangle.BOX);
            table.addCell(cell);

            cell.setPhrase(new Phrase("Second Name", font));
            // cell.setBorder(Rectangle.BOX);
            table.addCell(cell);

            

            cell.setPhrase(new Phrase("Date", font));
            // cell.setBorder(Rectangle.BOX);
            table.addCell(cell);
            cell.setPhrase(new Phrase("Amount", font));
            // cell.setBorder(Rectangle.BOX);
            table.addCell(cell);
// table.setHeaderRows(1);
            //get the total cells
            //    PdfPCell[] cells = table.getRow(0).getCells();
            //    for(int j =0; j < cells.length;j++){
            //        cells[j].setBackgroundColor(BaseColor.DARK_GRAY);
            //    
            //    
            //    }
            for (int i = 0; i < memberContr.size(); i++) {
                cell.setPhrase(new Phrase(memberContr.get(i).getFirstName()));
                table.addCell(cell);

                cell.setPhrase(new Phrase(memberContr.get(i).getSecondName()));
                table.addCell(cell);

                cell.setPhrase(new Phrase((memberContr.get(i).getDateRepaid())));
                table.addCell(cell);
                
                cell.setPhrase(new Phrase(Integer.toString(memberContr.get(i).getLoanedamount())));
                table.addCell(cell);
            }
            
            
            cell.setPhrase(new Phrase("Total", font));
            // cell.setBorder(Rectangle.BOX);
            table.addCell(cell);
            
             cell.setPhrase(new Phrase());
            // cell.setBorder(Rectangle.BOX);
            table.addCell(cell);
            cell.setPhrase(new Phrase());
            // cell.setBorder(Rectangle.BOX);
            table.addCell(cell);
            cell.setPhrase(new Phrase(Integer.toString(amount)));
            // cell.setBorder(Rectangle.BOX);
            table.addCell(cell);
            
            document.add(table);
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("CHAMA CONTRIBUTIONS:" + amount));
            String date1 = date.toString();
            document.add(new Paragraph("                                                                                                         "+ date1 +"                                               " ));
           // document.add(new Paragraph("---------------------------------------------------------PAGE NO::" + document.getPageNumber() + "------------------------------------------------------"));

            document.close(); //document instance closed

        } catch (DocumentException | IOException | SQLException de) {
            System.err.println("document: " + de.getMessage());

        }

        } catch (SQLException ex) {
            Logger.getLogger(showMemberContribution.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
}
