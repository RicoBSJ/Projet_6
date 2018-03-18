package org.exemple.demo.model.bean.utilisateur;

public class Admin {

    // ==================== Attributs ====================
    private Integer id;

    // ==================== Constructeurs ====================
    /**
     * Constructeur.
     */
    public Admin() {
    }


    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Admin(Integer pId) {
        id = pId;
    }


    // ==================== Getters/Setters ====================

    public Integer getId() {
        return id;
    }

    // ==================== Méthodes ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("Admin id=").append(id)
                .append("}");
        return vStB.toString();
    }
}

