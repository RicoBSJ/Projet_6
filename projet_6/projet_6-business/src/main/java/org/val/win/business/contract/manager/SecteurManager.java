package org.val.win.business.contract.manager;

import org.val.win.model.bean.grimpe.Secteur;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;

import java.util.List;

/**
 * Interface de SecteurManagerImpl
 */
public interface SecteurManager {

    /**
     * Creer un secteur
     * @param pSecteur Secteur a creer
     * @throws FunctionalException en cas d'erreur
     */
    void insertSecteur(Secteur pSecteur) throws FunctionalException;

    /**
     * liste de secteur
     * @param pId id d'un site
     * @return liste de secteur d'un site
     */
    List<Secteur> getListSecteur(Integer pId);

    /**
     * recuperer un secteur
     * @param idSecteur id du secteur a recuperer
     * @param idSite id du site auquel appartien le secteur
     * @return le secteur concerné
     * @throws NotFoundException en cas de secteur non trouvé
     */
    Secteur getSecteur(Integer idSecteur, Integer idSite) throws NotFoundException;

}
