package org.val.win.model.bean.utilisateur;

public class Commentaire {


    // ==================== Attributs ====================

    private Integer id_com;
    private Integer id_util;
    private Integer id_topo;
    private String text_com;


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
        id_com = pId;
    }


    // ==================== Getters/Setters ====================

    public Integer getIdCom() {
        return id_com;
    }

    public Integer getIdTopo() {
        return id_topo;
    }

    public void setIdTopo(Integer pIdTopo){
        id_topo = pIdTopo;
    }

    public Integer getIdUtil() {
        return id_util;
    }

    public void setIdUtil(Integer pIdUtil) {
        id_util = pIdUtil;
    }

    public String getText() {
        return text_com;
    }

    public void setText(String pText) {
        text_com = pText;
    }


    // ==================== Méthodes ====================

    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("id commentaire =\"").append(id_com)
                .append(vSEP).append("id utilisateur =\"").append(id_util).append('"')
                .append(vSEP).append("id du topo =\"").append(id_topo).append('"')
                .append(vSEP).append("commentaire = \"").append(text_com).append('"')
                .append("}");
        return vStB.toString();
    }
}
