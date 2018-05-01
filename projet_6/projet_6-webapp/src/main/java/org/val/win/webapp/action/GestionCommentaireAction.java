package org.val.win.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.grimpe.Topo;
import org.val.win.model.bean.utilisateur.Commentaire;
import org.val.win.model.bean.utilisateur.Utilisateur;
import org.val.win.model.exception.FunctionalException;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class GestionCommentaireAction extends ActionSupport implements SessionAware {

    /**
     * Récuperer session
     */
    private Map<String, Object> session;

    /**
     * Setteur pour la session
     * @param pSession
     */
    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    @Inject
    private ManagerFactory managerFactory;

    private Topo topo;

    // ==================== Attributs ====================

    // ----- Paramètres en entrée
    private Integer id;
    private Utilisateur utilisateur;

    // ----- Eléments en sortie
    private List<Commentaire> listCom;
    private Commentaire commentaire;

    // ==================== Getters/Setters ====================

    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }

    public Commentaire getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(Commentaire pCommentaire) {
        commentaire = pCommentaire;
    }


    // ==================== Methodes ====================

    /**
     * Liste de commantaire avec l'id topo parametre
     * @return
     */
    public String doList() {
        listCom = managerFactory.getCommentaireManager().getComTopo(id);
        System.out.println(listCom);
        return ActionSupport.SUCCESS;
    }

    /**
     * Creation de commentaire.
     * @return
     */
    public String doCreate() {
        utilisateur = (Utilisateur) session.get("user");
        if (session.get("user") == null){
            return ActionSupport.LOGIN; }
        else {
            // Si (this.commentaire == null) c'est que l'on entre dans l'ajout de projet
            // Sinon, c'est que l'on vient de valider le formulaire d'ajout
            // Par défaut, le result est "input"
            String vResult = ActionSupport.INPUT;
            // ===== Validation de l'ajout de projet (commentaire != null)
            if (this.commentaire != null) {
                if (this.commentaire.getIdUtil() == null) {
                    this.commentaire.setIdUtil(utilisateur.getId());
                }
                else if (this.commentaire.getIdTopo() == null) {
                    this.commentaire.setIdTopo(topo.getId());
                }
                System.out.println(this.commentaire);

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
}
