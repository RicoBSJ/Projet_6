package org.val.win.model.bean.grimpe;

import java.time.LocalDate;

public class Topo {

    // ==================== Attributs ====================
    private Integer idTopo;
    private Integer idEmprunteur;
    private Integer idUtilisateurCreateur;
    private String nomTopo;
    private String description;
    private String region;
    private String roche;
    private String lieu;
    private String profil;
    private String ancrage;
    private String relai;
    private Boolean etat;
    private LocalDate dateEmp;
    private LocalDate dateRet;


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
        idTopo = pId;
    }


    // ==================== Getters/Setters ====================

    public Integer getIdTopo(){
        return idTopo;
    }
    public void setIdTopo(Integer pId) {
        idTopo = pId;
    }
    public Integer getIdEmprunteur()
    {
        return idEmprunteur;
    }
    public void setIdEmprunteur(Integer pId_emprunteur) {
        idEmprunteur = pId_emprunteur;
    }
    public Integer getIdUtilisateurCreateur() {
        return idUtilisateurCreateur;
    }
    public void setIdUtilisateurCreateur(Integer pId_createur) {
        idUtilisateurCreateur = pId_createur;
    }
    public String getNomTopo() {
        return nomTopo;
    }
    public void setNomTopo(String pNom_topo) {
        nomTopo = pNom_topo;
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
    public LocalDate getDateEmp(){
        return dateEmp;
    }
    public void setDateEmp(LocalDate pDateEmp){
        this.dateEmp = pDateEmp;
    }
    public LocalDate getDateRet(){
        return dateRet;
    }
    public void setDateRet(LocalDate pDateRet){
        this.dateRet = pDateRet;
    }

    // ==================== Méthodes ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("id du topo =\"").append(idTopo).append('"')
                .append("Id createur Topo =\"").append(idUtilisateurCreateur).append('"')
                .append("Id emprunteur topo =\"").append(idEmprunteur).append('"')
                .append(vSEP).append("Nom du topo").append(nomTopo).append('"')
                .append(vSEP).append("region =\"").append(region).append('"')
                .append(vSEP).append("lieu =\"").append(lieu).append('"')
                .append(vSEP).append("description =\"").append(description).append('"')
                .append(vSEP).append("type de roche =\"").append(roche).append('"')
                .append(vSEP).append("profil =\"").append(profil).append('"')
                .append(vSEP).append("ancrage =\"").append(ancrage).append('"')
                .append(vSEP).append("relai = \"").append(relai).append('"')
                .append(vSEP).append("etat = \"").append(etat).append('"')
                .append(vSEP).append("Date d'emprunt = \"").append(dateEmp).append('"')
                .append(vSEP).append("Date de retour = \"").append(dateRet).append('"')
                .append("}");
        return vStB.toString();
    }
}
