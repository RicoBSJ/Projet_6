package org.val.win.model.bean.grimpe;

public class Voie {

    // ==================== Attributs ====================
    private Integer id;
    private Integer idTopo;
    private Integer idSecteur;
    private Integer idSite;
    private Float hauteur;
    private String cotation;
    private String nomVoie;
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

    public void setId(Integer pId) {
        id = pId;
    }

    public Integer getId(){
        return id;
    }

    public void setIdSite(Integer pIdSite){
        idSite = pIdSite;
    }

    public Integer getId_site() {
        return idSite;
    }

    public void setIdTopo(Integer pIdTopo) {
        idTopo = pIdTopo;
    }

    public Integer getId_topo() {
        return idTopo;
    }

    public void setIdSecteur(Integer pIdSecteur){
        idSecteur = pIdSecteur;
    }

    public Integer getId_secteur() {
        return idSecteur;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public void setNomVoie(String pNom) {
        nomVoie = pNom;
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
                .append("Secteur id = \"").append(idSecteur).append('"')
                .append("site id = \"").append(idSite).append('"')
                .append("topo id = \"").append(idTopo).append('"')
                .append(vSEP).append("nomVoie=\"").append(nomVoie).append('"')
                .append(vSEP).append("cotation=\"").append(cotation).append('"')
                .append(vSEP).append("hauteur=\"").append(hauteur).append('"')
                .append(vSEP).append("description=\"").append(description).append('"')
                .append("}");
        return vStB.toString();
    }
}
