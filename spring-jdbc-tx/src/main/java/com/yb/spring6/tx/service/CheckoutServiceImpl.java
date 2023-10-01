package com.yb.spring6.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName: CheckoutServiceImpl
 * Package: com.yb.spring6.tx.service
 * Description:
 *
 * @Author yang
 * @Create 2023/8/2 11:07
 * @Version
 */
@Service
public class CheckoutServiceImpl implements CheckoutService{

    //注入bookService
    @Autowired
    private BookService bookService;

    @Override
    @Transactional
    public void checkout(Integer[] bookIds, Integer userId) {
        for(Integer bookId : bookIds){
            //调用service的方法
            bookService.buyBook(bookId,userId);
        }
    }
}
