package com.yb.spring6.tx.service;

/**
 * ClassName: CheckoutService
 * Package: com.yb.spring6.tx.service
 * Description:
 *
 * @Author yang
 * @Create 2023/8/2 11:01
 * @Version
 */
public interface CheckoutService {
    //买多本书的方法
    void checkout(Integer[] bookIds, Integer userId);
}
