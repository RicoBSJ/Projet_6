package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.grimpe.Topo;

import java.util.List;

public interface TopoDao {

    List<Topo> getListTopo();

    Topo insertTopo(final Topo pTopo);

    void emprunt(final Topo pTopo);

    void updateInfoTopo(Topo pTopo);
}
