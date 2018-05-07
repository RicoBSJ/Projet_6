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


/**
 *
 * Gestion des actions liées aux topos.
 */

public class GestionTopoAction extends ActionSupport implements SessionAware {

    /**
     * Récuperer session
     */
    private Map<String, Object> session;

    /**
     * Récupérer manager factory
     */
    @Inject
    private ManagerFactory managerFactory;

    /**
     * Setteur pour la session
     * @param pSession
     */
    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    // ==================== Attributs ====================

    // ----- Paramètres en entrée
    private Integer idTopo;
    private Utilisateur utilisateur;

    // ----- Eléments en sortie
    private List<Topo> listTopo;
    private Topo topo;


    // ==================== Getters/Setters ====================

    public Integer getIdTopo() {
        return idTopo;
    }
    public void setIdTopo(Integer pId) {
        idTopo = pId;
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
        if (idTopo == null) {
            this.addActionError(getText("error.topo.missing.id"));
        } else {
            try {
                topo = managerFactory.getTopoManager().getTopo(idTopo);
                utilisateur = managerFactory.getUtilisateurManager().getUtilisateur(topo.getIdUtilisateurCreateur());
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.topo.notfound", Collections.singletonList(idTopo)));
            }
        }
        System.out.println(this.topo);
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    /**
     * Action permettant de créer un nouveau {@link Topo}
     * @return input / success / error
     */
    public String doCreate() {
        utilisateur = (Utilisateur) session.get("user");
        if (session.get("user") == null) {
            return ActionSupport.LOGIN; }
            else {
            // Si (this.projet == null) c'est que l'on entre dans l'ajout de projet
            // Sinon, c'est que l'on vient de valider le formulaire d'ajout
            // Par défaut, le result est "input"
            String vResult = ActionSupport.INPUT;
            // Récupération de l'utilisateur
            // ===== Validation de l'ajout de projet (topo != null)
            if (this.topo != null) {
                if (topo.getIdUtilisateurCreateur() == null) {
                    this.topo.setIdUtilisateurCreateur(utilisateur.getId());
                }
                System.out.println(this.topo);
                // Si pas d'erreur, ajout du topo...
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
}
