package com.yb.spring6.tx.controller;

import com.yb.spring6.tx.service.BookService;
import com.yb.spring6.tx.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * ClassName: BookController
 * Package: com.yb.spring6.tx.controller
 * Description:
 *
 * @Author yang
 * @Create 2023/7/18 16:34
 * @Version
 */
@Controller
public class BookController {
//    @Autowired
//    private BookService bookService;
//
//    //方法    买书：图书id和用户id
//    public void buyBook(Integer bookId,Integer userId){
//        //调用service中的方法
//        bookService.buyBook(bookId,userId);
//    }

    @Autowired
    private CheckoutService checkoutService;


    public void checkout(Integer[] bookIds, Integer userId){
        checkoutService.checkout(bookIds,userId);
    }

    public void buyBook(int i, int i1) {
    }
}
