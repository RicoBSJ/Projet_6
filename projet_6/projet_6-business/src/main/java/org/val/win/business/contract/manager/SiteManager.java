package org.val.win.business.contract.manager;

import org.val.win.model.bean.grimpe.Site;
import org.val.win.model.exception.FunctionalException;

public interface SiteManager {

    void insertSite(Site pSite) throws FunctionalException;

}
