package org.exemple.demo.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.exemple.demo.business.contract.ManagerFactory;
import org.exemple.demo.model.bean.grimpe.Topo;
import org.exemple.demo.model.bean.utilisateur.Utilisateur;
import org.exemple.demo.model.exception.FunctionalException;
import org.exemple.demo.model.exception.NotFoundException;
import org.exemple.demo.model.exception.TechnicalException;
import org.exemple.demo.webapp.WebappHelper;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

public class GestionTopoAction extends ActionSupport {

    @Inject
    private ManagerFactory managerFactory;

    // ==================== Attributs ====================

    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private List<Topo> listTopo;
    private Topo topo;


    // ==================== Getters/Setters ====================
    public Topo getTopo() {
        return topo;
    }
    public void setProjet(Topo pTopo) {
        topo = pTopo;
    }
    public List<Topo> getListTopo() {
        return listTopo;
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
                topo = WebappHelper.getManagerFactory().getTopoManager().getTopo(id);
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

        // ===== Validation de l'ajout de projet (projet != null)
        if (this.topo != null) {
            // Récupération du responsable
            if (this.topo.getId_utilisateur_createur() == null
                    || this.topo.getId_utilisateur_createur() == null) {
                this.addFieldError("projet.responsable.id", "ne doit pas être vide");
            } else {
                try {
                    Utilisateur vCreateur
                            = WebappHelper.getManagerFactory().getUtilisateurManager()
                            .getUtilisateur(this.topo.getId_utilisateur_createur());
                    this.topo.setId_utilisateur_createur(id);
                } catch (NotFoundException pEx) {
                    this.addFieldError("projet.responsable.id", pEx.getMessage());
                }
            }

            // Si pas d'erreur, ajout du projet...
            if (!this.hasErrors()) {
                try {
                    WebappHelper.getManagerFactory().getTopoManager().insertTopo(this.topo);
                    // Si ajout avec succès -> Result "success"
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Projet ajouté avec succès");

                } catch (FunctionalException pEx) {
                    // Sur erreur fonctionnelle on reste sur la page de saisie
                    // et on affiche un message d'erreur
                    this.addActionError(pEx.getMessage());

                } /*catch (TechnicalException pEx) {
                    // Sur erreur technique on part sur le result "error"
                    this.addActionError(pEx.getMessage());
                    vResult = ActionSupport.ERROR;
                } */
            }
        }

        // Si on doit aller sur le formulaire de saisie, il faut ajouter les info nécessaires
        if (vResult.equals(ActionSupport.INPUT)) {
            this.listTopo = WebappHelper.getManagerFactory().getTopoManager().getListTopo();
        }

        return vResult;
    }

}
