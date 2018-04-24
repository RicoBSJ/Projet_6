package org.val.win.business.contract;

import org.val.win.business.contract.manager.*;


public interface ManagerFactory {

    UtilisateurManager getUtilisateurManager();

    TopoManager getTopoManager();

    CommentaireManager getCommentaireManager();

    VoieManager getVoieManager();

    SiteManager getSiteManager();

    SecteurManager getSecteurManager();

}
