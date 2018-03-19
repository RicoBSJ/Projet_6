package org.exemple.demo.model.bean.grimpe;

public class Topo {

    // ==================== Attributs ====================
    private Integer id;
    private Integer id_possesseur;
    private Integer id_commentaire;
    private Integer id_utilisateur_com;
    private String description;
    private String region;
    private String roche;
    private String lieu;
    private String profil;
    private String ancrage;
    private String relai;
    private Boolean etat;


    // ==================== Constructeurs ====================
    /**
     * Constructeur.
     */
    public Topo() {
    }


    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Topo(Integer pId) {
        id = pId;
    }


    // ==================== Getters/Setters ====================

    public Integer getId(){
        return id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String pDescription) {
        description = pDescription;
    }
    public String getRegion(){
        return region;
    }
    public void setRegion(String pRegion){
        region = pRegion;
    }
    public String getRoche(){
        return roche;
    }
    public void setRoche(String pRoche){
        roche = pRoche;
    }
    public String getLieu(){
        return lieu;
    }
    public void setLieu(String pLieu){
        lieu = pLieu;
    }
    public String getProfil(){
        return profil;
    }
    public void setProfil(String pProfil){
        profil = pProfil;
    }
    public String getAncrage(){
        return ancrage;
    }
    public void setAncrage(String pAncrage){
        ancrage = pAncrage;
    }
    public String getRelai(){
        return relai;
    }
    public void setRelai(String pRelai){
        relai = pRelai;
    }
    public Boolean getEtat(){
        return etat;
    }
    public void setEtat(Boolean pEtat){
        etat = pEtat;
    }

    // ==================== Méthodes ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("Admin id=").append(id)
                .append(vSEP).append("region =\"").append(region).append('"')
                .append(vSEP).append("lieu =\"").append(lieu).append('"')
                .append(vSEP).append("description =\"").append(description).append('"')
                .append(vSEP).append("type de roche =\"").append(roche).append('"')
                .append(vSEP).append("profil =\"").append(profil).append('"')
                .append(vSEP).append("ancrage =\"").append(ancrage).append('"')
                .append(vSEP).append("relai = \"").append(relai).append('"')
                .append(vSEP).append("etat = \"").append(etat).append('"')
                .append("}");
        return vStB.toString();
    }
}
