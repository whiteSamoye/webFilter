package cn.samoye._filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter{
	public SecondFilter(){
		System.out.println("第二个过滤器实例化");
	}
	public void destroy() {
		System.out.println("第二个过滤器的destroy");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			System.out.println("第二个过滤器的doFilter方法");
			chain.doFilter(request, response);
			System.out.println("第二个过滤器处理完成");
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("第二个过滤器init方法");
	}

}
