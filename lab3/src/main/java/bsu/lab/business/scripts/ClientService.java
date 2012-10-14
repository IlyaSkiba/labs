package bsu.lab.business.scripts;

import bsu.lab.business.businessObjects.Client;

/**
 * @author Ilya SKiba
 * Date: 11.10.12
 */
public interface ClientService {
    void create(Client client);

    void update(Client client);

    void delete(Client client);

}
