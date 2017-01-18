package com.books.servlet.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.books.pojo.Book;
import com.books.pojo.Page;
import com.books.service.BookService;
/**
 * 
 * @author Gerry
 *
 */
public class GetAllBooks extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Map<String, Object> map = new HashMap<String, Object>();
		String currentPage = req.getParameter("currentPage");
		Page page = null;
		List<Book> blist = new ArrayList<Book>();
		int totalRow = BookService.getAllBooksCount();
		if(currentPage != null){
            //构造一个page，参数包括总记录条数和当前页号
            page = new Page(totalRow, Integer.parseInt(currentPage));
            //返回查询的结果
            blist = BookService.getbooks(page);
        }else{
            //第一次查询时默认currentPage为1
            page = new Page(totalRow,1);
            //返回查询的结果
            blist = BookService.getbooks(page);
        }
		req.setAttribute("page", page);
		req.setAttribute("blist",blist);
		req.getRequestDispatcher("/showbook.jsp").forward(req,resp);
		System.out.println(page.getStartPos()+","+page.getpageRow()+","+"currentpage:"+page.getcurrentPage());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

}
