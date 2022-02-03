package com.json;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Timestamp;

public class JsonDao {
	private String driver = "org.mariadb.jdbc.Driver";
	private String url = "jdbc:mariadb://127.0.0.1:3306/";
	private String id = "root";
	private String pw = "0000";
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	public JsonDao() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			connection = DriverManager.getConnection(url, id, pw);
			System.out.println("Connection 생성 성공");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//json 데이터 목록 조회
	public ArrayList<JsonDto> jsonSelect(){
		ArrayList<JsonDto> jsonDtoList = new ArrayList<JsonDto>();
		
		connection = null;
		statement = null;
		resultSet = null;
		
		try {
			connection = DriverManager.getConnection(url, id, pw);
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from testJson");
			
			while(resultSet.next()) {
				String EventID = resultSet.getString("EventID");
				String EventType = resultSet.getString("EventType");
				int CamID = resultSet.getInt("CamID");
				String PlaneID = resultSet.getString("PlaneID");
				int PeriodEnd = resultSet.getInt("PeriodEnd");
				int PeriodStart = resultSet.getInt("PeriodStart");
				int Amount = resultSet.getInt("Amount");
				Timestamp Reg_DT = resultSet.getTimestamp("Reg_DT");
				
				JsonDto jsonDto = new JsonDto(EventID, EventType, CamID, PlaneID, PeriodEnd, PeriodStart, Amount, Reg_DT);
				jsonDtoList.add(jsonDto);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
				try {
					if(resultSet != null) {
					resultSet.close();
					}
					if(statement != null) {
						statement.close();
					}
					if(connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		return jsonDtoList;
	}
	public void modify(String EventID, String EventType, int CamID, String PlaneID, int PeriodEnd, int PeriodStart, int Amount) {
        // TODO Auto-generated method stub
		connection = null;
		statement = null;
		resultSet = null;
 
        try {
            connection = dataSource.getConnection();
            String query = "update mvc_board set bName=?, bTitle=?, bContent=? where bId=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, bName);
            pstmt.setString(2, bTitle);
            pstmt.setString(3, bContent);
            pstmt.setInt(4, Integer.parseInt(bId));
            int result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }finally {
            try {
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
    }
 
    public void delete(String bId) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = dataSource.getConnection();
            String query = "delete from mvc_board where bId=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, Integer.parseInt(bId));
            int result = pstmt.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
    }
}
