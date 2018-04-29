package org.val.win.business.impl.manager;

import org.apache.commons.lang3.mutable.MutableObject;
import org.val.win.business.contract.manager.TopoManager;
import org.val.win.consumer.contract.dao.TopoDao;
import org.val.win.model.bean.grimpe.Topo;
import org.val.win.model.bean.utilisateur.Utilisateur;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

@Named
public class TopoManagerImpl extends AbstractManager implements TopoManager {

    @Inject
    private TopoDao topoDao;

    @Inject
    private TransactionHelper transactionHelper;

    @Inject
    @Named("txManagerP6")
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public Topo getTopo(Integer pId) throws NotFoundException {
        List<Topo> listTopo = this.getListTopo();
        Topo vTopo
                = listTopo.stream()
                .filter(p -> p.getId().equals(pId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Utilisateur non trouvé : ID=" + pId));
        return vTopo;
    }

    @Override
    public List<Topo> getListTopo() {
        return topoDao.getListTopo();
    }


    @Override
    public void insertTopo(Topo pTopo) throws FunctionalException {
        //MutableObject<TransactionStatus> vStatus = transactionHelper.beginTransaction();
        //try {
            topoDao.insertTopo(pTopo);
          //  transactionHelper.commit(vStatus);
        //} finally {
       //     transactionHelper.rollback(vStatus);
        }
    //}

    @Override
    public void ChangeEtat(Topo pTopo, Utilisateur pUtilisateur) {
        MutableObject<TransactionStatus> vStatus = transactionHelper.beginTransaction();
        Boolean bool = pTopo.getEtat();
        try {
            pTopo.setEtat(!bool);
            topoDao.updateEtat(pTopo);
            transactionHelper.commit(vStatus);
        } finally {
            transactionHelper.rollback(vStatus);
        }
    }

}
