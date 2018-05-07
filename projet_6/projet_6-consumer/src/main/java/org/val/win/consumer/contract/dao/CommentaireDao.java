package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.grimpe.Topo;
import org.val.win.model.bean.utilisateur.Commentaire;

import java.util.List;

public interface CommentaireDao {


    List<Commentaire> getListCommentaire();

    Commentaire insertCommentaire(Commentaire pCommentaire);

    List<Commentaire> getCommentaireTopo(Topo pTopo);
}
