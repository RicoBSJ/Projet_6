package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.grimpe.Site;

import java.util.List;

public interface SiteDao {

    List<Site> getListSite();

    void insertSite(Site pSite);
}
