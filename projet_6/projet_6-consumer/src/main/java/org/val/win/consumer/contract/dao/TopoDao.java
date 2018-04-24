package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.grimpe.Topo;

import java.util.List;

public interface TopoDao {

    List<Topo> getListTopo();

    void insertTopo(Topo pTopo);

    void updateEtat(Topo pTopo);
}
