package com.fileUploader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fileUploader.booksDAO.BooksDAO;

public class LibrarySearchServletService extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String searchItem = request.getParameter("searchItem");
		
		if(searchItem.trim().length()>0){
		List<List<String>> books = BooksDAO.retreiveBooks(searchItem);
		if(!books.isEmpty()){
		request.setAttribute("retrievedData", books);
		request.setAttribute("searchItem", searchItem);}
		}
		request.getRequestDispatcher("/ServletResponseBooks.jsp").forward(request, response);
	}
}
