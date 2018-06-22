package org.val.win.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.grimpe.Secteur;
import org.val.win.model.bean.utilisateur.Utilisateur;
import org.val.win.model.exception.FunctionalException;

import javax.inject.Inject;
import java.util.Map;

public class GestionSecteurAction extends ActionSupport implements SessionAware{

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
     * id du topo
     */
    private Integer idTopo;
    /**
     * id du site
     */
    private Integer idSite;

    // ----- Paramètres en sortie

    /**
     * un secteur
     */
    private Secteur secteur;


    // ==================== Getters/Setters ====================

    /**
     * recuperer l'id d'un topo
     * @return l'id d'un topo
     */
    public Integer getIdTopo(){
        return idTopo;
    }

    /**
     * modifier l'id d'un topo
     * @param pId
     */
    public void setIdTopo(Integer pId) {
        idTopo = pId;
    }

    /**
     * recuperer l'id d'un site
     * @return l'id d'un site
     */
    public Integer getIdSite(){
        return idSite;
    }

    /**
     * modifier l'id d'un site
     * @param pId modifier id site
     */
    public void setIdSite(Integer pId){
        idSite = pId;
    }

    /**
     * recuperer un secteur
     * @return un secteur
     */
    public Secteur getSecteur(){
        return secteur;
    }

    /**
     * modifier un secteur
     * @param pSecteur le nouveau secteur
     */
    public void setSecteur(Secteur pSecteur){
        secteur = pSecteur;
    }

    // ==================== Méthodes ====================

    /**
     * Creation de Secteur
     * @return le resultat de l'action
     */
    public String doCreate() {
        Utilisateur utilisateur = (Utilisateur) session.get("user");
        if (session.get("user") == null) {
            return ActionSupport.LOGIN; }
        else {
            String vResult = ActionSupport.INPUT;
            if (this.secteur != null) {
                if (!this.hasErrors()) {
                    if (this.secteur.getId_topo() == null){
                        this.secteur.setIdTopo(idTopo);
                    }
                    else if (this.secteur.getId_site() == null){
                        this.secteur.setIdSite(idSite);
                    }
                    try {
                        managerFactory.getSecteurManager().insertSecteur(this.secteur);
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
