package cn.samoye._filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.StringUtils;
/**
 * 编码过滤器：
 * 	使用动态代理的方式处理get请求的编码问题
 *  jsp:
 *  	login.jsp
 * @author samoye
 *
 */
public class EncodingFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//强转
		final HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest proxyRes = null;
		if("GET".equals(req.getMethod())){//get请求
			proxyRes = (HttpServletRequest) Proxy.newProxyInstance(
					req.getClass().getClassLoader(),//指定目标对象的类加载器
					req.getClass().getInterfaces(),//指定目标对象的接口
					new InvocationHandler() {//事件处理器
						/**
						 *proxy:经过代理的对象
						 *method：接口中方法对象
						 *args：接口中参数对象 
						 * 当request对象调用HttpServletRequest接口中的方法时，时间处理器会被触发。
						 */
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							if("getParameter".equals(method.getName())){
								String userName = req.getParameter(args[0].toString());
								String value = null;
								if(null != userName && !"".equals(userName.trim())){
									value = new String(userName.getBytes("iso-8859-1"),"utf-8");
								}
								return value;
							}
							//必须时req。
							return method.invoke(req, args);
						}
					});
		}else{//post请求
			req.setCharacterEncoding("utf-8");
			proxyRes = req;
		}
		res.setContentType("html/text;charset=utf-8");
		chain.doFilter(proxyRes, res);
	}

	public void destroy() {
		
	}

}
