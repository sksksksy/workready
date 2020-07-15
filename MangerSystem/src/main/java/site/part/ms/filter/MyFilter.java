package site.part.ms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@WebFilter(urlPatterns = "/**",filterName = "firstFilter")
public class MyFilter implements Filter{
	public long count=0;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		count++;
		System.out.println("this is first filter.");
		System.out.println("第"+count+"访问系统");
		chain.doFilter(request, response);
	}

}
