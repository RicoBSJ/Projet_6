package org.val.win.business.contract.manager;

import org.val.win.model.bean.grimpe.Site;
import org.val.win.model.bean.grimpe.Topo;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;

import java.util.List;

public interface SiteManager {

    void insertSite(Site pSite) throws FunctionalException;

    List<Site> getListSite(Integer id);

    Site getSite(Integer pId, Integer pIdTopo) throws NotFoundException;

}
