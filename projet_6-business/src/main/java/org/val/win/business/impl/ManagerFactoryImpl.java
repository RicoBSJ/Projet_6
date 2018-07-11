package org.val.win.business.impl;

import org.val.win.business.contract.manager.*;
import org.val.win.business.contract.ManagerFactory;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Classe des managers
 */
@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private UtilisateurManager utilisateurManager;

    @Inject
    private TopoManager topoManager;

    @Inject
    private SecteurManager secteurManager;

    @Inject
    private SiteManager siteManager;

    @Inject
    private VoieManager voieManager;

    @Inject
    private CommentaireManager commentaireManager;

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

    @Override
    public SecteurManager getSecteurManager() {
        return this.secteurManager;
    }
    public void setSecteurManager(SecteurManager pSecteurManager) {
        secteurManager = pSecteurManager;
    }

    @Override
    public SiteManager getSiteManager(){
        return this.siteManager;
    }
    public void setSiteManager(SiteManager pSiteManager) {
        siteManager = pSiteManager;
    }

    @Override
    public VoieManager getVoieManager(){
        return this.voieManager;
    }
    public void setVoieManager(VoieManager pVoieManager) {
        voieManager = pVoieManager;
    }

    @Override
    public CommentaireManager getCommentaireManager(){
        return this.commentaireManager;
    }
    public void setCommentaireManager(CommentaireManager pCommentaireManager) {
        commentaireManager = pCommentaireManager;
    }
}
