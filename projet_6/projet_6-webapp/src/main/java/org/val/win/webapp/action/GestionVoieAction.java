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
     * @param pSession la session de l'utilisateur
     */
    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    // ----- Paramètres en entrée

    private Integer idVoie;
    private Integer idTopo;
    private Integer idSite;
    private Integer idSecteur;

    // ----- Eléments en sortie

    private Voie voie;

    // ==================== Getters/Setters ====================

    public Integer getIdVoie() {
        return idVoie;
    }

    public void setIdVoie(Integer pId) {
        idVoie = pId;
    }

    public Integer getIdSite() {
        return idSite;
    }

    public void setIdSite(Integer idSite) {
        this.idSite = idSite;
    }

    public Integer getIdTopo() {
        return idTopo;
    }

    public void setIdTopo(Integer idTopo) {
        this.idTopo = idTopo;
    }

    public Integer getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(Integer idSecteur) {
        this.idSecteur = idSecteur;
    }

    public void setVoie(Voie pVoie){
        this.voie = pVoie;
    }

    public Voie getVoie(){
        return voie;
    }

    // ==================== Méthodes ====================


    /**
     * Creation d'une voie
     * @return le resultat de l'action
     */
    public String doCreate() {
        Utilisateur utilisateur = (Utilisateur) session.get("user");
        if (session.get("user") == null) {
            return ActionSupport.LOGIN; }
        else {
            String vResult = ActionSupport.INPUT;
            if (this.voie != null) {
                System.out.println(this.voie);
                if (!this.hasErrors()) {
                    if (this.voie.getId_topo() == null){
                        this.voie.setIdTopo(idTopo);
                    }
                    else if (this.voie.getId_site() == null){
                        this.voie.setIdSite(idSite);
                    }
                    else if (this.voie.getId_secteur() == null){
                        this.voie.setIdSecteur(idSecteur);
                    }
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
