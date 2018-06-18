package org.val.win.business.contract.manager;

import org.val.win.model.bean.grimpe.Topo;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;

import java.util.List;

/**
 * Interface de TopoManagerImpl
 */
public interface TopoManager {

    /**
     * Methode recupérant la liste de topo
     * @return liste de topo
     */
    List<Topo> getListTopo();

    /**
     * Methode retournant un topo
     * @param pId id d'un topo
     * @return un topo
     * @throws NotFoundException en cas de topo de non trouvé
     */
    Topo getTopo(Integer pId) throws NotFoundException;

    /**
     * Methode pour creer un topo
     * @param pTopo topo a creer
     * @throws FunctionalException en cas d'erreur
     */
    void insertTopo(Topo pTopo) throws FunctionalException;

    /**
     * Methode pour l'emprunt
     * @param pTopo topo a emprunter
     * @throws FunctionalException en cas d'erreur
     */
    void emprunt(Topo pTopo) throws FunctionalException;
}
