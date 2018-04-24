package org.val.win.business.impl.manager;

import org.val.win.business.contract.manager.SecteurManager;
import org.val.win.consumer.contract.dao.SecteurDao;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SecteurManagerImpl extends AbstractManager implements SecteurManager {

    @Inject
    private SecteurDao secteurDao;

    @Inject
    private TransactionHelper transactionHelper;

    @Inject
    @Named("txManagerP6")
    private PlatformTransactionManager platformTransactionManager;
}
