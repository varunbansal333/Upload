package com.fileUploader.booksDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.fileUploader.config.PropertiesConfiguration;

public class BooksDAO {

	public static List<List<String>> retreiveBooks(String searchItem) {

		List<List<String>> retreivedBooks = new ArrayList<List<String>>();
		Properties prop = new Properties();
		new PropertiesConfiguration().loadProperties(prop);

		Connection conn = null;
		Statement stmt = null;
		String JDBC_DRIVER = prop.getProperty("JDBC_DRIVER");
		String DB_URL = prop.getProperty("DB_URL")
				+ prop.getProperty("DATA_BASE_NAME");
		String USER = prop.getProperty("USER");
		String PASS = prop.getProperty("PASS");
		String table = prop.getProperty("TABLE_NAME");
		String[] columns = prop.getProperty("COLUMNS").split(",");
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql_QUERY = "SELECT * FROM " + table;

			ResultSet rs = stmt.executeQuery(sql_QUERY);
			List<String[]> retrievedRowsList = new ArrayList<String[]>();
			retrievedRowsList.add(columns);
			while (rs.next()) {
				String[] retrievedRow = new String[columns.length];

				for (int i = 0; i < columns.length; i++) {
					retrievedRow[i] = rs.getString(columns[i]);
				}
				retrievedRowsList.add(retrievedRow);
			}
			retreivedBooks = findBooks(retrievedRowsList, searchItem);
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retreivedBooks;
	}

	private static List<List<String>> findBooks(List<String[]> retrievedRowsList, String searchItem) {

		List<List<String>> myList = new ArrayList<List<String>>();
		List<String> book;
		List<String> columns = Arrays.asList(retrievedRowsList.get(0));
		myList.add(columns);
		for (int i = 1; i < retrievedRowsList.size(); i++) {
			String[] items = retrievedRowsList.get(i);
			for (String item : items) {
				if (item.toLowerCase().contains(searchItem.toLowerCase())
						|| searchItem.toLowerCase()
								.contains(item.toLowerCase())) {
					book = Arrays.asList(items);
					myList.add(book);
					break;
				}
			}
		}

		return myList;

	}
}
