package com.sunbeam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Ritu And Ujjwal
 * prn no ritu = 230940820086
 * prn no ujjwal = 230940820111
 *
 */
public class MoviesDao implements AutoCloseable{
	Connection con;
	public MoviesDao() {
		// TODO Auto-generated constructor stub
		try {
			con=DbUtil.getCon();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		if(con!=null) {
			con.close();
		}	
	}
	
	//displaying all movies
	public List<movies> display() throws Exception{
		String sql="select * from movies";
		List<movies> list=new ArrayList<movies>();
		try(PreparedStatement stmt=con.prepareStatement(sql)){
			try(ResultSet rs=stmt.executeQuery()){
				while(rs.next()) {
					movies q=new movies();
					q.setId(rs.getInt("id"));
					q.setTitle(rs.getString("title"));
					q.setRelease_date(rs.getDate("release_date"));
					list.add(q);
				}
			}
		}
		return list;
	}
	
}

