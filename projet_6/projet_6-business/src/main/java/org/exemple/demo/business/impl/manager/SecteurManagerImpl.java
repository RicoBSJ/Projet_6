package org.exemple.demo.business.impl.manager;

import org.exemple.demo.business.contract.manager.SecteurManager;
import org.exemple.demo.consumer.contract.dao.SecteurDao;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SecteurManagerImpl extends AbstractManager implements SecteurManager {

    @Inject
    private SecteurDao secteurDao;

    @Inject
    @Named("txManagerSecteur")
    private PlatformTransactionManager platformTransactionManager;
}
