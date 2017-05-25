package org.spring.springboot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * HTTP请求耗时监控统一入口
 * 
 * @author shangpan
 * 
 * @since Feb 13, 2017
 */
@WebFilter(filterName = "costFilter", urlPatterns = "/*", initParams = {
		@WebInitParam(name = "encoding", value = "UTF-8"), @WebInitParam(name = "forceEncoding", value = "true") })
public class RequestCostFilter implements Filter {

	private static final Logger log = LoggerFactory.getLogger(RequestCostFilter.class);

	@SuppressWarnings("unused")
	private String encoding;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}

	/*
	 * -- 原来代码
	 * 
	 * @Override 
	 * public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	 * 		HttpServletRequest httpRequest = (HttpServletRequest) request; StopWatch
	 * 		stopWatch = new StopWatch(System.currentTimeMillis() + "");
	 * 		stopWatch.start();
	 * 		chain.doFilter(request, response);
	 * 		stopWatch.stop();
	 * 		
	 * 		log.debug(httpRequest.getRequestURI() + " -> request cost - " + stopWatch.getTotalTimeMillis() + " ms"); 
	 * }
	 */

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		log.info("======>encoding:" + encoding);
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		// org.springframework.util.StopWatch
		StopWatch stopWatch = new StopWatch(System.currentTimeMillis() + "");
		stopWatch.start();
		chain.doFilter(request, response);
		stopWatch.stop();
		log.info("======>RequestURI: " + httpRequest.getRequestURI() + " -->Time cost: " + stopWatch.getTotalTimeMillis() + " ms");
	}

	@Override
	public void destroy() {
		
	}
}
