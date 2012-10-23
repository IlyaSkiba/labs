package bsu.lab.business.dao;

import bsu.lab.business.businessObjects.Client;

import java.util.List;

/**
 * @author Ilya SKiba
 *         Date: 10.10.12
 */
public interface ClientDao {

    void update(Client client);

    void delete(Client client);

    List<Client> getClient(int from, int limit);

    int getSize();

    void create(Client client);

    Client retrieve(String id);
}
