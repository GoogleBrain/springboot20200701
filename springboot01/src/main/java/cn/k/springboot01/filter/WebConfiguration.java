package cn.k.springboot01.filter;

import cn.k.springboot01.properties.StuComponent;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class WebConfiguration {

    @Bean
    public FilterRegistrationBean testFilterRegistration(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new MyFilter());
        bean.addUrlPatterns("/*");
        bean.setName("MyFilter");
        bean.setOrder(2);
        return bean;
    }
}
