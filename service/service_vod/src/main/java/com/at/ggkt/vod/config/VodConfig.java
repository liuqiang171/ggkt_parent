package com.at.ggkt.vod.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @ClassName VodConfig
 * @Description TODO
 * @Author liuqiang
 * @Date 2022-07-16-20:42
 */
@Configuration
@MapperScan("com.at.ggkt.vod.mapper")
public class VodConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
