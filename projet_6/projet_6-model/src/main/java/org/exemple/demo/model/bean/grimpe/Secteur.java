package org.exemple.demo.model.bean.grimpe;

public class Secteur {

    // ==================== Attributs ====================
    private Integer id;
    private Integer nbrVoie;
    public String nom;
    private String difficulte;
    private String orientation;
    private String description;


    // ==================== Constructeurs ====================
    /**
     * Constructeur.
     */
    public Secteur() {
    }


    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Secteur(Integer pId) {
        id = pId;
    }


    // ==================== Getters/Setters ====================

    public Integer getId(){
        return id;
    }
    public Integer getNbrVoie() {
        return nbrVoie;
    }
    public void setNbrVoie(Integer pNbrVoie){
        nbrVoie = pNbrVoie;
    }
    public String getDifficulte(){
        return difficulte;
    }
    public void setDifficulte(String pDifficulte){
        difficulte = pDifficulte;
    }
    public String getOrientation() {
        return orientation;
    }
    public void setOrientation(String pOrientation){
        orientation = pOrientation;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String pDescription) {
        description = pDescription;
    }


    // ==================== Méthodes ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("Admin id=").append(id)
                .append(vSEP).append("nom =\"").append(nom).append('"')
                .append(vSEP).append("description =\"").append(description).append('"')
                .append(vSEP).append("nombre de voie(s) =\"").append(nbrVoie).append('"')
                .append(vSEP).append("orientation =\"").append(orientation).append('"')
                .append(vSEP).append("difficulte =\"").append(difficulte).append('"')
                .append("}");
        return vStB.toString();
    }
}
