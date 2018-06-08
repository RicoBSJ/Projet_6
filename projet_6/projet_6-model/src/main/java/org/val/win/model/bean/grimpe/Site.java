package org.val.win.model.bean.grimpe;

public class Site {

    // ==================== Attributs ====================
    private Integer idSite;
    private Integer idTopo;
    private String nomSite;
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
        idSite = pId;
    }


    // ==================== Getters/Setters ====================

    public void setIdSite(Integer pIdSite){
        idSite = pIdSite;
    }
    public Integer getIdSite(){
        return idSite;
    }
    public Integer getIdTopo() {
        return idTopo;
    }
    public void setIdTopo(Integer pIdTopo){
        idTopo = pIdTopo;
    }
    public String getNomSite() {
        return nomSite;
    }
    public void setNomSite(String pNom_site) {
        nomSite = pNom_site;
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
                .append("Site id=").append(idSite)
                .append(vSEP).append("Topo id = \"").append(idTopo).append('"')
                .append(vSEP).append("description =\"").append(description).append('"')
                .append(vSEP).append("altitude pied voie =\"").append(altitudePiedVoie).append('"')
                .append("}");
        return vStB.toString();
    }
}
