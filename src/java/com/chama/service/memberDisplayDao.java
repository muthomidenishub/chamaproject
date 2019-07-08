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
public class memberDisplayDao {
    
    Databaseconnection conneDatabaseconnection = new Databaseconnection();
  
    PreparedStatement stmt;
 private int noOfRecords;

 public memberDisplayDao() { }

 

 public List viewAllEmployees(
    int offset,
    int noOfRecords,int chamaSup)
 {
  String query = "select SQL_CALC_FOUND_ROWS * from chama_member where chama_supervisor = ? limit "
     + offset + ", " + noOfRecords;
  List list = new ArrayList();
  ChamaMember member ;
  try {
   
   stmt = conneDatabaseconnection.connect().prepareStatement(query);
   stmt.setInt(1, chamaSup);
      ResultSet rs ;
      rs = stmt.executeQuery();
   while (rs.next()) {
    member = new ChamaMember();
    member.setFirstName(rs.getString("first_name"));
    member.setLastName(rs.getString("second_name"));
    member.setEmailAddress(rs.getString("member_email"));
    member.setIdNumber(rs.getInt("member_national"));
    member.setMemberID(rs.getInt("member_id"));
    member.setLocation(rs.getString("member_location"));
    member.setPhoneNumber(rs.getInt("member_phone"));
    
    list.add(member);
   }
   rs.close();

   rs = stmt.executeQuery("SELECT FOUND_ROWS()");
   if(rs.next())
    this.noOfRecords = rs.getInt(1);
  } catch (SQLException e) {
  }finally
  {
   try {
    if(stmt != null)
     stmt.close();
    if(conneDatabaseconnection != null)
     conneDatabaseconnection.disconnect();
    } catch (SQLException e) {
   }
  }
  return list;
 }

 public int getNoOfRecords() {
  return noOfRecords;
 }
    
}
