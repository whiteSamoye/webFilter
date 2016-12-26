package cn.samoye._filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 服务器启动时，实例化，并且执行init方法，在init方法中可以获取web.xml中过滤器配置的<init-param>中的参数。
 * @author samoye
 *
 */
public class FirstFilter implements Filter{
	public FirstFilter(){
		System.out.println("第一个过滤器FirstFilter.FirstFilter()");
	}

	public void init(FilterConfig conf) throws ServletException {
		System.out.println("第一个过滤器FirstFilter.init()");
		String name = conf.getInitParameter("name");
		System.out.println(name);
		Enumeration<String> names = conf.getInitParameterNames();
		while(names.hasMoreElements()){
			String key = names.nextElement();
			String values = conf.getInitParameter(key);
			System.out.println(key+" --- "+values);
		}
	}
	
	public void destroy() {
		System.out.println("第一个过滤器FirstFilter.destroy()");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("第一个过滤器FirstFilter.doFilter()");
		chain.doFilter(request, response);
		System.out.println("第一个过滤器处理完毕");
	}


}
