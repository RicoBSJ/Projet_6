package org.val.win.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.grimpe.Site;
import org.val.win.model.bean.utilisateur.Utilisateur;
import org.val.win.model.exception.FunctionalException;

import javax.inject.Inject;
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

    private Integer id;
    private Utilisateur utilisateur;

    // ----- Paramètres en sortie

    private Site site;

    public String doCreate() {
        utilisateur = (Utilisateur) session.get("user");
        if (session.get("user") == null) {
            return ActionSupport.LOGIN; }
        else {
            String vResult = ActionSupport.INPUT;
            if (this.site != null) {
                System.out.println(this.site);
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
