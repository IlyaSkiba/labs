package bsu.lab.impl;

import bsu.lab.MegoFilter;
import bsu.lab.exception.FilterException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: meloman
 * Date: 13.09.12
 * Time: 18:41
 */
public class OddFilter implements MegoFilter {
    private int oddRequest = 0;

    public OddFilter() {
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response) throws FilterException {
        if ((oddRequest++) % 2 != 0) {
            throw new FilterException();
        }
    }
}
