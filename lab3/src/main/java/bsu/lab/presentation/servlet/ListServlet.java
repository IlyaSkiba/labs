package bsu.lab.presentation.servlet;

import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.annotation.WebServlet;

/**
 * Created with IntelliJ IDEA.
 * User: meloman
 * Date: 13.09.12
 * Time: 17:58
 */

@WebServlet(description = "List Servlet", urlPatterns = {"/list"}, name = "mainHandler")
public class ListServlet extends HttpRequestHandlerServlet {
}
