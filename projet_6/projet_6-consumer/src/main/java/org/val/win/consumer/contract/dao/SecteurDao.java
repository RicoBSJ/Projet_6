package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.grimpe.Secteur;

import java.util.List;

public interface SecteurDao {

    List<Secteur> getListSecteur();

    void insertSecteur(Secteur pSecteur);

    void updateInfoSecteur(Secteur pSecteur);
}
