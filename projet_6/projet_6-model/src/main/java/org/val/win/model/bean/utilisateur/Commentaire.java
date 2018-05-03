package org.val.win.model.bean.utilisateur;

public class Commentaire {


    // ==================== Attributs ====================

    private Integer idCom;
    private Integer idUtil;
    private Integer idTopo;
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
    public Commentaire(Integer pId) {
        idCom = pId;
    }


    // ==================== Getters/Setters ====================

    public Integer getIdCom() {
        return idCom;
    }

    public void setIdCom(Integer pId) {
        idCom = pId;
    }

    public Integer getIdTopo() {
        return idTopo;
    }

    public void setIdTopo(Integer pIdTopo){
        idTopo = pIdTopo;
    }

    public Integer getIdUtil() {
        return idUtil;
    }

    public void setIdUtil(Integer pIdUtil) {
        idUtil = pIdUtil;
    }

    public String getText() {
        return com;
    }

    public void setText(String pText) {
        com = pText;
    }


    // ==================== Méthodes ====================

    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("id commentaire =\"").append(idCom)
                .append(vSEP).append("id utilisateur =\"").append(idUtil).append('"')
                .append(vSEP).append("id du topo =\"").append(idTopo).append('"')
                .append(vSEP).append("commentaire = \"").append(com).append('"')
                .append("}");
        return vStB.toString();
    }
}
