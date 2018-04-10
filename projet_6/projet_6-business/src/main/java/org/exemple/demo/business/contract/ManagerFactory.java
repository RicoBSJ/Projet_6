package org.exemple.demo.business.contract;

import org.exemple.demo.business.contract.manager.*;


public interface ManagerFactory {

    UtilisateurManager getUtilisateurManager();

    TopoManager getTopoManager();

    CommentaireManager getCommentaireManager();

    VoieManager getVoieManager();

    SiteManager getSiteManager();

    SecteurManager getSecteurManager();

}
