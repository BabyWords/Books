package test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.books.dao.BookDao;
import com.books.pojo.Book;
import com.books.pojo.Description;
import com.books.service.BookService;
import com.books.util.MybatisUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test extends MybatisUtils {
	private static BookDao bookdao;
	private static SqlSession sqlsession;
	private static SqlSessionFactory sqlsessionfactory;
private static BookService bookservice;
	public static void main(String[] args) throws Exception {
		sqlsessionfactory = MybatisUtils.getSqlSessionFactory();
		sqlsession = sqlsessionfactory.openSession();
		bookdao = (BookDao) sqlsession.getMapper(BookDao.class);
		bookservice =new BookService();
		JSONObject jsondescription = new JSONObject();
		JSONObject jsonbook = new JSONObject();
		JSONArray jsontotal = new JSONArray();
		JSONObject uptoserver = new JSONObject();
		// 获得所有书的marc_no
		List<Integer> bookmarc = bookdao.getAllBookmarc1("as");
		int bookscount=bookmarc.size();
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
			uptoserver.put("book_count",bookscount);
			uptoserver.put("is_alot", false);
		}
		List<Book> blist = new ArrayList<Book>();
		Book book=new Book();
		book.setMarc_no(1);
		book.setTitle("ssss");
		book.setAuthor("ssss");
		book.setPress("ssss");
		bookservice.insertbook(book);
		blist = bookservice.getbooks();
		System.out.println(uptoserver);
	}
}
