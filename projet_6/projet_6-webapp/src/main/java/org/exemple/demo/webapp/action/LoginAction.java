package org.exemple.demo.webapp.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.exemple.demo.business.contract.ManagerFactory;
import org.exemple.demo.model.bean.utilisateur.Utilisateur;
import org.exemple.demo.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    @Inject
    private ManagerFactory managerFactory;

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    // ==================== Attributs ====================

    // ----- Paramètres en entrée
    private String login;
    private String password;
    private List<Utilisateur> listUtilisateur;
    private Utilisateur utilisateur;


    // ==================== Getters/Setters ====================
    public String getLogin() {
        return login;
    }
    public void setLogin(String pLogin) {
        login = pLogin;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String pPassword) {
        password = pPassword;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
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

        return ActionSupport.SUCCESS;
    }
}
