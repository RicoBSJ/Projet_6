package org.val.win.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.grimpe.Voie;
import org.val.win.model.bean.utilisateur.Utilisateur;
import org.val.win.model.exception.FunctionalException;

import javax.inject.Inject;
import java.util.Map;

public class GestionVoieAction extends ActionSupport implements SessionAware {

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

    // ----- Eléments en sortie

    private Voie voie;

    // ==================== Getters/Setters ====================

    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public void setVoie(Voie pVoie){
        this.voie = pVoie;
    }
    public Voie getVoie(){
        return voie;
    }


    public String doCreate() {
        utilisateur = (Utilisateur) session.get("user");
        if (session.get("user") == null) {
            return ActionSupport.LOGIN; }
        else {
            String vResult = ActionSupport.INPUT;
            if (this.voie != null) {
                System.out.println(this.voie);
                if (!this.hasErrors()) {
                    try {
                        managerFactory.getVoieManager().insertVoie(this.voie);
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
