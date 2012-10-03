package bsu.lab.servlet;

import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.annotation.WebServlet;

/**
 * Created with IntelliJ IDEA.
 * User: meloman
 * Date: 13.09.12
 * Time: 17:58
 */

@WebServlet(description = "Http Servlet using pure java / annotations", urlPatterns = {"/"}, name = "mainHandler")
public class StartServlet extends HttpRequestHandlerServlet {
}
