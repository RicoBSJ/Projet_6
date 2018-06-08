package org.val.win.model.bean.grimpe;

public class Secteur {

    // ==================== Attributs ====================
    private Integer idSecteur;
    private Integer idSite;
    private Integer idTopo;
    private Integer nbrVoie;
    private String nomSecteur;
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
        idSecteur = pId;
    }


    // ==================== Getters/Setters ====================

    public Integer getIdSecteur(){
        return idSecteur;
    }

    public void setIdSecteur(Integer pId){
        idSecteur = pId;
    }

    public Integer getId_topo() {
        return idTopo;
    }

    public void setIdTopo(Integer pIdTopo){
        idTopo = pIdTopo;
    }

    public Integer getId_site() {
        return idSite;
    }

    public void setIdSite(Integer pIdSite){
        idSite = pIdSite;
    }

    public String getNomSecteur() {
        return nomSecteur;
    }

    public void setNomSecteur(String pNom) {
        nomSecteur = pNom;
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
                .append("Secteur idSecteur =\"").append(idSecteur).append('"')
                .append("Site idSecteur = \"").append(idSite).append('"')
                .append("topo idSecteur = \"").append(idTopo).append('"')
                .append(vSEP).append("nom =\"").append(nomSecteur).append('"')
                .append(vSEP).append("description =\"").append(description).append('"')
                .append(vSEP).append("nombre de voie(s) =\"").append(nbrVoie).append('"')
                .append(vSEP).append("orientation =\"").append(orientation).append('"')
                .append(vSEP).append("difficulte =\"").append(difficulte).append('"')
                .append("}");
        return vStB.toString();
    }
}
