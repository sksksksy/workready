package site.part.ms.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;


public class LogRecordFilter implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String path=request.getRequestURL().toString();
		System.out.println(path);
		String handlerString=handler.toString();
		String[] infos=handlerString.split("#");
		String classPath=null;
		String method=null;
		if(infos.length>1) {
			classPath=infos[0];
			method=infos[1];
		}
//		System.out.println("pre:"+handlerString);
		System.out.println("class:"+classPath);
		System.out.println("method:"+method);
		return true;
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
//		System.out.println("after:"+handler.toString());
	}
	
}
