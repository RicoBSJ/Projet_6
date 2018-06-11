package org.val.win.business.contract.manager;

import org.val.win.model.bean.grimpe.Topo;
import org.val.win.model.bean.utilisateur.Utilisateur;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;

import java.util.List;


public interface TopoManager {

    List<Topo> getListTopo();

    List<Topo> getListTopoDispo();

    Topo getTopo(Integer pId) throws NotFoundException;

    void insertTopo(Topo pTopo) throws FunctionalException;

    void Emprunt(Topo pTopo) throws FunctionalException;
}
