package com.example.demo.src;

import com.example.demo.config.interceptor.DefaultInterceptor; import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final DefaultInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);

        List<String> patterns = new ArrayList<String>();
        patterns.add("/api/hotel/**");
        patterns.add("/api/bookmark/**");
        patterns.add("/api/coupon/**");
        patterns.add("/api/payment/**");
        patterns.add("/api/refund/**");
        patterns.add("/api/hotel");

        registry.addInterceptor(interceptor);
    }
}
