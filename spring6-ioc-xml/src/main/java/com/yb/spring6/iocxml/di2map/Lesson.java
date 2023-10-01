package com.yb.spring6.iocxml.di2map;

/**
 * ClassName: Lesson
 * Package: com.yb.spring6.iocxml.di2map
 * Description:
 *
 * @Author yang
 * @Create 2023/6/20 16:52
 * @Version
 */
public class Lesson {
    private String lessonName;

    public String getLessonName() {
        return lessonName;
    }
    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonName='" + lessonName + '\'' +
                '}';
    }
}
