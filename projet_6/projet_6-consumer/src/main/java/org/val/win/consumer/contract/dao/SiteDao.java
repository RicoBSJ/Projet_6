package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.grimpe.Site;

import java.util.List;

/**
 * Interface de SiteDaoImpl
 */
public interface SiteDao {

    /**
     * Recuperer une liste de site dans la db
     * @param id id d'un topo
     * @return
     */
    List<Site> getListSite(Integer id);

    /**
     * creer un site
     * @param pSite le site a creer
     * @return le site crée
     */
    Site insertSite(Site pSite);

    /**
     * mise a jour d'un site
     * @param pSite le site a modifier
     */
    void updateInfoVoie(Site pSite);
}
