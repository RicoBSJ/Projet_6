package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.grimpe.Secteur;

import java.util.List;

/**
 * Interface de SecteurDaoImpl
 */
public interface SecteurDao {

    /**
     * Recuperer une liste de commentaire dans la db
     * @param id id d'un site
     * @return
     */
    List<Secteur> getListSecteur(Integer id);

    /**
     * Creer un secteur
     * @param pSecteur le secteur a creer
     * @return le secteur creer
     */
    Secteur insertSecteur(Secteur pSecteur);

    /**
     * mise a jour du secteur
     * @param pSecteur secteur a modifier
     */
    void updateInfoSecteur(Secteur pSecteur);
}
