package org.val.win.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.grimpe.Secteur;
import org.val.win.model.bean.grimpe.Site;
import org.val.win.model.bean.grimpe.Topo;
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
     * id du topo
     */
    private Integer idTopo;

    /**
     * Topo de la voie
     */
    private Topo topo;

    /**
     * Secteur de la voie
     */
    private Secteur secteur;

    /**
     * Site de la voie
     */
    private Site site;

    // ----- Eléments en sortie

    /**
     * Objet voie
     */
    private Voie voie;

    // ==================== Getters/Setters ====================


    public Integer getIdTopo() {
        return idTopo;
    }

    public void setIdTopo(Integer pId){
        idTopo = pId;
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

    /**
     * recuperer un topo
     * @return un topo
     */
    public Topo getTopo(){
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
     * Recuperer un site
     * @return un site
     */
    public Site getSite(){
        return site;
    }

    /**
     * modifier un site
     * @param pSite le nouveau site
     */
    public void setSite(Site pSite){
        site = pSite;
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
     * Creation d'une voie
     * @return le resultat de l'action
     */
    public String doCreate() {
        topo = (Topo) session.get("topo");
        if (session.get("user") == null) {
            return ActionSupport.LOGIN; }
        else {
            String vResult = ActionSupport.INPUT;
            if (this.voie != null) {
                if (!this.hasErrors()) {
                    if (this.voie.getIdTopo() == null){
                        this.voie.setIdTopo(topo.getIdTopo());
                    }
                    else if (this.voie.getIdSite() == null){
                        this.voie.setIdSite(site.getIdSite());
                    }
                    else if (this.voie.getIdSecteur() == null){
                        this.voie.setIdSecteur(secteur.getIdSecteur());
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
