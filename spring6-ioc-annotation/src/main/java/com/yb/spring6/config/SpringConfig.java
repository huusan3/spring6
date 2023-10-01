package com.yb.spring6.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: SpringConfig
 * Package: com.yb.spring6.config
 * Description:
 *
 * @Author yang
 * @Create 2023/6/27 16:58
 * @Version
 */
@Configuration //配置类
@ComponentScan("com.yb.spring6") //效果与配置文件中的开启扫描组件效果相同
public class SpringConfig {
}
