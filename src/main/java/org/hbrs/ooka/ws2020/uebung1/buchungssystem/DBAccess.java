package org.hbrs.ooka.ws2020.uebung1.buchungssystem;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBAccess {
	
	public final static int HOTEL = 0;
	
	public final static int AUTO = 1;

	private String url = "jdbc:postgresql://dumbo.inf.h-brs.de/demouser";
	
	private Connection conn;
	
	public void openConnection(){
		  try {
			DriverManager.registerDriver( new org.postgresql.Driver() ); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  Properties props = new Properties();
		  props.setProperty("user","demouser");
		  props.setProperty("password","demouser");

		  try {
			 this.conn = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<String> getObjects( int type, String value  ){
		Statement st;
		ResultSet rs;
		List<String> result = new ArrayList();
		if (value.equals("*") ) {
			value = "";
		}
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM buchungsystem.hotel WHERE buchungsystem.hotel.name ilike " + "\'%" + value +  "%\'" );
			while (rs.next() ){
				    // System.out.println( "Hotel: " + rs.getString( "name" ) ); 
				    result.add( rs.getString( 1 ) );
				    result.add( rs.getString( 2 ) );
				    result.add( rs.getString( 3 ) );
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public void closeConnection(){
		   try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}


}
