package bsu.lab;

import bsu.lab.exception.FilterException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: meloman
 * Date: 13.09.12
 * Time: 18:25
 * To change this template use File | Settings | File Templates.
 */
public interface MegoFilter {

    void doFilter(HttpServletRequest request, HttpServletResponse response) throws FilterException;
}
