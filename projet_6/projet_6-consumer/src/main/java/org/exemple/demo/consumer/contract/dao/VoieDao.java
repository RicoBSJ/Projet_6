package org.exemple.demo.consumer.contract.dao;

import org.exemple.demo.model.bean.grimpe.Secteur;
import org.exemple.demo.model.bean.grimpe.Voie;

import java.util.List;

public interface VoieDao {

    List<Voie> getListVoie();

    int getCountTicket(Secteur pSecteur);
}
