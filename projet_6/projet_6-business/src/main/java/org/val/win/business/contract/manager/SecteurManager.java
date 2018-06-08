package org.val.win.business.contract.manager;

import org.val.win.model.bean.grimpe.Secteur;
import org.val.win.model.bean.grimpe.Site;
import org.val.win.model.exception.FunctionalException;
import org.val.win.model.exception.NotFoundException;

import java.util.List;

public interface SecteurManager {

    void insertSecteur(Secteur pSecteur) throws FunctionalException;

    List<Secteur> getListSecteur(Integer pId);

    Secteur getSecteur(Integer idSecteur, Integer idSite) throws NotFoundException;

}
