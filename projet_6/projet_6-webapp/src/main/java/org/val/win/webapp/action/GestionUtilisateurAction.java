package org.val.win.webapp.action;


import java.util.Collections;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.utilisateur.Utilisateur;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;
import javax.inject.Inject;


public class GestionUtilisateurAction extends ActionSupport {

    @Inject
    private ManagerFactory managerFactory;

    // ==================== Attributs ====================

    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private List<Utilisateur> listUtilisateur;
    private Utilisateur utilisateur;


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public void setUtilisateur(Utilisateur pUtilisateur) {
        utilisateur = pUtilisateur;
    }
    public List<Utilisateur> getListUtilisateur() {
        return listUtilisateur;
    }

    // ==================== Méthodes ====================

    /**
     * Action affichant les détails d'un {@link Utilisateur}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError(getText("error.utilisateur.missing.id"));
        } else {
            try {
                utilisateur = managerFactory.getUtilisateurManager().getUtilisateur(id);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.utilisateur.notfound", Collections.singletonList(id)));
            }
        }
        return ActionSupport.SUCCESS;
    }

    /**
     * Action permettant la création d'un nouvel utilisateur {@link Utilisateur}
     * @return success / error
     */
    public String doCreate() {
        // Si (this.projet == null) c'est que l'on entre dans l'ajout de projet
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout
        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;
        // ===== Validation de l'ajout de projet (projet != null)
        if (this.utilisateur != null) {
            this.utilisateur.setAdmin(false);
            System.out.println(utilisateur);
            // Si pas d'erreur, ajout du projet...
            if (!this.hasErrors()) {
                try {
                    managerFactory.getUtilisateurManager().insertUtilisateur(this.utilisateur);
                    // Si ajout avec succès -> Result "success"
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Utilisateur ajouté avec succès");

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
}
