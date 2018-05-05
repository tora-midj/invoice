package jp.co.systena.tora.webjava.mid.api.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * The Class InvoiceRequestInterceptor.
 */
public class InvoiceRequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(final HttpServletRequest request,
            final HttpServletResponse response, final Object handler)
            throws Exception {
        return true;
    }

    @Override
    public void postHandle(final HttpServletRequest request,
            final HttpServletResponse response, final Object handler,
            final ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(final HttpServletRequest request,
            final HttpServletResponse response, final Object handler,
            final Exception ex)
            throws Exception {
    }

}
