package org.exemple.demo.webapp.action;


import java.util.Collections;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import org.exemple.demo.business.contract.ManagerFactory;
import org.exemple.demo.model.bean.utilisateur.Utilisateur;
import org.exemple.demo.model.exception.NotFoundException;
import org.exemple.demo.webapp.WebappHelper;

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
     * Action listant les {@link Utilisateur}
     * @return success
     */
    public String doList() {
        listUtilisateur = managerFactory.getUtilisateurManager().getListUtilisateur();;
        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les détails d'un {@link Utilisateur}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError(getText("error.utilisateur.missing.id"));
        } else {
            try {
                utilisateur = WebappHelper.getManagerFactory().getUtilisateurManager().getUtilisateur(id);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.utilisateur.notfound", Collections.singletonList(id)));
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}
