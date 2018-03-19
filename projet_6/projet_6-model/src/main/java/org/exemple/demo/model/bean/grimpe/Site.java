package org.exemple.demo.model.bean.grimpe;

public class Site {

    // ==================== Attributs ====================
    private Integer id_site;
    private Integer id_voie;
    private Integer id_secteur;
    public Float altitudePiedVoie;
    private String description;


    // ==================== Constructeurs ====================
    /**
     * Constructeur.
     */
    public Site() {
    }


    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Site(Integer pId) {
        id_site = pId;
    }


    // ==================== Getters/Setters ====================

    public Integer getId(){
        return id_site;
    }
    public Float getaltitudePiedVoie() {
        return altitudePiedVoie;
    }
    public void setAltitudePiedVoie(Float pAltitudePiedVoie){
        altitudePiedVoie = pAltitudePiedVoie;
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
                .append("Admin id=").append(id_site)
                .append(vSEP).append("description =\"").append(description).append('"')
                .append(vSEP).append("altitude pied voie =\"").append(altitudePiedVoie).append('"')
                .append("}");
        return vStB.toString();
    }
}
