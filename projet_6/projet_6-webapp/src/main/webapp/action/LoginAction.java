import org.apache.commons.lang3.StringUtils;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import org.exemple.demo.model.bean.utilisateur.Utilisateur;
import org.exemple.demo.model.exception.NotFoundException;
import org.exemple.demo.webapp.WebappHelper;


/**
 * Action de gestion de la connexion/déconnexion d'un utilisateur
 */
public class LoginAction extends ActionSupport implements SessionAware{

    // ----- Eléments Struts
    private Map<String, Object> session;

    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }



    // ==================== Attributs ====================
    // ----- Paramètres en entrée

    private String login;
    private String password;


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


    // ==================== Méthodes ====================
    /**
     * Action permettant la connexion d'un utilisateur
     * @return input / success
     */
    public String doLogin() {
        String vResult = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(login, password)) {
            try {
                Utilisateur vUtilisateur
                        = WebappHelper.getManagerFactory().getUtilisateurManager()
                        .getUtilisateur(login, password);

                // Ajout de l'utilisateur en session
                this.session.put("user", vUtilisateur);

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
     */
    public String doLogout() {
        // Suppression de l'utilisateur en session
        this.session.remove("user");

        return ActionSupport.SUCCESS;
    }
}
