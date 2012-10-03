package bsu.lab;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: meloman
 * Date: 13.09.12
 * Time: 18:25
 * To change this template use File | Settings | File Templates.
 */
public interface FilterManager {
    boolean doFilter(HttpServletRequest request, HttpServletResponse response);
}
