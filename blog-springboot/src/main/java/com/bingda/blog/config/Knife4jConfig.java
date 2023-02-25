package com.bingda.blog.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Collections;

/**
 * Knife4j配置类
 *
 * @author yezhiqiu
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfig {


    /**
     * 配置swagger2核心配置 docket
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)// 指定api类型为swagger2
                /*.protocols(Collections.singleton("https"))
                .host("https://www.talkxj.com")*/
                .protocols(Collections.singleton("http"))
                .host("http://www.bingda.love")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.minzheng.blog.controller"))
                .paths(PathSelectors.any())// 所有controller
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("博客api文档")
                .description("springboot+vue开发的博客项目")
                .contact(new Contact("dabing", "https://github.com/Dhb-150/blog", "1502007488@qq.com"))
                .termsOfServiceUrl("http://www.bingda.love/api")
                .version("1.0")
                .build();
    }

}
