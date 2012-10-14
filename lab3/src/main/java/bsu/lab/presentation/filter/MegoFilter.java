package bsu.lab.presentation.filter;

import bsu.lab.presentation.filter.exception.FilterException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ilya SKiba
 * @created 13.09.12
 */
public interface MegoFilter {

    void doFilter(HttpServletRequest request, HttpServletResponse response) throws FilterException;
}
