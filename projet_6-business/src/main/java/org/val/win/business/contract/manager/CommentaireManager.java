package org.val.win.business.contract.manager;

import org.val.win.model.bean.utilisateur.Commentaire;
import org.val.win.model.exception.FunctionalException;

import java.util.List;

/**
 * Interface de CommentaireManagerImpl
 */
public interface CommentaireManager {

    /**
     * recuperer une liste de commentaire
     * @param pId id d'un topo
     * @return la liste de commentaire d'un topo
     */
    List<Commentaire> getCommentaireTopo(Integer pId);

    /**
     * Creer un commentaire
     * @param pCom le commentaire a creer
     */
    void insertCom(Commentaire pCom) throws FunctionalException;
}
