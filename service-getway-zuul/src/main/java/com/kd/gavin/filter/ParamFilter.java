package com.kd.gavin.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kd_gavin
 * @time 2017/10/31,10:15
 * @dicription 参数过滤器
 */
public class ParamFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(ParamFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {//控制是否显示
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info("send{} request to {}",request.getMethod(),request.getRequestURL().toString());
        Cookie[] cookies =  request.getCookies();//这里可以去到cookie，但是默认传递到别的服务的时候是取不到的
        String name = request.getParameter("name");
        try{
            if(name==null){
                logger.info("name is null");
                context.setSendZuulResponse(false);
                context.setResponseStatusCode(400);

                logger.info( context.getResponse().getCharacterEncoding());//默认使用ISO-8859-1 这个进行编码的
                context.getResponse().setCharacterEncoding("utf-8");
                context.setResponseBody("name属性不能为空");
                //抛出异常
                throw new RuntimeException("Exit some error..");
            }
        }catch (Exception e){
            context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            context.set("error.exception",e);
        }

        return null;
    }
}
