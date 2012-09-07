package lab;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class BackFilter implements Filter {
    private String id;
    private int c = 0;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if (session == null) {
            session = req.getSession(true);
        }

        Object id = session.getAttribute("reqId");
        if (id != null) {
            if (id.toString().equals(this.id)) {
                this.id = req.getRequestURI();
                resp.setHeader("reqId", c++ + "");
                session.setAttribute("reqId", this.id);
                chain.doFilter(request, response);
                return;
            }
        } else {
            this.id = req.getRequestURI();
            session.setAttribute("reqId", this.id);
            resp.setHeader("reqId", c++ + "");
            chain.doFilter(request, response);
            return;
        }
        this.id = req.getRequestURI();
        session.setAttribute("reqId", this.id);
        resp.setHeader("reqId", c++ + "");
        HttpServletResponse res = (HttpServletResponse) response;
        res.sendRedirect(req.getContextPath() + "error.xhtml");

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {
    }
}
