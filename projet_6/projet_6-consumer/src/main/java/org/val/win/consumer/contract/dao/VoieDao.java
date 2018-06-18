package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.grimpe.Secteur;
import org.val.win.model.bean.grimpe.Voie;

import java.util.List;

/**
 * Interface de VoieDaoImpl
 */
public interface VoieDao {

    /**
     * recuperer une liste de voie
     * @param id id d'un secteur
     * @return
     */
    List<Voie> getListVoie(Integer id);

    /**
     * Recuperer le nombre de voie d'un secteur
     * @param pSecteur
     * @return
     */
    int getCountVoieSec(Secteur pSecteur);

    /**
     * creer une voie
     * @param pVoie la voie a creer
     * @return la voie créee
     */
    Voie insertVoie(Voie pVoie);

    /**
     * mise a jour des informations d'une voie
     * @param pVoie la voie a modifier
     */
    void updateInfoVoie(Voie pVoie);
}
