package org.val.win.model.bean.grimpe;

/**
 * Objet Voie
 */
public class Voie {

    // ==================== Attributs ====================

    /**
     * id de la voie
     */
    private Integer idVoie;
    /**
     * id du topo auquel appartient la voie
     */
    private Integer idTopo;
    /**
     * id du secteur auquel appartient la voie
     */
    private Integer idSecteur;
    /**
     * id du site auquel appartient la voie
     */
    private Integer idSite;
    /**
     * hauteur de la voie
     */
    private Float hauteur;
    /**
     * cotation de la voie
     */
    private String cotation;
    /**
     * nom de la voie
     */
    private String nomVoie;
    /**
     * description de la voie
     */
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
        idVoie = pId;
    }


    // ==================== Getters/Setters ====================

    /**
     * modifier l'id de la voie
     * @param pId nouvel id
     */
    public void setIdVoie(Integer pId) {
        idVoie = pId;
    }

    /**
     * recuperer l'id de la voie
     * @return l'id de la voie
     */
    public Integer getIdVoie(){
        return idVoie;
    }

    /**
     * modifier l'id du site
     * @param pIdSite nouvel id
     */
    public void setIdSite(Integer pIdSite){
        idSite = pIdSite;
    }

    /**
     * recuperer l'id du site
     * @return l'id du site
     */
    public Integer getIdSite() {
        return idSite;
    }

    /**
     * modifier l'id du topo
     * @param pIdTopo nouvel id
     */
    public void setIdTopo(Integer pIdTopo) {
        idTopo = pIdTopo;
    }

    /**
     * recuperer l'id du topo
     * @return l'id du topo
     */
    public Integer getIdTopo() {
        return idTopo;
    }

    /**
     * modifier l'id du secteur
     * @param pIdSecteur nouvel id
     */
    public void setIdSecteur(Integer pIdSecteur){
        idSecteur = pIdSecteur;
    }

    /**
     * recuperer l'id du secteur
     * @return l'id du secteur
     */
    public Integer getIdSecteur() {
        return idSecteur;
    }

    /**
     * recuperer le nom de la voie
     * @return le nom de la voie
     */
    public String getNomVoie() {
        return nomVoie;
    }

    /**
     * modifier le nom de la voie
     * @param pNom le nouveau nom
     */
    public void setNomVoie(String pNom) {
        nomVoie = pNom;
    }

    /**
     * recuperer la hauteur de la voie
     * @return la hauteur de la voie
     */
    public Float getHauteur() {
        return hauteur;
    }

    /**
     * modifier la hauteur de la voie
     * @param pHauteur nouvelle hauteur
     */
    public void setHauteur(Float pHauteur) {
        hauteur = pHauteur;
    }

    /**
     * recuperer la cotation de la voie
     * @return la cotation
     */
    public String getCotation() {
        return cotation;
    }

    /**
     * modifier la cotation de la voie
     * @param pCotation nouvelle cotation
     */
    public void setCotation(String pCotation) {
        cotation = pCotation;
    }

    /**
     * recuperer la description de la voie
     * @return la description
     */
    public String getDescription() {
        return description;
    }

    /**
     * modifier la description
     * @param pDescription nouvelle description
     */
    public void setDescription(String pDescription) {
        description = pDescription;
    }

    // ==================== Méthodes ====================
    /**
     * StringBuilder de l'objet voie
     * @return toutes les informations de la voie
     */
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("Voie idVoie = \"").append(idVoie).append('"')
                .append("Secteur idVoie = \"").append(idSecteur).append('"')
                .append("site idVoie = \"").append(idSite).append('"')
                .append("topo idVoie = \"").append(idTopo).append('"')
                .append(vSEP).append("nomVoie=\"").append(nomVoie).append('"')
                .append(vSEP).append("cotation=\"").append(cotation).append('"')
                .append(vSEP).append("hauteur=\"").append(hauteur).append('"')
                .append(vSEP).append("description=\"").append(description).append('"')
                .append("}");
        return vStB.toString();
    }
}
