package org.val.win.model.bean.grimpe;

/**
 * Objet Site
 */
public class Site {

    // ==================== Attributs ====================
    /**
     * id du site
     */
    private Integer idSite;
    /**
     * id du topo auquel appartien le site
     */
    private Integer idTopo;
    /**
     * le nom du site
     */
    private String nomSite;
    /**
     * l'altitude en pied du site
     */
    private Float altitudePiedVoie;
    /**
     * la description dus ite
     */
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

    /**
     * modifier l'id du site
     * @param pIdSite le nouvel id
     */
    public void setIdSite(Integer pIdSite){
        idSite = pIdSite;
    }

    /**
     * recuperer l'id du site
     * @return l'id du site
     */
    public Integer getIdSite(){
        return idSite;
    }

    /**
     * recuperer l'id du topo
     * @return l'id du topo
     */
    public Integer getIdTopo() {
        return idTopo;
    }

    /**
     * modifier l'id du topo
     * @param pIdTopo le nouvel id
     */
    public void setIdTopo(Integer pIdTopo){
        idTopo = pIdTopo;
    }

    /**
     * recuperer le nom du site
     * @return le nom du site
     */
    public String getNomSite() {
        return nomSite;
    }

    /**
     * modifier le nom du site
     * @param pNomSite le nouveau non du site
     */
    public void setNomSite(String pNomSite) {
        nomSite = pNomSite;
    }

    /**
     * recuperer l'altitude du site
     * @return l'altitude du site
     */
    public Float getAltitudePiedVoie() {
        return altitudePiedVoie;
    }

    /**
     * modifier l'altitude du site
     * @param pAltitudePiedVoie la nouvelle altitude
     */
    public void setAltitudePiedVoie(Float pAltitudePiedVoie){
        altitudePiedVoie = pAltitudePiedVoie;
    }

    /**
     * recuperer la description d'un site
     * @return la description du site
     */
    public String getDescription() {
        return description;
    }

    /**
     * modifier la description
     * @param pDescription la nouvelle description
     */
    public void setDescription(String pDescription) {
        description = pDescription;
    }


    // ==================== Méthodes ====================
    /**
     * StringBuilder de l'objet site
     * @return toutes les informations du site
     */
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
