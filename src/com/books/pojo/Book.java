package com.books.pojo;

public class Book {
	private String title;
	private int marc_no;
	private String press;
	private String author;

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMarc_no() {
		return marc_no;
	}

	public void setMarc_no(int mro_no) {
		this.marc_no = mro_no;
	}

	public String toString() {

		return "mco_no:" + this.marc_no + " booktitle:" + this.title;
	}

}
