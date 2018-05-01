package org.val.win.model.bean.utilisateur;

public class Utilisateur {

    // ==================== Attributs ====================
    private Integer id;
    private String tel;
    private String nom;
    private String prenom;
    private String mdp;
    private String mail;
    private String pseudonyme;
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
        id = pId;
    }


    // ==================== Getters/Setters ====================

    public void setId(Integer pId) {
        id = pId;
    }

    public Integer getId() {
        return id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String pTel) {
        tel = pTel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String pNom) {
        nom = pNom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String pPrenom) {
        prenom = pPrenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String pMail) {
        mail = pMail;
    }

    public String getMotDePasse() {
        return mdp;
    }

    public void setMotDePasse(String pMdp) {
        mdp = pMdp;
    }

    public String getPseudonyme() {
        return pseudonyme;
    }

    public void setPseudonyme(String pPseudonyme) {
        pseudonyme = pPseudonyme;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean padmin) {
        admin = padmin;
    }


    // ==================== Méthodes ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("Utilisateur id=").append(id)
                .append(vSEP).append("nom=\"").append(nom).append('"')
                .append(vSEP).append("prenom=\"").append(prenom).append('"')
                .append(vSEP).append("telephone=\"").append(tel).append('"')
                .append(vSEP).append("mail=\"").append(mail).append('"')
                .append(vSEP).append("mot de passe = \"").append(mdp).append(('"'))
                .append(vSEP).append("admin = \"").append(admin).append('"')
                .append("}");
        return vStB.toString();
    }
}