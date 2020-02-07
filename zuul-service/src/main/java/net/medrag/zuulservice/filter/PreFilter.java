package net.medrag.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
 * {@author} Stanislav Tretyakov
 * 06.02.2020
 *
 * Pre filter handles the request before it's routed
 */
@Component
public class PreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader("zuulRequestHeader", "set");
        System.out.println("Pre filter in work: request url is...");
        System.out.println(ctx.getRequest().getRequestURI());
        return null;
    }
}
