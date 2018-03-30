package org.exemple.demo.business.impl.manager;

import org.exemple.demo.business.contract.manager.TopoManager;
import org.exemple.demo.consumer.contract.dao.TopoDao;
import org.exemple.demo.model.bean.grimpe.Topo;
import org.exemple.demo.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

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
}
