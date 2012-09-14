package bsu.lab.servlet;

import bsu.lab.FilterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: meloman
 * Date: 13.09.12
 * Time: 19:37
 */
@Component("mainHandler")
public class ServletHandler implements HttpRequestHandler {
    private FilterManager filterManager;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean result = filterManager.doFilter(request, response);
        try {
            response.getWriter().print(String.format("<html><body><span>Filter result: %s</span></body></html>",
                    result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    public void setFilterManager(FilterManager filterManager) {
        this.filterManager = filterManager;
    }
}
