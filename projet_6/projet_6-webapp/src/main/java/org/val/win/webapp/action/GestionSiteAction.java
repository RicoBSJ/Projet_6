package org.val.win.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.grimpe.Site;
import org.val.win.model.bean.grimpe.Topo;
import org.val.win.model.bean.utilisateur.Utilisateur;
import org.val.win.model.exception.FunctionalException;

import javax.inject.Inject;
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
     * @param pSession session de l'utilisateur
     */
    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    // ----- Paramètres en entrée

    /**
     * objet topo
     */
    private Topo topo;

    // ----- Paramètres en sortie

    /**
     * Objet site
     */
    private Site site;

    // ==================== Getters/Setters ====================

    /**
     * recuperer un site
     * @return un site
     */
    public Site getSite(){
        return site;
    }

    /**
     * recuperer un topo
     * @return un topo
     */
    public Topo getTopo() {
        return topo;
    }

    /**
     * modifier un topo
     * @param pTopo le nouveau topo
     */
    public void setTopo(Topo pTopo) {
        topo = pTopo;
    }

    /**
     * modifier un site
     * @param pSite le site a modifier
     */
    public void setSite(Site pSite) {
        site = pSite;
    }

    // ==================== Méthodes ====================


    /**
     * Action servant a creer un site
     * @return resultat de l'action
     */
    public String doCreate() {
        topo = (Topo) session.get("topo");
        if (session.get("user") == null) {
            return ActionSupport.LOGIN; }
        else {
            String vResult = ActionSupport.INPUT;
            if (this.site != null) {
                if (site.getIdTopo() == null) {
                    this.site.setIdTopo(topo.getIdTopo());
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
