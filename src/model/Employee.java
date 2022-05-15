package model;

import java.sql.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class Employee {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ceb_power_usage", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public String insertEmployee(String employee_code, String empName, String address, int telepohneNo) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}

			// create a prepared statement
			String query = " insert into employee(`employee_id`,`employee_code`,`employee_name`,`address`,`telepohne_no`)" + " values(?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, employee_code);
			preparedStmt.setString(3, empName);
			preparedStmt.setString(4, address);
			preparedStmt.setInt(5, telepohneNo);
			// execute the statement
			preparedStmt.execute();
			con.close();

			String newItems = readEmployee();
			 output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}"; 

		} catch (Exception e) {
			output = "{\"status\":\"error\",\"data\":\"Error while Inserting the details.\"}";
					 
					 System.err.println(e.getMessage()); 

		}
		return output;
	}

	public String readEmployee() {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Employee Code</th><th>Employee Name</th><th>address</th><th>Telepohne No</th><th>Update</th><th>Remove</th></tr>";

			String query = "select * from employee";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String employee_id = Integer.toString(rs.getInt("employee_id"));
				String employee_code = rs.getString("employee_code");
				String empName = rs.getString("employee_name");
				String address = rs.getString("address");
				int telepohneNo = rs.getInt("telepohne_no");

				// Add into the html table
				output += "<tr><td>" + employee_code + "</td>";
				output += "<td>" + empName + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + telepohneNo + "</td>";
				
				//buttons 
				output += "<td><input name='btnUpdate' type='button' value='Update' "
						+ "class='btnUpdate btn btn-success' data-itemid='" + employee_id + "'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' "
						+ "class='btnRemove btn btn-danger' data-itemid='" + employee_id + "'></td></tr>";
			}

			con.close();

			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateEmployee(String employee_id,String employee_code, String empName, String address, int telepohneNo) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE employee SET employee_code=?, employee_name=?, address=?, telepohne_no=? WHERE employee_id=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, employee_code);
			preparedStmt.setString(2, empName);
			preparedStmt.setString(3, address);
			preparedStmt.setInt(4, telepohneNo);
			preparedStmt.setInt(5, Integer.parseInt(employee_id));

			// execute the statement
			preparedStmt.execute();
			con.close();

			String newItems = readEmployee();
			 output = "{\"status\":\"success\", \"data\": \"" +  newItems + "\"}"; 

		} catch (Exception e) {
			output = "{\"status\":\"error\",\"data\":\"Error while Updating the details.\"}";
					 
					 System.err.println(e.getMessage()); 

		}
		return output;
	}

	public String deleteEmployee(String employee_id) {
		String output = "";
		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from employee where employee_id=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(employee_id));

			// execute the statement
			preparedStmt.execute();
			con.close();

			String newItems = readEmployee();
			 output = "{\"status\":\"success\", \"data\": \"" +  newItems + "\"}"; 

		} catch (Exception e) {
			output = "{\"status\":\"error\",\"data\":\"Error while deleting the details.\"}";
					 
					 System.err.println(e.getMessage()); 

		}
		return output;
	}
	
	public String getCustomerPowerUsageByEmployee(int employeeId)
	{
		String output = "";
		 JSONArray jsonArray = new JSONArray();
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			String query = "select e.employee_id,e.employee_name,p.units,p.amount,p.customer_id from power_usage p,employee e where e.employee_id = p.employee_id AND e.employee_id = " + employeeId;
			PreparedStatement preparedStmt = con.prepareStatement(query);
//			preparedStmt.setInt(1, customerId);
			// binding values
			ResultSet rs = preparedStmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				int columns = rs.getMetaData().getColumnCount();
				JSONObject obj = new JSONObject();
				for (int i = 0; i < columns; i++)
		            obj.put(rs.getMetaData().getColumnLabel(i + 1).toLowerCase(), rs.getObject(i + 1));
		 
		        jsonArray.put(obj);
			}
			con.close();
			// Complete the html table
		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return jsonArray.toString();
	}
}
