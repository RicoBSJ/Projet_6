package org.exemple.demo.business.contract.manager;

import org.exemple.demo.model.bean.grimpe.Topo;
import org.exemple.demo.model.exception.FunctionalException;
import org.exemple.demo.model.exception.NotFoundException;

import java.util.List;


public interface TopoManager {

    List<Topo> getListTopo();

    Topo getTopo(Integer pId) throws NotFoundException;

    void insertTopo(Topo pTopo) throws FunctionalException;
}
