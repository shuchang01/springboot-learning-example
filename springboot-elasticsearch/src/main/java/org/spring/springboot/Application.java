package org.spring.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 16/4/26.
 */
// Spring Boot 应用的标识
@SpringBootApplication
@RestController
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return "springboot-elasticsearch demo";
    }

    /**
     * spring-boot-starter-actuator日志级别动态修改 </br>
     * <code>
     * /loggers/org.spring.springboot
     * {
     *     "configuredLevel": "DEBUG"
     * }
     * </code>
     * 影响包路径（org.spring.springboot）下的日志输出级别 </br>
     *
     * @return
     */
    @RequestMapping("/testLogLevel")
    public String testLogLevel() {
        logger.debug("Logger Level ：DEBUG");
        logger.info("Logger Level ：INFO");
        logger.error("Logger Level ：ERROR");
        return "testLogLevel method";
    }
}
