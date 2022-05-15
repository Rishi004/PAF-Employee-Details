package com;

import model.Employee;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeAPI
 */
@WebServlet("/EmployeeAPI")
public class EmployeeAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Employee emp = new Employee();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeAPI() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String output = emp.insertEmployee(request.getParameter("employee_code"), request.getParameter("empName"),
				request.getParameter("address"), Integer.parseInt(request.getParameter("telepohneNo")));
		response.getWriter().write(output);
	}

	private static Map getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params) {
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
		}
		return map;
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = emp.updateEmployee(paras.get("hidempIDSave").toString(), (String) paras.get("employee_code"),
				paras.get("empName").toString(), paras.get("address").toString(),
				Integer.parseInt((String) paras.get("telepohneNo")));
		response.getWriter().write(output);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = emp.deleteEmployee(paras.get("hidempIDSave").toString());
		response.getWriter().write(output);
	}
}
