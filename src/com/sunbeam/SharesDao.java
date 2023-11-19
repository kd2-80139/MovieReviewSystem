package com.sunbeam;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SharesDao implements AutoCloseable {
	Connection con;

	public SharesDao() {
		// TODO Auto-generated constructor stub
		try {
			con = DbUtil.getCon();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	/**
	 * @author Ritu And Ujjwal
	 * prn no ritu = 230940820086
	 * prn no ujjwal = 230940820111
	 *
	 */
	

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		if (con != null)
			con.close();
	}

	//adding shared reviews to the desired users
	public void add(int rid,int uid) throws Exception {
		String sql = "insert into shares values(?,?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, rid);
			stmt.setInt(2, uid);
			stmt.executeUpdate();
		}
	}
	
	//deleting shared reviews
	public void delete(int rid) throws Exception{
		String sql = "delete from shares where review_id = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, rid);
		
			stmt.executeUpdate();
		}
	}
}
