package org.val.win.business.impl.manager;

import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.val.win.business.contract.manager.TopoManager;
import org.val.win.consumer.contract.dao.TopoDao;
import org.val.win.model.bean.grimpe.Topo;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class TopoManagerImpl extends AbstractManager implements TopoManager {

    @Inject
    private TopoDao topoDao;

    @Inject
    @Named("txManagerP6")
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public Topo getTopo(Integer pId) throws NotFoundException {
        List<Topo> listTopo = this.getListTopo();
        Topo vTopo
                = listTopo.stream()
                .filter(p -> p.getIdTopo().equals(pId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Utilisateur non trouvé : ID=" + pId));
        if (vTopo.getIdEmprunteur() == 0) {
            vTopo.setIdEmprunteur(null);
        }
        return vTopo;
    }

    @Override
    public List<Topo> getListTopo() {
        return topoDao.getListTopo();
    }

    @Override
    public void insertTopo(Topo pTopo) throws FunctionalException {
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                topoDao.insertTopo(pTopo);
            }
        });
    }

    @Override
    public void Emprunt(Topo pTopo) throws FunctionalException {
        topoDao.emprunt(pTopo);
    }
}
