package bsu.lab.presentation.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ilya SKiba
 * @created 13.09.12
 */
public interface FilterManager {
    boolean doFilter(HttpServletRequest request, HttpServletResponse response);
}
