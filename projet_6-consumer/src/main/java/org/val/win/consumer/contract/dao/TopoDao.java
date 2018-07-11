package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.grimpe.Topo;

import java.util.List;

/**
 * Interface de TopoDaoImpl
 */
public interface TopoDao {

    /**
     * recuperer la liste des topos
     * @return la liste des topos
     */
    List<Topo> getListTopo();

    /**
     * creer un topo
     * @param pTopo le topo a creer
     * @return le topo crée
     */
    Topo insertTopo(final Topo pTopo);

    /**
     * emprunter un topo
     * @param pTopo le topo a emprunter
     */
    void emprunt(final Topo pTopo);

    /**
     * Rendre un topo
     * @param pTopo le topo a rendre
     */
    void retour(final Topo pTopo);

    /**
     * mise a jour des informations d'un topo
     * @param pTopo le topo a modifier
     */
    void updateInfoTopo(Topo pTopo);
}
