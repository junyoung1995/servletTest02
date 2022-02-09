package com.json.dao;

import java.io.PrintWriter;
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
	
	public void insertJson(JsonDto jsonDto) {
		preparedStatement = null;
		
		try {
			String query = "insert into testJson(EventID, EventType, CamID, PlaneID, PeriodEnd, PeriodStart, Amount, Reg_DT) values(?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, jsonDto.getEventID());
			preparedStatement.setString(2, jsonDto.getEventType());
			preparedStatement.setString(3, jsonDto.getCamID());
			preparedStatement.setString(4, jsonDto.getPlaneID());
			preparedStatement.setLong(5, jsonDto.getPeriodEnd());
			preparedStatement.setLong(6, jsonDto.getPeriodStart());
			preparedStatement.setLong(7, jsonDto.getAmount());
			preparedStatement.setTimestamp(8, jsonDto.getReg_DT());
			int insertResult = preparedStatement.executeUpdate();
			System.out.println(insertResult);
		} catch (SQLException e) {
			System.out.println(String.format("SQL 구문 오류 = %s", e.getMessage()));
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException eFinal) {
				System.out.println(String.format("또 다른 구문 오류 = %s", eFinal.getMessage()));;
			}
		}
	}
	
	//json 데이터 셀렉트
	public ArrayList<JsonDto> jsonSelect(){
		ArrayList<JsonDto> jsonDtoList = new ArrayList<JsonDto>();

		statement = null;
		resultSet = null;
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from testJson");
			
			while(resultSet.next()) {
				String EventID = resultSet.getString("EventID");
				String EventType = resultSet.getString("EventType");
				String CamID = resultSet.getString("CamID");
				String PlaneID = resultSet.getString("PlaneID");
				long PeriodEnd = resultSet.getInt("PeriodEnd");
				long PeriodStart = resultSet.getInt("PeriodStart");
				long Amount = resultSet.getInt("Amount");
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
		statement = null;
		resultSet = null;
 
        try {
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
        preparedStatement = null;
        
        try {
            String query = "delete from testJson where EventID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, EventID);
            System.out.println(String.format("너의 변수 값은 = %s", EventID));
            int resultDelete = preparedStatement.executeUpdate();
            System.out.println(resultDelete);
        } catch (SQLException e) {
            System.out.println(String.format("오류 사항 = %s", e.getMessage()));
        } finally {
            try {
                if(preparedStatement != null) {
                	preparedStatement.close();
                }
                if(connection != null) {
                	connection.close();
                }
            } catch (SQLException eFinal) {
                System.out.println(String.format("오류 = %s", eFinal.getMessage()));
            }
        }
    }
    
    public void createTable() {
    	System.out.println("테이블 생성");

    	try {
			String query = "create table JsonData.testJson\r\n" + 
					"(\r\n" + 
					"	EventID	VARCHAR(30) Not Null,\r\n" + 
					"	EventType VARCHAR(30) not null,\r\n" + 
					"	CamID VARCHAR(30) not null,\r\n" + 
					"	PlaneID VARCHAR(30) not null,\r\n" + 
					"	PeriodEnd int(11) not null,\r\n" + 
					"	PeriodStart int(11) not null,\r\n" + 
					"	Amount int(11) not null,\r\n" + 
					"	Reg_DT DateTime not null,\r\n" +
					"	Primary Key (EventID),\r\n" +
					"	key camIndex (CamID)\r\n" +
					")";
			preparedStatement = connection.prepareStatement(query);
		    boolean resultCreateTable = preparedStatement.execute ();
		    System.out.println(String.format("결과 = %s", resultCreateTable));
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
    }
    public void DropTable() {
    	System.out.println("테이블 삭제");
    	try {
			String query = "Drop table testJson";
			preparedStatement = connection.prepareStatement(query);
			
		    boolean resultDropTable = preparedStatement.execute ();
		    
		    System.out.println(String.format("결과 = %s", resultDropTable));
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
    }
    public void AlterTable() {
    	System.out.println("테이블 수정 완료");
    	try {
			String query = "Alter table testJson add jbColumn int after Reg_DT";
			preparedStatement = connection.prepareStatement(query);
		    boolean resultAlterTable = preparedStatement.execute ();
		    System.out.println(String.format("결과 = %s", resultAlterTable));
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
    }
}
