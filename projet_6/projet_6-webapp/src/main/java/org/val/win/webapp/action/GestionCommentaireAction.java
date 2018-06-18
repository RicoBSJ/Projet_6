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

    @Inject
    private ManagerFactory managerFactory;

    // ==================== Attributs ====================

    // ----- Paramètres en entrée
    private Integer idTopo;
    private Topo topo;

    // ----- Eléments en sortie
    private List<Commentaire> listCom;
    private Commentaire commentaire;

    // ==================== Getters/Setters ====================

    public Topo getTopo() {
        return topo;
    }
    public void setTopo(Topo pTopo) {
        topo = pTopo;
    }
    public Integer getIdTopo() {
        return idTopo;
    }
    public void setIdTopo(Integer pId) {
        idTopo = pId;
    }
    public Commentaire getCommentaire() {
        return commentaire;
    }
    public void setCommentaire(Commentaire pCommentaire) {
        commentaire = pCommentaire;
    }
    public List<Commentaire> getListCom(){
        return listCom;
    }


    // ==================== Methodes ====================

    /**
     * Creation de commentaire.
     * @return resultat de l'action
     */
    public String doCreate() {
        Utilisateur utilisateur = (Utilisateur) session.get("user");
        topo = (Topo) session.get("topo");
        System.out.println(topo);
        System.out.println(utilisateur);
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
