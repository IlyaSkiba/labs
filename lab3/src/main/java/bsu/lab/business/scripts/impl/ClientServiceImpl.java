package bsu.lab.business.scripts.impl;

import bsu.lab.business.businessObjects.Client;
import bsu.lab.business.dao.ClientDao;
import bsu.lab.business.scripts.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ilya SKiba
 *         Date: 11.10.12
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    @Override
    public void create(Client client) {
        clientDao.create(client);
    }

    @Override
    public void update(Client client) {
        clientDao.update(client);
    }

    @Override
    public void delete(Client client) {
        clientDao.delete(client);
    }
}
