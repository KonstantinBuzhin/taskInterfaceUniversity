package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Department;
import model.Lector;

public class DBWorker {

	private final static String SELECTALL = "SELECT * FROM lectors";
	private final static String NAMEDEPARTMENT = "SELECT * FROM departments WHERE department_Name=?";
	private final static String UNIVERSITYBYNAMEDEPARTMENT = "SELECT * FROM university Inner join departments ON university.id_Department = departments.id_Department Inner join lectors ON university.id_Lector = lectors.id_Lector WHERE departments.department_Name=?";
	private final static String GLOBALSEARCH = "SELECT * FROM university Inner join departments ON university.id_Department = departments.id_Department Inner join lectors ON university.id_Lector = lectors.id_Lector";

	public List<Lector> getLectors() {
		List<Lector> lectorsList = new ArrayList<Lector>();

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/university?" + "user=root&password=");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECTALL);
			while (rs.next()) {
				Lector lector = new Lector();
				lector.setIdLector(rs.getLong("id_Lector"));
				lector.setDegree(rs.getString("degree"));
				lector.setSalary(rs.getInt("salary"));
				lector.setLectorName(rs.getString("lector_Name"));
				lector.setLectorSurname(rs.getString("lector_Surname"));

				lectorsList.add(lector);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}

				stmt = null;
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lectorsList;
	}

	public void getHeadDepartment(String departmentName) {
		Department department = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/university?" + "user=root&password=");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.prepareStatement(NAMEDEPARTMENT);
			stmt.setString(1, departmentName);
			rs = stmt.executeQuery();
			if (rs.next()) {
				department = new Department();
				department.setIdDepartment(rs.getLong("id_Department"));
				department.setDepartmentName(departmentName);
				department.setHeadDepartmentName(rs.getString("head_Department_Name"));
				department.setHeadDepartmentSurname(rs.getString("head_Department_Surname"));
				System.out.println("Head of " + departmentName + " department is "
						+ rs.getString("head_Department_Surname") + " " + rs.getString("head_Department_Name"));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}

				stmt = null;
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void getAverageSalary(String departmentName) {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/university?" + "user=root&password=");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.prepareStatement(UNIVERSITYBYNAMEDEPARTMENT);
			stmt.setString(1, departmentName);
			rs = stmt.executeQuery();
			int salary = 0;
			int countEmployees = 0;
			while (rs.next()) {

				salary += rs.getInt("salary");
				countEmployees++;
			}
			if (countEmployees != 0) {
				System.out.println("The average salary of " + departmentName + " is " + (salary / countEmployees));
			} else {
				System.out.println("No answer");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}

				stmt = null;
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void writeCountEmployeesByDepartmentName(String departmentName) {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/university?" + "user=root&password=");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.prepareStatement(UNIVERSITYBYNAMEDEPARTMENT);
			stmt.setString(1, departmentName);
			rs = stmt.executeQuery();
			int countEmployees = 0;
			while (rs.next()) {

				countEmployees++;
			}
			System.out.println("Answer: " + countEmployees);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}

				stmt = null;
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void writeStatisticByDepartmentName(String departmentName) {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/university?" + "user=root&password=");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.prepareStatement(UNIVERSITYBYNAMEDEPARTMENT);
			stmt.setString(1, departmentName);
			rs = stmt.executeQuery();
			int countAssistans = 0;
			int countAssociateProfessors = 0;
			int countProfessors = 0;
			while (rs.next()) {

				switch (rs.getString("degree")) {
				case "assistant":
					countAssistans++;
					break;
				case "associate professor":
					countAssociateProfessors++;
					break;
				case "professor":
					countProfessors++;
					break;

				default:
					break;
				}
			}
			System.out.println("Answer: assistans - " + countAssistans + "\n" + "associate professors - "
					+ countAssociateProfessors + "\n" + "professors - " + countProfessors);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}

				stmt = null;
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void globalSearch(String word) {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/university?" + "user=root&password=");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.prepareStatement(GLOBALSEARCH);

			rs = stmt.executeQuery();

			String line = "";
			while (rs.next()) {
				if (rs.getString("lector_Name").contains(word)
						&& !line.contains(rs.getString("lector_Name") + " " + rs.getString("lector_Surname"))) {

					line += rs.getString("lector_Name") + " " + rs.getString("lector_Surname") + ", ";

				} else if (rs.getString("lector_Surname").contains(word)
						&& !line.contains(rs.getString("lector_Name") + " " + rs.getString("lector_Surname"))) {

					line += rs.getString("lector_Name") + " " + rs.getString("lector_Surname") + ", ";

				} else if (rs.getString("head_Department_Name").contains(word) && !line.contains(
						rs.getString("head_Department_Name") + " " + rs.getString("head_Department_Surname"))) {

					line += rs.getString("head_Department_Name") + " " + rs.getString("head_Department_Surname")
							+ "(head of Department), ";

				} else if (rs.getString("head_Department_Surname").contains(word) && !line.contains(
						rs.getString("head_Department_Name") + " " + rs.getString("head_Department_Surname"))) {

					line += rs.getString("head_Department_Name") + " " + rs.getString("head_Department_Surname")
							+ "(head of Department), ";
				}

			}
			if (line.length() > 2) {
				line = line.substring(0, line.length() - 2);
				System.out.println("Answer: " + line);
			} else {
				System.out.println("No answer");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}

				stmt = null;
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
