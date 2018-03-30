package org.exemple.demo.business.contract;

import org.exemple.demo.business.contract.manager.TopoManager;
import org.exemple.demo.business.contract.manager.UtilisateurManager;


public interface ManagerFactory {

    UtilisateurManager getUtilisateurManager();

    TopoManager getTopoManager();

}
