package com.myaccess.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.myaccess.Models.FlowEE;
import com.myaccess.Models.Guest;
import com.myaccess.Models.User;
import com.myaccess.Util.AES256;

public class UserDAO {
	
	DB db = new DB();
	AES256 aes256 = new AES256();
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet result;
	
	public void createGuest(Guest guest) {
		
        String insertSQL = "INSERT INTO tb_guest (ssn, fullname, gender, contact_number, company_name, create_date, observations, blocked) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    	try {
    		conn = db.connect();
            pstmt = conn.prepareStatement(insertSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, guest.getsSN());
            pstmt.setString(2, guest.getFullName());
            pstmt.setString(3, guest.getGender());
            pstmt.setString(4, guest.getContactNumber());
            pstmt.setString(5, guest.getCompanyName());
            pstmt.setTimestamp(6, guest.getCreateDate());
            pstmt.setString(7, guest.getObservations());
            pstmt.setBoolean(8, guest.getBlocked());
                        
            int rowsAffected = pstmt.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					guest.setId(id);
				}
				rs.close();
			}

	        pstmt.close();
	        conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGuest(Guest guest) {
    	
        String updateSQL = "UPDATE tb_guest SET fullname = ?, gender = ?, contact_number = ?, company_name = ?, observations = ?, blocked = ? WHERE ssn = ?";
		try {
    		conn = db.connect();
            pstmt = conn.prepareStatement(updateSQL);
            pstmt.setString(1, guest.getFullName());
            pstmt.setString(2, guest.getGender());
            pstmt.setString(3, guest.getContactNumber());
            pstmt.setString(4, guest.getCompanyName());
            pstmt.setString(5, guest.getObservations());
            pstmt.setBoolean(6, guest.getBlocked());
            pstmt.setString(7, guest.getsSN());
			pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
		}
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteGuest(String ssn) {
    	
        String deleteSQL = "DELETE FROM tb_guest WHERE ssn = ?";
        try {
    		conn = db.connect();
    		pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setString(1, ssn);
            pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
        }
        catch (SQLException e) {
        	e.printStackTrace();
        }
	}

    public void entryGuest(FlowEE entry) {
    	
        String insertSQL = "INSERT INTO tb_in_out (ssn, vehicle_model, vehicle_plate, destination, person, date, type) VALUES (?, ?, ?, ?, ?, ?, ?)";
    	try {
    		conn = db.connect();
            pstmt = conn.prepareStatement(insertSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, entry.getSsn());
            pstmt.setString(2, entry.getVehicleModel());
            pstmt.setString(3, entry.getVehiclePlate());
            pstmt.setString(4, entry.getDestination());
            pstmt.setString(5, entry.getPerson());
            pstmt.setTimestamp(6, entry.getDate());
            pstmt.setString(7, entry.getType());
                        
            int rowsAffected = pstmt.executeUpdate();
			
			if (rowsAffected > 0) {
				result = pstmt.getGeneratedKeys();
				if (result.next()) {
					int id = result.getInt(1);
					entry.setId(id);
				}
				result.close();
			}
	        pstmt.close();
	        conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void exitGuest(FlowEE exit) {
    	
        String insertSQL = "INSERT INTO tb_in_out (ssn, vehicle_model, vehicle_plate, destination, person, date, type) VALUES (?, ?, ?, ?, ?, ?, ?)";
    	try {
    		conn = db.connect();
            pstmt = conn.prepareStatement(insertSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, exit.getSsn());
            pstmt.setString(2, exit.getVehicleModel());
            pstmt.setString(3, exit.getVehiclePlate());
            pstmt.setString(4, exit.getDestination());
            pstmt.setString(5, exit.getPerson());
            pstmt.setTimestamp(6, exit.getDate());
            pstmt.setString(7, exit.getType());
	        
            int rowsAffected = pstmt.executeUpdate();
			
			if (rowsAffected > 0) {
				result = pstmt.getGeneratedKeys();
				if (result.next()) {
					int id = result.getInt(1);
					exit.setId(id);
				}
				result.close();
			}
	        pstmt.close();
	        conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Guest getGuestBySSN(String ssn) {
    	
        String selectSQL = "SELECT * FROM tb_guest WHERE ssn = ?";
    	try {
    		conn = db.connect();
	        pstmt = conn.prepareStatement(selectSQL);
	        pstmt.setString(1, ssn);
	        result = pstmt.executeQuery();

	        if (result.next()) {
	        	Guest guest = new Guest(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),result.getTimestamp(7), result.getString(8), result.getBoolean(9));
	            return guest;
	        }

	        result.close();
	        pstmt.close();
	        conn.close();
	    }
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
		return null;
    }

    public boolean findGuestBySSN(String ssn) {
    	
        String selectSQL = "SELECT ssn FROM tb_guest WHERE ssn = ?";
    	try {
    		conn = db.connect();
            pstmt = conn.prepareStatement(selectSQL);
            pstmt.setString(1, ssn);
            result = pstmt.executeQuery();

            if (result.next()) {
                return true;
            }

            result.close();
            pstmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    	return false;
    }
    
	public FlowEE getLastFlowBySSN(String ssn) {

        String selectSQL = "SELECT * FROM tb_in_out WHERE ssn = ? ORDER BY date DESC LIMIT 1";
		try {
    		conn = db.connect();
            pstmt = conn.prepareStatement(selectSQL);
            pstmt.setString(1, ssn);
            result = pstmt.executeQuery();

            if (result.next()) {
                FlowEE entry = new FlowEE(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getTimestamp(7), result.getString(8));
                return entry;
            }

        	result.close();
            pstmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

// ============================= USER SIDE ================================

    public boolean findLogin(String username, String password) {

        String selectSQL = "SELECT * FROM tb_users WHERE username = ? AND password = ?";
        try {
    		conn = db.connect();
            pstmt = conn.prepareStatement(selectSQL);
            pstmt.setString(1, username);
            pstmt.setString(2, aes256.encrypt(password));
            result = pstmt.executeQuery();

            if (result.next()) {
            	return true;
            }

        	result.close();
            pstmt.close();
            conn.close();
        }
        catch (SQLException e) {
        	e.printStackTrace();
		}
        return false;
    }

    public boolean findUserByName(String username) {

        String selectSQL = "SELECT username FROM tb_users WHERE username = ?";
        try {
    		conn = db.connect();
            pstmt = conn.prepareStatement(selectSQL);
            pstmt.setString(1, username);
            result = pstmt.executeQuery();

            if (result.next()) {
                return true;
            }

            result.close();
            pstmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	public boolean findBlockedUserStatusByName(String username) {
		
		String selectSQL = "SELECT blocked FROM tb_users WHERE username = ?";
		try {
    		conn = db.connect();
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setString(1, username);
			result = pstmt.executeQuery();

			if (result.next()) {
				return result.getBoolean(1);
			}

			result.close();
			pstmt.close();
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean findRecoveryUser(String username, String question, String answer) {
		
		String selectSQL = "SELECT * FROM tb_users WHERE username = ? AND question = ? AND answer = ?";
		try {
    		conn = db.connect();
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setString(1, username);
			pstmt.setString(2, question);
			pstmt.setString(3, answer);
			result = pstmt.executeQuery();

			if (result.next()) {
				return true;
			}

			result.close();
			pstmt.close();
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

    public User getUserByName(String username) {

        String selectSQL = "SELECT * FROM tb_users WHERE username = ?";
        try {
    		conn = db.connect();
            pstmt = conn.prepareStatement(selectSQL);
            pstmt.setString(1, username);
            result = pstmt.executeQuery();

            if (result.next()) {
                User user = new User(result.getInt(1), result.getString(2), result.getString(3), result.getTimestamp(4), result.getBoolean(5), result.getBoolean(6), result.getString(7), result.getString(8), result.getBoolean(9));
                return user;
            }

            result.close();
            pstmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	public void setUserPassword(String username, String newPassword) {
		
		String updateSQL = "UPDATE tb_users SET password = ? WHERE username = ?";
		try {
			pstmt = conn.prepareStatement(updateSQL);
			pstmt.setString(1, aes256.encrypt(newPassword));
			pstmt.setString(2, username);
			pstmt.execute();
			pstmt.close();
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

    public void setLoggedStatus(Boolean loggedStatus, String username) {
    	
        String updateSQL = "UPDATE tb_users SET logged = ? WHERE username = ?";
		try {
    		conn = db.connect();
            pstmt = conn.prepareStatement(updateSQL);
            pstmt.setBoolean(1, loggedStatus);
            pstmt.setString(2, username);
			pstmt.executeUpdate();
            pstmt.close();
            conn.close();
		}
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}