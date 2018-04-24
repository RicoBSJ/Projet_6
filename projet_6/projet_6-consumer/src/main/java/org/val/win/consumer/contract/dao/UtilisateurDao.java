package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.utilisateur.Utilisateur;

import java.util.List;

public interface UtilisateurDao {

    List<Utilisateur> getListUtilisateur();

    Utilisateur getUtilisateur(Integer id);

    void insertUtilisateur(Utilisateur pUtilisateur);

    void updateEtat(Utilisateur pUtilisateur);

    void updateInfoUtil(Utilisateur pUtilisateur);

}