package org.exemple.demo.business.impl.manager;

import org.exemple.demo.business.contract.manager.TopoManager;
import org.exemple.demo.consumer.contract.dao.TopoDao;
import org.exemple.demo.model.bean.grimpe.Topo;
import org.exemple.demo.model.exception.FunctionalException;
import org.exemple.demo.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Named
public class TopoManagerImpl extends AbstractManager implements TopoManager {

    @Inject
    private TopoDao topoDao;

    private final List<Topo> listTopo = new ArrayList<>();

    @Override
    public Topo getTopo(Integer pId) throws NotFoundException {
        Topo vTopo
                = this.listTopo.stream()
                .filter(p -> p.getId().equals(pId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Topo non trouvé : ID=" + pId));
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
}
