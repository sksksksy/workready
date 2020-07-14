package site.part.ms.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import site.part.ms.filter.LogRecordFilter;

@Configuration
public class FilterConf implements WebMvcConfigurer{
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LogRecordFilter()).addPathPatterns("/*");
	}
}
