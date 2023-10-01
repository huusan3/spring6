package com.yb.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Di
 * Package: com.yb.annotation
 * Description:
 *
 * @Author yang
 * @Create 2023/6/28 17:32
 * @Version
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Di {
}
