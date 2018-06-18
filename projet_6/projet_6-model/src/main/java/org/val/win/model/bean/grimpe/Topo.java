package org.val.win.model.bean.grimpe;

import java.time.LocalDate;

/**
 * Objet Topo
 */
public class Topo {

    // ==================== Attributs ====================
    /**
     * id du topo
     */
    private Integer idTopo;
    /**
     * id de l'emprunteur du topo
     */
    private Integer idEmprunteur;
    /**
     * id du createur du topo
     */
    private Integer idUtilisateurCreateur;
    /**
     * nom du topo
     */
    private String nomTopo;
    /**
     * description du topo
     */
    private String description;
    /**
     * region du topo
     */
    private String region;
    /**
     * type de roche du topo
     */
    private String roche;
    /**
     * lieu du topo
     */
    private String lieu;
    /**
     * profil du topo
     */
    private String profil;
    /**
     * ancrage du topo
     */
    private String ancrage;
    /**
     * relai du topo
     */
    private String relai;
    /**
     * etat disponibilité du topo
     */
    private Boolean etat;
    /**
     * date d'emprunt du topo
     */
    private LocalDate dateEmp;
    /**
     * date de retour du topo
     */
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

    /**
     * recuperer l'id du topo
     * @return l'id tu topo
     */
    public Integer getIdTopo(){
        return idTopo;
    }

    /**
     * modifier l'id du topo
     * @param pId nouvel id
     */
    public void setIdTopo(Integer pId) {
        idTopo = pId;
    }

    /**
     * recuperer l'id de l'emprunteur
     * @return id de l'emprunteur
     */
    public Integer getIdEmprunteur() {
        return idEmprunteur;
    }

    /**
     * modifier l'id de l'emprunteur
     * @param pId_emprunteur nouvel id
     */
    public void setIdEmprunteur(Integer pId_emprunteur) {
        idEmprunteur = pId_emprunteur;
    }

    /**
     * recuperer l'id du createur
     * @return l'id du createur
     */
    public Integer getIdUtilisateurCreateur() {
        return idUtilisateurCreateur;
    }

    /**
     * modifier l'id de l'utilisateur
     * @param pId_createur nouvel id
     */
    public void setIdUtilisateurCreateur(Integer pId_createur) {
        idUtilisateurCreateur = pId_createur;
    }

    /**
     * recuperer le nom du topo
     * @return le nom du topo
     */
    public String getNomTopo() {
        return nomTopo;
    }

    /**
     * modifier le nom du topo
     * @param pNom_topo nouveau nom
     */
    public void setNomTopo(String pNom_topo) {
        nomTopo = pNom_topo;
    }

    /**
     * recuperer la description du topo
     * @return la description
     */
    public String getDescription() {
        return description;
    }

    /**
     * modifier la description du topo
     * @param pDescription nouvelle description
     */
    public void setDescription(String pDescription) {
        description = pDescription;
    }

    /**
     * recuperer la region du topo
     * @return la region
     */
    public String getRegion(){
        return region;
    }

    /**
     * modifier la region
     * @param pRegion nouvelle region
     */
    public void setRegion(String pRegion){
        region = pRegion;
    }

    /**
     * recuperer le type de roche
     * @return le type de roche du topo
     */
    public String getRoche(){
        return roche;
    }

    /**
     * modifier le type de roche d'un topo
     * @param pRoche le nouveau type
     */
    public void setRoche(String pRoche){
        roche = pRoche;
    }

    /**
     * recuperer le lieu de topo
     * @return le lieu du topo
     */
    public String getLieu(){
        return lieu;
    }

    /**
     * modifier le lieu de topo
     * @param pLieu le nouveau lieu
     */
    public void setLieu(String pLieu){
        lieu = pLieu;
    }

    /**
     * recuperer le profil du topo
     * @return le profil
     */
    public String getProfil(){
        return profil;
    }

    /**
     * modifier le profil du topo
     * @param pProfil le nouveau profil
     */
    public void setProfil(String pProfil){
        profil = pProfil;
    }

    /**
     * recuperer le type d'ancrage du topo
     * @return le type d'ancrage
     */
    public String getAncrage(){
        return ancrage;
    }

    /**
     * modifier l'ancrage d'un topo
     * @param pAncrage le nouveau type d'ancrage
     */
    public void setAncrage(String pAncrage){
        ancrage = pAncrage;
    }

    /**
     * recuperer le type de relais d'un topo
     * @return relai
     */
    public String getRelai(){
        return relai;
    }

    /**
     * modifier le type de relai du topo
     * @param pRelai nouveau type de relai
     */
    public void setRelai(String pRelai){
        relai = pRelai;
    }

    /**
     * recuperer la date d'emprunt du topo
     * @return la date d'emprunt
     */
    public LocalDate getDateEmp(){
        return dateEmp;
    }

    /**
     * modifier la date d'emprunt
     * @param pDateEmp nouvelle date d'emprunt
     */
    public void setDateEmp(LocalDate pDateEmp){
        this.dateEmp = pDateEmp;
    }

    /**
     * recuperer la date de retour du topo
     * @return la date de retour
     */
    public LocalDate getDateRet(){
        return dateRet;
    }

    /**
     * modifier la date de retour d'un topo
     * @param pDateRet nouvelle date de retour
     */
    public void setDateRet(LocalDate pDateRet){
        this.dateRet = pDateRet;
    }

    /**
     * recuperer la disponibilité d'un topo
     * @return l'etat du topo
     */
    public Boolean getEtat(){
        return etat;
    }

    /**
     * modifier la disponibilité d'un topo
     * @param pEtat nouvelle disponibilité
     */
    public void setEtat(Boolean pEtat) {
        etat = pEtat;
    }

    // ==================== Méthodes ====================
    /**
     * StringBuilder de l'objet topo
     * @return toutes les informations du topo
     */
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
                .append(vSEP).append("etat =\"").append(etat).append('"')
                .append(vSEP).append("Date d'emprunt = \"").append(dateEmp).append('"')
                .append(vSEP).append("Date de retour = \"").append(dateRet).append('"')
                .append("}");
        return vStB.toString();
    }
}
