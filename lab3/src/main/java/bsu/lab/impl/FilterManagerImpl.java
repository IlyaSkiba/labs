package bsu.lab.impl;

import bsu.lab.FilterManager;
import bsu.lab.MegoFilter;
import bsu.lab.exception.FilterException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: meloman
 * Date: 13.09.12
 * Time: 18:25
 */
public class FilterManagerImpl implements FilterManager {
    private List<MegoFilter> filters;

    public void setFilters(List<MegoFilter> filters) {
        this.filters = filters;
    }

    @Override
    public boolean doFilter(HttpServletRequest request, HttpServletResponse response) {
        boolean result = true;
        for (MegoFilter filter : filters) {
            try {
                filter.doFilter(request, response);
            } catch (FilterException e) {
                result = false;
                break;//TODO: Нужно ли?
            }
        }
        return result;
    }
}
