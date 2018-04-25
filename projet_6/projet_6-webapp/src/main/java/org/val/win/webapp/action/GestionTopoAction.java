package org.val.win.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.grimpe.Topo;
import org.val.win.model.bean.utilisateur.Utilisateur;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.Collections;
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
        System.out.println(session);
        listTopo = managerFactory.getTopoManager().getListTopo();
        return ActionSupport.SUCCESS;
    }

    /*public String doList() {
        Utilisateur utilisateur = (Utilisateur) session.get("user");
        if(session.get("user") == null){
            return ActionSupport.LOGIN; }
            else { listTopo = managerFactory.getTopoManager().getListTopo();
            return ActionSupport.SUCCESS; } }
            */



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
    public String doCreate() {
        // Si (this.projet == null) c'est que l'on entre dans l'ajout de projet
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout
        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;
        // Récupération de l'utilisateur
        Utilisateur pUtilisateur = (Utilisateur) session.get("user");
        // ===== Validation de l'ajout de projet (projet != null)
        if (this.topo != null) {
            // Récupération du responsable
            if (this.topo.getId_utilisateur_createur() == null) {
                this.addFieldError("topo.id_utilisateur_createur", "ne doit pas être vide");
            } else {
                this.topo.setId_utilisateur_createur(pUtilisateur.getId());
            }
            // Si pas d'erreur, ajout du projet...
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
