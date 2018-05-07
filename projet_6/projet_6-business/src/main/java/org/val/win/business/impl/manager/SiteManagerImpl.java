package org.val.win.business.impl.manager;

import org.val.win.business.contract.manager.SiteManager;
import org.val.win.consumer.contract.dao.SiteDao;
import org.springframework.transaction.PlatformTransactionManager;
import org.val.win.model.bean.grimpe.Site;
import org.val.win.model.bean.grimpe.Topo;
import org.val.win.model.bean.grimpe.Voie;
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
    public List<Site> getListSite(Topo pTopo) {
        return siteDao.getListSite(pTopo);
    }

    @Override
    public void insertSite(Site pSite) throws FunctionalException {
        //MutableObject<TransactionStatus> vStatus = transactionHelper.beginTransaction();
        //try {
        siteDao.insertSite(pSite);
        //  transactionHelper.commit(vStatus);
        //} finally {
        //     transactionHelper.rollback(vStatus);
    }
    //}
}
