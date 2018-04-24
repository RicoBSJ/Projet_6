package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.grimpe.Secteur;
import org.val.win.model.bean.grimpe.Voie;

import java.util.List;

public interface VoieDao {

    List<Voie> getListVoie();

    int getCountVoieSec(Secteur pSecteur);

    void insertVoie(Voie pVoie);

    void updateInfoVoie(Voie pVoie);
}
