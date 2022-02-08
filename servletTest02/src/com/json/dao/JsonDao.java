package com.json.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.sql.DataSource;
import com.json.dto.JsonDto;
import java.sql.Timestamp;

public class JsonDao {
	DataSource dataSource;
	
	private final String driver = "org.mariadb.jdbc.Driver";
	private String url = "jdbc:mariadb://127.0.0.1:3306/jsondata";
	private String id = "root";
	private String pw = "0000";

	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public JsonDao() {
		try {
			Class.forName(driver);
			System.out.println("마리아DB연동");
			connection = DriverManager.getConnection(url, id, pw);
			System.out.println("Connection 성공");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insertJson(String EventID, String EventType, String CamID, String PlaneID, String PeriodEnd, String PeriodStart, String Amount, String Reg_DT) {
		connection = null;
		preparedStatement = null;
		
		try {
			connection = DriverManager.getConnection(url, id, pw);
			String query = "insert into testJson (EventID, EventType, CamID, PlaneID, PeriodEnd, PeriodStart, Amount, Reg_DT) "
					+ "values (\"evt_1KGBx1GG19GQA0KmX7wRBJ98\",\"invoice.payment_succeeded\",\"138669\",\"doorcam-cloud-plan\",\"1644450027\",\"1641771627\",0,\"2020-02-07\")";
			preparedStatement = connection.prepareStatement(query);
			/*
			 * preparedStatement.setString(1, EventID); preparedStatement.setString(2,
			 * EventType); preparedStatement.setInt(3, Integer.parseInt(CamID));
			 * preparedStatement.setString(4, PlaneID); preparedStatement.setInt(5,
			 * Integer.parseInt(PeriodEnd)); preparedStatement.setInt(6,
			 * Integer.parseInt(PeriodStart)); preparedStatement.setInt(7,
			 * Integer.parseInt(Amount)); preparedStatement.setTimestamp(8,
			 * Timestamp.valueOf(Reg_DT));
			 */
			int insertResult = preparedStatement.executeUpdate();
			System.out.println(insertResult);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException eFinal) {
				System.out.println(eFinal.getMessage());
			}
		}
	}
	
	//json 데이터 셀렉트
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
	
	public void modifyJson(String EventID, String EventType, String CamID, String PlaneID, String PeriodEnd, String PeriodStart, String Amount) {
        // TODO Auto-generated method stub
		connection = null;
		statement = null;
		resultSet = null;
 
        try {
            connection = DriverManager.getConnection(url, id, pw);
            String query = "update testJson set EventID=? EventType=?, CamID=?, PlaneID=?, PerionEnd=?, PeriodStart=?, Amount=?";
            statement = connection.prepareStatement(query);
            preparedStatement.setString(1, EventID);
            preparedStatement.setString(2, EventType);
            preparedStatement.setInt(3, Integer.parseInt(CamID));
            preparedStatement.setString(4, PlaneID);
            preparedStatement.setInt(5, Integer.parseInt(PeriodEnd));
            preparedStatement.setInt(6, Integer.parseInt(PeriodStart));
            preparedStatement.setInt(7, Integer.parseInt(Amount));
            int resultModify = preparedStatement.executeUpdate();
            System.out.println(resultModify);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }finally {
            try {
                if(preparedStatement != null) {
                	preparedStatement.close();
                }
                if(connection != null) {
                	connection.close();
                }
            } catch (SQLException eFinal) {
                System.out.println(eFinal.getMessage());
            }
        }
    }
 
    public void deleteJson(String EventID) {

        connection = null;
        preparedStatement = null;
        
        try {
        	connection = dataSource.getConnection();
            String query = "delete from testJson where EventID=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, EventID);
            int resultDelete = preparedStatement.executeUpdate();
            System.out.println(resultDelete);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(preparedStatement != null) {
                	preparedStatement.close();
                }
                if(connection != null) {
                	connection.close();
                }
            } catch (SQLException eFinal) {
                System.out.println(eFinal.getMessage());
            }
        }
    }
}
