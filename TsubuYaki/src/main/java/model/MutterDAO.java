package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MutterDAO {
	String jdbcUrl    = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&useSSL=false";
	String userId     = "test_user";
	String userPass   = "test_pass";
	String dml        = "INSERT INTO MUTTER ( NAME , MESSAGE , TIME ) VALUES ( ? , ? , ? )";
	String ddl        = "SELECT  NAME , MESSAGE , TIME FROM MUTTER ORDER BY TIME" ;
	boolean isSuccess = true;

	public boolean doInsert( Mutter dto ) {
		Connection        con = null;
		PreparedStatement ps  = null;
		
		try {
			con = DriverManager.getConnection( jdbcUrl , userId , userPass );
			ps  = con.prepareStatement( dml );
			con.setAutoCommit( false );
			ps.setString   (    1, dto.getUserName()       ); 
			ps.setString   (    2, dto.getText()           ); 
			ps.setTimestamp(    3, dto.getTime()           );
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			isSuccess = false ;
		
		} finally {
			if(isSuccess){
				try {
					con.commit();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else{
				try {
					con.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isSuccess;
	}
	
	
	public List<Mutter> doSelect() {
		
		List<Mutter> selectDataList = new ArrayList<Mutter>();

		try(Connection con = DriverManager.getConnection(jdbcUrl , userId , userPass);
			PreparedStatement ps  = con.prepareStatement( ddl )){

			ResultSet rs = ps.executeQuery();
			while ( rs.next() ) {
				Mutter dto = new Mutter();
				dto.setUserName   ( rs.getString   ( "NAME"    ) );
				dto.setText       ( rs.getString   ( "MESSAGE" ) );
				dto.setTime       ( rs.getTimestamp( "TIME"    ) );
				selectDataList.add( dto );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return selectDataList;
		
	}
}
