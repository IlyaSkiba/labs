package bsu.lab.business.scripts.impl;

import bsu.lab.business.businessObjects.Client;
import bsu.lab.business.dao.controller.UnityController;
import bsu.lab.business.scripts.ValueListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ilya SKiba
 *         Date: 10.10.12
 */
@Service
public class ValueListHandlerImpl implements ValueListHandler {
    private final int PAGE_SIZE;
    private int from = 0;
    @Autowired
    private UnityController unityController;

    public ValueListHandlerImpl() {
        PAGE_SIZE = 2;
    }

    public ValueListHandlerImpl(int maxPageSize) {
        PAGE_SIZE = maxPageSize;
    }

    @Override
    public List<Client> navigate(DIRECTION direction) {
        int pageSize = Math.min(PAGE_SIZE, clientDao.getSize());
        switch (direction) {
            case FIRST:
                this.from = 0;
                break;
            case PREV:
                this.from = Math.max(from - PAGE_SIZE, 0);
                break;
            case NEXT:
                this.from = Math.min(pageSize + from, clientDao.getSize());
                pageSize = clientDao.getSize() < from + PAGE_SIZE ?
                        clientDao.getSize() - from : PAGE_SIZE;
                break;
            case LAST:
                this.from = Math.max(clientDao.getSize() - PAGE_SIZE, 0);
                break;
            default:
                throw new IllegalArgumentException("Not implemented direction " + direction);
        }
        return unityController.getClients(from, pageSize);
    }
}
