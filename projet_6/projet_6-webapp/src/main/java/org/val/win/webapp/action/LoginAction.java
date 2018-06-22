package org.val.win.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.val.win.business.contract.ManagerFactory;
import org.val.win.model.bean.utilisateur.Utilisateur;
import org.val.win.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {

    /**
     * creer une session
     */
    private Map<String, Object> session;

    /**
     * Récupérer manager factory
     */
    @Inject
    private ManagerFactory managerFactory;

    /**
     * Recuperer la session de l'utilisateur
     * @param pSession
     */
    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    // ==================== Attributs ====================

    // ----- Paramètres en entrée
    /**
     * login de l'utilisateur
     */
    private String login;
    /**
     * mot de passe de l'utilisateur
     */
    private String password;
    /**
     * Objet Utilisateur
     */
    private Utilisateur utilisateur;


    // ==================== Getters/Setters ====================

    /**
     * Recuperer le login
     * @return le login
     */
    public String getLogin() {
        return login;
    }

    /**
     * modifier le login
     * @param pLogin le nouveau login
     */
    public void setLogin(String pLogin) {
        login = pLogin;
    }

    /**
     * recuperer le mot de passe
     * @return le mot de passe
     */
    public String getPassword() {
        return password;
    }

    /**
     * modifier le mot de passe
     * @param pPassword le nouveau mot de passe
     */
    public void setPassword(String pPassword) {
        password = pPassword;
    }

    /**
     * Recuperer un utilisateur
     * @return un utilisateur
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * Recuperer la session de l'tuilisateur
     * @return
     */
    public Map<String, Object> getSession(){
        return session;
    }

    // ==================== Méthodes ====================

    /**
     * Action permettant la connexion d'un utilisateur
     * @return input / success
     **/
    public String doLogin() {
        String vResult = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(login, password)) {
            try {
                utilisateur = managerFactory.getUtilisateurManager().getUtilisateur(login, password);

                // Ajout de l'utilisateur en session
                this.session.put("user", utilisateur);
                this.session.put("check", "true");
                this.addActionMessage("Vous etes bien connecté");

                vResult = ActionSupport.SUCCESS;
            } catch (NotFoundException pEx) {
                this.addActionError("Identifiant ou mot de passe invalide !");
            }
        }
        return vResult;
    }


    /**
     * Action de déconnexion d'un utilisateur
     * @return success
     **/
    public String doLogout() {
        // Suppression de l'utilisateur en session
        this.session.remove("user");
        this.session.remove("check");
        return ActionSupport.SUCCESS;
    }
}
