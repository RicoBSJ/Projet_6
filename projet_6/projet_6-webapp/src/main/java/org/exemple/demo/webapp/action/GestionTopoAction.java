package org.exemple.demo.webapp.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.exemple.demo.business.contract.ManagerFactory;
import org.exemple.demo.model.bean.grimpe.Topo;
import org.exemple.demo.model.bean.utilisateur.Utilisateur;
import org.exemple.demo.model.exception.FunctionalException;
import org.exemple.demo.model.exception.NotFoundException;
import org.exemple.demo.model.exception.TechnicalException;
import org.exemple.demo.webapp.WebappHelper;

import javax.inject.Inject;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class GestionTopoAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    @Inject
    private ManagerFactory managerFactory;

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    // ==================== Attributs ====================

    // ----- Paramètres en entrée
    private Integer id;
    private Utilisateur utilisateur;

    // ----- Eléments en sortie
    private List<Topo> listTopo;
    private Topo topo;
    private List<Utilisateur> listUtilisateur;


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public Topo getTopo() {
        return topo;
    }
    public void setTopo(Topo pTopo) {
        topo = pTopo;
    }
    public List<Topo> getListTopo() {
        return listTopo;
    }
    public List<Utilisateur> getListUtilisateur() {
        return listUtilisateur;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
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
     * Action affichant les détails d'un {@link Topo}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError(getText("error.topo.missing.id"));
        } else {
            try {
                topo = managerFactory.getTopoManager().getTopo(id);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.topo.notfound", Collections.singletonList(id)));
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    /**
     * Action permettant de créer un nouveau {@link Topo}
     * @return input / success / error
     */
    /*public String doCreate() {


        // Si (this.projet == null) c'est que l'on entre dans l'ajout de projet
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout

        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;

        // ===== Validation de l'ajout de projet (projet != null)
        if (this.topo != null) {
            // Récupération du responsable
            if (this.topo.getId_utilisateur_createur() == null) {
                this.addFieldError("topo.createur.id", "ne doit pas être vide");
            } else {
                try {
                    Utilisateur vCreateur
                            = managerFactory.getUtilisateurManager()
                            .getUtilisateur(this.topo.getId_utilisateur_createur());
                    this.topo.setCreateur(vCreateur);
                } catch (NotFoundException pEx) {
                    this.addFieldError("topo.createur.id", pEx.getMessage());
                }
            }
            // Si pas d'erreur, ajout du projet...
            if (!this.hasErrors()) {
                try {
                    managerFactory.getTopoManager().insertTopo(this.topo);
                    // Si ajout avec succès -> Result "success"
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Projet ajouté avec succès");

                } catch (FunctionalException pEx) {
                    // Sur erreur fonctionnelle on reste sur la page de saisie
                    // et on affiche un message d'erreur
                    this.addActionError(pEx.getMessage());

                }
            }
        }

        // Si on doit aller sur le formulaire de saisie, il faut ajouter les info nécessaires
        if (vResult.equals(ActionSupport.INPUT)) {
            this.listUtilisateur = managerFactory.getUtilisateurManager().getListUtilisateur();
        }

        return vResult;
    }
    */

}
