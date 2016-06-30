package com.fileUploader.booksDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.fileUploader.config.PropertiesConfiguration;
import com.fileUploader.model.Books;

public class BooksDAO {

	public List<Books> retreiveBooks(String searchItem) {

			List<Books> retreivedBooks = new ArrayList<Books>();
			Books book = new Books();
		Properties prop = new Properties();
		new PropertiesConfiguration().loadProperties(prop);

		Connection conn = null;
		Statement stmt = null;
		String JDBC_DRIVER=prop.getProperty("JDBC_DRIVER");
		String DB_URL=prop.getProperty("DB_URL");
		String USER=prop.getProperty("USER");
		String PASS=prop.getProperty("PASS");
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connecting to database...");
			

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql = "SELECT * FROM BOOKS";
			
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String name = rs.getString("NAME");
				if(name.contains(searchItem)){
					book.setName(name);
					book.setId(rs.getInt("ID"));
					book.setAuthor(rs.getString("AUTHOR"));
					book.setFileLocation(rs.getString("LOCATION"));
				}
				retreivedBooks.add(book);
			}
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
}
