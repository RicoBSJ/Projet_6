package org.val.win.webapp;

import org.val.win.business.contract.ManagerFactory;


public class WebappHelper {

    private static ManagerFactory managerFactory;

    public static ManagerFactory getManagerFactory() {
        return managerFactory;
    }
    public static void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }
}
