package org.exemple.demo.consumer.contract.dao;

import org.exemple.demo.model.bean.grimpe.Secteur;

import java.util.List;

public interface SecteurDao {

    List<Secteur> getListSecteur();

    void insertSecteur(Secteur pSecteur);
}
