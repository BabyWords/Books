package com.books.servlet.wechat;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.books.service.BookService;

import net.sf.json.JSONObject;
/**
 * 
 * @author Gerry
 *
 */
public class WechatBooks extends HttpServlet {
	private JSONObject uptoserver;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		uptoserver = new JSONObject();
		String booktitle=req.getParameter("book");
		try {
			uptoserver = BookService.getAllBooksSearch(booktitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println(uptoserver.toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doGet(req, resp);
	}

}
