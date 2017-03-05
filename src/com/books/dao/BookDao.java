package com.books.dao;

import java.util.List;

import com.books.pojo.Book;
import com.books.pojo.Description;
import com.books.pojo.Page;
public interface BookDao {
	//public Book selectbook(int maro_no) throws Exception;

	public List<Book> getAllBooks() throws Exception;

	public List<Integer> getAllBookmarc1(String booktitle);
	
//	public List<Integer> getAllBookmarc();

	public Description getBookDescription(int marc_no);

	public Book getBookBymarc_no(int marc_no);
	
	void insertbook(Book book);
	
	void deletebook(int marc_no);
	
	List<Book> searchbooks(String booktitle);

	int getAllBooksCount();
	
	public List<Book> getbooks(Page page);
}
