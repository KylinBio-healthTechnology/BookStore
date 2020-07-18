package com.cyf.bean;

public class Book {
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookSprice=" + bookSprice + ", bookAuthor="
				+ bookAuthor + ", bookCount=" + bookCount + ", booktype=" + booktype + ", bookremark=" + bookremark
				+ ", img=" + img + "]";
	}

	private Integer bookId;  //编号
    private String bookName;  //书名
    private double bookSprice;  //价格
    private String bookAuthor;  //作者
    private Integer bookCount;  //数量
    private String booktype;//类型
    private String bookremark;//简介
	private String img;//图片
    
    public String getBooktype() {
		return booktype;
	}
    


	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}

	public String getBookremark() {
		return bookremark;
	}

	public void setBookremark(String bookremark) {
		this.bookremark = bookremark;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookSprice() {
        return bookSprice;
    }

    public void setBookSprice(double bookSprice) {
        this.bookSprice = bookSprice;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

}
