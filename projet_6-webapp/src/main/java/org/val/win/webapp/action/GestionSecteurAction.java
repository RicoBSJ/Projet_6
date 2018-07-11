package org.val.win.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.grimpe.Secteur;
import org.val.win.model.bean.grimpe.Site;
import org.val.win.model.bean.grimpe.Topo;
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
     * Topo du secteur
     */
    private Topo topo;
    /**
     * Site du secteur
     */
    private Site site;

    /**
     * id du topo
     */
    private Integer idTopo;

    // ----- Paramètres en sortie

    /**
     * un secteur
     */
    private Secteur secteur;


    // ==================== Getters/Setters ====================

    /**
     * recuperer l'id d'un topo
     * @return l'id du topo
     */
    public Integer getIdTopo(){
        return idTopo;
    }

    /**
     * modifier l'id du topo
     * @param pId le nouvel id
     */
    public void setIdTopo(Integer pId){
        idTopo = pId;
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

    // ==================== Méthodes ====================

    /**
     * Creation de Secteur
     * @return le resultat de l'action
     */
    public String doCreate() {
        topo = (Topo) session.get("topo");
        if (session.get("user") == null) {
            return ActionSupport.LOGIN; }
        else {
            String vResult = ActionSupport.INPUT;
            if (this.secteur != null) {
                if (secteur.getIdTopo() == null) {
                    this.secteur.setIdTopo(topo.getIdTopo());
                }
                if (!this.hasErrors()) {
                    try {
                        managerFactory.getSecteurManager().insertSecteur(secteur);
                        // Si ajout avec succès -> Result "success"
                        vResult = ActionSupport.SUCCESS;
                        this.addActionMessage("Topo ajouté avec succès");
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
