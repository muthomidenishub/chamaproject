/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chama.service;

import java.util.List;

/**
 *
 * @author denis
 */
public class DataObject {
    private int  iTotalRecords;
 
   private  int  iTotalDisplayRecords;
 
    private String  sEcho;
 
    private String sColumns;
    private List<ChamaMember> member;

    public int getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(int iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public int getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public String getsEcho() {
        return sEcho;
    }

    public void setsEcho(String sEcho) {
        this.sEcho = sEcho;
    }

    public String getsColumns() {
        return sColumns;
    }

    public void setsColumns(String sColumns) {
        this.sColumns = sColumns;
    }
    public List<ChamaMember> getMember() {
  return member;
 }

 public void setMember(List<ChamaMember> mem) {
  this.member = mem;
 }
    
}
