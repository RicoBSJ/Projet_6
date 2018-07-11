package org.val.win.business.contract.manager;

import org.val.win.model.bean.grimpe.Site;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;

import java.util.List;

/**
 * Interface de SiteManagerImpl
 */
public interface SiteManager {

    /**
     * Creation d'un site
     * @param pSite site a creer
     * @throws FunctionalException en cas d'erreur
     */
    void insertSite(Site pSite) throws FunctionalException;

    /**
     * Recuperer une liste de site
     * @param id id d'un topo
     * @return liste de site
     */
    List<Site> getListSite(Integer id);

    /**
     * Recuperer un site
     * @param idSite id du site
     * @param idTopo id du topo auquel appartien le site
     * @return un site
     * @throws NotFoundException en cas de site non trouvé
     */
    Site getSite(Integer idSite, Integer idTopo) throws NotFoundException;

}
