package org.exemple.demo.business.impl.manager;

import org.exemple.demo.business.contract.manager.SiteManager;
import org.exemple.demo.consumer.contract.dao.SiteDao;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SiteManagerImpl extends AbstractManager implements SiteManager {


    @Inject
    private SiteDao siteDao;

    @Inject
    @Named("txManagerSite")
    private PlatformTransactionManager platformTransactionManager;
}
