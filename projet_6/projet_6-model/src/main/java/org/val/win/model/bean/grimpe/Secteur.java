package org.val.win.model.bean.grimpe;

/**
 * Objet Secteur
 */
public class Secteur {

    // ==================== Attributs ====================
    /**
     * l'id du secteur
     */
    private Integer idSecteur;
    /**
     * id du site auquel appartien le secteur
     */
    private Integer idSite;
    /**
     * id du topo auquel appartien le secteur
     */
    private Integer idTopo;
    /**
     * le nom du secteur
     */
    private String nomSecteur;
    /**
     * la difficulté du secteur
     */
    private String difficulte;
    /**
     * l'orientation du secteur
     */
    private String orientation;
    /**
     * la description du secteur
     */
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
        idSecteur = pId;
    }


    // ==================== Getters/Setters ====================

    /**
     * recuperer l'id du secteur
     * @return l'id du secteur
     */
    public Integer getIdSecteur(){
        return idSecteur;
    }

    /**
     * modifier l'id du secteur
     * @param pId le nouvel id
     */
    public void setIdSecteur(Integer pId){
        idSecteur = pId;
    }

    /**
     * recuperer l'id du topo
     * @return l'id du topo
     */
    public Integer getId_topo() {
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
     * recuperer l'id du site
     * @return l'id du site
     */
    public Integer getId_site() {
        return idSite;
    }

    /**
     * modifier l'id du site
     * @param pIdSite le nouvel id
     */
    public void setIdSite(Integer pIdSite){
        idSite = pIdSite;
    }

    /**
     * recuperer le nom du secteur
     * @return le nom du secteur
     */
    public String getNomSecteur() {
        return nomSecteur;
    }

    /**
     * modifier le nom du secteur
     * @param pNom le nouveau nom
     */
    public void setNomSecteur(String pNom) {
        nomSecteur = pNom;
    }

    /**
     * recuperer la difficulté du secteur
     * @return la difficulté
     */
    public String getDifficulte(){
        return difficulte;
    }

    /**
     * modifie la difficulté
     * @param pDifficulte la nouvelle difficulté
     */
    public void setDifficulte(String pDifficulte){
        difficulte = pDifficulte;
    }

    /**
     * recuperer l'orientation
     * @return l'orientation
     */
    public String getOrientation() {
        return orientation;
    }

    /**
     * modifier l'orientation
     * @param pOrientation la nouvelle orientation
     */
    public void setOrientation(String pOrientation){
        orientation = pOrientation;
    }

    /**
     * recuperer la description
     * @return la description
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
     * StringBuilder de l'objet secteur
     * @return toutes les informations du secteur
     */
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("Secteur idSecteur =\"").append(idSecteur).append('"')
                .append("Site idSecteur = \"").append(idSite).append('"')
                .append("topo idSecteur = \"").append(idTopo).append('"')
                .append(vSEP).append("nom =\"").append(nomSecteur).append('"')
                .append(vSEP).append("description =\"").append(description).append('"')
                .append(vSEP).append("orientation =\"").append(orientation).append('"')
                .append(vSEP).append("difficulte =\"").append(difficulte).append('"')
                .append("}");
        return vStB.toString();
    }
}
