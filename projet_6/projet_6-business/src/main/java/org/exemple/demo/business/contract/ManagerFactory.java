package org.exemple.demo.business.contract;

import org.exemple.demo.business.contract.manager.UtilisateurManager;

import javax.inject.Inject;
import javax.inject.Named;

public interface ManagerFactory {

    @Named("managerFactory")
    public class ManagerFactoryImpl implements ManagerFactory {

        @Inject
        private UtilisateurManager utilisateurManager;
        @Override
        public UtilisateurManager getUtilisateurManager() {
            return this.utilisateurManager;
        }
        public void setTicketManager(UtilisateurManager pUtilisateurManager) {
            utilisateurManager = pUtilisateurManager;
        }
    }

}
