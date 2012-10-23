package bsu.lab.business.dao.controller;

import bsu.lab.business.businessObjects.Client;

import java.util.List;

/**
 * @author Ilya SKiba
 * @created 22.10.12
 */
public interface UnityController {
    Client create(Client newClient);

    Client retrieve(String id);

    Client update(Client oldClient);

    boolean delete(Client client);

    boolean commit();

    List<Client> getClients(int from, int limit);

    int getSize();
}
