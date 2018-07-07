package org.val.win.webapp.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.grimpe.Secteur;
import org.val.win.model.bean.grimpe.Site;
import org.val.win.model.bean.grimpe.Topo;
import org.val.win.model.bean.grimpe.Voie;
import org.val.win.model.bean.utilisateur.Utilisateur;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 *
 * Gestion des actions liées aux topos.
 */

public class GestionTopoAction extends ActionSupport implements SessionAware {


    /**
     * Récuperer session
     */
    private Map<String, Object> session;

    /**
     * Récupérer manager factory
     */
    @Inject
    private ManagerFactory managerFactory;

    /**
     * Setteur pour la session
     * @param pSession session de l'utilisateur
     */
    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }


    // ==================== Attributs ====================

    // ----- Paramètres en entrée

    /**
     * id du topo
     */
    private Integer idTopo;
    /**
     * utilisateur
     */
    private Utilisateur utilisateur;
    /**
     * emprunteur du topo
     */
    private Utilisateur emprunteur;

    // ----- Eléments en sortie

    /**
     * Liste des topos
     */
    private List<Topo> listTopo;
    /**
     * Liste des sites
     */
    private List<Site> listSite;
    /**
     * Liste des secteurs
     */
    private List<Secteur> listSecteur;
    /**
     * Liste des voies
     */
    private List<Voie> listVoie;
    /**
     * topo
     */
    private Topo topo;
    /**
     * site
     */
    private Site site;
    /**
     * secteur
     */
    private Secteur secteur;
    /**
     * voie
     */
    private Voie voie;


    // ==================== Getters/Setters ====================

    /**
     * Recuperer l'id d'un topo
     * @return l'id d'un topo
     */
    public Integer getIdTopo() {
        return idTopo;
    }

    /**
     * modifier l'id d'un topo
     * @param pId le nouvel id
     */
    public void setIdTopo(Integer pId) {
        idTopo = pId;
    }

    /**
     * recuperer un topo
     * @return
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
     * recuperer un site
     * @return un site
     */
    public Site getSite(){ return site;}

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
    public Secteur getSecteur(){ return secteur;}

    /**
     * modifier un secteur
     * @param pSecteur nouveau secteur
     */
    public void setSecteur(Secteur pSecteur){
        secteur = pSecteur;
    }

    /**
     * Recuperer une voie
     * @return une voie
     */
    public Voie getVoie() {
        return voie;
    }

    /**
     * modifier une voie
     * @param pVoie nouvelle voie
     */
    public void setVoie(Voie pVoie) {
        voie = pVoie;
    }

    /**
     * recuprer une liste de topo
     * @return une liste de topo
     */
    public List<Topo> getListTopo() {
        return listTopo;
    }

    /**
     * recuperer une liste de site
     * @return une liste de site
     */
    public List<Site> getListSite() {
        return listSite;
    }

    /**
     * recuperer une liste de secteur
     * @return une liste de secteur
     */
    public List<Secteur> getListSecteur() {
        return listSecteur;
    }

    /**
     * recuperer une liste de voie
     * @return une liste de voie
     */
    public List<Voie> getListVoie() {
        return listVoie;
    }

    /**
     * recuperer un utilisateur
     * @return
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * recuperer l'emprunteur d'un topo
     * @return
     */
    public Utilisateur getEmprunteur(){
        return emprunteur;
    }

    /**
     * modifier l'emprunteur d'un topo
     * @param pEmprunteur le nouvel emprunteur
     */
    public void setEmprunteur(Utilisateur pEmprunteur){
        this.emprunteur = pEmprunteur;
    }

    // ==================== Méthodes ====================

    /**
     * Action listant les {@link Topo}
     * @return success
     */
    public String doList() {
        listTopo = managerFactory.getTopoManager().getListTopo();
        return ActionSupport.SUCCESS;
    }

    /**
     * Action listant les secteurs.
     * @return liste de secteur
     */
    public String doListSecteur() {
        if (site == null) {
            addActionError("Le site doit être précisé !");
        } else {
            listSecteur = managerFactory.getSecteurManager().getListSecteur(site.getIdSite());
        }
        return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    /**
     * Action listant les sites
     * @return liste de sites
     */
    public String doListSite() {
        topo = (Topo) session.get("topo");
        listSite = managerFactory.getSiteManager().getListSite(topo.getIdTopo());
        return ActionSupport.SUCCESS;
    }

    /**
     * Actions listant les voies
     * @return liste de voies
     */
    public String doListVoie() {
        if (secteur == null) {
            addActionError("Le secteur doit être précisé !");
        } else {
            listVoie = managerFactory.getVoieManager().getListVoie(secteur.getIdSecteur());
        }
        return ActionSupport.SUCCESS;
    }

    /**
     * Action retournant un site
     * @return un secteur
     */
    public String doDetailSite() {
        return ActionSupport.SUCCESS;
    }

    /**
     * Action retournant une voie
     * @return un secteur
     */
    public String doDetailVoie() {
        return ActionSupport.SUCCESS;
    }

    /**
     * Action retournant un secteur
     * @return un secteur
     */
    public String doDetailSecteur() {
        return ActionSupport.SUCCESS;
    }

    /**
     * Action affichant les détails d'un {@link Topo}
     * @return success / error
     */
    public String doDetail() {
        if (idTopo == null) {
            this.addActionError(getText("error.topo.missing.id"));
        } else {
            try {
                topo = managerFactory.getTopoManager().getTopo(idTopo);
                utilisateur = managerFactory.getUtilisateurManager().getUtilisateur(topo.getIdUtilisateurCreateur());
                if (this.topo.getIdEmprunteur() != null) {
                    emprunteur = managerFactory.getUtilisateurManager().getUtilisateur(topo.getIdEmprunteur());
                }
                this.session.put("topo", topo);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.topo.notfound", Collections.singletonList(idTopo)));
            }
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    /**
     * Action permettant de créer un nouveau {@link Topo}
     * @return input / success / error
     */
    public String doCreate() {
        utilisateur = (Utilisateur) session.get("user");
        if (session.get("user") == null) {
            return ActionSupport.LOGIN; }
            else {
            // Si (this.topo == null) c'est que l'on entre dans l'ajout de projet
            // Sinon, c'est que l'on vient de valider le formulaire d'ajout
            // Par défaut, le result est "input"
            String vResult = ActionSupport.INPUT;
            // Récupération de l'utilisateur
            // ===== Validation de l'ajout de topo (topo != null)
            if (this.topo != null) {
                if (topo.getIdUtilisateurCreateur() == null) {
                    this.topo.setIdUtilisateurCreateur(utilisateur.getIdUtilisateur());
                }
                // Si pas d'erreur, ajout du topo...
                if (!this.hasErrors()) {
                    try {
                        managerFactory.getTopoManager().insertTopo(this.topo);
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

    /**
     * Action permettant l'emprunt
     * Gestion des dates
     * @return input / success
     */
    public String EmpruntTopo(){
        topo = (Topo) session.get("topo");
        utilisateur = (Utilisateur) session.get("user");
        if(session.get("user") == null){
            return ActionSupport.LOGIN; }
            else {
            String vResult = Action.INPUT;
            if (this.topo.getIdEmprunteur() != null) {
                addActionError("Vous ne pouvez pas emprunter ce topo");
            }
            if (!this.hasErrors()) {
                try {
                    managerFactory.getTopoManager().emprunt(topo, utilisateur);
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Topo reservé avec Succès");
                } catch (FunctionalException pEx) {
                    this.addActionMessage(pEx.getMessage());
                }
            }
            return vResult;
        }
    }

    /**
     * Rendre un topo
     * @return le topo a retourner
     */
    public String RendreTopo(){
        topo = (Topo) session.get("topo");
        utilisateur = (Utilisateur) session.get("user");
        if(session.get("user") == null){
            return ActionSupport.LOGIN; }
        else {
            String vResult = Action.INPUT;
            if (!this.hasErrors()) {
                try {
                    managerFactory.getTopoManager().retour(topo);
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Topo rendu avec Succès");
                } catch (FunctionalException pEx) {
                    this.addActionMessage(pEx.getMessage());
                }
            }
            return vResult;
        }
    }
}
