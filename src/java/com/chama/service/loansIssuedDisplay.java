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
public class loansIssuedDisplay extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String display_loan_url = "LoanIssued.jsp";
            int page = 1;
            int recordsPerPage = 2;
            int chamaSupervisor = Integer.parseInt(request.getParameter("sup"));
            page = Integer.parseInt(request.getParameter("page"));
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            int loan_status = 0;

            //get chama ID
            List<chamaModel> chamaDet;
            chamaDet = DatabaseHandler.getChamaDetails(chamaSupervisor);

            int chamaID = chamaDet.get(0).getChamaID();
            LoansDao loansIss = new LoansDao();
            //create pagination
            List<retrieveLoan> loanIssued = loansIss.ViewAllEmployees((page - 1) * recordsPerPage, recordsPerPage, chamaID, loan_status);
            int numberOfRecords = loansIss.getNoOfRecords();
            int numberOfPages = (int) Math.ceil(numberOfRecords * 1.0 / recordsPerPage);
            HttpSession session = request.getSession();
            //set sessions
            session.setAttribute("loanRecords", loanIssued);
            session.setAttribute("numberOfP", numberOfPages);
            session.setAttribute("currentP", page);
            request.getRequestDispatcher(display_loan_url).forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(loansIssuedDisplay.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get the supervisor id 

        try {

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
                int loan_status = 0;
                chamaModel chama = new chamaModel();
                chama.setChamaID(chamaID);

                List<retrieveLoan> loanIss = DatabaseHandler.getLoans(chama, loan_status); //Got total amount of contributions;
                int amount = 0;
                for (int i = 0; i < loanIss.size(); i++) {
                    amount += loanIss.get(i).getLoanedamount();

                }
                document.open();

                /* new paragraph instance initialized and add function write in pdf file*/
                document.add(new Paragraph("---------------------------------------------------------REPORT---------------------------------------------------------\n\n"));
                document.add(new Paragraph("                                                 CREATED REPORT BY-DENIS\n"));
                document.add(new Paragraph("                                                 LOANS APPROVED\n"));
                document.add(new Paragraph("                                                  \n"));
                document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------\n\n"));
                Date date = new Date();

                //  document.add(new Paragraph("CHAMA CONTRIBUTIONS:" + amount));
                //create a table
                PdfPTable table = new PdfPTable(5);
                table.setWidthPercentage(100);
                Font font = FontFactory.getFont(FontFactory.TIMES_BOLD, 12);
                PdfPCell cell = new PdfPCell(new Phrase("First Name", font));

                cell.setBorder(Rectangle.BOX);
                table.addCell(cell);

                cell.setPhrase(new Phrase("Second Name", font));
                // cell.setBorder(Rectangle.BOX);
                table.addCell(cell);

                cell.setPhrase(new Phrase("Amount Issued", font));
                // cell.setBorder(Rectangle.BOX);
                table.addCell(cell);
                cell.setPhrase(new Phrase("Date Issued", font));
                table.addCell(cell);
                cell.setPhrase(new Phrase("Date To Be Repaid", font));
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
                for (int i = 0; i < loanIss.size(); i++) {
                    cell.setPhrase(new Phrase(loanIss.get(i).getFirstName()));
                    table.addCell(cell);

                    cell.setPhrase(new Phrase(loanIss.get(i).getSecondName()));
                    table.addCell(cell);

                    cell.setPhrase(new Phrase(Integer.toString(loanIss.get(i).getLoanedamount())));
                    table.addCell(cell);
                    cell.setPhrase(new Phrase(loanIss.get(i).getDateCreated()));
                    table.addCell(cell);
                    cell.setPhrase(new Phrase(loanIss.get(i).getDateRepaid()));
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
                document.add(new Paragraph("CHAMA TOTAL LOANS ISSUED:" + amount+"\n\n\n\n\n"));
                document.add(new Paragraph("Approved by:.........................." ));
                String date1 = date.toString();
                document.add(new Paragraph("                                                                                                         " + date1 + "                                               "));
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
