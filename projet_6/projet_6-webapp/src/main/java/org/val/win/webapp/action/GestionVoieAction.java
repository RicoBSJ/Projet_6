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

    /**
     * id de la voie
     */
    private Integer idVoie;
    /**
     * id du topo
     */
    private Integer idTopo;
    /**
     * id du site
     */
    private Integer idSite;
    /**
     * id du secteur
     */
    private Integer idSecteur;

    // ----- Eléments en sortie

    /**
     * Objet voie
     */
    private Voie voie;

    // ==================== Getters/Setters ====================

    /**
     * Recuperer l'id de la voie
     * @return id de la voie
     */
    public Integer getIdVoie() {
        return idVoie;
    }

    /**
     * Modifier id Voie
     * @param pId le nouvel id
     */
    public void setIdVoie(Integer pId) {
        idVoie = pId;
    }

    /**
     * Recuperer l'id du site
     * @return id du site
     */
    public Integer getIdSite() {
        return idSite;
    }

    /**
     * modifier l'id du site
     * @param idSite nouvel id site
     */
    public void setIdSite(Integer idSite) {
        this.idSite = idSite;
    }

    /**
     * recuperer l'id du topo
     * @return id topo
     */
    public Integer getIdTopo() {
        return idTopo;
    }

    /**
     * modifier l'id du topo
     * @param idTopo le nouvel id
     */
    public void setIdTopo(Integer idTopo) {
        this.idTopo = idTopo;
    }

    /**
     * recuperer l'id du secteur
     * @return l'id du secteur
     */
    public Integer getIdSecteur() {
        return idSecteur;
    }

    /**
     * modifier l'id du secteur
     * @param idSecteur le nouvel id
     */
    public void setIdSecteur(Integer idSecteur) {
        this.idSecteur = idSecteur;
    }

    /**
     * modifier une voie
     * @param pVoie une voie
     */
    public void setVoie(Voie pVoie){
        this.voie = pVoie;
    }

    /**
     * recuperer une voie
     * @return une voie
     */
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
