package bsu.lab.presentation.servlet.add;

import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.annotation.WebServlet;

/**
 * @author Ilya SKiba
 *         Date: 11.10.12
 */
@WebServlet(description = "User registration", urlPatterns = {"/registration"}, name = "addUser")
public class AddUserServlet extends HttpRequestHandlerServlet {

}
