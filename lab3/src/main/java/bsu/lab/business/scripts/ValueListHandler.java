package bsu.lab.business.scripts;

import bsu.lab.business.businessObjects.Client;

import java.util.List;

/**
 * @author Ilya SKiba
 *         Date: 10.10.12
 */
public interface ValueListHandler {
    List<Client> navigate(DIRECTION direction);

    public enum DIRECTION {
        FIRST, PREV, NEXT, LAST
    }
}
