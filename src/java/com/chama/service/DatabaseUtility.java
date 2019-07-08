package com.chama.service;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility {
	 public static void closeStatement(Statement s) {
			if(s!=null) {
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
			
		}
		public static void closePreparedStatement( Statement prestate) {
			if(prestate!=null) {
				try {
					prestate.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
		}
		public static void closeResultSetStatement( java.sql.ResultSet resultset) {
			if(resultset!=null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		


}
