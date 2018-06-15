package org.val.win.business.impl.manager;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.val.win.business.contract.manager.VoieManager;
import org.val.win.consumer.contract.dao.VoieDao;
import org.springframework.transaction.PlatformTransactionManager;
import org.val.win.model.bean.grimpe.Voie;
import org.val.win.model.exception.FunctionalException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class VoieManagerImpl extends AbstractManager implements VoieManager {

    @Inject
    private VoieDao voieDao;

    @Inject
    @Named("txManagerP6")

    private PlatformTransactionManager platformTransactionManager;

    @Override
    public List<Voie> getListVoie(Integer id) {
        return voieDao.getListVoie(id);
    }

    @Override
    public void insertVoie(Voie pVoie) throws FunctionalException {
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                voieDao.insertVoie(pVoie);
            }
        });
    }
}
