package org.val.win.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.grimpe.Site;
import org.val.win.model.bean.grimpe.Topo;
import org.val.win.model.bean.utilisateur.Utilisateur;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GestionSiteAction extends ActionSupport implements SessionAware {

    /**
     * Récupérer manager factory
     */
    @Inject
    private ManagerFactory managerFactory;

    /**
     * Récuperer session
     */
    private Map<String, Object> session;

    /**
     * Setteur pour la session
     * @param pSession
     */
    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    // ----- Paramètres en entrée

    private Integer idUtilisateur;
    private Integer idTopoSite;
    private Integer idSite;
    private Utilisateur utilisateur;
    private Topo topo;

    // ----- Paramètres en sortie

    private Site site;
    private List<Site> listSite;

    // ==================== Getters/Setters ====================

    public void setIdTopoSite(Integer pId){
        idTopoSite = pId;
    }

    public Integer getIdTopoSite() {
        return idTopoSite;
    }

    public Site getSite(){
        return site;
    }

    public void setSite(Site pSite) {
        site = pSite;
    }

    public List<Site> getListSite() {
        return listSite;
    }

    public void setListSite(List<Site> listSite) {
        this.listSite = listSite;
    }
    // ==================== Méthodes ====================


    /**
     * Action servant a creer un site
     * @return
     */
    public String doCreate() {
        utilisateur = (Utilisateur) session.get("user");
        if (session.get("user") == null) {
            return ActionSupport.LOGIN; }
        else {
            String vResult = ActionSupport.INPUT;
            if (this.site != null) {
                if (site.getIdTopo() == null) {
                    this.site.setIdTopo(idTopoSite);
                }
                if (!this.hasErrors()) {
                    try {
                        managerFactory.getSiteManager().insertSite(this.site);
                        // Si ajout avec succès -> Result "success"
                        vResult = ActionSupport.SUCCESS;
                        this.addActionMessage("Voie ajouté avec succès");
                    } catch (FunctionalException pEx) {
                        // Sur erreur fonctionnelle on reste sur la page de saisie
                        // et on affiche un message d'erreur
                        this.addActionError(pEx.getMessage());
                    }
                }
            }
            return vResult;
        }
    }
}
