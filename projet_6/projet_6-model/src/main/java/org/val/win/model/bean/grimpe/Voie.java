package org.val.win.model.bean.grimpe;

public class Voie {

    // ==================== Attributs ====================
    private Integer id;
    private Integer id_topo;
    private Integer id_secteur;
    private Integer id_site;
    private Float hauteur;
    private String cotation;
    private String nom;
    private String description;


    // ==================== Constructeurs ====================
    /**
     * Constructeur.
     */
    public Voie() {
    }


    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Voie(Integer pId) {
        id = pId;
    }


    // ==================== Getters/Setters ====================


    public Integer getId_site() {
        return id_site;
    }

    public void setId(Integer pId) {
        id = pId;
    }

    public Integer getId_topo() {
        return id_topo;
    }

    public Integer getId_secteur() {
        return id_secteur;
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String pNom) {
        nom = pNom;
    }

    public Float getHauteur() {
        return hauteur;
    }

    public void setHauteur(Float pHauteur) {
        hauteur = pHauteur;
    }

    public String getCotation() {
        return cotation;
    }

    public void setCotation(String pCotation) {
        cotation = pCotation;
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
                .append("Voie id = \"").append(id).append('"')
                .append("Secteur id = \"").append(id_secteur).append('"')
                .append("site id = \"").append(id_site).append('"')
                .append("topo id = \"").append(id_topo).append('"')
                .append(vSEP).append("nom=\"").append(nom).append('"')
                .append(vSEP).append("cotation=\"").append(cotation).append('"')
                .append(vSEP).append("hauteur=\"").append(hauteur).append('"')
                .append(vSEP).append("description=\"").append(description).append('"')
                .append("}");
        return vStB.toString();
    }
}
