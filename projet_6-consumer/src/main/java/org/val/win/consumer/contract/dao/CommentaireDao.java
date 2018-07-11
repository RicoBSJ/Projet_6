package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.utilisateur.Commentaire;

import java.util.List;

/**
 * Interface de CommentaireDaoImpl
 */
public interface CommentaireDao {

    /**
     * Insertion d'un commentaire dans la DB
     * @param pCommentaire le commentaire a ajouter
     * @return le commentaire
     */
    Commentaire insertCommentaire(Commentaire pCommentaire);

    /**
     * Recuperer la liste de commentaire d'un topo
     * @param id id d'un topo
     * @return la liste de commentaire d'un topo
     */
    List<Commentaire> getCommentaireTopo(Integer id);
}
