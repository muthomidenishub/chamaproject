/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chama.service;

import static com.itextpdf.kernel.xmp.PdfConst.Date;
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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author denis
 */
public class memberLoanReport extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get the dates to get contribution
//            String startDate =  request.getParameter("startDate");
//            String endDate = request.getParameter("endDate");
//            int chamaSup = Integer.parseInt(request.getParameter("adminUnique"));
//            //get the chamaID
//            List<chamaModel> chamaDet;
//            chamaDet = DatabaseHandler.getChamaDetails(chamaSup);
//            
//            int chamaID = chamaDet.get(0).getChamaID();
        int chamaID = 24;
        String startDate = "2019-06-07";
        String endDate = "2019-06-22";
        String str = "pdf";
        try {
            Document document = new Document();
            if (str.equals("pdf")) {
                response.setContentType("application/pdf");
                PdfWriter.getInstance(document, response.getOutputStream());
            }

            int penStatus = 1;
             List<chamaModel> chamaDet;
            chamaDet = DatabaseHandler.getChamaDetails(chamaSup);
            int chamaID = chamaDet.get(0).getChamaID();
             //fetch from the DB
             String col = "pen_charges";
            Lcharges = DatabaseHandler.getCharges(col,chamaID);
            List<MemberContribution> memberContr = DatabaseHandler.getChamaContribution(startDate, endDate, chamaID);

            //Got total amount of contributions;
            int amount = 0;
            for (int i = 0; i < memberContr.size(); i++) {
                amount += memberContr.get(i).getAmount();

            }
            document.open();

            /* new paragraph instance initialized and add function write in pdf file*/
            document.add(new Paragraph("---------------------------------------------------------REPORT---------------------------------------------------------\n\n"));
            document.add(new Paragraph("                                                 CREATED REPORT BY-DENIS\n"));
            document.add(new Paragraph("                                                 SUMMARY OF CONTRIBUTION\n"));
            document.add(new Paragraph("                                                 BETWEEN" + "  " + startDate + " AND " + "  " + endDate + "\n"));
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
                cell.setPhrase(new Phrase(memberContr.get(i).getFname()));
                table.addCell(cell);

                cell.setPhrase(new Phrase(memberContr.get(i).getLname()));
                table.addCell(cell);

                cell.setPhrase(new Phrase((memberContr.get(i).getDateContributed())));
                table.addCell(cell);
                
                cell.setPhrase(new Phrase(Integer.toString(memberContr.get(i).getAmount())));
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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
