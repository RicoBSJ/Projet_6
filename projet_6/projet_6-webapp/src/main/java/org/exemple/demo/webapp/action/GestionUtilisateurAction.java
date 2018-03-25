package org.exemple.demo.webapp.action;


import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import org.exemple.demo.model.bean.utilisateur.Utilisateur;
import org.exemple.demo.model.exception.NotFoundException;
import org.exemple.demo.webapp.WebappHelper;

import javax.rmi.CORBA.Util;


public class GestionUtilisateurAction extends ActionSupport {


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
        listUtilisateur = WebappHelper.getManagerFactory().getUtilisateurManager().getListUtilisateur();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les détails d'un {@link Utilisateur}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError(getText("error.project.missing.id"));
        } else {
            try {
                utilisateur = WebappHelper.getManagerFactory().getUtilisateurManager().getUtilisateur(id);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.project.notfound", Collections.singletonList(id)));
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}
