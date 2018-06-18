package org.val.win.business.contract.manager;

import org.val.win.model.bean.grimpe.Voie;
import org.val.win.model.exception.FunctionalException;

import java.util.List;

/**
 * Interface de VoieManagerImpl
 */
public interface VoieManager {

    /**
     * creer une voie
     * @param pVoie voie a creer
     * @throws FunctionalException en cas d'erreur
     */
    void insertVoie(Voie pVoie) throws FunctionalException;

    /**
     * recuperer une liste de voie en fonction de l'id du secteur
     * @param id id du secteur
     * @return une liste de voie
     */
    List<Voie> getListVoie(Integer id);
}
