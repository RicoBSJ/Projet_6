package org.val.win.business.contract;

import org.val.win.business.contract.manager.*;

/**
 * Interface de ManagerFactoryImpl
 */
public interface ManagerFactory {

    /**
     * manager des l'utilsateur
     * @return manager des l'utilisateur
     */
    UtilisateurManager getUtilisateurManager();

    /**
     * manager des topo
     * @return manager des topos
     */
    TopoManager getTopoManager();

    /**
     * manager des commentaires
     * @return manager des commentaires
     */
    CommentaireManager getCommentaireManager();

    /**
     * manager des voies
     * @return manager des voies
     */
    VoieManager getVoieManager();

    /**
     * manager des sites
     * @return manager des sites
     */
    SiteManager getSiteManager();

    /**
     * manager des secteurs
     * @return manager des secteurs
     */
    SecteurManager getSecteurManager();

}
