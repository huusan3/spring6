package com.yb.spring6.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * ClassName: JDBCTemplateTest
 * Package: com.yb.spring6.jdbc
 * Description:
 *
 * @Author yang
 * @Create 2023/7/17 17:19
 * @Version
 */
@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加、修改、操作
    @Test
    public void testUpdate(){
        /*
        //一 添加
        //1 编写SQL语句
        String sql = "INSERT INTO t_emp VALUES(NULL,?,?,?)";
        //2 调用jdbcTemplate的方法，传入相关参数
//        Object[] params = {"swang",25,"boy"};
//        int rows = jdbcTemplate.update(sql, params);
        int rows = jdbcTemplate.update(sql,"jhshi",26,"男");//int表示影响行数
        System.out.println(rows);
         */

        /*
        //二 修改
        String sql = "update t_emp set age=? where id=?";
        int rows = jdbcTemplate.update(sql, "26", 2);
        System.out.println(rows);
         */

        //三 删除
        String sql = "delete from t_emp where id=?";
        int rows = jdbcTemplate.update(sql, 3);
        System.out.println(rows);
    }

    //四 查询
    //查询 返回对象
    @Test
    public void testSelectObject(){
        String sql = "select * from t_emp where id=?";
        //方法1：手动封装
//        Emp empResult = jdbcTemplate.queryForObject(sql,
//                (rs, rowNum) -> {
//                    Emp emp = new Emp();
//                    emp.setId(rs.getInt("id"));
//                    emp.setName(rs.getString("name"));
//                    emp.setAge(rs.getInt("age"));
//                    emp.setSex(rs.getString("sex"));
//                    return emp;
//                }, 1);
//        System.out.println(empResult);

        //方法2：
        Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class),1);
        System.out.println(emp);
    }

    //查询 返回list集合
    @Test
    public void testSelectList(){
        String sql = "select * from t_emp";
        List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(list);
    }

    //查询 返回单个值
    @Test
    public void testSelectValue(){
        //查询表中有多少天记录
        String sql = "select count(*) from t_emp";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

}
