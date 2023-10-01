package com.yb.spring6.iocxml.di1;

import java.util.List;

/**
 * ClassName: Dept
 * Package: com.yb.spring6.iocxml.di1
 * Description:
 *
 * @Author yang
 * @Create 2023/6/19 17:04
 * @Version
 */
//部门类
public class Dept {
    //一个部门有很多员工
    private List<Emp> empList;

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void info(){
        System.out.println("部门名称：" + dname);
        for(Emp emp : empList){
            System.out.println(emp.getEname());
        }
    }
}
