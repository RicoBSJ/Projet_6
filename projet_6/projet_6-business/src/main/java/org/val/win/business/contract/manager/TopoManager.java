package org.val.win.business.contract.manager;

import org.val.win.model.bean.grimpe.Topo;
import org.val.win.model.bean.utilisateur.Utilisateur;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;

import java.util.List;


public interface TopoManager {

    List<Topo> getListTopo();

    Topo getTopo(Integer pId) throws NotFoundException;

    void insertTopo(Topo pTopo) throws FunctionalException;

    void ChangeEtat(Topo pTopo, Utilisateur pUtilisateur) throws FunctionalException;
}
