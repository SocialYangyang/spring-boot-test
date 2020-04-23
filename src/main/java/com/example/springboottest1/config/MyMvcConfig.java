package com.example.springboottest1.config;

//import com.example.springboottest1.component.LoginHanderInterceptor;
import com.example.springboottest1.component.LoginHanderInterceptor;
import com.example.springboottest1.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    //静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/")
                .addResourceLocations("classpath:/resources/");
    }

    //多个访问达到同一个页面可以这样写
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("commons/index");
        registry.addViewController("/index.html").setViewName("commons/index");
        //实现点击转换中英文
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/register.html").setViewName("register");
//        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/user.html").setViewName("user/userindex");
        //来到管理员界面
        registry.addViewController("/admin.html").setViewName("admin/dashboard");
//       registry.addViewController("/admin").setViewName("admin/dashboard");
        registry.addViewController("/loginpage").setViewName("login");
        registry.addViewController("/registerpage").setViewName("register");
        registry.addViewController("/baoming.html").setViewName("user/baoming");
    }

    //配置非登录进入的拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHanderInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/Login","/user/register",
                        "/login.html","/register.html","/loginpage","/registerpage","/user/baoming","/baoming.html",
                        "/**/*.css","/**/*.js", "/**/*.jpg","/**/*.png","/**/*.gif",
                        "/**/*.jpeg","/**/asserts/*","/**/*.svg","/user/findByName","/student",
                        "/admin/login", "/commons/Introduce", "/commons/Introduce.html","/druid/login.html");
}

    //将我们配置的国际化加入容器中
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
