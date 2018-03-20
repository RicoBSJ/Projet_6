package org.exemple.demo.model.bean.utilisateur;

public class Grimpeur {

    // ==================== Attributs ====================
    private Integer id;

    // ==================== Constructeurs ====================
    /**
     * Constructeur.
     */
    public Grimpeur() {
    }


    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Grimpeur(Integer pId) {
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
                .append("Grimpeur id=").append(id)
                .append("}");
        return vStB.toString();
    }
}

