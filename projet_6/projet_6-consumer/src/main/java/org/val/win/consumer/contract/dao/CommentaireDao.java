package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.utilisateur.Commentaire;

import java.util.List;

public interface CommentaireDao {


    List<Commentaire> getListCommentaire();

    String getCommentaire(Commentaire pCommentaire);

    Commentaire insertCommentaire(Commentaire pCommentaire);

    List<Commentaire> getCommentaireTopo(Integer id);
}
