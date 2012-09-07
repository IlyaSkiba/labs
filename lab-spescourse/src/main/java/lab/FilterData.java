package lab;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 * Created with IntelliJ IDEA.
 * User: meloman
 * Date: 07.09.12
 * Time: 16:01
 * To change this template use File | Settings | File Templates.
 */
@RequestScoped
@Named
public class FilterData {
    public String filterData;

    public FilterData() {
        filterData = Math.random() + "";
    }

    public String getFilterData() {
        return filterData;
    }

    public void setFilterData(String filterData) {
        this.filterData = filterData;
    }
}
