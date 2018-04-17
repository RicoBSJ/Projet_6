package org.exemple.demo.business.impl.manager;

import org.apache.commons.lang3.mutable.MutableObject;
import org.exemple.demo.business.contract.manager.TopoManager;
import org.exemple.demo.consumer.contract.dao.TopoDao;
import org.exemple.demo.model.bean.grimpe.Topo;
import org.exemple.demo.model.bean.utilisateur.Utilisateur;
import org.exemple.demo.model.exception.FunctionalException;
import org.exemple.demo.model.exception.NotFoundException;
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

    @Inject TransactionHelper transactionHelper;

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
        if (pTopo == null) {
            throw new FunctionalException("L'objet Topo ne doit pas être null !");
        }

        Set<ConstraintViolation<Topo>> vViolations = getConstraintValidator().validate(pTopo);
        if (!vViolations.isEmpty()) {
            throw new FunctionalException("L'objet Topo est invalide",
                    new ConstraintViolationException(vViolations));

        }

        topoDao.insertTopo(pTopo);

    }

    @Override
    public void ChangeEtat(Topo pTopo, Utilisateur pUtilisateur) throws FunctionalException {
        MutableObject<TransactionStatus> vStatus = transactionHelper.beginTransaction();
        try {
            pTopo.setEtat(pTopo);

            topoDao.updateEtat(pTopo);
            throw new FunctionalException("...");

            transactionHelper.commit(vStatus);
        } finally {
            transactionHelper.rollback(vStatus);
        }
    }
    }
}
