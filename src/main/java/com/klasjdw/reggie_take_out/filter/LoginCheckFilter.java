package com.klasjdw.reggie_take_out.filter;

import com.alibaba.fastjson.JSON;
import com.klasjdw.reggie_take_out.common.BaseContext;
import com.klasjdw.reggie_take_out.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 检查是否登陆，不登陆不让看内容
 * @author klasjdw
 * @Package com.klasjdw.reggie_take_out.filter
 * @date 2023/3/21 15:45
 */
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")

@Slf4j
public class LoginCheckFilter implements Filter {
    //路径匹配器，支持通配符写法
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1、获取本次请求的URI
        String requestURI = request.getRequestURI();
        log.info("拦截到请求:{}", requestURI);
        //定义不需要处理的请求路径
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**"
        };

        //2、判断本次请求是否需要处理
        boolean check = check(urls, requestURI);

        //3、如果不需要处理，直接放行
        if (check) {
            log.info("本次请求{}不需要处理", requestURI);
            filterChain.doFilter(request, response);
            return;
        }

        //4、判断是否完成登陆
        if (request.getSession().getAttribute("employee") != null) {
            log.info("用户已登陆，ID：{}", request.getSession().getAttribute("employee"));

            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);

            filterChain.doFilter(request, response);
            return;
        }


        log.info("用户未登陆");
        //5、如果未登陆返回页面，通过输出流方式向客户端响应数据
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;


    }

    /**
     * 路径匹配，检查本次请求是否需要放行
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls,String requestURI) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) {
                return true;
            }
        }
        return false;
    }
}
