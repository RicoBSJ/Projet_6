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

@Named
public class SiteManagerImpl extends AbstractManager implements SiteManager {


    @Inject
    private SiteDao siteDao;

    @Inject
    private TransactionHelper transactionHelper;

    @Inject
    @Named("txManagerP6")

    private PlatformTransactionManager platformTransactionManager;

    @Override
    public Site getSite(Integer idSite, Integer idTopo) throws NotFoundException {
        List<Site> listSite = this.getListSite(idTopo);
        Site vSite
                = listSite.stream()
                .filter(p -> p.getIdSite().equals(idSite))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Projet non trouvé : ID=" + idSite));
        return vSite;
    }

    @Override
    public List<Site> getListSite(Integer id) {
        return siteDao.getListSite(id);
    }

    @Override
    public void insertSite(Site pSite) throws FunctionalException {
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
