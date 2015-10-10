package solutions.egen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import solutions.egen.exception.AppException;
import solutions.egen.model.Login;
import solutions.egen.util.DBUtils;

public class LoginDAO {
	
	
	public static boolean authenticateUser(Login log) throws AppException{

		Connection con = DBUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("SELECT * FROM login WHERE USERNAME=?");
			ps.setString(1, log.getUsername());
			rs = ps.executeQuery();
			
			if(rs.next()){
				if(log.getPassword().compareTo(rs.getString(2)) == 0)
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}finally{
		DBUtils.closeResource(ps, rs, con);
		}
		return false;
	}
}
