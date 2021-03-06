package org.val.win.model.bean.utilisateur;

/**
 * Objet utilisateur
 */
public class Utilisateur {

    // ==================== Attributs ====================
    /**
     * Id de l'utilisateur
     */
    private Integer idUtilisateur;
    /**
     * numero de telephone de l'utilisateur
     */
    private String tel;
    /**
     * nom de l'utilisateur
     */
    private String nom;
    /**
     * prenom de l'utilisateur
     */
    private String prenom;
    /**
     * mot de passe de l'utilisateur
     */
    private String mdp;
    /**
     * adresse mail de l'utilisateur
     */
    private String mail;
    /**
     * pseudonyme de l'utilisateur
     */
    private String pseudonyme;
    /**
     * statut de l'utilisateur, TRUE == admin, FALSE == non admin
     */
    private Boolean admin;


    // ==================== Constructeurs ====================
    /**
     * Constructeur.
     */
    public Utilisateur() {
    }


    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Utilisateur(Integer pId) {
        idUtilisateur = pId;
    }


    // ==================== Getters/Setters ====================

    /**
     * modifier l'id de l'utilisateur
     * @param pId nouvel id
     */
    public void setIdUtilisateur(Integer pId) {
        idUtilisateur = pId;
    }

    /**
     * recuperer l'id de l'utilisateur
     * @return l'id de l'utilisateur
     */
    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * recuperer le numero de telephone de l'utilisateur
     * @return le numero de telephone
     */
    public String getTel() {
        return tel;
    }

    /**
     * modifier le numero
     * @param pTel nouveau numero
     */
    public void setTel(String pTel) {
        tel = pTel;
    }

    /**
     * recuperer le nom de l'utilisateur
     * @return le nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * recuperer le prenom de l'utilisateur
     * @param pNom le nouveau nom
     */
    public void setNom(String pNom) {
        nom = pNom;
    }

    /**
     * recuperer le prenom de l'utilisateur
     * @return le prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * modifier le prenom de l'utilisateur
     * @param pPrenom le nouveau prenom
     */
    public void setPrenom(String pPrenom) {
        prenom = pPrenom;
    }

    /**
     * recuperer l'adresse mail de l'utilisateur
     * @return l'adresse mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * modifier l'adresse mail de l'utilisateur
     * @param pMail la nouvelle adresse mail
     */
    public void setMail(String pMail) {
        mail = pMail;
    }

    /**
     * recuperer le mot de passe de l'utilisateur
     * @return le mot de passe
     */
    public String getMotDePasse() {
        return mdp;
    }

    /**
     * modifier le mot de passe de l'utilisateur
     * @param pMdp le nouveau mot de passe
     */
    public void setMotDePasse(String pMdp) {
        mdp = pMdp;
    }

    /**
     * recuperer le pseudo de l'utilisateur
     * @return le pseudo
     */
    public String getPseudonyme() {
        return pseudonyme;
    }

    /**
     * modifier le pseudo de l'utilisateur
     * @param pPseudonyme nouveau pseudo
     */
    public void setPseudonyme(String pPseudonyme) {
        pseudonyme = pPseudonyme;
    }

    /**
     * recuperer le statut de l'utilisateur
     * @return le statut
     */
    public Boolean getAdmin() {
        return admin;
    }

    /**
     * modifier le statut de l'utilisateur
     * @param padmin le nouveau statut
     */
    public void setAdmin(Boolean padmin) {
        admin = padmin;
    }


    // ==================== Méthodes ====================
    /**
     * StringBuilder de l'objet utilisateur
     * @return toutes les informations de l'utilisateur
     */
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("Utilisateur idUtilisateur=").append(idUtilisateur)
                .append(vSEP).append("nom=\"").append(nom).append('"')
                .append(vSEP).append("prenom=\"").append(prenom).append('"')
                .append(vSEP).append("pseudonyme\"").append(pseudonyme).append('"')
                .append(vSEP).append("telephone=\"").append(tel).append('"')
                .append(vSEP).append("mail=\"").append(mail).append('"')
                .append(vSEP).append("mot de passe = \"").append(mdp).append(('"'))
                .append(vSEP).append("admin = \"").append(admin).append('"')
                .append("}");
        return vStB.toString();
    }
}