package org.exemple.demo.business.impl;

import org.exemple.demo.business.contract.ManagerFactory;
import org.exemple.demo.business.contract.manager.UtilisateurManager;

import javax.inject.Inject;
import javax.inject.Named;


@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private UtilisateurManager utilisateurManager;
    @Override
    public UtilisateurManager getUtilisateurManager() {
        return this.utilisateurManager;
    }
    public void setUtilisateurManager(UtilisateurManager pUtilisateurManager) {
        utilisateurManager = pUtilisateurManager;
    }
}
