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

/**
 * Classe de gestion des transactions pour les secteurs
 */
@Named
public class SecteurManagerImpl extends AbstractManager implements SecteurManager {

    /**
     * creation du dao des secteurs
     */
    @Inject
    private SecteurDao secteurDao;

    /**
     * creation d'un platformTransactionManager pour gerer les transactions
     */
    @Inject
    @Named("txManagerP6")
    private PlatformTransactionManager platformTransactionManager;

    /**
     * recuperer un secteur
     * @param idSecteur id du secteur a recuperer
     * @param idSite id du site auquel appartien le secteur
     * @return le secteur concerné
     * @throws NotFoundException en cas de secteur non trouvé
     */
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

    /**
     * liste de secteur
     * @param pId id d'un site
     * @return liste de secteur d'un site
     */
    @Override
    public List<Secteur> getListSecteur(Integer pId) {
        return secteurDao.getListSecteur(pId);
    }

    /**
     * Creer un secteur
     * @param pSecteur Secteur a creer
     * @throws FunctionalException en cas d'erreur
     */
    @Override
    public void insertSecteur(Secteur pSecteur) {
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
