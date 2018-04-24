package org.val.win.business.impl.manager;

import org.val.win.business.contract.manager.SiteManager;
import org.val.win.consumer.contract.dao.SiteDao;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SiteManagerImpl extends AbstractManager implements SiteManager {


    @Inject
    private SiteDao siteDao;

    @Inject
    private TransactionHelper transactionHelper;

    @Inject
    @Named("txManagerP6")


    private PlatformTransactionManager platformTransactionManager;
}
