package org.exemple.demo.consumer.contract.dao;

import org.exemple.demo.model.bean.utilisateur.Utilisateur;

import java.util.List;

public interface UtilisateurDao {

    List<Utilisateur> getListUtilisateur();

    List<Utilisateur> getUtilisateur(Utilisateur pUtilisateur);

    void insertUtilisateur(Utilisateur pUtilisateur);

    void updateEtat(Utilisateur pUtilisateur);




}