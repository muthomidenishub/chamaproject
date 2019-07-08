/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chama.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author denis
 */
public class LoansDao {
     Databaseconnection conneDatabaseconnection = new Databaseconnection();
  
    PreparedStatement stmt;
      PreparedStatement stmt_one;
 private int noOfRecords;
public LoansDao(){}

public List ViewAllEmployees(
    int offset,
    int noOfRecords,int chamaID,int loan_status) throws SQLException{
      String query = "select SQL_CALC_FOUND_ROWS * from loan_table where chama_id = ? and loan_status = ? limit "
     + offset + ", " + noOfRecords;
     
  List list = new ArrayList();
  retrieveLoan loan ;
  
  stmt = conneDatabaseconnection.connect().prepareStatement(query);
  stmt.setInt(1, chamaID);
  stmt.setInt(2, loan_status);
      ResultSet rs ;
      ResultSet rs1;
      rs = stmt.executeQuery();
  
         String Squery = "select m.first_name,m.member_national,m.member_id,m.second_name , "
                + "l.date_created,l.loaned_amount,l.repay_date,l.loan_id from loan_table  as l inner join chama_member   as m on l.member_id = m.member_national "
                + " where  l.chama_id = ? and l.loan_status = ? limit "
     + offset + ", " + noOfRecords ;
        stmt_one = conneDatabaseconnection.connect().prepareStatement(Squery);
        stmt_one.setInt(1, chamaID);
        stmt_one.setInt(2, loan_status);
        rs1 = stmt_one.executeQuery();
        
        while (rs1.next()) {  
            loan = new retrieveLoan();
            loan.setFirstName(rs1.getString("first_name"));
            loan.setSecondName(rs1.getString("second_name"));   
            loan.setLoanid(rs1.getInt("loan_id"));
            loan.setLoanedamount(rs1.getInt("loaned_amount"));
            loan.setDateCreated(rs1.getDate("date_created").toString());
            loan.setDateRepaid(rs1.getString("repay_date"));
            list.add(loan);
            
        }
        rs.close();
 rs = stmt.executeQuery("SELECT FOUND_ROWS()");
 if(rs.next()){
 this.noOfRecords = rs.getInt(1);

   try {
    if(stmt_one != null)
     stmt_one.close();
    if(conneDatabaseconnection != null)
     conneDatabaseconnection.disconnect();
    } catch (SQLException e) {
   }
  
        
    

}
    return  list;
    
    
}
public int getNoOfRecords() {
  return noOfRecords;
 }
}