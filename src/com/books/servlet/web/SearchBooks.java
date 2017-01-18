package com.books.servlet.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.books.pojo.Book;
import com.books.service.BookService;

public class SearchBooks extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String booktitle=req.getParameter("booktitle");
		List<Book> booklist=new ArrayList<Book>();
		booklist=BookService.searchbooks(booktitle);
		req.setAttribute("booklist", booklist);
		req.getRequestDispatcher("/showsearchbook.jsp").forward(req, resp);
	}

}
