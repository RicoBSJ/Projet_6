package org.val.win.business.impl.manager;

import org.val.win.business.contract.manager.SecteurManager;
import org.val.win.consumer.contract.dao.SecteurDao;
import org.springframework.transaction.PlatformTransactionManager;
import org.val.win.model.bean.grimpe.Secteur;
import org.val.win.model.exception.FunctionalException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SecteurManagerImpl extends AbstractManager implements SecteurManager {

    @Inject
    private SecteurDao secteurDao;

    @Inject
    private TransactionHelper transactionHelper;

    @Inject
    @Named("txManagerP6")
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public List<Secteur> getListSecteur(Integer id) {
        return secteurDao.getListSecteur();
    }

    @Override
    public void insertSecteur(Secteur pSecteur) throws FunctionalException {
        //MutableObject<TransactionStatus> vStatus = transactionHelper.beginTransaction();
        //try {
        secteurDao.insertSecteur(pSecteur);
        //  transactionHelper.commit(vStatus);
        //} finally {
        //     transactionHelper.rollback(vStatus);
    }
    //}
}
