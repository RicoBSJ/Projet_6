package org.val.win.webapp.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.grimpe.Secteur;
import org.val.win.model.bean.grimpe.Site;
import org.val.win.model.bean.grimpe.Topo;
import org.val.win.model.bean.grimpe.Voie;
import org.val.win.model.bean.utilisateur.Commentaire;
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
     * @param pSession
     */
    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    // ==================== Attributs ====================

    // ----- Paramètres en entrée
    private Integer idTopo;
    private Utilisateur utilisateur;
    private Utilisateur emprunteur;

    // ----- Eléments en sortie
    private List<Topo> listTopo;
    private List<Site> listSite;
    private List<Secteur> listSecteur;
    private List<Voie> listVoie;
    private List<Commentaire> listCom;
    private Topo topo;
    private Site site;
    private Secteur secteur;


    // ==================== Getters/Setters ====================

    public Integer getIdTopo() {
        return idTopo;
    }
    public void setIdTopo(Integer pId) {
        idTopo = pId;
    }
    public Topo getTopo() {
        return topo;
    }
    public void setTopo(Topo pTopo) {
        topo = pTopo;
    }
    public Site getsite(){ return site;}
    public void setSite(Site pSite){
        site = pSite;
    }
    public Secteur getSecteur(){ return secteur;}
    public void setSecteur(Secteur pSecteur){
        secteur = pSecteur;
    }
    public List<Topo> getListTopo() {
        return listTopo;
    }
    public List<Site> getListSite() {
        return listSite;
    }
    public List<Secteur> getListSecteur() {
        return listSecteur;
    }
    public List<Voie> getListVoie() {
        return listVoie;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public List<Commentaire> getListCom(){
        return listCom;
    }
    public Utilisateur getEmprunteur(){
        return emprunteur;
    }
    public void setEmprunteur(Utilisateur pEmprunteur){
        this.emprunteur = pEmprunteur;
    }

    // ==================== Méthodes ====================

    @Override
    public String execute() {
        return ActionSupport.SUCCESS;
    }

    /**
     * Action listant les {@link Topo}
     * @return success
     */

    public String doList() {
        listTopo = managerFactory.getTopoManager().getListTopo();
        return ActionSupport.SUCCESS;
    }

    public String doListSecteur() {
        if (site == null) {
            addActionError("Le site doit être précisé !");
        } else {
            listSecteur = managerFactory.getSecteurManager().getListSecteur(site.getId());
        }
        return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;

    }

    public String doListSite() {
        topo = (Topo) session.get("topo");
        listSite = managerFactory.getSiteManager().getListSite(topo.getIdTopo());
        return ActionSupport.SUCCESS;
    }

    public String doListVoie() {
        if (secteur == null) {
            addActionError("Le secteur doit être précisé !");
        } else {
            listVoie = managerFactory.getVoieManager().getListVoie(site.getId());
        }
        return ActionSupport.SUCCESS;
    }

    public String doListcom() {
        topo = (Topo) session.get("topo");
        listCom = managerFactory.getCommentaireManager().getCommentaireTopo(topo.getIdTopo());
        return ActionSupport.SUCCESS;
    }

    /**
     * Action affichant les détails d'un {@link Topo}
     * @return success / error
     */
    public String doDetail() throws NotFoundException {
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
                    this.topo.setIdUtilisateurCreateur(utilisateur.getId());
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

    public String EmpruntTopo(){
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
                    topo.setIdEmprunteur(utilisateur.getId());
                    if(this.topo.getEtat() == true) {
                        topo.setEtat(false);
                    }
                    else if(this.topo.getEtat() == false){
                        topo.setEtat(true);
                    }
                    System.out.println(topo);
                    managerFactory.getTopoManager().ChangeEtat(this.topo, this.utilisateur);
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Topo reservé avec Succès");
                } catch (FunctionalException pEx) {
                    this.addActionMessage(pEx.getMessage());
                }
            }
            return vResult;
        }
    }
}
