package org.val.win.business.contract.manager;

import org.val.win.model.bean.utilisateur.Commentaire;
import org.val.win.model.exception.FunctionalException;

import java.util.List;

public interface CommentaireManager {

    List<Commentaire> getCommentaireTopo(Integer pId);

    void insertCom(Commentaire pCom) throws FunctionalException;
}
