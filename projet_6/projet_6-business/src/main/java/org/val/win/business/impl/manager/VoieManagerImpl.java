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

/**
 * Classe de gestion des transactions pour les voies
 */
@Named
public class VoieManagerImpl extends AbstractManager implements VoieManager {

    /**
     * creation du dao des voies
     */
    @Inject
    private VoieDao voieDao;

    /**
     * creation d'un platformTransactionManager pour gerer les transactions
     */
    @Inject
    @Named("txManagerP6")
    private PlatformTransactionManager platformTransactionManager;

    /**
     * recuperer une liste de voie en fonction de l'id du secteur
     * @param id id du secteur
     * @return une liste de voie
     */
    @Override
    public List<Voie> getListVoie(Integer id) {
        return voieDao.getListVoie(id);
    }

    /**
     * creer une voie
     * @param pVoie voie a creer
     * @throws FunctionalException en cas d'erreur
     */
    @Override
    public void insertVoie(Voie pVoie) {
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
