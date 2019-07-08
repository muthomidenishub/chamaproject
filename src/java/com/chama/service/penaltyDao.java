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
public class penaltyDao {
    
    Databaseconnection conneDatabaseconnection = new Databaseconnection();
  
    PreparedStatement stmt;
    PreparedStatement stmt_one;
 private int noOfRecords;

    public penaltyDao() {
    }
 
 
 public List viewAllPenalties(
    int offset,
    int noOfRecords,int chamaSuperv,int con_status,int charges) throws SQLException
 {
     List list = new ArrayList();
     penaltyModel penal;
    String query = "select SQL_CALC_FOUND_ROWS * from chama_contribution where treasurer_id = ? and contr_status = ? limit "
     + offset + ", " + noOfRecords;
     stmt = conneDatabaseconnection.connect().prepareStatement(query);
     stmt.setInt(1, chamaSuperv);
     stmt.setInt(2, con_status);
      ResultSet rs ;
      ResultSet rs1;
      rs = stmt.executeQuery();
     
          String Squery = "select m.first_name as 'member_fname',m.member_national as 'membernational',m.member_id as 'memberuniqueacc',m.second_name as 'member_sname', "
                + "s.date_contrib  as 'date_penal',s.contr_id as 'penalty_id' from chama_contribution  as s inner join chama_member   as m on s.member_id = m.member_national "
                + " where  m.chama_supervisor = ? and s.contr_status = ?  group by m.first_name,m.member_national,m.member_id,m.second_name,s.date_contrib,s.contr_id";
        stmt_one = conneDatabaseconnection.connect().prepareStatement(Squery);
        stmt_one.setInt(1, chamaSuperv);
        stmt_one.setInt(2, con_status);
        rs1 = stmt_one.executeQuery();
        while(rs1.next()){
            penal = new penaltyModel();
            penal.setFirstname(rs1.getString("member_fname"));
            penal.setMemberaccountID(rs1.getInt("memberuniqueacc"));
            penal.setSecondname(rs1.getString("member_sname"));
            penal.setDateCreated(rs1.getString("date_penal"));
            penal.setPenaltyID(rs1.getInt("penalty_id"));
            penal.setIdnumber(rs1.getInt("membernational"));
            penal.setAmountCharged(charges);
            list.add(penal);
   
   
   }
      
      
   
        
        rs.close();
        rs = stmt.executeQuery("SELECT FOUND_ROWS()");
        if(rs.next())
    this.noOfRecords = rs.getInt(1);
        
   try {
    if(stmt_one != null)
     stmt_one.close();
    if(conneDatabaseconnection != null)
     conneDatabaseconnection.disconnect();
    } catch (SQLException e) {
   }
      
   
   return list;
 }
  
 public int getNoOfRecords() {
  return noOfRecords;
 }  
}
