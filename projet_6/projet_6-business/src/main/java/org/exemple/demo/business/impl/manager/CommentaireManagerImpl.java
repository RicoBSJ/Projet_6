package org.exemple.demo.business.impl.manager;

import org.exemple.demo.business.contract.manager.CommentaireManager;
import org.exemple.demo.consumer.contract.dao.CommentaireDao;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CommentaireManagerImpl extends AbstractManager implements CommentaireManager {

    @Inject
    private CommentaireDao commentaireDao;

    @Inject
    @Named("txManagerP6")
    private PlatformTransactionManager platformTransactionManager;
}
