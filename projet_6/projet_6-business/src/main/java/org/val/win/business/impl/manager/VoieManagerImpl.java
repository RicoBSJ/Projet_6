package org.val.win.business.impl.manager;

import org.val.win.business.contract.manager.VoieManager;
import org.val.win.consumer.contract.dao.VoieDao;
import org.springframework.transaction.PlatformTransactionManager;
import org.val.win.model.bean.grimpe.Voie;
import org.val.win.model.exception.FunctionalException;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class VoieManagerImpl extends AbstractManager implements VoieManager {

    @Inject
    private VoieDao voieDao;

    @Inject
    private TransactionHelper transactionHelper;

    @Inject
    @Named("txManagerP6")

    private PlatformTransactionManager platformTransactionManager;

    @Override
    public void insertVoie(Voie pVoie) throws FunctionalException {
        //MutableObject<TransactionStatus> vStatus = transactionHelper.beginTransaction();
        //try {
        voieDao.insertVoie(pVoie);
        //  transactionHelper.commit(vStatus);
        //} finally {
        //     transactionHelper.rollback(vStatus);
    }
    //}
}
