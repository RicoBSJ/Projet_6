package org.val.win.business.impl.manager;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.val.win.business.contract.manager.SecteurManager;
import org.val.win.consumer.contract.dao.SecteurDao;
import org.springframework.transaction.PlatformTransactionManager;
import org.val.win.model.bean.grimpe.Secteur;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SecteurManagerImpl extends AbstractManager implements SecteurManager {

    @Inject
    private SecteurDao secteurDao;

    @Inject
    @Named("txManagerP6")
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public Secteur getSecteur(Integer idSecteur, Integer idSite) throws NotFoundException {
        List<Secteur> listSecteur = this.getListSecteur(idSite);
        Secteur vSecteur
                = listSecteur.stream()
                .filter(p -> p.getIdSecteur().equals(idSecteur))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Secteur non trouvé : ID=" + idSecteur));
        return vSecteur;
    }

    @Override
    public List<Secteur> getListSecteur(Integer pId) {
        return secteurDao.getListSecteur(pId);
    }

    @Override
    public void insertSecteur(Secteur pSecteur) throws FunctionalException {
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                secteurDao.insertSecteur(pSecteur);
            }
        });
    }
}
