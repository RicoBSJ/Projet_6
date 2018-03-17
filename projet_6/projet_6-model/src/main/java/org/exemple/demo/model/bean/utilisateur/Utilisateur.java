package org.exemple.demo.model.bean.utilisateur;

public class Utilisateur {

    // ==================== Attributs ====================
    private Integer id;
    private Integer tel;
    private String nom;
    private String prenom;
    private String mail;


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

    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public Integer getTel() {
        return tel;
    }
    public void setTel(Integer pTel) {
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



    // ==================== Méthodes ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("id=").append(id)
                .append(vSEP).append("nom=\"").append(nom).append('"')
                .append(vSEP).append("prenom=\"").append(prenom).append('"')
                .append(vSEP).append("telephone=\"").append(tel).append('"')
                .append(vSEP).append("mail=\"").append(mail).append('"')
                .append("}");
        return vStB.toString();
    }
}