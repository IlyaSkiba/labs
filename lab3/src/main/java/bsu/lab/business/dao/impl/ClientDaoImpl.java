package bsu.lab.business.dao.impl;

import bsu.lab.business.businessObjects.Client;
import bsu.lab.business.dao.ClientDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ilya SKiba
 *         Date: 10.10.12
 */
@Service
public class ClientDaoImpl implements ClientDao {
    List<Client> clients = new ArrayList<Client>();

    @Override
    public void update(Client client) {
        Client prevClient = clients.get(clients.indexOf(client));
        prevClient.setTelephone(client.getTelephone());
        prevClient.setName(client.getName());
        prevClient.setAddress(client.getAddress());
    }

    @Override
    public void delete(Client client) {
        clients.remove(client);
    }

    @Override
    public List<Client> getClient(int from, int limit) {
        return clients.subList(from, from + limit);
    }

    @Override
    public int getSize() {
        return clients.size();
    }

    @Override
    public void create(Client client) {
        clients.add(client);
    }
}
