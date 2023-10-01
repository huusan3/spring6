package com.yb.spring6.iocxml.di2map;

import java.util.List;
import java.util.Map;

/**
 * ClassName: Student
 * Package: com.yb.spring6.iocxml.di2map
 * Description:
 *
 * @Author yang
 * @Create 2023/6/20 11:31
 * @Version
 */
public class Student {
    private List<Lesson> lessonList;
    private Map<String,Teacher> teacherMap;
    private String sid;
    private String sname;

    public List<Lesson> getLessonList() {
        return lessonList;
    }
    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }
    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public String getSid() {
        return sid;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }

    public void run(){
        System.out.println("the id of student is " + sid + ", and the name of student is " + sname);
        System.out.println(teacherMap);
        System.out.println(lessonList);
    }
}
