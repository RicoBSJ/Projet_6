package org.exemple.demo.business.impl.manager;

import org.exemple.demo.business.contract.manager.VoieManager;
import org.exemple.demo.consumer.contract.dao.VoieDao;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class VoieManagerImpl extends AbstractManager implements VoieManager {

    @Inject
    private VoieDao voieDao;

    @Inject
    @Named("txManagerVoie")
    private PlatformTransactionManager platformTransactionManager;
}
