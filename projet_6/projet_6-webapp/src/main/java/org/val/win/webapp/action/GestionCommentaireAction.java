package org.val.win.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.grimpe.Topo;
import org.val.win.model.bean.utilisateur.Commentaire;
import org.val.win.model.exception.FunctionalException;

import javax.inject.Inject;
import java.util.List;

public class GestionCommentaireAction extends ActionSupport {

    @Inject
    private ManagerFactory managerFactory;

    private Topo topo;

    // ==================== Attributs ====================

    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private List<Commentaire> listCom;
    private Commentaire commentaire;

    public String doList() {
        commentaire = managerFactory.getCommentaireManager().getComTopo(this.topo.getId());
        return ActionSupport.SUCCESS;
    }

    public String doCreate() {
        // Si (this.projet == null) c'est que l'on entre dans l'ajout de projet
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout
        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;
        // ===== Validation de l'ajout de projet (projet != null)
        if (this.commentaire != null) {
            // Si pas d'erreur, ajout du projet...
            if (!this.hasErrors()) {
                try {
                    managerFactory.getCommentaireManager().insertCom(this.commentaire);
                    // Si ajout avec succès -> Result "success"
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Commentaire ajouté avec succès");
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
