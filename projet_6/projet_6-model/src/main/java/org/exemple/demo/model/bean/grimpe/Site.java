package org.exemple.demo.model.bean.grimpe;

public class Site {

    // ==================== Attributs ====================
    private Integer id_site;
    private Integer id_topo;
    private String nom_site;
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


    public Integer getId_topo() {
        return id_topo;
    }
    public Integer getId_site(){
        return id_site;
    }
    public String getNom_site() {
        return nom_site;
    }
    public void setNom_site(String pNom_site) {
        nom_site = pNom_site;
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
                .append("Site id=").append(id_site)
                .append(vSEP).append("Topo id = \"").append(id_topo).append('"')
                .append(vSEP).append("description =\"").append(description).append('"')
                .append(vSEP).append("altitude pied voie =\"").append(altitudePiedVoie).append('"')
                .append("}");
        return vStB.toString();
    }
}
