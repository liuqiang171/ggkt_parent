package com.at.ggkt.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.at.ggkt.swagger.Swagger2Config;
/**
 * @ClassName ServiceVodApplication
 * @Description TODO
 * @Author liuqiang
 * @Date 2022-07-16-20:41
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.at")
public class ServiceVodApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVodApplication.class, args);
    }
}