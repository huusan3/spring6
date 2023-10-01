package com.yb.spring6.iocxml.di2map;

/**
 * ClassName: Teacher
 * Package: com.yb.spring6.iocxml.di2map
 * Description:
 *
 * @Author yang
 * @Create 2023/6/20 11:32
 * @Version
 */
public class Teacher {
    private String tid;
    private String tname;

    public String getTid() {
        return tid;
    }
    public void setTid(String tid) {
        this.tid = tid;
    }
    public String getTname() {
        return tname;
    }
    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }
}
