package org.val.win.business.contract.manager;

import org.val.win.model.bean.utilisateur.Commentaire;
import org.val.win.model.exception.FunctionalException;

public interface CommentaireManager {

    Commentaire getComTopo(Integer pId);

    void insertCom(Commentaire pCom) throws FunctionalException;
}
