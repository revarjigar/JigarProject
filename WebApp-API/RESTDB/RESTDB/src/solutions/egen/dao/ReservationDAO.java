package solutions.egen.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import solutions.egen.exception.AppException;
import solutions.egen.model.Reservation;
import solutions.egen.util.DBUtils;

public class ReservationDAO {

	public List<Reservation> fetchAll() throws AppException{

		List<Reservation> rsvList = new ArrayList<Reservation>();

		Connection con = DBUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("SELECT * FROM rsv");

			rs = ps.executeQuery();

			while (rs.next()) {
				Reservation rsv = new Reservation();
				rsv.setId(rs.getInt("ID"));
				rsv.setName(rs.getString("GNAME"));
				rsv.setDate(rs.getString("IDATE"));
				rsv.setEmail(rs.getString("EMAIL"));
				rsv.setPhone(rs.getString("PHONE"));
				rsv.setGuests(rs.getInt("GUESTS"));

				rsvList.add(rsv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}finally{
		DBUtils.closeResource(ps, rs, con);
		}
		return rsvList;
	}
	
	public Reservation fetchOne(int rsvID) throws AppException{

		Reservation rsv=null;
		Connection con = DBUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("SELECT * FROM rsv WHERE ID=?");
			ps.setInt(1, rsvID);
			rs = ps.executeQuery();

			if (rs.next()) {
				rsv= new Reservation();
				rsv.setId(rs.getInt("ID"));
				rsv.setName(rs.getString("GNAME"));
				rsv.setDate(rs.getString("IDATE"));
				rsv.setEmail(rs.getString("EMAIL"));
				rsv.setPhone(rs.getString("PHONE"));
				rsv.setGuests(rs.getInt("GUESTS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}finally{
		DBUtils.closeResource(ps, rs, con);
		}
		return rsv;
	}
	
	public Reservation create(Reservation rsv) throws AppException {
		Connection con = DBUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("INSERT INTO rsv (GNAME, IDATE, EMAIL, PHONE, GUESTS) VALUES (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, rsv.getName());
			ps.setString(2, rsv.getDate());
			ps.setString(3, rsv.getEmail());
			ps.setString(4, rsv.getPhone());
			ps.setInt(5, rsv.getGuests());
			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				//rsv= new Reservation();
				rsv.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}finally{
		DBUtils.closeResource(ps, rs, con);
		}
		return rsv;
	}
	
	public Reservation update(int rsvId,Reservation rsv) throws AppException {///////////////////////////////////////////////
		Connection con = DBUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("UPDATE rsv SET GNAME=?, IDATE=?, EMAIL=?, PHONE=?, GUESTS=? WHERE ID=? ");
			ps.setString(1, rsv.getName());
			ps.setString(2, rsv.getDate());
			ps.setString(3, rsv.getEmail());
			ps.setString(4, rsv.getPhone());
			ps.setInt(5, rsv.getGuests());
			ps.setInt(6, rsvId);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}finally{
		DBUtils.closeResource(ps, rs, con);
		}
		return rsv;
	}
	
	public Reservation delete(int rsvID) throws AppException {
		Reservation emp=null;
		Connection con = DBUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("DELETE FROM rsv WHERE ID=?");
			ps.setInt(1, rsvID);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}finally{
		DBUtils.closeResource(ps, rs, con);
		}
		return emp;
	}
}
