package com.myaccess.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.myaccess.Models.User;
import com.myaccess.Util.AES256;

public class AdminDAO extends UserDAO {
	
	DB db = new DB();
	AES256 aes256 = new AES256();
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet result;

    public void createUser(User user) {
    	
        String insertSQL = "INSERT INTO tb_users (username, password, create_date, blocked, admin, question, answer, logged) VALUES (? , ? , ? , ? , ?, ?, ?, ?)";
        try {
       		conn = db.connect();
            pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, aes256.encrypt(user.getPassword()));
            pstmt.setTimestamp(3, user.getCreateDate());
            pstmt.setBoolean(4, user.getBlocked());
            pstmt.setBoolean(5, user.getAdmin());
            pstmt.setString(6, user.getQuestion());
            pstmt.setString(7, user.getAnswer());
            pstmt.setBoolean(8, false);
            pstmt.execute();
	        pstmt.close();
	        conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String username) {
    	
        String deleteSQL = "DELETE FROM tb_users WHERE username = ?";
        try {
       		conn = db.connect();
            pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setString(1, username);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public List<User> getAllUsers() {

        String selectSQL = "SELECT * FROM tb_users ORDER BY id";
        try {
    		conn = db.connect();
            pstmt = conn.prepareStatement(selectSQL);
	        result = pstmt.executeQuery();
	    
            List<User> list = new ArrayList<>();

            while (result.next()) {
                Integer id = result.getInt("id");
                String username = result.getString("username");
                String password = result.getString("password");
                Timestamp createDate = result.getTimestamp("create_date");
                Boolean blocked = result.getBoolean("blocked");
                Boolean admin = result.getBoolean("admin");
                String question = result.getString("password");
                String answer = result.getString("password");
                Boolean logged = result.getBoolean("logged");
                list.add(new User(id, username, password, createDate, blocked, admin, question, answer, logged));
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
}