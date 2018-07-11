package org.val.win.business.impl.manager;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.val.win.business.contract.manager.SiteManager;
import org.val.win.consumer.contract.dao.SiteDao;
import org.springframework.transaction.PlatformTransactionManager;
import org.val.win.model.bean.grimpe.Site;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Classe de gestion des transactions pour les Sites
 */
@Named
public class SiteManagerImpl extends AbstractManager implements SiteManager {

    /**
     * creation du dao des sites
     */
    @Inject
    private SiteDao siteDao;

    /**
     * creation d'un platformTransactionManager pour gerer les transactions
     */
    @Inject
    @Named("txManagerP6")
    private PlatformTransactionManager platformTransactionManager;

    /**
     * Recuperer un site
     * @param idSite id du site
     * @param idTopo id du topo auquel appartien le site
     * @return un site
     * @throws NotFoundException en cas de site non trouvé
     */
    @Override
    public Site getSite(Integer idSite, Integer idTopo) throws NotFoundException {
        List<Site> listSite = this.getListSite(idTopo);
        Site vSite
                = listSite.stream()
                .filter(p -> p.getIdSite().equals(idSite))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Site non trouvé : ID=" + idSite));
        return vSite;
    }

    /**
     * Recuperer une liste de site
     * @param id id d'un topo
     * @return liste de site
     */
    @Override
    public List<Site> getListSite(Integer id) {
        return siteDao.getListSite(id);
    }

    /**
     * Creation d'un site
     * @param pSite site a creer
     * @throws FunctionalException en cas d'erreur
     */
    @Override
    public void insertSite(Site pSite) {
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                siteDao.insertSite(pSite);
            }
        });
    }
}
