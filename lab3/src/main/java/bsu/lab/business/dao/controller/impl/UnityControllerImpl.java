package bsu.lab.business.dao.controller.impl;

import bsu.lab.business.businessObjects.Client;
import bsu.lab.business.dao.ClientDao;
import bsu.lab.business.dao.controller.UnityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Ilya SKiba
 * @created 22.10.12
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class UnityControllerImpl implements UnityController {
    private Map<String, Client> cache = new ConcurrentHashMap<String, Client>();
    private Map<String, Client> unModifiedCache = new ConcurrentHashMap<String, Client>();
    @Autowired
    private ClientDao clientDao;

    @Override
    public synchronized Client create(Client newClient) {
        newClient.setId(Math.random() + "");
        cache.put(newClient.getId(), newClient);
        return cache.get(newClient.getId());
    }

    @Override
    public synchronized Client retrieve(String id) {
        if (cache.containsKey(id)) {
            return cache.get(id);
        }

        Client newClient = clientDao.retrieve(id);
        unModifiedCache.put(id, newClient);
        cache.put(id, newClient);

        return newClient;
    }

    @Override
    public synchronized Client update(Client oldClient) {
        cache.put(oldClient.getId(), oldClient);
        return oldClient;
    }

    @Override
    public synchronized boolean delete(Client client) {
        cache.remove(client.getId());
        unModifiedCache.put(client.getId(), client);
        return true;
    }

    @Override
    public synchronized boolean commit() {
        boolean dirty = false;
        for (String id : unModifiedCache.keySet()) {
            if (!cache.containsKey(id)) {
                clientDao.delete(cache.get(id));
                dirty = true;
            }
            if (cache.containsKey(id) && !cache.get(id).equals(unModifiedCache.get(id))) {
                clientDao.update(cache.get(id));
                dirty = true;
            }
        }
        for (String id : cache.keySet()) {
            if (!unModifiedCache.containsKey(id)) {
                clientDao.create(cache.get(id));
                dirty = true;
            }
        }
        return dirty;
    }

    @Override
    public List<Client> getClients(int from, int limit) {
        return clientDao.getClient(from, limit);
    }
}
