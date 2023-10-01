package com.yb.spring6.tx.service;

/**
 * ClassName: BookService
 * Package: com.yb.spring6.tx.service
 * Description:
 *
 * @Author yang
 * @Create 2023/7/18 16:35
 * @Version
 */
public interface BookService {
    void buyBook(Integer bookId, Integer userId);
}
