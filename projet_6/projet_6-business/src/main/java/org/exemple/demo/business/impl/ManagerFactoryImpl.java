package org.exemple.demo.business.impl;

import org.exemple.demo.business.contract.ManagerFactory;
import org.exemple.demo.business.contract.manager.TopoManager;
import org.exemple.demo.business.contract.manager.UtilisateurManager;

import javax.inject.Inject;
import javax.inject.Named;


@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private UtilisateurManager utilisateurManager;

    @Inject
    private TopoManager topoManager;

    @Override
    public UtilisateurManager getUtilisateurManager() {
        return this.utilisateurManager;
    }
    public void setUtilisateurManager(UtilisateurManager pUtilisateurManager) {
        utilisateurManager = pUtilisateurManager;
    }

    @Override
    public TopoManager getTopoManager(){
        return this.topoManager;
    }
    public void setTopoManager(TopoManager pTopoManager) {
        topoManager = pTopoManager;
    }
}
