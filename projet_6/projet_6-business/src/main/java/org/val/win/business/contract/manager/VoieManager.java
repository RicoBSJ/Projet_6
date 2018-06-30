package org.val.win.business.contract.manager;

import org.val.win.model.bean.grimpe.Voie;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;

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

    /**
     * recuperer une voie
     * @param idVoie l'id de la voie
     * @param idSecteur l'id du secteur
     * @return une voie
     * @throws NotFoundException en cas de voie non trouvée
     */
    Voie getVoie(Integer idVoie, Integer idSecteur) throws NotFoundException;
}
