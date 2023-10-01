package com.yb.spring6.tx.dao;

/**
 * ClassName: BookDao
 * Package: com.yb.spring6.tx.dao
 * Description:
 *
 * @Author yang
 * @Create 2023/7/18 16:35
 * @Version
 */
public interface BookDao {
    //根据图书id查询图书价格
    Integer getBookPriceByBookId(Integer bookId);

    //更新图书库存量
    void updateStock(Integer bookId);

    //更新用户账户余额
    void updateUserBalance(Integer userId, Integer price);
}
