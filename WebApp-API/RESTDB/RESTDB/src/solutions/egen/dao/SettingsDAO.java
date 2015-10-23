package solutions.egen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import solutions.egen.exception.AppException;
import solutions.egen.model.Settings;
import solutions.egen.util.DBUtils;

public class SettingsDAO {
	
	public Settings update(Settings sett) throws AppException {///////////////////////////////////////////////
		Connection con = DBUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("UPDATE settings SET DATE=?, TIME=?");
			ps.setString(1, sett.getDate());
			ps.setString(2, sett.getTime());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}finally{
		DBUtils.closeResource(ps, rs, con);
		}
		return sett;
	}
}
