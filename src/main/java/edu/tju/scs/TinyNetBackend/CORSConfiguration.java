package edu.tju.scs.TinyNetBackend;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")
                    .allowCredentials(true)
                    .allowedHeaders("*")
                    .maxAge(3600)
                    .allowedHeaders("*");
    }
}

