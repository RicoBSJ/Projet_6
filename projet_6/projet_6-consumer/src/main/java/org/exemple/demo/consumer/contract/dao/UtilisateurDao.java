package org.exemple.demo.consumer.contract.dao;

import org.exemple.demo.model.bean.utilisateur.Utilisateur;

import java.util.List;

public interface UtilisateurDao {

    List<Utilisateur> getListUtilisateur();

    Utilisateur getUtilisateur(Integer id);

    void insertUtilisateur(Utilisateur pUtilisateur);

    void updateEtat(Utilisateur pUtilisateur);




}