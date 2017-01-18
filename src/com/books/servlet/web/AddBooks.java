package com.books.servlet.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.books.pojo.Book;
import com.books.service.BookService;

public class AddBooks extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book book = new Book();
		book.setMarc_no(Integer.parseInt(req.getParameter("marc_no")));
		book.setTitle(req.getParameter("title"));
		book.setAuthor(req.getParameter("author"));
		book.setPress(req.getParameter("press"));
		BookService.insertbook(book);
		// TODO 重复提交请求验证待处理
		req.getRequestDispatcher("/getallbooks").forward(req, resp);
	}

}
