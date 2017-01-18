package com.books.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.books.dao.BookDao;
import com.books.pojo.Book;
import com.books.pojo.Description;
import com.books.pojo.Page;
import com.books.util.MybatisUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * @author Gerry
 *
 */
public class BookService {

	// TODO 将BookService设置为单例调用

	private static BookDao bookdao;
	private static SqlSession sqlsession;
	private static SqlSessionFactory sqlsessionfactory;

	static {
		// 映射到mapper
		sqlsessionfactory = MybatisUtils.getSqlSessionFactory();
		// 设置为true，更新后自动提交
		sqlsession = sqlsessionfactory.openSession(true);
		bookdao = (BookDao) sqlsession.getMapper(BookDao.class);
	}

	// 将数据库查询数据转换成json数据发送到微信,查询所有
//	public static JSONObject getAllBooks() throws Exception {
//		return null;
//	}

	public static JSONObject getAllBooksSearch(String booktitle) throws Exception {
		JSONObject jsondescription = new JSONObject();
		JSONObject jsonbook = new JSONObject();
		JSONArray jsontotal = new JSONArray();
		JSONObject uptoserver = new JSONObject();
		// 获得所有书的marc_no
		List<Integer> bookmarc = bookdao.getAllBookmarc1(booktitle);
		System.out.println(bookmarc);
		int bookscount = bookmarc.size();
		// 遍历list来组装json,四层嵌套
		for (Integer tmp : bookmarc) {
			Description dp = bookdao.getBookDescription(tmp);
			Book book = bookdao.getBookBymarc_no(tmp);
			jsondescription.put("author", dp.getAuthor());
			jsondescription.put("press", dp.getPress());
			jsonbook.put("description", jsondescription);
			jsonbook.put("title", book.getTitle());
			jsonbook.put("marc_no", book.getMarc_no());
			jsontotal.add(jsonbook);
			uptoserver.put("books", jsontotal);
			uptoserver.put("book_count", bookscount);
			uptoserver.put("is_alot", false);
		}
		return uptoserver;
	}

	// 后台查询所有书本信息
	public static List<Book> getbooks() {
		List<Book> blist = new ArrayList<Book>();
		try {
			blist = bookdao.getAllBooks();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return blist;
	}

	public static void insertbook(Book book) {
		bookdao.insertbook(book);
	}

	public static void deletebook(int marc_no) {
		bookdao.deletebook(marc_no);

	}

	public static List<Book> searchbooks(String title) {
		return bookdao.searchbooks(title);
	}

	public static int getAllBooksCount() {
		return bookdao.getAllBooksCount();
	}

	public static List<Book> getbooks(Page page) {
		return bookdao.getbooks(page);
	}
}
