package com.yb.spring6.iocxml.di;

/**
 * ClassName: Book
 * Package: com.yb.spring6.iocxml.di
 * Description:
 *
 * @Author yang
 * @Create 2023/6/19 11:33
 * @Version
 */
public class Book {
    private String bname;
    private String author;
    private String others;

    //生成属性的set方法
    public void setBname(String bname) {
        this.bname = bname;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    //无参构造器
    public Book() {
        System.out.println("无参构造器执行了...");
    }

    //有参数的构造器
    public Book(String bname, String author) {
        System.out.println("有参构造器执行了...");
        this.bname = bname;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", others='" + others + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //set方法注入
        Book book = new Book();
        book.setBname("java");
        book.setAuthor("sgg");

        //构造器注入
        Book book1 = new Book("c++","hmcxy");
    }
}
