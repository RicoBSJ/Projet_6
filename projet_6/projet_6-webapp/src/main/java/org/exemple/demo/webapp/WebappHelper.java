package org.exemple.demo.webapp;

import org.exemple.demo.business.contract.ManagerFactory;

import javax.inject.Inject;



public class WebappHelper {

    private static ManagerFactory managerFactory;

    public static ManagerFactory getManagerFactory() {
        return managerFactory;
    }
    public static void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }
}
