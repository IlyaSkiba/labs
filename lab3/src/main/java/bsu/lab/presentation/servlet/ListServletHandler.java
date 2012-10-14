package bsu.lab.presentation.servlet;

import bsu.lab.business.businessObjects.Client;
import bsu.lab.business.scripts.ValueListHandler;
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
import java.io.StringReader;
import java.util.List;

import static bsu.lab.business.scripts.ValueListHandler.DIRECTION;

/**
 * Created with IntelliJ IDEA.
 * User: meloman
 * Date: 13.09.12
 * Time: 19:37
 */
@Component("mainHandler")
public class ListServletHandler implements HttpRequestHandler {
    private static final String DIRECTION_NAME = "Direction";
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private ValueListHandler valueListHandler;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String direction = (String) request.getParameter(DIRECTION_NAME);
        DIRECTION currDirection = DIRECTION.PREV;
        if (direction != null) {
            currDirection = DIRECTION.valueOf(direction);
        }
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(new StreamSource(getServletContext()
                    .getResourceAsStream("WEB-INF/base.xsl")));

            transformer.transform(new StreamSource(new StringReader(getList(currDirection))),
                    new StreamResult(response.getOutputStream()));

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private String getList(final DIRECTION direction) {
        StringBuilder result = new StringBuilder();
        result.append("<clients>");
        List<Client> clientList = valueListHandler.navigate(direction);
        for (Client client : clientList) {
            result.append(client.toString());
        }
        result.append("</clients>");
        return result.toString();
    }

    public ServletContext getServletContext() {
        return servletContext;
    }
}
