package com.climb.timecounting.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080" ,"http://localhost:8080/", "http://localhost:5000", "http://localhost:5000/", "http://localhost:5000/#/")
                //.allowedOrigins("http://localhost:8080", "http://localhost:5000/", "http://localhost:5000/#/")
                .allowCredentials(true);
        //.exposedHeaders("authorization")
    }
}
