package com.gmail.mordress.epamproject.controller;

import javax.servlet.*;
import java.io.IOException;

/**
 * Sets encoding to request and response.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class EncodingFilter implements Filter {

    public void destroy() {
    }

    /** Sets UTF-8 encoding to request and response.
     * @param req servlet request.
     * @param resp servlet response.
     * @param chain servlet filter chain
     * @throws IOException - if process requested URI throws this exception.
     * @throws ServletException - if servlet can not do this operation correctly. */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
