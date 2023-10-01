package com.yb.spring6.tx;

import com.yb.spring6.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * ClassName: TestBookTx
 * Package: com.yb.spring6.tx
 * Description:
 *
 * @Author yang
 * @Create 2023/7/18 17:01
 * @Version
 */
@SpringJUnitConfig(locations = "classpath:beans.xml")
public class TestBookTx {
    @Autowired
    private BookController bookController;

    @Test
    public void testBookTx(){
        bookController.buyBook(1,1);
    }
}
