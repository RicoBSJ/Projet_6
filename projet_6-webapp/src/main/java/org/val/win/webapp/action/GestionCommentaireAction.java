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
     * @param pSession session de l'utilisateur
     */
    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    /**
     * Récupérer manager factory
     */
    @Inject
    private ManagerFactory managerFactory;

    // ==================== Attributs ====================

    // ----- Paramètres en entrée
    /**
     * id du topo
     */
    private Integer idTopo;
    /**
     * Objet topo
     */
    private Topo topo;

    // ----- Eléments en sortie
    /**
     * Liste de commantaire
     */
    private List<Commentaire> listCommentaire;
    /**
     * Un commentaire
     */
    private Commentaire commentaire;

    // ==================== Getters/Setters ====================

    /**
     * recuperer l'id topo
     * @return l'id du topo
     */
    public Integer getIdTopo(){
        return idTopo;
    }

    /**
     * modifier l'id du topo
     * @param pId nouvel id
     */
    public void setIdTopo(Integer pId){
        idTopo = pId;
    }

    /**
     * recuperer un topo
     * @return un topo
     */
    public Topo getTopo() {
        return topo;
    }

    /**
     * modifier un topo
     * @param pTopo le topo a modifier
     */
    public void setTopo(Topo pTopo) {
        topo = pTopo;
    }

    /**
     * recuperer un commentaire
     * @return
     */
    public Commentaire getCommentaire() {
        return commentaire;
    }

    /**
     * modifier un commentaire
     * @param pCommentaire le nouveau commentaire
     */
    public void setCommentaire(Commentaire pCommentaire) {
        commentaire = pCommentaire;
    }

    /**
     * recuperer une liste de commentaire
     * @return
     */
    public List<Commentaire> getListCommentaire(){
        return listCommentaire;
    }


    // ==================== Methodes ====================

    /**
     * Action listant les commentaires
     * @return liste de commentaire d'un topo
     */
    public String doListcom() {
        topo = (Topo) session.get("topo");
        listCommentaire = managerFactory.getCommentaireManager().getCommentaireTopo(topo.getIdTopo());
        return ActionSupport.SUCCESS;
    }

    /**
     * Creation de commentaire.
     * @return resultat de l'action
     */
    public String doCreate() {
        Utilisateur utilisateur = (Utilisateur) session.get("user");
        topo = (Topo) session.get("topo");
        if (session.get("user") == null){
            return ActionSupport.LOGIN; }
        else {
            // Si (this.commentaire == null) c'est que l'on entre dans l'ajout de projet
            // Sinon, c'est que l'on vient de valider le formulaire d'ajout
            // Par défaut, le result est "input"
            String vResult = ActionSupport.INPUT;
            // ===== Validation de l'ajout de projet (commentaire != null)
            if (this.commentaire != null) {
                if (commentaire.getIdUtil() == null) {
                    this.commentaire.setIdUtil(utilisateur.getIdUtilisateur());
                }
                if (commentaire.getIdTopo() == null) {
                    this.commentaire.setIdTopo(topo.getIdTopo());
                }
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
