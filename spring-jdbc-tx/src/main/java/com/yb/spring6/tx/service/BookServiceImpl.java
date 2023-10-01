package com.yb.spring6.tx.service;

import com.yb.spring6.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: BookServiceImpl
 * Package: com.yb.spring6.tx.service
 * Description:
 *
 * @Author yang
 * @Create 2023/7/18 16:35
 * @Version
 */
//service层，又叫业务逻辑层
@Service
//@Transactional(noRollbackFor = ArithmeticException.class)
@Transactional
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookDao;

//    //TODO 模拟超时效果
//
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


    //方法    买书：图书id和用户id

    @Override
    public void buyBook(Integer bookId, Integer userId) {
        //根据图书的id查询图书的价格
        Integer price = bookDao.getBookPriceByBookId(bookId);
        //更新图书表中的库存量（库存量-1）
        bookDao.updateStock(bookId);
        //更新用户表的用户余额（用户余额-图书价格）
        bookDao.updateUserBalance(userId,price);
//        System.out.println(1/0);
    }
}
