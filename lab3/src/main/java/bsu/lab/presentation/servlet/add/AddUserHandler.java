package bsu.lab.presentation.servlet.add;

import bsu.lab.business.businessObjects.Client;
import bsu.lab.business.scripts.ClientService;
import bsu.lab.presentation.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ilya SKiba
 *         Date: 11.10.12
 */
@Controller("addUser")
public class AddUserHandler implements HttpRequestHandler {
    @Autowired
    private ClientService clientService;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClientModel clientModel = (ClientModel) request.getAttribute("clientModel");
        Client newClient = new Client();
        newClient.setAddress(clientModel.getAddress());
        newClient.setName(clientModel.getName());
        newClient.setTelephone(clientModel.getPhone());
        clientService.create(newClient);
        response.sendRedirect("/list");
    }

}
