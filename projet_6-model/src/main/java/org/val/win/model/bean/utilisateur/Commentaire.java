package org.val.win.model.bean.utilisateur;

/**
 * objet commentaire.
 */
public class Commentaire {


    // ==================== Attributs ====================

    /**
     * id du commentaire
     */
    private Integer idCommentaire;
    /**
     * id de l'utilisateur
     */
    private Integer idUtil;
    /**
     * id du topo
     */
    private Integer idTopo;
    /**
     * le commentaire
     */
    private String com;


    // ==================== Constructeurs ====================

    /**
     * Constructeur.
     */
    public Commentaire() {
    }


    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Commentaire(final Integer pId) {
        idCommentaire = pId;
    }


    // ==================== Getters/Setters ====================

    /**
     * recuperer l'id du commentaire
     * @return l'id du commentaire
     */
    public Integer getId() {
        return idCommentaire;
    }

    /**
     * modifier l'id du commenataire
     * @param pId nouvel id
     */
    public void setId(final Integer pId) {
        idCommentaire = pId;
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
     * @param pIdTopo nouvel id
     */
    public void setIdTopo(final Integer pIdTopo){
        idTopo = pIdTopo;
    }

    /**
     * recuperer l'id de l'utilisateur
     * @return l'id de l'utilisateur
     */
    public Integer getIdUtil() {
        return idUtil;
    }

    /**
     * modifier l'id de l'utilisateur
     * @param pIdUtil le nouvel id
     */
    public void setIdUtil(final Integer pIdUtil) {
        idUtil = pIdUtil;
    }

    /**
     * recuperer le commentaire
     * @return le commentaire
     */
    public String getText() {
        return com;
    }

    /**
     * modifier le commentaire
     * @param pText le nouveau commentaire
     */
    public void setText(final String pText) {
        com = pText;
    }


    // ==================== Méthodes ====================

    /**
     * StringBuilder de l'objet commentaire
     * @return toutes les informations du commentaire
     */
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("id commentaire =\"").append(idCommentaire)
                .append(vSEP).append("id utilisateur =\"").append(idUtil).append('"')
                .append(vSEP).append("id du topo =\"").append(idTopo).append('"')
                .append(vSEP).append("commentaire = \"").append(com).append('"')
                .append("}");
        return vStB.toString();
    }
}
