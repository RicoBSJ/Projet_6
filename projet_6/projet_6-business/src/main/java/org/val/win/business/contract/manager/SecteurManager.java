package org.val.win.business.contract.manager;

import org.val.win.model.bean.grimpe.Secteur;
import org.val.win.model.bean.grimpe.Site;
import org.val.win.model.exception.FunctionalException;

import java.util.List;

public interface SecteurManager {

    void insertSecteur(Secteur pSecteur) throws FunctionalException;

    List<Secteur> getListSecteur(Site pSite);

}
