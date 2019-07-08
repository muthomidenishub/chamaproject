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

/**
 *
 * @author denis
 */
public class ManagaePenalties extends HttpServlet {


  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get the penalties and update accordingly
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //get the supervisor ID
            //get the attributes to retrieve the penalties
            int chamaSup = Integer.parseInt(request.getParameter("sup"));
            List<chamaModel> chamaDet;
            chamaDet = DatabaseHandler.getChamaDetails(chamaSup);
            int chamaID = chamaDet.get(0).getChamaID();
            //get status
            int penStatus = 0;
            String col = "late_repay";
            double Lcharges = DatabaseHandler.getCharges(col,chamaID)*(0.01);//fetch from the DB
            int charges = (int) (Lcharges * 100);
            //perform the query
           // List<penaltyModel> penalisedMembers = DatabaseHandler.getPenalisedMembers(chamaSup, penStatus,charges);
            String str = "pdf";
        
                Document document = new Document();
                if (str.equals("pdf")) {
                    response.setContentType("application/pdf");
                    PdfWriter.getInstance(document, response.getOutputStream());
                }
                

                List<penaltyModel> penaltyDetails = DatabaseHandler.getPenalisedMembers(chamaSup, penStatus, charges); //Got total amount of contributions;
                int penalty = 0 ;
                for(int i = 0; i < penaltyDetails.size();i++){
                    penalty += penaltyDetails.get(i).getAmountCharged();
                }
                document.open();

                /* new paragraph instance initialized and add function write in pdf file*/
                document.add(new Paragraph("---------------------------------------------------------REPORT---------------------------------------------------------\n\n"));
                document.add(new Paragraph("                                                \n"));
                document.add(new Paragraph("                                                 PENALISED MEMBERS ON CONTRIBUTIONS\n"));
                document.add(new Paragraph("                                                  \n"));
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

                cell.setPhrase(new Phrase("Penalty Charged", font));
                // cell.setBorder(Rectangle.BOX);
                table.addCell(cell);
                cell.setPhrase(new Phrase("Date Penalised", font));
                table.addCell(cell);
                
// table.setHeaderRows(1);
                //get the total cells
                //    PdfPCell[] cells = table.getRow(0).getCells();
                //    for(int j =0; j < cells.length;j++){
                //        cells[j].setBackgroundColor(BaseColor.DARK_GRAY);
                //    
                //    
                //    }
                for (int i = 0; i < penaltyDetails.size(); i++) {
                    cell.setPhrase(new Phrase(penaltyDetails.get(i).getFirstname()));
                    table.addCell(cell);

                    cell.setPhrase(new Phrase(penaltyDetails.get(i).getSecondname()));
                    table.addCell(cell);

                    cell.setPhrase(new Phrase(Integer.toString(penaltyDetails.get(i).getAmountCharged())));
                    table.addCell(cell);
                    cell.setPhrase(new Phrase(penaltyDetails.get(i).getDateCreated()));
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
                

                document.add(table);
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("TOTAL PENALTIES:" + penalty+"\n\n\n\n\n"));
                document.add(new Paragraph("Approved by:.........................." ));
                String date1 = date.toString();
                document.add(new Paragraph("                                                                                                         " + date1 + "                                               "));
                // document.add(new Paragraph("---------------------------------------------------------PAGE NO::" + document.getPageNumber() + "------------------------------------------------------"));

                document.close(); //document instance closed

            } catch (DocumentException | IOException | SQLException de) {
                System.err.println("document: " + de.getMessage());

            }

        } 
            //get the charges and add to the model
        } 
           
       
    
  

