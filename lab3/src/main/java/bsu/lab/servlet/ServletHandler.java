package bsu.lab.servlet;

import bsu.lab.FilterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
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
    @Autowired
    private ServletContext servletContext;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //   boolean result = filterManager.doFilter(request, response);

        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(new StreamSource(getServletContext().getResourceAsStream("WEB-INF/base.xsl")));
            transformer.transform(new StreamSource(getServletContext().getResourceAsStream("WEB-INF/inp.xml")), new StreamResult(response.getOutputStream()));
            System.out.println("************* The result is in output.out *************");

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }

    @Autowired
    public void setFilterManager(FilterManager filterManager) {
        this.filterManager = filterManager;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }
}
