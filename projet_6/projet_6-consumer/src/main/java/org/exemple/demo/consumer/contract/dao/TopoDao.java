package org.exemple.demo.consumer.contract.dao;

import org.exemple.demo.model.bean.grimpe.Topo;

import java.util.List;

public interface TopoDao {

    List<Topo> getListTopo();

    void insertTopo(Topo pTopo);

    List<Topo> getTopo(Topo pTopo);

    void updateEtat(Topo pTopo);
}
