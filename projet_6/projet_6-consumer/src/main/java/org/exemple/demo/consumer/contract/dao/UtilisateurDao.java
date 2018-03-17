package org.exemple.demo.consumer.contract.dao;

import org.exemple.demo.model.bean.utilisateur.Utilisateur;

import java.util.List;

public interface UtilisateurDao {

    void add( Utilisateur utilisateur );
    List<Utilisateur> lister();

}