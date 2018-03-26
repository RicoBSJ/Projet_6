package org.exemple.demo.consumer.contract.dao;

import org.exemple.demo.model.bean.utilisateur.Commentaire;

import java.util.List;

public interface CommentaireDao {


    List<Commentaire> getCommentaire();
}
